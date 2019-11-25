package com.mgjun.envoyweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {
    
    @Bean
    public RestTemplate restTemplate(SimpleClientHttpRequestFactory httpRequestFactory) {
        return new RestTemplate(httpRequestFactory);
    }
    
    @Bean
    public SimpleClientHttpRequestFactory httpClientFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20000);
        factory.setConnectTimeout(5000);
        return factory;
    }
}
