package decorator;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import business.NewReportGenerator;
import entities.ColorType;
import entities.ColorType.colorTypes;
import entities.Item;
import entities.Report;

public class GreenReportDecorator extends ReportDecorator{

	
	
	public GreenReportDecorator(Report newReport,List<Item> items) throws ParseException, FileNotFoundException, DocumentException {
		super(newReport,items);
	    System.out.println(" Setting report to green ");
	    this.color = getColor();
	    generateNewReport(items , color);
	}

	@Override
	public String generateNewReport(List<Item> allItems,colorTypes color) throws ParseException, FileNotFoundException, DocumentException {
		 return NewReportGenerator.generate(7,allItems,color);
		
	}

	public colorTypes getColor() {
		return ColorType.colorTypes.Green;
	}

	@Override
	public List<Item> getItems() {
		return items;
	}
}
