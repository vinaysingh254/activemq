package com.vs.mq.sp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import com.vs.mq.constants.SPConstant;

public class HostConfigSP extends StoredProcedure implements SPConstant {
	public HostConfigSP (JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, HOST_CONFIG);
		setFunction(false);
	}
}
