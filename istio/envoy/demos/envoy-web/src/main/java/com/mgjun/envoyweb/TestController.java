package com.mgjun.envoyweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/envoy-web")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/local")
    public String sayLocal() {
        LOGGER.info("get request, send response");
        return "local";
    }

    @GetMapping("/hello")
    public String sayHello() {
        String url = "http://127.0.0.1:10000/envoy-server/hello";
        LOGGER.info("get request, send rest template to {}", url);
        return getRemote(url, "mock value for hello");
    }

    @GetMapping("/hi")
    public String sayHi() {
        String url = "http://127.0.0.1:10000/envoy-server/hi";
        LOGGER.info("get request, send rest template to {}", url);
        return getRemote(url, "mock value for hi");
    }

    @GetMapping("/self")
    public String saySelf() {
        String url = "http://127.0.0.1:10000/envoy-server/self";
        LOGGER.info("get request, send rest template to {}", url);
        return getRemote(url, "mock value for self");
    }

    private String getRemote(String url, String mock) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch (Exception e) {
            LOGGER.error("error happens: ", e);
            return mock;
        }
    }
}
