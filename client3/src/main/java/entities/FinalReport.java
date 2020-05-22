package entities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import entities.ColorType.colorTypes;
import presentation.ReportsFrame;

public class FinalReport {
	
	List<Item> targetItems;
	int noOfItems ;
	List<Item> wastedItems;
	float caloriesWasted;
	colorTypes color ;
	
	public FinalReport(List<Item> targetItems,int noOfItems ,List<Item> wastedItems , float caloriesWasted ,float totalCalories, colorTypes color) throws FileNotFoundException, DocumentException
	{
		this.targetItems = targetItems;
		this.noOfItems = noOfItems;
		this.wastedItems = wastedItems;
		this.caloriesWasted = caloriesWasted;
		this.color = color;
		//createReportPDF(noOfItems,wastedItems,caloriesWasted,totalCalories,color);
		displayIt( noOfItems,wastedItems,caloriesWasted,totalCalories);
		
	}
	
	
	void displayIt(int noOfItems2, List<Item> wastedItems2, float caloriesWasted2,float totalCalories2) throws FileNotFoundException, DocumentException {
		JTextPane panee = ReportsFrame.forReportDisplay();
		panee.setText("Number of items purchased in this period :  ");
		try {
		      Document doc = panee.getDocument();
		      doc.insertString(doc.getLength(), Integer.toString(noOfItems2), null);
		      doc.insertString(doc.getLength(), "\n", null);
		      doc.insertString(doc.getLength(), "Wasted items : \n", null);
		      doc.insertString(doc.getLength(), wastedItems2.toString(), null);
		      doc.insertString(doc.getLength(), "\n Wasted calories : ", null);
		      doc.insertString(doc.getLength(), Float.toString(caloriesWasted2), null);
		      doc.insertString(doc.getLength(), "\n Total calories : ", null);
		      doc.insertString(doc.getLength(), Float.toString(totalCalories2), null);
		      
		      
		   } catch(BadLocationException exc) {
		      exc.printStackTrace();
		   }
		
		ReportPDF.createReportPDF(noOfItems2,wastedItems2,caloriesWasted2,totalCalories2,this.color);
	}
	
	
	
	

}
