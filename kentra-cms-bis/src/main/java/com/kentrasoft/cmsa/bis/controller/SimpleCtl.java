package com.kentrasoft.cmsa.bis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Api("BIS-SimpleCtl接口")
@RestController
public class SimpleCtl {
    private AtomicInteger count = new AtomicInteger();
    private AtomicInteger sleepCount = new AtomicInteger();
    @ApiOperation(value="/zipkin/simple方法")
	@GetMapping(value="/zipkin/simple")
    public String ribbonClientCall(){
	    int newCount = count.incrementAndGet();
	    System.out.println("-------------- ribbonClientCall -----------------");
		return "zipkin" + newCount + ": " + ThreadLocalRandom.current().nextInt(1000);
    }
    @ApiOperation(value="/zipkin/sleep方法")
    @GetMapping(value="/zipkin/sleep")
    public String ribbonClientCallSleep(){
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int newCount = sleepCount.incrementAndGet();
        return "zipkin sleep " + newCount + ": " + ThreadLocalRandom.current().nextInt(1000);
    }
}
