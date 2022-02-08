package in.ashokit.reports;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.bindings.responce.PlanResponce;

public class PdfExport {
	
	public void pdfReport(List<PlanResponce> plans ,HttpServletResponse response) throws DocumentException, IOException {
		
		  // Create the Object of Document
		  Document document = new Document(PageSize.A4);
		// get the document and write the response to output stream
		  PdfWriter.getInstance(document, response.getOutputStream());
		  document.open();
		  
		  // Add Font
		  Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  fontTiltle.setSize(20);
		   // Create Object of Paragraph
		  Paragraph paragraph = new Paragraph("Insurance Plans", fontTiltle);
		  paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		  
		  // Add to the document
		  document.add(paragraph);
		  
		  PdfPTable table = new PdfPTable(5);
		  table.setWidthPercentage(100f);
		  table.setWidths(new int[] { 1, 2, 3, 2, 4 });
		  table.setSpacingBefore(5);
		  
		  // Create Table Header
		  PdfPCell cell = new PdfPCell();
		  cell.setBackgroundColor(Color.MAGENTA);
		  cell.setPadding(5);
		  
		  // Add Font
		  Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  font.setColor(Color.WHITE);
		  
		  cell.setPhrase(new Phrase("Plan ID", font));
		  table.addCell(cell);
		  cell.setPhrase(new Phrase("Plan Name", font));
		  table.addCell(cell);
		  cell.setPhrase(new Phrase("Holder Name", font));
		  table.addCell(cell);
		  cell.setPhrase(new Phrase("Holder SSN", font));
		  table.addCell(cell);
		  cell.setPhrase(new Phrase("Plan Status", font));
		  table.addCell(cell);
		  
		  for (PlanResponce plan : plans) {
			   table.addCell(plan.getPlanId()+"");
			   table.addCell(plan.getPlanName());
			   table.addCell(plan.getHolderName());
			   table.addCell(String.valueOf(plan.getHolderSsn()));
			   table.addCell(plan.getPlanStatus());
			  }
		  
		  // Add table to document
		  document.add(table);
		  document.close();
		
	}

}
