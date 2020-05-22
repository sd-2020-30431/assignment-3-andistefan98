package business;

import java.util.List;

import entities.Item;
import entities.ReportType.reportTypes;


public class ReportCreator {

	 public static AbstractFactory getFactory(reportTypes choice , List<Item> items){  
	      if(choice.equals(reportTypes.Weekly)){  
	        
	    	  return new WeeklyReportFactory();  
	      } else {  
	      
	    	  return new MonthlyReportFactory();  
	      }  
	   }  
}
