package com.infy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AccountSummaryView extends Composite implements ClickHandler {

  

  public AccountSummaryView() {

    // The input widgets will be stacked from top to bottom, so a vertical panel
    // is created and used as the base panel of the composite object.
    final VerticalPanel loanFormMainPanel = new VerticalPanel();

    // Each input elements requires a label and input field. These should be
    // displayed together from left to right. So, a horizontal panel needs to be
    // created for each input
    final HorizontalPanel hPanelItem1 = new HorizontalPanel();
    hPanelItem1.setWidth("1800px");
    Button signOut=new Button();
    signOut.setText("Sign Out");
    signOut.setStyleName("signout-button");
    signOut.addClickHandler(this);
    
    
    //create menu bar
    MenuBar menu = new MenuBar();
    menu.setAutoOpen(true);
    menu.setWidth("600px");
    menu.setAnimationEnabled(true);
    
    //add accounts
    MenuBar accountsMenu = new MenuBar(true);
    accountsMenu.setAnimationEnabled(true);
    accountsMenu.addItem("Savings",new Command() {

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
    	
    });
    accountsMenu.addItem("Current",new Command() {

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
    	
    });
    
    //add fund transfer
    MenuBar fundTransferMenu = new MenuBar(true);
    fundTransferMenu.setAnimationEnabled(true);
    fundTransferMenu.addItem("Add Beneficiary",new Command() {

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
    	
    });
    fundTransferMenu.addItem("UPI Payment",new Command() {

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
    	
    });
    
    fundTransferMenu.addItem("IMPS",new Command() {

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
    	
    });
    
    fundTransferMenu.addItem("RTGS",new Command() {

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
    	
    });
    
    
    //add sub menus to main menu
    
    menu.addItem(new MenuItem("Accounts",accountsMenu));
    menu.addItem(new MenuItem("Fund Transfer",fundTransferMenu ));
    
    hPanelItem1 .add(menu);
    hPanelItem1 .add(signOut);
    loanFormMainPanel.add(hPanelItem1);
    hPanelItem1.setStyleName("loanForm-Panel");

    

    // The initWidget(...) method is called with the base element of the
    // composite.
    // The base element that contains all other elements is the vertical
    // panel you created in the beginning of this constructor.
    initWidget(loanFormMainPanel);
  }

@Override
public void onClick(ClickEvent event) {
	// TODO Auto-generated method stub
	Window.alert("Sign Out Button Triggered");
	RootPanel.get().clear();
	
}

 
 
}
