package com.infy.client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;




public class AccountSummaryView extends Composite implements ClickHandler {
	
	
	
	

  public AccountSummaryView(String customerName) {

    // The input widgets will be stacked from top to bottom, so a vertical panel
    // is created and used as the base panel of the composite object.
    final VerticalPanel accountViewMainPanel = new VerticalPanel();

    // Each input elements requires a label and input field. These should be
    // displayed together from left to right. So, a horizontal panel needs to be
    // created for each input
    final HorizontalPanel menubarHPanel = new HorizontalPanel();
    final HorizontalPanel printerHPanel = new HorizontalPanel();
    //hPanelItem1.setWidth("100px");
    Button signOut=new Button();
    signOut.setText("Sign Out");
    signOut.setStyleName("signout-button");
    signOut.addClickHandler(this);
    Label customerLbl=new Label();
    customerLbl.setText("Welcome  "+customerName.toUpperCase());
   Label loginTimeLbl=new Label();
   //SimpleDateFormat dateTimeFormatter=new SimpleDateFormat("MMM/dd/yyyy 'at' hh:mm:ss a z");
   //String currentTime=dateTimeFormatter.format(new Date());
   loginTimeLbl.setText("Last Login: "+new Date().toGMTString());
    accountViewMainPanel.add(customerLbl);
    accountViewMainPanel.add(loginTimeLbl);
    menubarHPanel .add(createMenuBar());
    menubarHPanel.add(signOut);      
    menubarHPanel.setStyleName("menubar-HPanel");
    accountViewMainPanel.add(menubarHPanel);
    //Label summaryLbl =new Label();
   // summaryLbl.setText("Account Summary");
   // Image image=new Image();
  //  image.setUrl(GWT.getModuleBaseURL()+"images/printer.png");
	//image.setSize("100px","100px");
	/*
    Hyperlink printerLink =new Hyperlink();
    printerLink.setText("Print this Page");
    printerLink.addDomHandler(new ClickHandler()
    		{

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					//printIframeContent("printiframe"); 
					//new Showcase();
					//new RegistrationPopup().show();
					//new RegistrationPopup();
				}
    	
    		}, ClickEvent.getType());
    
    printerHPanel.add(summaryLbl);
    printerHPanel.add(image);    
    printerHPanel.add(printerLink);
    */
    //printerHPanel.add(new PrinterUIBinder());
    //printerHPanel.setStyleName("printer-Panel");
    //accountViewMainPanel.add(printerHPanel);
    
    
    accountViewMainPanel.add(new PhotosView());
   
    // The initWidget(...) method is called with the base element of the
    // composite.
    // The base element that contains all other elements is the vertical
    // panel you created in the beginning of this constructor.
    initWidget(accountViewMainPanel);
  }

@Override
public void onClick(ClickEvent event) {
	// TODO Auto-generated method stub
	Window.alert("Sign Out Button Triggered");
	RootPanel.get().clear();
	
}

 private MenuBar createMenuBar()
 {

	    //create menu bar
	    MenuBar menu = new MenuBar();
	    menu.setAutoOpen(true);
	   // menu.setWidth("600px");
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
	    
	    
	    MenuBar billPayandRechargeMenu = new MenuBar(true);
	    billPayandRechargeMenu.setAnimationEnabled(true);
	    billPayandRechargeMenu.addItem("Utility Bill",new Command() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    MenuBar cardsMenu = new MenuBar(true);
	    cardsMenu.setAnimationEnabled(true);
	    cardsMenu.addItem("Debit Card",new Command() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    cardsMenu.addItem("Credit Card",new Command() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	    MenuBar dematMenu = new MenuBar(true);
	    dematMenu.setAnimationEnabled(true);
	    dematMenu.addItem("View",new Command() {

			@Override
			public void execute() {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	    //add sub menus to main menu
	    
	    menu.addItem(new MenuItem("Accounts",accountsMenu));
	    menu.addItem(new MenuItem("Fund Transfer",fundTransferMenu ));
	    menu.addItem(new MenuItem("Bill Pay & Recharge",billPayandRechargeMenu));
	    menu.addItem(new MenuItem("Cards",cardsMenu));
	    menu.addItem(new MenuItem("Demat",dematMenu));
	    menu.setStyleName("menubar-HPanel");
	    return menu;
 }
 
	


 
}
