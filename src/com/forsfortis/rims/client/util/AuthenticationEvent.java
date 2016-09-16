package com.forsfortis.rims.client.util;

import com.google.gwt.event.shared.GwtEvent;

public class AuthenticationEvent extends GwtEvent<AuthenticationEventHandlers> {

	public static Type<AuthenticationEventHandlers> TYPE=new Type<AuthenticationEventHandlers>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AuthenticationEventHandlers> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AuthenticationEventHandlers handler) {
		handler.onAuthenticationChanged(this);
	}

}
