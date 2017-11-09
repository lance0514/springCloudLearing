package com.ribbonconsumer.ribbonconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    RestTemplate restTemplate;

    @GetMapping("/ribbon-com")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }
}
