package com.forsfortis.rims.client.util;

import com.google.gwt.event.shared.GwtEvent;

public class ApplicationEvent extends GwtEvent<AppEventHandler>{

	public static Type<AppEventHandler> TYPE=new Type<AppEventHandler>();
	private EventType eventType;
	
	public enum EventType{
		SAVE,
		START_DISCOVERY
	}
	public ApplicationEvent(EventType eventType){
		this.eventType=eventType;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AppEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AppEventHandler handler) {
		switch (eventType) {
		case SAVE:
			handler.onSave(this);	
			break;
		case START_DISCOVERY:
			handler.startDiscoveryEvent(this);
		default:
			break;
		}
				
	}

}
