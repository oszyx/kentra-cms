package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.SysVersion;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "sysVersionMapper")
public interface SysVersionMapper {

    /**
     * 获取版本分页数据
     *
     * @param page
     * @return
     */
    List<SysVersion> getVersionList(PageForm<SysVersion> page);

    /**
     * 添加的时候查询此版本号是否存在
     *
     * @param vId
     * @return
     */
    List<SysVersion> selectByVId(String vId);

    /**
     * 添加功能
     *
     * @param sysVersion
     * @return
     */
    void insert(SysVersion sysVersion);

    /**
     * 编辑功能
     *
     * @param sysVersion
     * @return
     */
    int updateByExampleSelective(SysVersion sysVersion);

    /**
     * 删除版本信息
     *
     * @param params
     */
    void deleteByIds(Map<String, Object> params);

    /**
     * 编辑的时候查询除了此条数据之外是否有相同的版本号
     *
     * @param params
     * @return
     */
    List<SysVersion> selectExitByVId(Map<String, Object> params);

    /**
     * 描述：app端获取最新版本信息
     *
     * @return
     */
    SysVersion latestVersion();
}