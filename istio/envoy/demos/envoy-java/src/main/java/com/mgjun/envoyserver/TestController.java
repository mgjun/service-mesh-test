package com.mgjun.envoyserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    
    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("get request from remote, send response, say hello");
        return "hello";
    }

    @GetMapping("/hi")
    public String hi() {
        LOGGER.info("get request from remote, send response, say hi");
        return "hi";
    }

    @GetMapping("/self")
    public String self() {
        LOGGER.info("get request from remote, send response, say self");
        return "self";
    }
}
