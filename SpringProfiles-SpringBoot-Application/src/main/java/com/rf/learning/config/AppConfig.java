package com.rf.learning.config;

import com.rf.learning.api.SystemPrinter;
import com.rf.learning.impl.SystemPrinterDevImpl;
import com.rf.learning.impl.SystemPrinterProdImpl;
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
