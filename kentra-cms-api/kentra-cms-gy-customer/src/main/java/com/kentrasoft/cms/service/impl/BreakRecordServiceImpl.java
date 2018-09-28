package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.BreakRecordMapper;
import com.kentrasoft.cms.dao.PayRecordMapper;
import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.cms.entity.BreakRecordExample;
import com.kentrasoft.cms.entity.BreakRecordExample.Criteria;
import com.kentrasoft.cms.entity.PayRecord;
import com.kentrasoft.cms.entity.dto.BreakCount;
import com.kentrasoft.cms.service.BreakRecordService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BreakRecordServiceImpl implements BreakRecordService {

    @Autowired
    private BreakRecordMapper breakRecordMapper;
    
    @Autowired
    private PayRecordMapper payRecordMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public PageForm<BreakRecord> getPageList(PageForm<BreakRecord> page, String licenseNum, String remakeType, String searchBreakType) {
        BreakRecordExample breakRecordExample = new BreakRecordExample();
        Criteria crit = breakRecordExample.or();
        if (licenseNum != null && licenseNum != "") {
            crit.andLicenseNumLike("%"+licenseNum+"%");
        }
        if (remakeType != null && remakeType != "") {
            crit.andAuditStatusLike("%"+remakeType+"%");
        }
        if(searchBreakType !=null && !"".equals(searchBreakType)) {
        	crit.andRemakeTypeEqualTo(searchBreakType);
        }
        //是否显示三天后数据
        if("break_page_type2".equals(redisUtil.get("break_record_pagetype"))) {
        	crit.andEntranceNameNotEqualTo("暂无数据");
        }
        breakRecordExample.or(crit);
        //查询所有的数据数量
        long BreakRecordCount = breakRecordMapper.countByExample(breakRecordExample);

        //分页查询所有的数据
        breakRecordExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        breakRecordExample.setLimitEnd(page.getLimit());

        List<BreakRecord> breakRecord = breakRecordMapper.selectByExample(breakRecordExample);

        //回写内容
        page.setCount((int) BreakRecordCount);
        page.setData(breakRecord);

        return page;
    }

    @Override
    public BaseResult add(BreakRecord breakRecord) {
    	DecimalFormat df = new DecimalFormat("0.00");
    	double payMoney = 0L;
    	if (!StringUtils.isEmpty(breakRecord.getExtends1())&&!StringUtils.isEmpty(breakRecord.getExtends2())) {
    		payMoney =  Double.parseDouble(breakRecord.getExtends1())-Double.parseDouble(breakRecord.getExtends2());
		}
    	if (!StringUtils.isEmpty(breakRecord.getExtends1())&&StringUtils.isEmpty(breakRecord.getExtends2())) {
    		payMoney =  Double.parseDouble(breakRecord.getExtends1());
		}
    	String payvalue=df.format(payMoney);
    	breakRecord.setExtends1(df.format(Double.parseDouble(breakRecord.getExtends1())));//应缴
    	breakRecord.setExtends2(df.format(Double.parseDouble(breakRecord.getExtends2())));//已缴
		breakRecord.setPayMoney(payvalue);//待缴
    	breakRecord.setAuditStatus("break_underview_01");//待审核状态
    	breakRecord.setCreateTime(new Date());
        breakRecordMapper.insert(breakRecord);
        return BaseResult.success("违规处理信息录入成功！");
    }

    @Override
    public BaseResult delete(String ids) {
        try {
            breakRecordMapper.deleteByPKs(ids);
            return BaseResult.success("违规信息删除成功！");
        } catch (Exception e) {
            return BaseResult.faild("删除失败：" + e.getMessage());
        }
    }

    @SuppressWarnings("unused")
    @Override
    public BaseResult edit(BreakRecord breakRecord) {
        if (breakRecord == null) {
            return BaseResult.faild("修改对象不能为空");
        }
        DecimalFormat df = new DecimalFormat("0.00");
    	if (!StringUtils.isEmpty(breakRecord.getExtends1())&&!StringUtils.isEmpty(breakRecord.getExtends2())) {
    		double payMoney =  Double.parseDouble(breakRecord.getExtends1())-Double.parseDouble(breakRecord.getExtends2());
    		String payMony=df.format(payMoney);
    		breakRecord.setPayMoney(payMony);
    	}
    	if (!StringUtils.isEmpty(breakRecord.getExtends1())&&StringUtils.isEmpty(breakRecord.getExtends2())) {
    		double payMoney =  Double.parseDouble(breakRecord.getExtends1());
    		String payMony=df.format(payMoney);
    		breakRecord.setPayMoney(payMony);
    	}
    	breakRecord.setExtends1(df.format(Double.parseDouble(breakRecord.getExtends1())));//应缴
    	breakRecord.setExtends2(df.format(Double.parseDouble(breakRecord.getExtends2())));//待缴
        breakRecord.setUpdateTime(new Date());
        breakRecordMapper.updateByPrimaryKeySelective(breakRecord);
        return BaseResult.success("违规信息修改成功！");
    }

	@Override
	public List<BreakRecord> exportBreakRecord(String searchLicenseNum,String searchAuditStatus,String searchRemakeType) {
		BreakRecordExample breakRecordExample = new BreakRecordExample();
		Criteria crit = breakRecordExample.or();
        if (searchLicenseNum != null && searchLicenseNum != "") {
            crit.andLicenseNumLike("%"+searchLicenseNum+"%");
        }
        if (searchAuditStatus != null && searchAuditStatus != "") {
            crit.andAuditStatusLike("%"+searchAuditStatus+"%");
        }
        if (searchRemakeType != null && searchRemakeType != "") {
            crit.andRemakeTypeLike("%"+searchRemakeType+"%");
        }
        breakRecordExample.or(crit);
		List<BreakRecord> breakRecordList =breakRecordMapper.selectByExample(breakRecordExample);
		return breakRecordList;
	}

    @Override
    public BaseResult examine(BreakRecord breakRecord) {
		if (breakRecord == null) {
            return BaseResult.faild("违规信息不能为空");
        }
        breakRecordMapper.updateByPrimaryKeySelective(breakRecord);
        //新增缴费记录
        if("break_underview_02".equals(breakRecord.getAuditStatus())) {
        	PayRecord payRecord=new PayRecord();
            payRecord.setLicenseNum(breakRecord.getLicenseNum());//车牌号
            payRecord.setDrivingRecord(breakRecord.getDrivingRecord());//记录编号
            payRecord.setEntranceName(breakRecord.getEntranceName());//进站名称
            payRecord.setExitName(breakRecord.getExitName());//出站名称
            payRecord.setEntranceTime(breakRecord.getEntranceTime());//进站时间
            payRecord.setExitTime(breakRecord.getExitTime());//出站时间
            payRecord.setReceivables(Double.valueOf(breakRecord.getExtends1()));//应缴费用
            payRecord.setPayCount(Double.valueOf(breakRecord.getExtends2()));//已缴
            payRecord.setExpensesPaid(Double.valueOf(breakRecord.getPayMoney()));//待缴费用
            payRecord.setPayTime(new Date());
            payRecord.setPayStatus(breakRecord.getExtends3());//缴费类型
            if("0".equals(breakRecord.getPayMoney()) || "0.00".equals(breakRecord.getPayMoney())) {
            	payRecord.setIsPay("payment_state_0");//缴费状态:完成缴费
            }else {
            	payRecord.setIsPay("payment_state_1");//缴费状态:未完成缴费
            }
            payRecord.setExtends1("");//违规备注
            payRecordMapper.insert(payRecord);
        }
        
        return BaseResult.success("违规信息审核成功！");
	}

    /**
     * 描述：违规统计
     *
     * @param year
     */
    @Override
    public BaseResult breakCount(String year) {
        List<BreakCount> persent = breakRecordMapper.breakCount(year);
        return BaseResult.success("查询成功！",persent);
    }

}
