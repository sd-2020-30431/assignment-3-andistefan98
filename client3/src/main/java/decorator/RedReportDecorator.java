package decorator;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import business.NewReportGenerator;
import entities.ColorType;
import entities.Item;
import entities.Report;
import entities.ColorType.colorTypes;

public class RedReportDecorator extends ReportDecorator{

	public RedReportDecorator(Report newReport,List<Item> items) throws ParseException, FileNotFoundException, DocumentException {
		super(newReport,items);
		System.out.println(" Setting report to red ");
		this.color = getColor();
		generateNewReport(items , this.color);
	}

	@Override
	public String generateNewReport(List<Item> allItems,colorTypes color) throws ParseException, FileNotFoundException, DocumentException {
		return NewReportGenerator.generate(7,allItems,color);
		
	}

	
	public colorTypes getColor() {
		return ColorType.colorTypes.Red;
	}

	@Override
	public List<Item> getItems() {
		return items;
	}
}
