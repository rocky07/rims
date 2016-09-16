package com.forsfortis.rims.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DiscoveryServiceAsync {
  void startDiscovery(String startIp,String endIp, AsyncCallback<String> callback)
      throws IllegalArgumentException;
}
