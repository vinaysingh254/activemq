package com.vs.mq.dao;

import com.vs.mq.model.HostInfoEntity;

public interface InsertDao {
	public boolean insertHostConfig (HostInfoEntity hostInfoEntity) throws Exception;
}
