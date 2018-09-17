package com.kentrasoft.cms.auth.controller;

import com.kentrasoft.cms.auth.feign.IRibbonClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("AUTH-SimpleCtl接口")
@RestController
public class SimpleCtl {
    private static final Logger log = LoggerFactory.getLogger(SimpleCtl.class);
    @Autowired
    private IRibbonClient ribbonClient;

    @ApiOperation(value="/zipkin/simple方法")
	@RequestMapping(value="/zipkin/simple")
    public String simpleClientCall(){
        log.info("call " + this.getClass().getSimpleName() + " simpleClientCall" );
		return "rsp: " + ribbonClient.ribbonClientCall();
    }
    @ApiOperation(value="/zipkin/sleep方法")
    @RequestMapping(value="/zipkin/sleep")
    public String simpleClientCallSleep(){
        return "sleep rsp: " + ribbonClient.ribbonClientCallSleep();
    }
}
