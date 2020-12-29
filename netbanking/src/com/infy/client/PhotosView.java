package com.infy.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gwt.core.client.GWT;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.infy.client.models.Photo;
import com.itextpdf.text.pdf.PdfDiv;




public class PhotosView extends Composite implements ClickHandler {

	PhotoFactory factory = GWT.create(PhotoFactory.class);

  public PhotosView() {

    // The input widgets will be stacked from top to bottom, so a vertical panel
    // is created and used as the base panel of the composite object.
    final VerticalPanel photoViewMainPanel = new VerticalPanel();
    final ScrollPanel scrollPanel  = new ScrollPanel(); 
    scrollPanel.setSize("1200px", "600px");
    // Each input elements requires a label and input field. These should be
    // displayed together from left to right. So, a horizontal panel needs to be
    // created for each input
    //final HorizontalPanel menubarHPanel = new HorizontalPanel();
    
	
	//REST call
	 String url = "https://jsonplaceholder.typicode.com/photos";
	 RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));

	 try {
	  Request request = builder.sendRequest(null, new RequestCallback() {
	   public void onError(Request request, Throwable exception) {
	     // Couldn't connect to server (could be timeout, SOP violation, etc.)
	   }

	   public void onResponseReceived(Request request, Response response) {
	    if (200 == response.getStatusCode()) {
	      // Process the response in response.getText()	    	
	    	//Window.alert(response.getText());       
	    
	    	try {
	    		  // parse the response text into JSON
	    		  JSONValue jsonValue = JSONParser.parse(response.getText());
	    		  JSONArray jsonArray = jsonValue.isArray();
	    		  //Window.alert(String.valueOf(jsonArray.size()));
	    		  List<Photo> photos=new ArrayList<Photo>();
	    		  for(int i=0;i<jsonArray.size();i++)
	    		  {
	    		  if (jsonArray != null) {
	    		    
	    			  JSONValue item = jsonArray.get(i);
	    			  AutoBean<Photo> bean = AutoBeanCodex
                              .decode(factory, Photo.class, item.toString());
	    			 // Window.alert(bean.as().getThumbnailUrl());
	    			  photos.add(bean.as());	    			  
	    		    
	    		  } 
	    		  
	    		  }
	    		  
	    		 //Window.alert(String.valueOf(photos.size()));    		
	    		
	    	    	CellTable<Photo> cellTable= createCellTable();
	    	    	cellTable.setRowCount(photos.size());
	    	    	cellTable.setRowData(photos);
	    	    	photoViewMainPanel.add(TableToExcelClientBuilder.fromTable(cellTable).buildExportExcelFormWidget());
	    	    	photoViewMainPanel.add(TableToExcelClientBuilder.fromTable(cellTable).buildExportPDFFormWidget());
	    	    	 ListDataProvider<Photo> dataProvider = new ListDataProvider<Photo>();
	    	    	    dataProvider.addDataDisplay(cellTable);
	    	    	    dataProvider.setList(photos);   	    	
	    	    	
		    	
	    	    	SimplePager pager = new SimplePager();
	    	        pager.setDisplay(cellTable);
	    	        pager.setPageSize(15); // 20 rows will be shown at a time
	    	    	photoViewMainPanel.add(cellTable);	    	    	
	    	    	photoViewMainPanel.add(pager);
	    	    	scrollPanel.add(photoViewMainPanel);
	    	}
	    	catch(Exception ex)
	    	{
	    		
	    	}
	         
	    	
	    
	    	
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
	
	

    // The initWidget(...) method is called with the base element of the
    // composite.
    // The base element that contains all other elements is the vertical
    // panel you created in the beginning of this constructor.
    initWidget(photoViewMainPanel);
  }

@Override
public void onClick(ClickEvent event) {
	// TODO Auto-generated method stub
	
	
}

 
private static CellTable<Photo> createCellTable()
{
	CellTable<Photo> cellTable=new CellTable<Photo>();
	TextColumn<Photo> albumIdCol=new TextColumn<Photo>() {

		@Override
		public String getValue(Photo object) {
			// TODO Auto-generated method stub
			return String.valueOf(object.getAlbumId());
		}
		
	};
	cellTable.addColumn(albumIdCol,"Album Id");
	
	TextColumn<Photo> idCol=new TextColumn<Photo>() {

		@Override
		public String getValue(Photo object) {
			// TODO Auto-generated method stub
			return String.valueOf(object.getId());
		}
		
	};
	cellTable.addColumn(idCol,"Id");
	
	TextColumn<Photo> thumbnailCol=new TextColumn<Photo>() {

		@Override
		public String getValue(Photo object) {
			// TODO Auto-generated method stub
			return object.getThumbnailUrl();
		}
		
	};
	cellTable.addColumn( thumbnailCol,"ThumbnailUrl");
	TextColumn<Photo> urlCol=new TextColumn<Photo>() {

		@Override
		public String getValue(Photo object) {
			// TODO Auto-generated method stub
			return object.getUrl();
		}
		
	};
	cellTable.addColumn( urlCol,"Url");
	TextColumn<Photo> titleCol=new TextColumn<Photo>() {

		@Override
		public String getValue(Photo object) {
			// TODO Auto-generated method stub
			return object.getTitle();
		}
		
	};
	cellTable.addColumn(titleCol,"Title");
	return cellTable;
}

 
}
