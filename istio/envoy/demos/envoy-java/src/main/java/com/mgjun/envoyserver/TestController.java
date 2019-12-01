package com.mgjun.envoyserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/service")
public class TestController {

    @GetMapping("/{serviceName}")
    public String get(@PathVariable String serviceName) throws UnknownHostException {
        return String.format("get request from service{ %s }, local address: %s", serviceName, Inet4Address.getLocalHost()
                                                                                                           .getHostAddress());
    }
}
