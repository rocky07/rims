package com.forsfortis.rims.client;

import com.google.gwt.i18n.client.Messages.DefaultMessage;
import com.google.gwt.i18n.server.Message;

public interface RimsMessages extends Message{
	@DefaultMessage("Start Ip")
	String startIp();
	@DefaultMessage("End Ip")
	String endtIp();
	@DefaultMessage("Start")
	String start();
	@DefaultMessage("Cancel")
	String cancel();
	//validation messages
	@DefaultMessage("Enter a Valid Ip ")
	String enterValidIp();
	
	
	
}
