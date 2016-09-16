package com.forsfortis.rims.client;

import java.util.List;

import com.forsfortis.rims.shared.BaseDto;
import com.forsfortis.rims.shared.FolderDto;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ObjectManagementServiceAsync {
	void getObjectManagementTree(AsyncCallback<List<BaseDto>> callback) throws IllegalArgumentException;
	
}
