package com.forsfortis.rims.server;

import javax.ws.rs.core.MultivaluedMap;

import com.forsfortis.rims.client.DiscoveryService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class DiscoveryServiceImpl extends RemoteServiceServlet implements DiscoveryService {
	
	private static final String START_DISCOVERY="managementservice/startdiscovery";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String startDiscovery(String startIp, String endIp) throws IllegalArgumentException {
		Client client = new Client();
		WebResource webResource = client.resource(ServerConfig.getInstance().getRemoteHost()+START_DISCOVERY);

		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("startIp", startIp);
		formData.add("endIp", endIp);
		ClientResponse response = webResource.type("application/x-www-form-urlencoded").post(ClientResponse.class, formData);
		final String entity = response.getEntity(String.class);
		System.out.println("discory status :" + entity);
		return "";
		// return null;
	}

}
