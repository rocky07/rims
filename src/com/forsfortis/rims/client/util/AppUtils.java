package com.forsfortis.rims.client.util;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

public class AppUtils {
	public static EventBus EVENT_BUS=GWT.create(SimpleEventBus.class);
}
