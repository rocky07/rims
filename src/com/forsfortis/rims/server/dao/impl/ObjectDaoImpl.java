package com.forsfortis.rims.server.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.forsfortis.rims.server.dao.ObjectDAO;
import com.forsfortis.util.NetworkObject;

public class ObjectDaoImpl implements ObjectDAO{
	private static final String NETWORK_OBJECTS_COLLECTION="networkobjects";
	private MongoOperations mongoOps;
	public ObjectDaoImpl(){
		
	}
	
	public ObjectDaoImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	@Override
	public List<NetworkObject> getAllNetworkObjects() {
		return this.mongoOps.findAll(NetworkObject.class, NETWORK_OBJECTS_COLLECTION);
	}

}
