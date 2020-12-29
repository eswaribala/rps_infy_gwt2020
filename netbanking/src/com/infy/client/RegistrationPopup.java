package com.infy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class RegistrationPopup extends DialogBox {
	 private static final Binder binder = GWT.create(Binder.class);
	 interface Binder extends UiBinder<Widget, RegistrationPopup> {
	    }
	public RegistrationPopup()
	{
		 setWidget(binder.createAndBindUi(this));
	        setAutoHideEnabled(true);
	        setText("Registration");
	       // setGlassEnabled(true);
	         //center();
	        setPopupPosition(500, 150);
	        //this.setSize("800px", "400px");
	        this.setWidth("400px");
	        //FlowPanel flowPanel=new FlowPanel();
	        //flowPanel.add(new RegistrationForm());
	        //this.add(flowPanel);
	}
	
}
