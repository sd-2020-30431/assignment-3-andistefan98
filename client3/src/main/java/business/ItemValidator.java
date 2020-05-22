package business;

import java.util.Calendar;
import java.util.Date;

import entities.GroceryList;


public class ItemValidator {

	
	public static boolean checkItemValidity(String name, int quantity , float caloricValue , Date purchase, Date exp, Date con, GroceryList list) {
		Date today = new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		
		
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); 
		int month = cal.get(Calendar.MONTH); 
		
		if( name == null)
			return false;
		if(caloricValue <=0)
			return false;
		if(quantity<=0)
			return false;
		
	if(purchase.after(today))
		return false;

		
		return true;
		
		
	}
	
	
	public static boolean checkConsumptionDate(Date consump) {
		if(consump.compareTo(new Date())>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
