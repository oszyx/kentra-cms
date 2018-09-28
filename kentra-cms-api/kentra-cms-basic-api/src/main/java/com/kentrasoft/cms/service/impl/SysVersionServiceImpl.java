package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.SysVersionMapper;
import com.kentrasoft.cms.entity.SysVersion;
import com.kentrasoft.cms.service.SysVersionService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class SysVersionServiceImpl implements SysVersionService {

    @Autowired
    private SysVersionMapper sysVersionMapper;

    /**
     * 获取版本列表数据
     *
     * @return
     */
    @Override
    public PageForm<SysVersion> getVersionList(PageForm<SysVersion> page) {
        List<SysVersion> versionList = sysVersionMapper.getVersionList(page);
        page.setCount(versionList.size());
        page.setData(versionList);
        return page;
    }

    /**
     * 添加版本信息
     *
     * @param sysVersion
     * @return
     */
    @Override
    public BaseResult add(SysVersion sysVersion) {
        String vId = sysVersion.getvId();
        List<SysVersion> sysVersions = sysVersionMapper.selectByVId(vId);
        if (sysVersions.size() > 0) {
            return BaseResult.faild("版本号已存在");
        }
        sysVersion.setvCreateTime(new Date());
        sysVersionMapper.insert(sysVersion);
        return BaseResult.success("新增成功");
    }

    /**
     * 删除版本信息
     *
     * @param ids
     * @return
     */
    @Override
    public BaseResult delete(String ids) {
        try {
            if (!StringUtils.isNullOrEmpty(ids)) {
                List<String> idList = Arrays.asList(ids.split(","));
                Map<String, Object> params = new HashMap<>();
                params.put("idList", idList);
                //删除设备信息
                sysVersionMapper.deleteByIds(params);
                return BaseResult.success("删除成功");
            } else {
                return BaseResult.faild("传入数据错误");
            }
        } catch (Exception e) {
            return BaseResult.faild("删除失败：" + e.getMessage());
        }
    }

    /**
     * 编辑版本信息
     *
     * @param sysVersion
     * @return
     */
    @Override
    public BaseResult edit(SysVersion sysVersion) {
        String vId = sysVersion.getvId();
        Map<String, Object> params = new HashMap<>();
        params.put("vId", vId);
        params.put("id", sysVersion.getId());
        List<SysVersion> sysVersions = sysVersionMapper.selectExitByVId(params);
        if (sysVersions.size() > 0) {
            return BaseResult.faild("版本号已存在");
        }
        sysVersionMapper.updateByExampleSelective(sysVersion);
        return BaseResult.success("修改成功");
    }


}
