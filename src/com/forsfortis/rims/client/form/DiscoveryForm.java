package com.forsfortis.rims.client.form;


import com.forsfortis.rims.client.util.dbservice.ServiceFactory;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer.CssFloatData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.EmptyValidator;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;
import com.sencha.gxt.widget.core.client.info.Info;

public class DiscoveryForm extends FramedPanel{

	private static final String IPADDRESS_PATTERN = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	Window w;
	private TextField startIpField;
	private TextField endIpField;
	DiscoveryForm() {
		 TextButton startButton=null;
		TextButton endButton =null;
		 SelectHandler selectHandler = new SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					// TODO Auto-generated method stub
					if(((TextButton)event.getSource()).getText()=="Start" ){
						if(!validateFields()){
							return;
						}
						ServiceFactory.getinstance().getDiscoveryService().startDiscovery(startIpField.getText(),endIpField.getText(), new AsyncCallback<String>(){

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Info.display("Success", "Discovery Process failed to start");
								w.hide();
							}

							@Override
							public void onSuccess(String result) {
								// TODO Auto-generated method stub
								Info.display("Success", "Discovery Process is started!");
								w.hide();
							}
							
						});
					}
					else{
						w.hide();
					}
				}
			};
		startButton = new TextButton("Cancel",selectHandler);
			endButton = new TextButton("Start",selectHandler);
			startIpField = new TextField();
			startIpField.addValidator(new EmptyValidator<String>());
			startIpField.addValidator(new RegExValidator(IPADDRESS_PATTERN,"Enter a Valid Ip"));
			endIpField = new TextField();
			endIpField.addValidator(new EmptyValidator<String>());
			endIpField.addValidator(new RegExValidator(IPADDRESS_PATTERN,"Enter a Valid Ip"));
			CssFloatLayoutContainer columns = new CssFloatLayoutContainer();
			HorizontalLayoutData containerData=new HorizontalLayoutData();
			containerData.setMargins(new Margins(5));
			columns.add(new FieldLabel(startIpField,"Start IP"),new CssFloatData(.5,new Margins(5)));
			columns.add(new FieldLabel(endIpField,"End IP"),new CssFloatData(.5,new Margins(5)));
			this.add(columns);
			w=new Window();
			w.setHeading("Start Discovery");
			
			w.addButton(startButton);
			
			w.addButton(endButton);
			w.add(this);
					
	}
	
	public void show(){
		w.show();
	}
	
	static Long toNumeric(String ip) {
		String[] output = ip.split("\\.");
        return 
            (Long.valueOf(output[0]) << 24) + 
            (Long.valueOf(output[1]) << 16) + 
            (Long.valueOf(output[2]) << 8) + 
            (Long.valueOf(output[3])); 
    }
	
	public boolean isIpGreater(String startIp,String endIp){
		return toNumeric(startIp)>toNumeric(endIp);
	}
	public boolean validateFields(){
		boolean isValid=true;
		final boolean ipGreater = isIpGreater(startIpField.getText(), endIpField.getText());
		if(ipGreater){
			endIpField.forceInvalid("End ip should be greater than start ip");
			isValid=false;
		}
		return isValid;
	}
	
}
