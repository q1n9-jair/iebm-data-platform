package com.iebm.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
public class DataSourceConfig {

		@ConfigurationProperties(prefix = "datasource.druid")
		@Bean(name = "datasource", initMethod = "init", destroyMethod = "close")
		public DruidDataSource getDataSource() {
			return new DruidDataSource();
		}

		@Bean
		public PlatformTransactionManager transactionManager() {
			return new DataSourceTransactionManager(getDataSource());
		}
}
