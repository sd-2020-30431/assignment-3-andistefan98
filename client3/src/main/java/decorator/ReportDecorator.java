package decorator;

import java.text.ParseException;
import java.util.List;

import entities.ColorType;
import entities.ColorType.colorTypes;
import entities.Item;
import entities.Report;

public abstract class ReportDecorator implements Report{
	
	protected Report reportPlain;
	colorTypes color;
	protected static List<Item> items;
	
//	ReportDecorator()
	
	public ReportDecorator(Report newReport,List<Item> items) {
		this.reportPlain =  newReport;
	    this.items= items;
	}

	public colorTypes getColor() {
		return reportPlain.getColor();
	}
	
	

}
