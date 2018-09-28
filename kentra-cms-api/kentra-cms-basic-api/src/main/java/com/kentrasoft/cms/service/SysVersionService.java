package com.kentrasoft.cms.service;


import com.kentrasoft.cms.entity.SysVersion;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

public interface SysVersionService {


    /**
     * 获取版本列表数据
     *
     * @return
     */
    PageForm<SysVersion> getVersionList(PageForm<SysVersion> page);

    /**
     * 添加版本信息
     *
     * @param sysVersion
     * @return
     */
    BaseResult add(SysVersion sysVersion);

    /**
     * 删除版本信息
     *
     * @param ids
     * @return
     */
    BaseResult delete(String ids);

    /**
     * 编辑版本信息
     *
     * @param sysVersion
     * @return
     */
    BaseResult edit(SysVersion sysVersion);
}
