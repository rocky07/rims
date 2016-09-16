package com.forsfortis.rims.server.dbservice;

import java.util.List;

import com.forsfortis.rims.server.dao.ObjectDAO;
import com.forsfortis.util.NetworkObject;

public class ObjectManagementDbService{
	private ObjectDAO objectDAO;
	public ObjectManagementDbService(){
	}
	
	public ObjectDAO getObjectDAO() {
		return objectDAO;
	}
	
	public void setObjectDAO(ObjectDAO objectDAO) {
		this.objectDAO = objectDAO;
	}
	
	public List<NetworkObject> listNetworkObjects() {
		return objectDAO.getAllNetworkObjects();
	}
}
