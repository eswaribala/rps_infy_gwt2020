package com.infy.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.infy.client.models.Account;
import com.infy.client.models.AccountType;
import com.infy.client.models.Customer;
import com.infy.client.models.CustomerMapper;

public class RegistrationForm extends Composite{
	 CustomerMapper mapper = GWT.create( CustomerMapper.class );
	public RegistrationForm()
	{
		// Create a FormPanel and point it at a service.
	      //final FormPanel form = new FormPanel();
	      //form.setAction("/myFormHandler");

	      // Because we're going to add a FileUpload widget, 
	      // we'll need to set the form to use the POST method, 
	      // and multipart MIME encoding.
	     // form.setEncoding(FormPanel.ENCODING_MULTIPART);
	     //form.setMethod(FormPanel.METHOD_POST);

	      // Create a panel to hold all of the form widgets.
	      VerticalPanel panel = new VerticalPanel();
	      panel.setSpacing(10);
	      //form.setWidget(panel);
          Grid grid=new Grid(6,2);
          //customer id
          Label customerIdLbl=new Label();
          customerIdLbl.setText("Customer Id");
          grid.setWidget(0, 0, customerIdLbl);          
	      // Create a TextBox, giving it a name so that it will be submitted.
	      final TextBox  customerIdTxtBox = new TextBox();
	      customerIdTxtBox .setWidth("220");
	      grid.setWidget(0, 1, customerIdTxtBox);    
	      
	      //name
	      Label nameLbl=new Label();
          nameLbl.setText("Name");
          grid.setWidget(1, 0, nameLbl);          
	      // Create a TextBox, giving it a name so that it will be submitted.
	      final TextBox  nameTxtBox = new TextBox();
	      nameTxtBox .setWidth("220");
	      grid.setWidget(1, 1, nameTxtBox);   	      
	      //email	      
	      Label emailLbl=new Label();
          emailLbl.setText("Email");
          grid.setWidget(2, 0, emailLbl);          
	      // Create a TextBox, giving it a name so that it will be submitted.
	      final TextBox  emailTxtBox = new TextBox();
	      emailTxtBox .setWidth("220");
	      grid.setWidget(2, 1, emailTxtBox);  
	      //dob
	      Label dobLbl=new Label();
	      dobLbl.setText("DOB");
	      grid.setWidget(3, 0, dobLbl); 
	      
	      final TextBox  dobTxtBox = new TextBox();
	      dobTxtBox .setWidth("220");
	      grid.setWidget(3, 1, dobTxtBox);  
	      
	      //balance
	      Label balanceLbl=new Label();
	      balanceLbl.setText("Balance");
	      grid.setWidget(4, 0, balanceLbl); 
	      
	      final TextBox  balanceTxtBox = new TextBox();
	      balanceTxtBox .setWidth("220");
	      grid.setWidget(4, 1, balanceTxtBox);
	      
	      //account type
	      Label actTypeLbl=new Label();
	      actTypeLbl.setText("Account Type");
	      grid.setWidget(5, 0, actTypeLbl); 
	      
	      ListBox actTypeLbox = new ListBox();
	      actTypeLbox.setName("AccountType");
	      actTypeLbox.addItem("SAVINGS", "0");
	      actTypeLbox.addItem("CURRENT", "1");
	      actTypeLbox.addItem("DEMAT", "2");
	      actTypeLbox.setWidth("220");
	      grid.setWidget(5, 1, actTypeLbox); 
	           
	      
	      panel.add(grid);
	      // Add a 'submit' button.
	      panel.add(new Button("Submit", new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	        	 
	        	 Customer customer =new Customer();
	        	 customer.setId("5bfd996f7b8e48dc15ff215d");
	        	 customer.setCustomerId(Long.parseLong( customerIdTxtBox .getText()));
	        	 customer.setName(nameTxtBox.getText());
	        	 customer.setEmail(emailTxtBox.getText());
	        	 customer.setDob(dobTxtBox.getText());
	        	 
	        	 List<Account> accountList=new ArrayList();
	        	 Account account=new Account();
	        	 account.setBalance( Long.parseLong(balanceTxtBox.getText()));       	
	        	 
	        	//account.setAccount_Type(AccountType.valueOf(actTypeLbox .getSelectedValue()));
	        	 
	        	 accountList.add(account);
	        	 customer.setAccounts(accountList);
	           
	           
	            
	            //java to json object
	           // ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	            //String json = ow.writeValueAsString(customer);
	            
	           String customerJSON= mapper.write(customer );
	           Window.alert(customerJSON);
	            
	            String url="https://localhost:44373/api/Customer";
	            RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, URL.encode(url));
	            try {
	            	 builder.setHeader("Content-Type", "application/json");
	            	 
	            	 
	          	  Request request = builder.sendRequest(null, new RequestCallback() {
	          	   public void onError(Request request, Throwable exception) {
	          	     // Couldn't connect to server (could be timeout, SOP violation, etc.)
	          	   }

	          	   public void onResponseReceived(Request request, Response response) {
	          	    if (200 == response.getStatusCode()) {
	          	      // Process the response in response.getText()	    	
	          	    	Window.alert(response.getText());              	    
	          	       }	          		  	
	          		  	else {
	          	         // Handle the error.  Can get the status text from response.getStatusText()
	          	    	Window.alert(response.getText());
	          	    }
	          	   }
	          	  });
	          	 } catch (RequestException e) {
	          	  // Couldn't connect to server
	          	 }
	            
	         }
	      }));

	     

	      DecoratorPanel decoratorPanel = new DecoratorPanel();
	      decoratorPanel.add(panel);
	      initWidget(decoratorPanel);
	}

	/*
	 * 
	 * 
	 *  
	 *   
	      
	      /*
	      DatePicker datePicker=new DatePicker();
	      grid.setWidget(3, 1, dobLbl);
	      datePicker.addValueChangeHandler(new ValueChangeHandler<Date>(){

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				// TODO Auto-generated method stub
				Date date=event.getValue();
				//String dob=DateTimeFormat.getFormat("MM/dd/yyyy").format(date);
				//SimpleDateFormat dateTimeFormatter=new SimpleDateFormat("MMM/dd/yyyy 'at' hh:mm:ss a z");
				//String dob=dateTimeFormatter.format(date);
				//dobLbl.setText(dob);
			}
	    	  
	      });
	      */
	      /*
	      // Create a ListBox, giving it a name and 
	      // some values to be associated with its options.
	      ListBox lb = new ListBox();
	      lb.setName("listBoxFormElement");
	      lb.addItem("item1", "item1");
	      lb.addItem("item2", "item2");
	      lb.addItem("item3", "item3");
	      lb.setWidth("220");
	      panel.add(lb);

	      // Create a FileUpload widget.
	      FileUpload upload = new FileUpload();
	      upload.setName("uploadFormElement");
	      panel.add(upload);
          */
	      // Add an event handler to the form.
	/*      
	form.addSubmitHandler(new FormPanel.SubmitHandler() {
	         @Override
	         public void onSubmit(SubmitEvent event) {
	            // This event is fired just before the form is submitted. 
	            // We can take this opportunity to perform validation.
	            
	               Window.alert("Form Submitted");
	               
	            				
	         }
	      });

	      form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	         @Override
	         public void onSubmitComplete(SubmitCompleteEvent event) {
	            // When the form submission is successfully completed,
	            // this event is fired. Assuming the service returned 
	            // a response of type text/html, we can get the result
	            // here.
	            Window.alert(event.getResults());					
	         }
	      });
	 * 
	 */
}
