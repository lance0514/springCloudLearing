package com.didispace.hello;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        logger.info("/hello,host:" + serviceInstance.getHost() + ",server_id" + serviceInstance.getServiceId());
        return "Hello world1111";
    }
}
