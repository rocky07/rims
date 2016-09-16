package com.forsfortis.rims.client;

import java.util.logging.Logger;

import com.forsfortis.rims.client.form.DiscoveryForm;
import com.forsfortis.rims.client.form.MainMenu;
import com.forsfortis.rims.client.tree.ObjectTree;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBar;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Rims implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	
	private static void intialConfig(){
		//loads init config
		
	}
	
	public void onModuleLoad() {

		Viewport viewport = new Viewport();
		BorderLayoutContainer main = new BorderLayoutContainer();
		ContentPanel centerPanel = new ContentPanel();
		MarginData layoutDataCenter = new MarginData(5);

		ContentPanel eastPanel = new ContentPanel();
		BorderLayoutData eastData = new BorderLayoutData(250);
		eastPanel.setWidget(new ObjectTree());
		eastData.setCollapsible(true);
		eastData.setSplit(true);
		eastData.setMargins(new Margins(5));
		main.setNorthWidget(new MainMenu().asWidget(),new BorderLayoutData(26));
		main.setCenterWidget(centerPanel, layoutDataCenter);
		main.setWestWidget(eastPanel, eastData);
		viewport.add(main);

		RootPanel.get().add(viewport);

		/*
		 * 
		 * TextButton textButton = new TextButton("Verify GXT Works");
		 * RootPanel.get().add(textButton); textButton.addSelectHandler(new
		 * SelectHandler() {
		 * 
		 * @Override public void onSelect(SelectEvent event) { MessageBox
		 * messageBox = new MessageBox("GXT Works."); messageBox.show(); } });
		 * 
		 * 
		 * final Button sendButton = new Button("Send"); final TextBox nameField
		 * = new TextBox(); nameField.setText("GWT User"); final Label
		 * errorLabel = new Label();
		 * 
		 * // We can add style names to widgets
		 * sendButton.addStyleName("sendButton");
		 * 
		 * // Add the nameField and sendButton to the RootPanel // Use
		 * RootPanel.get() to get the entire body element
		 * RootPanel.get("nameFieldContainer").add(nameField);
		 * RootPanel.get("sendButtonContainer").add(sendButton);
		 * RootPanel.get("errorLabelContainer").add(errorLabel);
		 * 
		 * // Focus the cursor on the name field when the app loads
		 * nameField.setFocus(true); nameField.selectAll();
		 * 
		 * // Create the popup dialog box final DialogBox dialogBox = new
		 * DialogBox(); dialogBox.setText("Remote Procedure Call");
		 * dialogBox.setAnimationEnabled(true); final Button closeButton = new
		 * Button("Close"); // We can set the id of a widget by accessing its
		 * Element closeButton.getElement().setId("closeButton"); final Label
		 * textToServerLabel = new Label(); final HTML serverResponseLabel = new
		 * HTML(); VerticalPanel dialogVPanel = new VerticalPanel();
		 * dialogVPanel.addStyleName("dialogVPanel"); dialogVPanel.add(new HTML(
		 * "<b>Sending name to the server:</b>"));
		 * dialogVPanel.add(textToServerLabel); dialogVPanel.add(new HTML(
		 * "<br><b>Server replies:</b>"));
		 * dialogVPanel.add(serverResponseLabel);
		 * dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		 * dialogVPanel.add(closeButton); dialogBox.setWidget(dialogVPanel);
		 * 
		 * // Add a handler to close the DialogBox
		 * closeButton.addClickHandler(new ClickHandler() { public void
		 * onClick(ClickEvent event) { dialogBox.hide();
		 * sendButton.setEnabled(true); sendButton.setFocus(true); } });
		 * 
		 * // Create a handler for the sendButton and nameField class MyHandler
		 * implements ClickHandler, KeyUpHandler {
		 *//**
			 * Fired when the user clicks on the sendButton.
			 */
		/*
		 * public void onClick(ClickEvent event) { sendNameToServer(); }
		 * 
		 *//**
			 * Fired when the user types in the nameField.
			 */
		/*
		 * public void onKeyUp(KeyUpEvent event) { if (event.getNativeKeyCode()
		 * == KeyCodes.KEY_ENTER) { sendNameToServer(); } }
		 * 
		 *//**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
		/*
		 * private void sendNameToServer() { // First, we validate the input.
		 * errorLabel.setText(""); String textToServer = nameField.getText(); if
		 * (!FieldVerifier.isValidName(textToServer)) { errorLabel.setText(
		 * "Please enter at least four characters"); return; }
		 * 
		 * // Then, we send the input to the server.
		 * sendButton.setEnabled(false);
		 * textToServerLabel.setText(textToServer);
		 * serverResponseLabel.setText("");
		 * greetingService.greetServer(textToServer, new AsyncCallback<String>()
		 * { public void onFailure(Throwable caught) { // Show the RPC error
		 * message to the user dialogBox.setText(
		 * "Remote Procedure Call - Failure");
		 * serverResponseLabel.addStyleName("serverResponseLabelError");
		 * serverResponseLabel.setHTML(SERVER_ERROR); dialogBox.center();
		 * closeButton.setFocus(true); }
		 * 
		 * public void onSuccess(String result) { dialogBox.setText(
		 * "Remote Procedure Call");
		 * serverResponseLabel.removeStyleName("serverResponseLabelError");
		 * serverResponseLabel.setHTML(result); dialogBox.center();
		 * closeButton.setFocus(true); } }); } }
		 * 
		 * // Add a handler to send the name to the server MyHandler handler =
		 * new MyHandler(); sendButton.addClickHandler(handler);
		 * nameField.addKeyUpHandler(handler);
		 */}
}
