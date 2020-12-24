package com.infy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite implements ClickHandler {

	private Label resultLbl;
	private TextBox frmCustomerId;
	private PasswordTextBox frmPassword;
	private VerticalPanel resultPanel;
	private VerticalPanel loginPanel;

  public LoginView() {

    // The input widgets will be stacked from top to bottom, so a vertical panel
    // is created and used as the base panel of the composite object.
    final VerticalPanel loanFormMainPanel = new VerticalPanel();

    // Each input elements requires a label and input field. These should be
    // displayed together from left to right. So, a horizontal panel needs to be
    // created for each input
    final HorizontalPanel hPanelItem1 = new HorizontalPanel();
    hPanelItem1.setWidth("1800px");
    Grid grid =new Grid(4,2);
	//grid.setWidth("300px");
	Label lblCustomerId=new Label();
	lblCustomerId.setText("User ID / Customer ID");
	frmCustomerId=new TextBox();
	Label lblPassword=new Label();
	lblPassword.setText("Password");
	frmPassword=new PasswordTextBox();
	Button frmButton=new Button();
	resultLbl=new Label();
	frmButton.setText("Continue");
	frmButton.setStyleName("login-button");
	frmButton.addClickHandler(this);
	grid.setWidget(0, 0, lblCustomerId);  
	grid.setWidget(0, 1, frmCustomerId);
	grid.setWidget(1, 0, lblPassword);  
	grid.setWidget(1, 1, frmPassword);		
	grid.setWidget(2, 1, frmButton);  
	grid.setWidget(3, 1, resultLbl);
	    // You can use the CellFormatter to affect the layout of the grid's cells.  
	grid.getCellFormatter().setWidth(0,0, "100px");	
	
	
	Grid newNBGrid=new Grid(2,2);
	
	Label frmLabel=new Label();
	frmLabel.setText("New to NetBanking ?");
	Hyperlink newNBhyperLink=new Hyperlink();
	newNBhyperLink.setText("View Demo");
	newNBGrid.setWidget(0, 0,frmLabel);
	newNBGrid.setWidget(0, 1,newNBhyperLink);
	loginPanel.add(grid);
	loginPanel.add(newNBGrid);
	loginPanel.setStyleName("gwt-Logo-Panel");
    loanFormMainPanel.add(loginPanel);
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
