package com.kentrasoft.cms.controller.version;

import com.kentrasoft.cms.dao.SysVersionMapper;
import com.kentrasoft.cms.entity.SysVersion;
import com.kentrasoft.cms.service.SysVersionService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/version")
public class SysVersionController {

    @Autowired
    private SysVersionService sysVersionService;
    @Autowired
    private SysVersionMapper sysVersionMapper;

    /**
     * 描述：获取版本列表
     *
     * @param
     */
    @RequestMapping(value = "/getVersionList")
    @ResponseBody
    public PageForm<SysVersion> getVersionList(PageForm<SysVersion> page, SysVersion sysVersion) {
        page.setModel(sysVersion);
        return sysVersionService.getVersionList(page);
    }

    /**
     * 描述：添加版本信息
     *
     * @param sysVersion
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(SysVersion sysVersion) {
        return sysVersionService.add(sysVersion);
    }

    /**
     * 描述：删除led信息，PS:维修记录保留
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return sysVersionService.delete(ids);
    }

    /**
     * 描述：编辑版本信息
     *
     * @param sysVersion
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(SysVersion sysVersion) {
        return sysVersionService.edit(sysVersion);
    }
}
