package entities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import entities.ColorType.colorTypes;

public class ReportPDF {

	
	
	
static void createReportPDF(int noOfItems2, List<Item> wastedItems2, float caloriesWasted2,float totalCalories2,colorTypes color) throws FileNotFoundException, DocumentException {
	    
	    Rectangle pageSize = new Rectangle(516, 720);
	    if(color.equals(colorTypes.Red)) {
	    pageSize.setBackgroundColor(new BaseColor(0xFF, 0x33, 0x66));
	    }
	    else {
	    pageSize.setBackgroundColor(new BaseColor(0x66, 0xFF, 0x33));
	    }
	    
		Document document = new Document(pageSize);
		PdfWriter.getInstance(document, new FileOutputStream("userReport.pdf"));
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
	
		document.add( new Paragraph( "REPORT" ) );
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		document.add( new Paragraph( "Number of Items purchased in the last 7 days : " + noOfItems2 ) );
		document.add(Chunk.NEWLINE);
		document.add( new Paragraph( "Items that have expired : "  ) );
		for(Item itm: wastedItems2) {
			document.add( new Paragraph( itm.toString()  ) );
		}
		document.add(Chunk.NEWLINE);
		document.add( new Paragraph( "Number of Items that have expired in the last 7 days before consumption: " + wastedItems2.size() ) );
		document.add(Chunk.NEWLINE);
		document.add( new Paragraph( "Calories wasted in the last 7 days : " + caloriesWasted2 ) );
		document.add(Chunk.NEWLINE);
		document.add( new Paragraph("Total calories value from the last 7 days : " + totalCalories2 ) );
		document.add(Chunk.NEWLINE);
		
		document.close();
		
		
		
	}
}
