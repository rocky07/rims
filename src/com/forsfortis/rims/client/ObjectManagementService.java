package com.forsfortis.rims.client;

import java.util.List;

import com.forsfortis.rims.shared.BaseDto;
import com.forsfortis.rims.shared.FolderDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("objectmanagementservice")
public interface ObjectManagementService extends RemoteService {
	List<BaseDto> getObjectManagementTree() throws IllegalArgumentException;
}
