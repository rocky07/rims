package com.forsfortis.rims.client.util.dbservice;

import com.forsfortis.rims.client.DiscoveryService;
import com.forsfortis.rims.client.DiscoveryServiceAsync;
import com.forsfortis.rims.client.ObjectManagementService;
import com.forsfortis.rims.client.ObjectManagementServiceAsync;
import com.google.gwt.core.client.GWT;

public class ServiceFactory {
	private static ServiceFactory instance=null;
	private ServiceFactory(){
	}
	
	public static ServiceFactory getinstance(){
		if(instance==null){
			instance=new ServiceFactory();
		}
		return instance; 
	}
	
	public DiscoveryServiceAsync getDiscoveryService(){
		return GWT.create(DiscoveryService.class);
	}

	public ObjectManagementServiceAsync getObjectManagementService() {
		return GWT.create(ObjectManagementService.class);
	}
}
