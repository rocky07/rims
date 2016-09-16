package com.forsfortis.rims.client.util;

import com.google.gwt.event.shared.EventHandler;

public interface AppEventHandler extends EventHandler {
	void onSave(ApplicationEvent event);
	void startDiscoveryEvent(ApplicationEvent event);
}
