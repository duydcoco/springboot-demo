package com.ck.springbootdemo.modules.conf;

import java.util.Arrays;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.StringUtil;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware{
	private static Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
	
	private Environment environment;
    private RelaxedPropertyResolver datasourcePropertyResolver;
	
    //从application.yml中读取资源
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
		this.datasourcePropertyResolver = new RelaxedPropertyResolver(environment,
                "spring.datasource.");
	}
	
	@Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() {
        log.debug("Configruing DataSource");
        if (StringUtil.isEmpty(datasourcePropertyResolver.getProperty("url"))) {
            log.error("Your database conncetion pool configuration is incorrct ! The application "
                    + "cannot start . Please check your jdbc");
            Arrays.toString(environment.getActiveProfiles());
            throw new ApplicationContextException(
                    "DataBase connection pool is not configured correctly");
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(datasourcePropertyResolver.getProperty("url"));
        druidDataSource.setUsername(datasourcePropertyResolver.getProperty("username"));
        druidDataSource.setPassword(datasourcePropertyResolver.getProperty("password"));
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        return druidDataSource;
    }

}
