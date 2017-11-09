package com.rf.learning.jpaddbspringbootapp.orders.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.rf.learning.jpaddbspringbootapp.orders.repository",
    entityManagerFactoryRef = "ordersEntityManagerFactory",
    transactionManagerRef = "ordersTransactionManager"
)
public class OrdersDBConfig
{
  @Autowired
  private Environment env;

  @Bean
  @ConfigurationProperties(prefix = "datasource.orders")
  public DataSourceProperties ordersDataSourceProperties()
  {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource ordersDataSource()
  {
    DataSourceProperties ordersDataSourceProperties = ordersDataSourceProperties();
    return DataSourceBuilder.create()
        .driverClassName(ordersDataSourceProperties.getDriverClassName())
        .url(ordersDataSourceProperties.getUrl())
        .username(ordersDataSourceProperties.getUsername())
        .password(ordersDataSourceProperties.getPassword())
        .build();
  }

  @Bean
  public PlatformTransactionManager ordersTransactionManager()
  {
    EntityManagerFactory factory = ordersEntityManagerFactory().getObject();
    return new JpaTransactionManager(factory);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean ordersEntityManagerFactory()
  {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(ordersDataSource());
    factory.setPackagesToScan("com.rf.learning.jpaddbspringbootapp.orders.entity");
    factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    Properties jpaProperties = new Properties();
    jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show-sql"));
    jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
    factory.setJpaProperties(jpaProperties);

    return factory;
  }

  @Bean
  public DataSourceInitializer ordersDataSourceInitializer()
  {
    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    dataSourceInitializer.setDataSource(ordersDataSource());
    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
    databasePopulator.addScripts(
        new ClassPathResource("orders-schema.sql"),
        new ClassPathResource("orders-data.sql"));
    dataSourceInitializer.setDatabasePopulator(databasePopulator);
    dataSourceInitializer.setEnabled(Boolean.parseBoolean(env.getProperty("datasource.orders.initialize", "false")));
    return dataSourceInitializer;
  }
}
