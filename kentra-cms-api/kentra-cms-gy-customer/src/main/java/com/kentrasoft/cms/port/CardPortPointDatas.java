package com.kentrasoft.cms.port;
/**
 * 卡口数据接口
 *
 * @author jiaming
 */

import com.kentrasoft.cms.basic.properties.Properties;
import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.BreakRecordMapper;
import com.kentrasoft.cms.dao.CardPortDataMapper;
import com.kentrasoft.cms.dao.DrivingRecordMapper;
import com.kentrasoft.cms.dao.TollStationMapper;
import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.cms.entity.CardPortData;
import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.cms.entity.TollStation;
import com.kentrasoft.cms.port.entity.cardPortPoint.CardPortContent;
import com.kentrasoft.cms.port.entity.cardPortPoint.CardPortPointEntity;
import com.kentrasoft.utils.Base64MultipartFile.Base64ImgUtils;
import com.kentrasoft.utils.uuid.UUIDUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class CardPortPointDatas {

    private static final Logger log = LoggerFactory.getLogger(ImportPointDate.class);

    @Autowired
    private CardPortDataMapper cardPortDataMapper;

    @Autowired
    private DrivingRecordMapper drivingRecordMapper;

    @Autowired
    private BreakRecordMapper breakRecordMapper;

    @Autowired
    private Properties properties;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TollStationMapper tollStationMapper;

    @KafkaListener(topics = {"gyfvs-bucklepoint"})
    public synchronized void loadImportPointDate(String BaseData) {
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            String Data = new String(decoder.decodeBuffer(BaseData), "UTF-8");
            log.warn("------传输卡口数据-----" + Data);
            Map<String, Class> listMap = new HashMap<>();
            listMap.put("data", CardPortContent.class);
            CardPortPointEntity cardPortPointEntity = (CardPortPointEntity) JSONObject.toBean(JSONObject.fromObject(Data), CardPortPointEntity.class, listMap);

            // 校验数据
            boolean checkData = this.checkData(cardPortPointEntity);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
            List<CardPortContent> datalist = cardPortPointEntity.getData();

            if (checkData && datalist.size() > 0) {
                for (CardPortContent data : datalist) {
                    //查询行行驶记录，cond:大于卡口通过时间最近得行驶记录
                    DrivingRecord drivingrecord = drivingRecordMapper.selectbyCardportPasstime(this.licenseaddpoint(data.getLicense()), sdf.format(new Date(data.getPointTime())));
                    if (drivingrecord == null) {
                        log.info("卡口未查询到车牌：{},通过时间：{} 的行驶记录", data.getLicense(), sdf.format(new Date(data.getPointTime())));
                        continue;
                    }
                    //初判违规
                    this.insertBreakRecord(drivingrecord);
                    //保存卡口数据
                    this.insertCardPort(data, drivingrecord.getDrivingRecord());
                    log.info("-----传输卡口数据完毕-----{}", Data);
                }
            } else {
                log.warn("卡口数据校验不通过:{}", Data);
            }
        } catch (Exception e) {
            log.info("数据解析出错");
            e.printStackTrace();
        }

    }


    /**
     * 插入违规记录
     *
     *author:赵参谋
     * @param
     * @param
     */
    public void insertBreakRecord(DrivingRecord drivingrecord) {
        BreakRecord breakRecord = new BreakRecord();
        //行驶记录id
        breakRecord.setDrivingRecord(drivingrecord.getDrivingRecord());
        //车牌号
        breakRecord.setLicenseNum(this.licenseaddpoint(drivingrecord.getLicenseNum()));
        //行驶起时间起
        breakRecord.setEntranceTime(null != drivingrecord.getEntranceTime() ? drivingrecord.getEntranceTime() : null);
        //行驶段起名称
        breakRecord.setEntranceName(!"暂无数据".equals(drivingrecord.getEntranceName()) ? drivingrecord.getEntranceName() : "暂无数据");
        //行驶时间止
        breakRecord.setExitTime(null != drivingrecord.getExitTime() ? drivingrecord.getExitTime() : null);
        //行驶段止名称
        breakRecord.setExitName(!"暂无数据".equals(drivingrecord.getExitName()) ? drivingrecord.getExitName() : "暂无数据");
        //审核状态:待审核
        breakRecord.setAuditStatus("break_underview_01");
        //违规类型：卡口数据
        breakRecord.setRemakeType("type_of_violation_3");
        //应缴费
        breakRecord.setExtends1("0.00");
        //已缴
        breakRecord.setExtends2("0.00");
        //待缴
        breakRecord.setPayMoney("0.00");
        //备注
        breakRecord.setRemakeContent("卡口数据，系统自动生成");
        //创建时间
        breakRecord.setCreateTime(new Date());
        breakRecordMapper.insert(breakRecord);
    }

    /**
     * 插入卡口数据
     *
     *author:赵参谋
     * @param data
     * @param
     */
    public void insertCardPort(CardPortContent data, String trackId) {
        CardPortData cardPortData = new CardPortData();
        cardPortData.setDrivingRecord(trackId);
        cardPortData.setLicenseNum(this.licenseaddpoint(data.getLicense()));
        cardPortData.setStationName(data.getPointName());
        cardPortData.setPassTime(new Date(data.getPointTime()));
		/*cardPortData.setPointGisX(data.getPointGisX());
		cardPortData.setPointGisY(data.getPointGisY());*/
        //是否启用配置卡口坐标点

        if ("true".equals(redisUtil.get("isopen_carport_gis"))) {
            TollStation outstationgis = this.tollstationinfos(data.getPointName(), data.getPointCode());
            if (null != outstationgis) {
                cardPortData.setPointGisX(outstationgis.getLongitude());
                cardPortData.setPointGisY(outstationgis.getLatitude());
            }
        } else {
            cardPortData.setPointGisX(data.getPointGisX());
            cardPortData.setPointGisY(data.getPointGisY());
        }
        cardPortData.setPointCode(data.getPointCode());
        //获取并格式化base64图片字符串
        if (data.getImageCode() != null && StringUtils.isNotBlank(data.getImageCode())) {
            String imgname = UUIDUtils.getUUID();//生成图片名称
            String imgUrl = properties.getCardportimgLinkaddress() + "/gy/" + imgname + ".jpg";
            Base64ImgUtils.Base64ToImage(data.getImageCode(), properties.getCardportimgCountaddress(), imgname + ".jpg");
            cardPortData.setImgUrl(imgUrl);
            cardPortData.setStatus("02");//行驶完成
            cardPortDataMapper.insert(cardPortData);
        } else {
            cardPortData.setStatus("02");//行驶中完成
            cardPortDataMapper.insert(cardPortData);
        }
    }

    /**
     * 查询进出口坐标
     *
     *author:赵参谋
     * @param stationName
     * @param stationcode
     * @return
     */
    public TollStation tollstationinfos(String stationName, String stationcode) {
        TollStation tollstation = tollStationMapper.querytollstationbycode(stationName, stationcode);
        if (tollstation != null) {
            return tollstation;
        } else {
            log.info("未查询到收费站信息");
            return null;
        }
    }

    /**
     * 校验数据
     *author:jiaming
     */
    public boolean checkData(CardPortPointEntity cardPortPointEntity) {
        try {
            if (cardPortPointEntity.getData() == null) {
                log.warn("data数据不为空");
                return false;
            }
            if (StringUtils.isBlank(cardPortPointEntity.getFrom())) {
                log.warn("数据来源不为空");
                return false;
            }
            if (cardPortPointEntity.getTimestamp() == 0) {
                log.warn("发送时间不为空");
                return false;
            }
            for (CardPortContent cardPortContent : cardPortPointEntity.getData()) {
                for (Field field : cardPortContent.getClass().getDeclaredFields()) {
                    String fileName = field.getName();
                    if ("pointGisX".equals(fileName) || "pointGisY".equals(fileName) || "imageCode".equals(fileName)) {
                        continue;
                    }
                    field.setAccessible(true);
                    Object value = field.get(cardPortContent);
                    if (value == null || value.toString() == null || value.toString().length() == 0) {
                        log.warn("{}:不能为空", fileName);
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("卡口数据校验失败:{}", e.getMessage());
            return false;
        }
    }

    /**
     * 解析json数据
     *author:赵参谋
     * @param jsonObject
     * @param t
     * @return
     */
    public Object getInstance(JSONObject jsonObject, Class<?> t) {
        try {
            //创建一个实例
            Object obj = t.newInstance();
            Field[] fieldList = obj.getClass().getDeclaredFields();//获取属性集合
            Method[] method = obj.getClass().getDeclaredMethods();//获取方法集合
            for (Field field : fieldList) {
                String fielName = field.getName();//获取属性
                String value = jsonObject.get(fielName).toString();//获取值
                String fieldSetMethodName = this.getFieldsetmethod(fielName);//获取属性对应set方法
                if (!this.checkMethod(method, fieldSetMethodName)) {//判断set方法是否存在
                    return null;
                }
                Method fieldSetMethod = t.getMethod(fieldSetMethodName, field.getType());

                if (value != null && !"".equals(value)) {
                    String type = field.getType().getName();
                    if ("java.lang.String".equals(type)) {
                        fieldSetMethod.invoke(obj, value);
                    } else if ("java.util.Date".equals(type)) {
                        Date temp = this.parseDate(value);
                        fieldSetMethod.invoke(obj, temp);
                    } else if ("java.lang.Integer".equals(type)) {
                        Integer intval = Integer.parseInt(value);
                        fieldSetMethod.invoke(obj, intval);
                    } else if ("java.lang.Long".equalsIgnoreCase(type)) {
                        Long temp = Long.parseLong(value);
                        fieldSetMethod.invoke(obj, temp);
                    } else if ("java.lang.Double".equalsIgnoreCase(type)) {
                        Double temp = Double.parseDouble(value);
                        fieldSetMethod.invoke(obj, temp);
                    } else if ("java.lang.Boolean".equalsIgnoreCase(type)) {
                        Boolean temp = Boolean.parseBoolean(value);
                        fieldSetMethod.invoke(obj, temp);
                    } else if ("java.util.List".equals(type)) {
                        Type genericType = field.getGenericType();//获取List,Generic的类型
                        if (genericType == null) continue;
                        if (genericType instanceof ParameterizedType) {//判断是否是泛型类
                            ParameterizedType pt = (ParameterizedType) genericType;
                            Class genericClazz = (Class) pt.getActualTypeArguments()[0];//得到泛型里的class类型对象
                            fieldSetMethod.invoke(obj, JSONArray.toCollection(JSONArray.fromObject(value), genericClazz));
                        }

                    } else {//实体类
                        fieldSetMethod.invoke(obj, getInstance(JSONObject.fromObject(value), Class.forName(type)));
                    }
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取set方法
     *author:赵参谋
     * @param fieldName
     * @return
     */

    public String getFieldsetmethod(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "set"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);

    }

    /**
     * 判断方法是否存在
     */
    public boolean checkMethod(Method[] method, String methodName) {
        for (Method met : method) {
            if (methodName.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间转换
     *author:赵参谋
     * @param datestr
     * @return
     */
    public Date parseDate(String datestr) {
        if (null == datestr || "".equals(datestr)) {
            return null;
        }
        try {
            String fmtstr = null;
            if (datestr.indexOf(':') > 0) {
                fmtstr = "yyyy-MM-dd HH:mm:ss";
            } else {
                fmtstr = "yyyy-MM-dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr);
            return sdf.parse(datestr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 给车牌加·
     *author:赵参谋
     * @param license
     * @return
     */
    public String licenseaddpoint(String license) {
        if (license.contains("·")) {
            return license;
        } else {
            return license.substring(0, 2) + "·" + license.substring(2, license.length());
        }
    }

}
