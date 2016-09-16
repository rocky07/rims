package com.forsfortis.rims.client.util;

import com.google.gwt.event.shared.EventHandler;

public interface AuthenticationEventHandlers extends EventHandler {
	public void onAuthenticationChanged(AuthenticationEvent authenticationEvent);
}
