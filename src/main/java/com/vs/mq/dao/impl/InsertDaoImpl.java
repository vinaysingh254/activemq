package com.vs.mq.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.vs.mq.dao.InsertDao;
import com.vs.mq.model.HostInfoEntity;

/** @author Vinay Singh */
public class InsertDaoImpl implements InsertDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;

	public void setDataSource (DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public DataSource getDataSource () {
		return dataSource;
	}

	public void setTransactionManager (PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public boolean insertHostConfig (HostInfoEntity hostInfoEntity) throws Exception {
		return false;
	}
}
