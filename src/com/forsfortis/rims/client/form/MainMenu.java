package com.forsfortis.rims.client.form;

import com.forsfortis.rims.client.util.AppEventHandler;
import com.forsfortis.rims.client.util.AppUtils;
import com.forsfortis.rims.client.util.ApplicationEvent;
import com.forsfortis.rims.client.util.ApplicationEvent.EventType;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBar;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

public class MainMenu implements IsWidget {

	private static final String START_DISCOVERY = "Start Discovery";

	@Override
	public Widget asWidget() {

		AppUtils.EVENT_BUS.addHandler(ApplicationEvent.TYPE, new AppEventHandler() {

			@Override
			public void startDiscoveryEvent(ApplicationEvent event) {
				// TODO Auto-generated method stub
				System.out.println("start discovery event :: invoked");
				 /*final ConfirmMessageBox mb = new ConfirmMessageBox("Confirmation Required", "Are you ready?");
				    mb.addDialogHideHandler(new DialogHideHandler() {
				      @Override
				      public void onDialogHide(DialogHideEvent event) {
				        switch (event.getHideButton()) {
				          case YES:
				            //Perform YES action
				            break;
				          case NO:
				            //perform NO action
				            break;
				          default:
				            //error, button added with no specific action ready
				        }
				      }
				    });
				    mb.setWidth(300);
				    mb.show();*/
				new DiscoveryForm().show();
			}

			@Override
			public void onSave(ApplicationEvent event) {
				// TODO Auto-generated method stub

			}
		});
		// if(menuBar==null){
		Menu adminOperationsMenu = new Menu();
		adminOperationsMenu.add(new MenuItem(START_DISCOVERY));
		adminOperationsMenu.add(new MenuItem("Start Agent"));
		adminOperationsMenu.addSelectionHandler(new SelectionHandler<Item>() {
			@Override
			public void onSelection(SelectionEvent<Item> event) {
				if(((MenuItem)event.getSelectedItem()).getText().equals(START_DISCOVERY))
				AppUtils.EVENT_BUS.fireEvent(new ApplicationEvent(EventType.START_DISCOVERY));
			}
		});

		MenuBarItem menubarItem = new MenuBarItem("Operations", adminOperationsMenu);
		MenuBar menuBar = new MenuBar();
		menuBar.setHeight(-1);
		menuBar.add(menubarItem);
		/// }

		return menuBar;
	}

}
