package business;

import java.util.List;

import entities.Item;
import entities.MonthlyReport;
import entities.Report;
import entities.ReportType.reportTypes;



class MonthlyReportFactory extends AbstractFactory{


	public Report getReport(reportTypes type ,  List<Item> items){  

	      return new MonthlyReport(items);
	   } 
	
}
