package com.infy.client;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
 
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Netbanking implements EntryPoint,ClickHandler {
	
	LoginServiceAsync loginServiceAsync = GWT.create(LoginService.class); 
	
	private Label resultLbl;
	private TextBox frmCustomerId;
	private PasswordTextBox frmPassword;
	private VerticalPanel resultPanel;
	private VerticalPanel loginPanel,regPanel;
	private HorizontalPanel horizontalPanel;
	private DockLayoutPanel dockLayoutPanel;
	private static List<String> newsList=new ArrayList<String>();
	static
	{
		newsList.add("Loan Offer 5%");
		newsList.add("Avail Education Loan");
		newsList.add("Car Loan At Door Steps");
		newsList.add("Be Healthy and Ensure Healthy Life with HDFC");
		newsList.add("We Safeguard your Jewels");
	}
	
	public void onModuleLoad() {	
	
		resultLbl=new Label();
		regPanel=new VerticalPanel();
		resultPanel=new VerticalPanel();
		horizontalPanel = new HorizontalPanel();      	
		horizontalPanel.add(createLogoPanel());
		
		horizontalPanel.add(createVerticalLine());	
		horizontalPanel.add(createBanner());
		
        dockLayoutPanel=new DockLayoutPanel(Unit.PX);
        dockLayoutPanel.addWest(horizontalPanel, 2000);        
		RootLayoutPanel.get().add(dockLayoutPanel);		
		
	}
	
	public VerticalPanel createLogoPanel()
	{
		Image image=new Image();		
		image.setUrl(GWT.getModuleBaseURL()+"images/hdfc.png");
		image.setSize("100px","100px");
		VerticalPanel verticalPanel=new VerticalPanel();
		verticalPanel.add(image);
		HTML hrLine = new HTML("<hr  style=\"width:100%;background-color:red;border: none; border-bottom: 1px solid red;\" />");
		verticalPanel.add(hrLine);
		verticalPanel.add(createHeader());
	    verticalPanel.add(createLoginPanel());
		return verticalPanel;		
	}
	
	
	public HTML createVerticalLine()
	{
		return new HTML("<div  style=\"width:100%;height: 100px;border-left:6px solid green;\" />");
	}
	
	public VerticalPanel createBanner()
	{
		Image image=new Image();		
		image.setUrl(GWT.getModuleBaseURL()+"images/banner.jpg");
		image.setSize("600px","100px");
		VerticalPanel verticalPanel=new VerticalPanel();
		verticalPanel.setStyleName("banner");
		verticalPanel.add(image);
		final Label newsLbl=new Label();
		newsLbl.setStyleName("show-message");
		Timer timer=new Timer() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				newsLbl.setText(getMessage());
			}
			
		};
		
		timer.scheduleRepeating(1000);
		verticalPanel.add(newsLbl);
		verticalPanel.add(regPanel);
		verticalPanel.add(resultPanel);
		return verticalPanel;
	}
	
	public VerticalPanel createHeader()
	{
		VerticalPanel verticalPanel=new VerticalPanel();
		Label label =new Label();
		label.setText("NetBanking Login");
		verticalPanel.add(label);		
		 verticalPanel.setStyleName("gwt-Login-Header");
		return verticalPanel;
		
	}
	
	public VerticalPanel createLoginPanel()
	{
		loginPanel=new VerticalPanel();
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
		newNBhyperLink.setText("Register");
		newNBhyperLink.addDomHandler(new ClickHandler()
				{

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						//new RegistrationPopup().show();
						
						regPanel.add(new RegistrationForm());
					}
			
				}, ClickEvent.getType());
		newNBGrid.setWidget(0, 0,frmLabel);
		newNBGrid.setWidget(0, 1,newNBhyperLink);
		loginPanel.add(grid);
		loginPanel.add(newNBGrid);
		loginPanel.setStyleName("gwt-Logo-Panel");
		return loginPanel;
	}
	
	private String getMessage()
	{
		return newsList.get(new Random().nextInt(newsList.size()));
	}

	@Override
	public void onClick(ClickEvent event) {
			
		

		
		
		// TODO Auto-generated method stub
        loginServiceAsync.validateCredentials(frmCustomerId.getText(), frmPassword.getText(), new AsyncCallback() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Exception Received from server.");  
			}

			@Override
			public void onSuccess(Object result) {
				// TODO Auto-generated method stub
				//frmCustomerId.setText("");
				//frmPassword.setText("");
				String customerName=frmCustomerId.getText();
				loginPanel.clear();
				regPanel.clear();
				boolean status=(boolean) result;
				if(status)
				{
				resultPanel.clear();
				resultPanel.add(new AccountSummaryView(customerName));
				}
				else
					resultPanel.clear();
			}
        	
        });
                		
	}
	
	
}
