package com.infy.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


public class TableToExcelClientBuilder {

	private Element tableElement;
	private Widget exportExcelWidget = new Button("Export To Excel");
	private Widget exportPDFWidget = new Button("Export To PDF");
	private String fileName = "export";

	private TableToExcelClientBuilder(Element tableElement) {
		super();
		this.tableElement = tableElement;
	}

	
	@SuppressWarnings("rawtypes")
	public static TableToExcelClientBuilder fromTable(CellTable cellTable) {
		return new TableToExcelClientBuilder(cellTable.getElement());
	}

	
	public TableToExcelClientBuilder withClickable(HasClickHandlers exportWidget) {
		this.exportExcelWidget = (Widget) exportWidget;
		return this;
	}

	
	public TableToExcelClientBuilder withWidget(Widget exportWidget) {
		this.exportExcelWidget = exportWidget;
		return this;
	}


	public TableToExcelClientBuilder toFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	protected TableToExcelClient excelBuild() {
		return new TableToExcelClient(tableElement, exportExcelWidget, exportPDFWidget,fileName);
	}
	protected TableToExcelClient pdfBuild() {
		return new TableToExcelClient(tableElement, exportExcelWidget, exportPDFWidget,fileName);
	}
	
	public FormPanel buildExportExcelFormWidget() {
		return excelBuild().getExportExcelFormWidget();
	}
	public FormPanel buildExportPDFFormWidget() {
		return excelBuild().getExportPDFFormWidget();
	}
}
