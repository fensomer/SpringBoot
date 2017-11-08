package com.rf.com.rf.learning.profilesspringbootapp.config;

import com.rf.com.rf.learning.profilesspringbootapp.api.SystemPrinter;
import com.rf.com.rf.learning.profilesspringbootapp.impl.SystemPrinterDevImpl;
import com.rf.com.rf.learning.profilesspringbootapp.impl.SystemPrinterProdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig
{
  @Bean
  @Profile("DEV")
  public SystemPrinter systemPrinterDevImpl() {
    return new SystemPrinterDevImpl();
  }

  @Bean
  @Profile("PROD")
  public SystemPrinter systemPrinterProdImpl()
  {
    return new SystemPrinterProdImpl();
  }
}
