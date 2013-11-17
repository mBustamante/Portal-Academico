package is2.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
class JpaConfig implements TransactionManagementConfigurer {

	@Value("${dataSource.driverClassName}")
	private String driver;

	@Value("${dataSource.url}")
	private String url;

	@Value("${dataSource.username}")
	private String username;

	@Value("${dataSource.password}")
	private String password;

	@Value("${eclipselink.targetDatabase}")
	private String eclipseLinkTargetDatase;

	@Value("${eclipselink.logging.level}")
	private String eclipseLinkLoggingLevel;

	@Value("${eclipselink.queryResultsCache}")
	private String eclipseLinkQueryResultsCache;

	@Value("${eclipselink.ddlGeneration}")
	private String eclipseLinkDdlGeneration;

	@Value("${eclipselink.ddlGeneration.outputMode}")
	private String eclipseLinkOutputMode;

	@Value("${eclipselink.weaving}")
	private String eclipseLinkWeaving;

	@Bean
	public DataSource configureDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(configureDataSource());
		entityManagerFactoryBean.setPackagesToScan("is2");
		entityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());

		Properties jpaProperties = new Properties();
		jpaProperties.put("eclipselink.target-database", eclipseLinkTargetDatase);
		jpaProperties.put("eclipselink.logging.level", eclipseLinkLoggingLevel);
		jpaProperties.put("eclipselink.query-resultsCache", eclipseLinkQueryResultsCache);
		jpaProperties.put("eclipselink.ddl-generation", eclipseLinkDdlGeneration);
		jpaProperties.put("eclipselink.ddl-generation.output-mode", eclipseLinkOutputMode);
		jpaProperties.put("eclipselink.weaving", eclipseLinkWeaving);

		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		PlatformTransactionManager txManager = new JpaTransactionManager();
		AnnotationTransactionAspect.aspectOf().setTransactionManager(txManager);
		return txManager;

	}
}
