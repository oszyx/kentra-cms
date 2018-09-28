package com.kentrasoft.cms.controller.version;

import com.kentrasoft.cms.dao.SysVersionMapper;
import com.kentrasoft.cms.entity.SysVersion;
import com.kentrasoft.utils.plugin.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class AppVersionController {

    @Autowired
    private SysVersionMapper sysVersionMapper;

    /**
     * 描述：app端获取最新版本信息
     *
     * @return
     */
    @RequestMapping(value = "/latestVersion")
    @ResponseBody
    public BaseResult latestVersion() {
        SysVersion sysVersion = sysVersionMapper.latestVersion();
        return BaseResult.success("获取成功！", sysVersion);
    }


}
