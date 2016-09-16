package com.forsfortis.rims.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */

@RemoteServiceRelativePath("discoveryservice")
public interface DiscoveryService extends RemoteService {
  String startDiscovery(String startIp,String endIp) throws IllegalArgumentException;
}
