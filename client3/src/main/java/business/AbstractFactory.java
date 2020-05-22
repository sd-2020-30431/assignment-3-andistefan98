package business;

import java.util.List;

import entities.Item;
import entities.Report;
import entities.ReportType.reportTypes;


public abstract class AbstractFactory {

	public abstract Report getReport(reportTypes type, List<Item> items );  
	
}
