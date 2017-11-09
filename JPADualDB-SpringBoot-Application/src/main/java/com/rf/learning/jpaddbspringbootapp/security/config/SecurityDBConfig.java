package com.rf.learning.jpaddbspringbootapp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.rf.learning.jpaddbspringbootapp.security.repository",
    entityManagerFactoryRef = "securityEntityManagerFactory",
    transactionManagerRef = "securityTransactionManager"
)
public class SecurityDBConfig
{
  @Autowired
  private Environment env;

  @Bean
  @ConfigurationProperties(prefix = "datasource.security")
  public DataSourceProperties securityDataSourceProperties()
  {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource securityDataSource()
  {
    DataSourceProperties securityDataSourceProperties = securityDataSourceProperties();
    return DataSourceBuilder.create()
        .driverClassName(securityDataSourceProperties.getDriverClassName())
        .url(securityDataSourceProperties.getUrl())
        .username(securityDataSourceProperties.getUsername())
        .password(securityDataSourceProperties.getPassword())
        .build();
  }

  @Bean
  public PlatformTransactionManager securityTransactionManager()
  {
    EntityManagerFactory factory = securityEntityManagerFactory().getObject();
    return new JpaTransactionManager(factory);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean securityEntityManagerFactory()
  {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

    factory.setDataSource(securityDataSource());
    factory.setPackagesToScan("com.rf.learning.jpaddbspringbootapp.security.entity");
    factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    Properties jpaProperties = new Properties();
    jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show-sql"));
    jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
    factory.setJpaProperties(jpaProperties);

    return factory;
  }

  @Bean
  public DataSourceInitializer securityDataSourceInitializer()
  {
    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    dataSourceInitializer.setDataSource(securityDataSource());
    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
    databasePopulator.addScripts(
        new ClassPathResource("security-schema.sql"),
        new ClassPathResource("security-data.sql"));
    dataSourceInitializer.setDatabasePopulator(databasePopulator);
    dataSourceInitializer.setEnabled(Boolean.parseBoolean(env.getProperty("datasource.security.initialize", "false")));
    return dataSourceInitializer;
  }
}
