package com.kentrasoft.cms.basic.client;

import com.kentrasoft.cms.basic.client.fallback.UserRemoteFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "kentra-cms-basicApi", fallback = UserRemoteFallback.class)
public interface UserRemote {


}
