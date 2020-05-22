package business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import entities.ColorType.colorTypes;
import entities.GroceryList;
import entities.Item;
import entities.User;
import requests.ListRequests;



public class BurnDownRateCalculator {

static float computeBurndownRateOfProduct(Item item) throws ParseException {
		
		float calories = item.getCalorieValue();
	    int quantity = item.getQuantity() ; 
	    Date expiration = new SimpleDateFormat("dd/MM/yyyy").parse(item.getExpirationDate());
	    

       Calendar calendar = Calendar.getInstance();
       int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); 
       
       LocalDate expirationLocal = convertToLocalDateViaInstant(expiration);
       int dayyExp = expirationLocal.getDayOfYear();
       
       int noOfDays = dayyExp - dayOfYear + 1; 
       
       float burndownRate = (calories * quantity)/noOfDays;
       
       return burndownRate;
       
	
	}
	
	
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}


	public static String getWasteMessage(User user) throws ParseException, IOException {
		String message ; 

		  List<Item> usersLists = ListRequests.getAll(user.getId());
	
		 
		 float sum = 0;
		 
		 for(Item item : usersLists) {
			 if(item.getConsumptionDate()==null || new SimpleDateFormat("dd/MM/yyyy").parse(item.getConsumptionDate()).getYear()<2020 || new SimpleDateFormat("dd/MM/yyyy").parse(item.getConsumptionDate()).getYear()>2021) {//at first I added wrongly some values for the conumption date
				if( new SimpleDateFormat("dd/MM/yyyy").parse(item.getExpirationDate()).after(new Date()))
				 sum += computeBurndownRateOfProduct(item); 
			 }
		 }
		 
		 if(sum > user.getCaloric_goal()) {
			 float val = sum - user.getCaloric_goal();
			 message ="Waste level exceeded with " + val;
		 }
		 else {
			 message ="Waste level in normal limits " ;
		 }
		return message;
	}
	
	
	
	public static colorTypes getWasteColor(User user) throws ParseException, IOException {
	
		  List<Item> usersLists = ListRequests.getAll(user.getId());
	      colorTypes color;
		 
		 float sum = 0;
		 
		 for(Item item : usersLists) {
			 if(item.getConsumptionDate()==null || new SimpleDateFormat("dd/MM/yyyy").parse(item.getConsumptionDate()).getYear()<2020 || new SimpleDateFormat("dd/MM/yyyy").parse(item.getConsumptionDate()).getYear()>2021) {//at first I added wrongly some values for the conumption date
				if( new SimpleDateFormat("dd/MM/yyyy").parse(item.getExpirationDate()).after(new Date()))
				 sum += computeBurndownRateOfProduct(item); 
			 }
		 }
		 
		 if(sum > user.getCaloric_goal()) {
			 float val = sum - user.getCaloric_goal();
			 color = colorTypes.Red;
		 }
		 else {
			 color = colorTypes.Green;
		 }
		return color;
	}

	
	
}
