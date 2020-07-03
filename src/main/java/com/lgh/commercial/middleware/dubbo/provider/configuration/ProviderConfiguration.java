package com.lgh.commercial.middleware.dubbo.provider.configuration;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.lgh.commercial.middleware.dubbo")
@PropertySource("classpath:dubbo-provider.properties")
public class ProviderConfiguration {
}
