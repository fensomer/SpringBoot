package com.rf.learning.jpaddbspringbootapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class WebMvcConfig
{
  @Bean
  public OpenEntityManagerInViewFilter securityOpenEntityManagerInViewFilter()
  {
    OpenEntityManagerInViewFilter osInViewFilter = new OpenEntityManagerInViewFilter();
    osInViewFilter.setEntityManagerFactoryBeanName("securityEntityManagerFactory");
    return osInViewFilter;
  }

  @Bean
  public OpenEntityManagerInViewFilter ordersOpenEntityManagerInViewFilter()
  {
    OpenEntityManagerInViewFilter osInViewFilter = new OpenEntityManagerInViewFilter();
    osInViewFilter.setEntityManagerFactoryBeanName("ordersEntityManagerFactory");
    return osInViewFilter;
  }
}
