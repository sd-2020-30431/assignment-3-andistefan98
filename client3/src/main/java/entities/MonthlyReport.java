package entities;

import java.text.ParseException;
import java.util.List;

import business.NewReportGenerator;



public class MonthlyReport implements Report {

	public MonthlyReport(List<Item> allItems) {
        generateNewReport(allItems);
	}
	
	
	public void generateNewReport( List<Item> allItems) {
		
		  try {
			NewReportGenerator.generate(30, allItems);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	}

