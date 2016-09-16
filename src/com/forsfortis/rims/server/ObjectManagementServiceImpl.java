package com.forsfortis.rims.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.forsfortis.rims.client.ObjectManagementService;
import com.forsfortis.rims.server.dbservice.DBServiceFactory;
import com.forsfortis.rims.shared.BaseDto;
import com.forsfortis.rims.shared.FolderDto;
import com.forsfortis.util.DeviceName;
import com.forsfortis.util.DeviceType;
import com.forsfortis.util.NetworkObject;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ObjectManagementServiceImpl extends RemoteServiceServlet implements ObjectManagementService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<BaseDto> getObjectManagementTree() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		FolderDto rootFolder=new FolderDto(1, "Root");
		Map<DeviceName,FolderDto> folders=new HashMap<>();
		List<BaseDto> allRootObjects=new ArrayList<>();
 		final List<NetworkObject> allNetworkObjects = DBServiceFactory.getInstance().getObjectManagementDbService().listNetworkObjects();
		int count=0;
		int folderCount=100;
		List<BaseDto> list=new ArrayList<BaseDto>();
		
		/*for (Iterator<NetworkObject> iterator = allNetworkObjects.iterator(); iterator.hasNext();) {
			NetworkObject networkObject =  iterator.next();
			if(networkObject!=null){
			
			//if(!folders.keySet().contains(networkObject.getDeviceName())){
			if(!folders.keySet().contains(networkObject.getDeviceType())){
				FolderDto deviceFolder=new FolderDto(folderCount++, String.valueOf(networkObject.getDeviceType()));
				//FolderDto deviceFolder=new FolderDto(folders.size(), "abc");
				folders.put(networkObject.getDeviceName(),deviceFolder);
				deviceFolder.addChild(new BaseDto(count++, networkObject.getObjectName()+"["+networkObject.getObjectIp()+"]"));
			//	rootFolder.addChild(deviceFolder);
		//		list.add(new BaseDto(count++, networkObject.getObjectName()+"["+networkObject.getObjectIp()+"]"));
				allRootObjects.add(deviceFolder);
				
			}else{
				final FolderDto folderDto = folders.get(networkObject.getDeviceName());
				//folderDto.addChild(new BaseDto(count++, networkObject.getObjectName()+"["+networkObject.getObjectIp()+"]"));
			}
			
		 }
		}*/
		// temp data ..
		
		/*FolderDto rootFolder1=new FolderDto(1111, "Root11");
		rootFolder1.addChild(new BaseDto(11,"hello"));
		rootFolder1.addChild(new BaseDto(13,"hello13"));
		FolderDto rootFolder2=new FolderDto(2, "Root2");
		rootFolder2.addChild(new BaseDto(112,"hello2"));
		rootFolder2.addChild(new BaseDto(132,"hello132"));
		//rootFolder1.addChild(rootFolder2);
		list.add(rootFolder1);
		list.add(rootFolder2);
		list.add(rootFolder);*/
		//list.add(rootFolder2);
		
		
		return list;
	//return allRootObjects;
	}
}
