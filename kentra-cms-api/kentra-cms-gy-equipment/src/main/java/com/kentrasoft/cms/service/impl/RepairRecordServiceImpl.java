package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.RepairRecordMapper;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.entity.RepairRecordExample;
import com.kentrasoft.cms.service.RepairRecordService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：设备维护管理service实现
 *
 * @author zhangmengkang
 * @date 2018-6-12 13:42:37
 */
@Service
public class RepairRecordServiceImpl implements RepairRecordService {

    @Autowired
    private RepairRecordMapper repairRecordMapper;

    /**
     * 描述：分页查询
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<RepairRecord> getPageList(PageForm<RepairRecord> page, String repairUserName, String repairDeviceId) {
        RepairRecordExample repairRecordExample = new RepairRecordExample();
        RepairRecordExample.Criteria criteria = repairRecordExample.createCriteria();
        if (repairUserName != "" && repairUserName != null) {
            criteria.andRepairUserNameLike("%" + repairUserName + "%");
        }
        if (repairDeviceId != "" && repairDeviceId != null) {
            criteria.andRepairDeviceIdEqualTo(repairDeviceId);
        }
        //查询所有的数据数量
        long repairRecordCount = repairRecordMapper.countByExample(repairRecordExample);

        //分页查询所有的数据
        repairRecordExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        repairRecordExample.setLimitEnd(page.getLimit());
        List<RepairRecord> repairRecords = repairRecordMapper.selectByExample(repairRecordExample);

        //回写内容
        page.setCount((int) repairRecordCount);
        page.setData(repairRecords);

        return page;
    }

    /**
     * 描述：添加维修记录
     *
     * @param repairRecord
     */
    @Override
    public BaseResult add(RepairRecord repairRecord) {
        try {
            repairRecordMapper.insertSelective(repairRecord);
            return BaseResult.success("设备维修信息添加成功！");
        } catch (Exception e) {
            return BaseResult.faild("设备维修信息添加失败：" + e.getMessage());
        }
    }

    /**
     * 描述：删除维修记录
     *
     * @param ids
     */
    @Override
    public BaseResult delete(String ids) {
        try {
            repairRecordMapper.deleteByPKs(ids);
            return BaseResult.success("维修记录删除成功！");
        } catch (Exception e) {
            return BaseResult.faild("删除失败：" + e.getMessage());
        }
    }

    /**
     * 描述：修改维修记录
     *
     * @param repairRecord
     */
    @Override
    public BaseResult edit(RepairRecord repairRecord) {
        repairRecordMapper.updateByPrimaryKeySelective(repairRecord);
        return BaseResult.success("维修记录修改成功！");
    }

    /**
     * 描述：根据设备id查找维修记录
     *
     * @param repairDeviceId
     * @return
     */
    @Override
    public BaseResult findByRepairDeviceId(String repairDeviceId) {
        RepairRecordExample repairRecordExample = new RepairRecordExample();
        RepairRecordExample.Criteria criteria = repairRecordExample.createCriteria();
        if (repairDeviceId == "" || repairDeviceId == null) {
            return BaseResult.faild("未查询到该设备的为序记录！");
        }
        criteria.andRepairDeviceIdEqualTo(repairDeviceId);
        List<RepairRecord> repairRecords = repairRecordMapper.selectByExample(repairRecordExample);
        return BaseResult.success("查询成功！", repairRecords);
    }
}
