package com.ck.test;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ck.springbootdemo.modules.Application;

@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class SpringTransactionalContextTests extends AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
	
}