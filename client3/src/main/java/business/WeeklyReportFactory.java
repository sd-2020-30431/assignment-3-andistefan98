package business;

import java.util.List;

import entities.Item;
import entities.Report;
import entities.ReportType.reportTypes;
import entities.WeeklyReport;



class WeeklyReportFactory extends AbstractFactory {



	public Report getReport(reportTypes type, List<Item> items) {
		return new WeeklyReport(items);
	} 
	 
}
