package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.ControllerManagementMapper;
import com.kentrasoft.cms.dao.RepairRecordMapper;
import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.cms.entity.ControllerManagementExample;
import com.kentrasoft.cms.service.ControllerManagementService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 描述：控制器管理服务实现
 *
 * @author zmk
 * @date 2018-6-12 13:42:37
 */
@Service
public class ControllerManagementServiceImpl implements ControllerManagementService {
    @Autowired
    private ControllerManagementMapper controllerManagementMapper;
    @Autowired
    private RepairRecordMapper repairRecordMapper;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<ControllerManagement> getPageList(PageForm<ControllerManagement> page,
                                                      String name, String controllerCode, String controllerStatus, String extends3) {
        ControllerManagementExample controllerManagementExample = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria = controllerManagementExample.createCriteria();
        if (name != "" && name != null) {
            criteria.andNameLike("%" + name + "%");
        }
        if (controllerCode != "" && controllerCode != null) {
            criteria.andControllerCodeLike("%" + controllerCode + "%");
        }
        if (controllerStatus != "" && controllerStatus != null) {
            criteria.andControllerStatusEqualTo(controllerStatus);
        }
        if (extends3 != null && !"".equals(extends3)) {
            criteria.andExtends3EqualTo(extends3);
        }
        //查询所有的数据数量
        long controllerManagementCount = controllerManagementMapper.countByExample(controllerManagementExample);

        //分页查询所有的数据
        controllerManagementExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        controllerManagementExample.setLimitEnd(page.getLimit());
        List<ControllerManagement> controllerManagement = controllerManagementMapper.selectByExample(controllerManagementExample);

        //回写内容
        page.setCount((int) controllerManagementCount);
        page.setData(controllerManagement);

        return page;
    }

    /**
     * 描述：添加控制器
     *
     * @param controllerManagement
     */
    @Override
    public BaseResult add(ControllerManagement controllerManagement) {
        ControllerManagementExample controllerManagementExample = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria = controllerManagementExample.createCriteria();
        criteria.andControllerCodeEqualTo(controllerManagement.getControllerCode());
        List<ControllerManagement> controllerManagements = controllerManagementMapper.selectByExample(controllerManagementExample);
        if (controllerManagements.size() > 0) {
            return BaseResult.faild("设备编号已存在");
        }
        ControllerManagementExample controllerManagementExample_cond2 = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria_cond2 = controllerManagementExample_cond2.createCriteria();
        criteria_cond2.andExtends1EqualTo(controllerManagement.getExtends1());
        criteria_cond2.andExtends2EqualTo(controllerManagement.getExtends2());
        List<ControllerManagement> controllerManagements_cond2 = controllerManagementMapper.selectByExample(controllerManagementExample_cond2);
        if (controllerManagements_cond2.size() > 0) {
            return BaseResult.faild("设备网络地址端口重复");
        }

        controllerManagement.setCreateTime(new Date());
        controllerManagement.setUpdateTime(new Date());
        controllerManagementMapper.insert(controllerManagement);
        return BaseResult.success("新增成功");
    }

    /**
     * 描述：删除控制器
     *
     * @param ids
     */
    @Override
    public BaseResult delete(String ids) {
        /*String[] idArr = ids.split(",");
        for (String id : idArr) {
            ControllerManagement controllerManagement = controllerManagementMapper.selectByPrimaryKey(id);
            if (!controllerManagement.getControllerStatus().equals("equipment_state_0")) {
                return BaseResult.faild("删除失败：只能删除未启用设备!");
            }
        }*/

        try {
            controllerManagementMapper.deleteByPKs(ids);
            return BaseResult.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("删除失败");
        }
    }

    /**
     * 描述：修改控制器信息
     *
     * @param controllerManagement
     */
    @Override
    public BaseResult edit(ControllerManagement controllerManagement) {
        //判断是否启用
        /*ControllerManagement controllerManagementDB = controllerManagementMapper.selectByPrimaryKey(controllerManagement.getId());
        if (!controllerManagementDB.getControllerStatus().equals("equipment_state_0")) {
            if (!controllerManagement.getControllerCode().equals(controllerManagementDB.getControllerCode())) {
                return BaseResult.faild("该设备已启用，请勿更改设备编号！");
            }
        }*/
        //判断编号是否重复
        ControllerManagementExample controllerManagementExample = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria = controllerManagementExample.createCriteria();
        criteria.andControllerCodeEqualTo(controllerManagement.getControllerCode());
        criteria.andIdNotEqualTo(controllerManagement.getId());
        List<ControllerManagement> controllerManagements = controllerManagementMapper.selectByExample(controllerManagementExample);
        if (controllerManagements.size() > 0) {
            return BaseResult.faild("设备编号已存在");
        }
        //判断网络端口是否重复
        ControllerManagementExample controllerManagementExample_cond2 = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria_cond2 = controllerManagementExample_cond2.createCriteria();
        criteria_cond2.andExtends1EqualTo(controllerManagement.getExtends1());
        criteria_cond2.andExtends2EqualTo(controllerManagement.getExtends2());
        criteria_cond2.andIdNotEqualTo(controllerManagement.getId());
        List<ControllerManagement> controllerManagements_cond2 = controllerManagementMapper.selectByExample(controllerManagementExample_cond2);
        if (controllerManagements_cond2.size() > 0) {
            return BaseResult.faild("设备网络地址端口重复");
        }

        controllerManagement.setUpdateTime(new Date());
        controllerManagementMapper.updateByPrimaryKeySelective(controllerManagement);
        return BaseResult.success("修改成功");
    }

    /**
     * 描述：根据控制器编号查找控制器设备
     *
     * @param controllerCode
     */
    @Override
    public BaseResult<ControllerManagement> findByControllerCode(String controllerCode) {
        ControllerManagementExample controllerManagementExample = new ControllerManagementExample();
        ControllerManagementExample.Criteria criteria = controllerManagementExample.createCriteria();
        criteria.andControllerCodeEqualTo(controllerCode);
        List<ControllerManagement> controllerManagements = controllerManagementMapper.selectByExample(controllerManagementExample);
        if (controllerManagements.size() < 1) {
            return BaseResult.faild("您查询的设备编号不存在！");
        } else {
            return BaseResult.success("控制器设备信息查找成功！", controllerManagements.get(0));
        }
    }

    /**
     * 描述：根据设备编号 修改设备状态
     *
     * @param repairDeviceId
     * @param repairStatus
     */
    @Override
    public void updataStatus(String repairDeviceId, String repairStatus) {
        ControllerManagement controllerManagement = controllerManagementMapper.selectByPrimaryKey(repairDeviceId);
        controllerManagement.setControllerStatus(repairStatus);
        controllerManagement.setUpdateTime(new Date());
        controllerManagementMapper.updateByPrimaryKey(controllerManagement);
    }
}
