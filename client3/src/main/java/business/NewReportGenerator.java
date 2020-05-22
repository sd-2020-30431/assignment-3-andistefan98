package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import entities.FinalReport;
import entities.Item;



public class NewReportGenerator {


	public static void generate(int noDays, List<Item> allItems) throws ParseException {
		
		Date dateNow = new Date();
		
		List<Item> targetItems = new ArrayList<Item>();
		 Date date = new Date(System.currentTimeMillis() - noDays * 24 * 60 * 60 * 1000L);
		
		 for(Item itm : allItems) {
			 
			 if(new SimpleDateFormat("dd/MM/yyyy").parse(StringUtils.substringBetween(itm.getPurchaseDate(),"\"","\"")).before(dateNow) ) {
				 if(new SimpleDateFormat("dd/MM/yyyy").parse(StringUtils.substringBetween(itm.getPurchaseDate(),"\"","\"")).after(date))
				 targetItems.add(itm);
			 }
		 }
		 
		 float totalCalories = 0;
		 
		 int noOfTargetItems  = targetItems.size();
		 List<Item> expiredItems = new ArrayList<Item>();
		 
		 for(Item itm : targetItems) {
			 totalCalories += itm.getCalorieValue();
			 if(new SimpleDateFormat("dd/MM/yyyy").parse(itm.getExpirationDate()).before(dateNow)) {
				 if(itm.getConsumptionDate()==null || (new SimpleDateFormat("dd/MM/yyyy").parse(itm.getConsumptionDate()).getYear() >2021))
				   expiredItems.add(itm);
			 }
		 }
		 
		 float wastedCalories = 0;
		 
		 for(Item itm : expiredItems) {
			 wastedCalories += itm.getCalorieValue() * itm.getQuantity();
			 
		 }
		 
	
		 new FinalReport(targetItems,noOfTargetItems,expiredItems,wastedCalories,totalCalories);
		 
	}
	
	
}
