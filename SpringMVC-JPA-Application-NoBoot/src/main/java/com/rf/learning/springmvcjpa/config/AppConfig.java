package com.rf.learning.springmvcjpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.rf.learning.springmvcjpa.repos")
@PropertySource(value = {"classpath:application.properties"})
public class AppConfig
{

}
