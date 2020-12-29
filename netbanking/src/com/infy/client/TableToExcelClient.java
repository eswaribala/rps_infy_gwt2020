package com.infy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TableToExcelClient {

	private final FormPanel excelFormPanel = new FormPanel("gwt-table-to-excel-target");

	private final FormPanel pdfFormPanel = new FormPanel("gwt-table-to-pdf-target");

	protected TableToExcelClient(final com.google.gwt.dom.client.Element tableElement, Widget exportExcelWidget, Widget exportPDFWidget, String fileName) {
		excelFormPanel .setAction(GWT.getModuleBaseURL() + "excel");
		// formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		excelFormPanel .setMethod(FormPanel.METHOD_POST);
		excelFormPanel .addStyleName("gwt-table-to-excel-form");
		FlowPanel excelFlowPanel = new FlowPanel();
		excelFlowPanel.addStyleName("gwt-table-to-excel-panel");
		excelFormPanel .setWidget(excelFlowPanel);
		final Hidden contentHidden = new Hidden("html");
		excelFlowPanel.add(contentHidden);
		final Hidden fileNameHidden = new Hidden("fileName", fileName);
		excelFlowPanel.add(fileNameHidden);
		excelFlowPanel.add(exportExcelWidget);
		exportExcelWidget.addStyleName("gwt-table-to-excel-exportWidget");
		((HasClickHandlers) exportExcelWidget).addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// lazy copy
				contentHidden.setValue(tableElement.getString());
				excelFormPanel.submit();
			}
		});
		
		pdfFormPanel .setAction(GWT.getModuleBaseURL() + "pdf");
		// formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		pdfFormPanel.setMethod(FormPanel.METHOD_POST);
		pdfFormPanel.addStyleName("gwt-table-to-excel-form");
		FlowPanel pdfFlowPanel = new FlowPanel();
		pdfFlowPanel.addStyleName("gwt-table-to-excel-panel");
		pdfFormPanel .setWidget(pdfFlowPanel);
		final Hidden pdfContentHidden = new Hidden("html");
		pdfFlowPanel.add(pdfContentHidden);
		final Hidden pdfFileNameHidden = new Hidden("fileName", fileName);
		pdfFlowPanel.add(pdfFileNameHidden);
		pdfFlowPanel.add(exportPDFWidget);
		exportPDFWidget.addStyleName("gwt-table-to-pdf-exportWidget");
		((HasClickHandlers) exportPDFWidget).addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// lazy copy
				pdfContentHidden.setValue(tableElement.getString());
				pdfFormPanel.submit();
			}
		});
		
		HorizontalPanel horizontalPanel=new HorizontalPanel();
		horizontalPanel.addStyleName("export");
		horizontalPanel.add(excelFormPanel);
		horizontalPanel.add(pdfFormPanel);
		
		
	}

	
	@Deprecated
	protected FormPanel excelBuild() {
		return excelFormPanel;
	}

	
	public FormPanel getExportExcelFormWidget() {
		return excelFormPanel;
	}
	public FormPanel getExportPDFFormWidget() {
		return pdfFormPanel;
	}

}
