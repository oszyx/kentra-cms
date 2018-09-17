package com.kentrasoft.cms.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="kentra-cms-bis")
public interface IRibbonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/zipkin/simple")
    String ribbonClientCall();

    @RequestMapping(method = RequestMethod.GET, value="/zipkin/sleep")
    String ribbonClientCallSleep();
}