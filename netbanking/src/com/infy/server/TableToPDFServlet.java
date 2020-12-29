package com.infy.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gwt.http.client.URL;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("serial")
public class TableToPDFServlet extends HttpServlet {

	private static String encoding = "ISO-8859-1";
	  private static String FILE = "g:/temp/HDFCBankStatement.pdf";
	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	            Font.BOLD);
	    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.NORMAL, BaseColor.RED);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	            Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);

	/**
	 * Constructor
	 */
	public TableToPDFServlet() {
		super();
	}

	/**
	 * @see HttpServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		
	}

	/**
	 * see HttpServlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String initParameterEncoding = config.getInitParameter("encoding");
		if (initParameterEncoding != null) {
			setEncoding(initParameterEncoding);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		export(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		export(request, response);
	}

	private void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String html = request.getParameter("html");
		
		String html = request.getParameter("html");
		
		
		response.setContentType("application/pdf");
		response.setContentLength(html.length());	
		//response.setHeader( "Content-Disposition", "attachment; filename=\"hdfc.pdf\"");
		
		OutputStream out=response.getOutputStream();
		InputStream pdfSource = request.getInputStream();
	    OutputStream pdfTarget = response.getOutputStream();

	    int FILE_CHUNK_SIZE = 1024 * 4;
	    byte[] chunk = new byte[FILE_CHUNK_SIZE]; 
	    int n =0;
	    
		try {
	            Document document = new Document();	         		
				
	            
	            PdfWriter.getInstance(document, pdfTarget);		         
	            document.open();
	            document.add(new Paragraph("HDFC Statement"));
	          //IOUtils.write(html, response.getOutputStream(), encoding);
	            while ( (n = pdfSource.read(chunk)) != -1 ) {
	    	        pdfTarget.write(chunk, 0, n);
	    	    }
	            document.add(new Paragraph(html));
	            //IOUtils.write(html, pdfTarget, encoding);
	            document.close();
	           
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
		
	
	        
		
	
	}


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	

}
