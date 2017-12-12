package com.qipai.jpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.qipai.jpa.*" })
@PropertySource("classpath:application.properties")  
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.qipai.jpa.repo")
public class AppConfig implements EnvironmentAware{
private Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment=environment;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}
	@Bean
	@Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds){  
		 final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		 emf.setDataSource(ds);
	     final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	     adapter.setDatabase(Database.MYSQL);
	     adapter.setShowSql(false);
	     adapter.setGenerateDdl(false);
	     adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
	     Properties jpaProperties=new Properties();  
	     jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");//validate,create,create-drop
	     emf.setPackagesToScan("com.qipai.jpa.domain");
	     emf.setJpaVendorAdapter(adapter);
	     emf.setJpaProperties(jpaProperties);
	     return emf;
    }
	@Bean
	@Autowired
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf){  
        JpaTransactionManager transactionManager=new JpaTransactionManager();  
        transactionManager.setEntityManagerFactory(emf.getObject());  
        return transactionManager;  
    }
	@Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){  
		PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor=new PersistenceAnnotationBeanPostProcessor();  
        return persistenceAnnotationBeanPostProcessor;  
    }

}
