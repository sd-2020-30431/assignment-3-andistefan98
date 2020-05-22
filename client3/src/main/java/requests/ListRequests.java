package requests;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import entities.GroceryList;
import entities.Item;

public class ListRequests {
	
	

	public static List<Item> getAll(int user_id) throws IOException, ParseException{
		
	
		List<Item> lists = new ArrayList<Item>();
		
		String query = "query" + 
		        " { "  + "\n allItems " + 
				"(" + "userId" + " : \\\"" + String.valueOf(user_id) +"\\\") " + " { " + "\n name " + "\n purchaseDate "+ "\n id " + "\n calorieValue " + "\n quantity " + "\n expirationDate " 
		        + "\n } "
				+ "\n }";
		
		String json = "{\"query\":\"";
		json += query;
        json += "\"}";
		
        json = json.replace("\n", " ").replace("  ", " ");
        
		URL url = new URL("http://localhost:8081/graphql");
		
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.addRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
        
        String[] listNames = StringUtils.substringsBetween(result , "\"name\":", ",");
        String[] expDates  = StringUtils.substringsBetween(result,"\"expirationDate\":\"", "\"");
        String[] listcalories = StringUtils.substringsBetween(result , "\"calorieValue\":", ",");
        String[] listquant  = StringUtils.substringsBetween(result,"\"quantity\":", ",");
        String[] listIds  = StringUtils.substringsBetween(result,"\"id\":", ",");
        String[] purchaseDates  = StringUtils.substringsBetween(result,"\"purchaseDate\":", ",");
        
     System.out.println(result);
        
        if(listNames!=null) {
        int size = listNames.length;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        while(size>0) {
        	Item newItm = new Item();
        	//newLst.setId(Integer.parseInt(listNames[size-1]));
        	newItm.setPurchaseDate(purchaseDates[size-1]);
        	newItm.setId(Integer.parseInt(listIds[size-1]));
        	newItm.setName(listNames[size-1]);
        	newItm.setCalorieValue(Float.parseFloat(listcalories[size-1]));
        	newItm.setQuantity(Integer.parseInt(listquant[size-1]));
        	
        	//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(expDates[size-1]);  
        	
        	newItm.setExpirationDate(expDates[size-1]);
        	System.out.println(newItm.getExpirationDate() + "       " + expDates[size-1]);
        	
        	lists.add(newItm);
        	
        	size--;
        }
        }
        else {
        	System.out.println("NULLL");
        }
        
        
        System.out.println(result);

        in.close();
        conn.disconnect();
		

        return lists;
		
	}
	
	
	public static void addItem(String name , int quantity, float calorie_value , String purch, String exp , int list ,String consmp)  throws IOException{
		
		String json ="{\"query\": \"mutation { addItem ( listId: \\\"" + String.valueOf(list) + "\\\", name: \\\"" + name + "\\\", calorie_value: \\\"" + String.valueOf(calorie_value) + "\\\", quantity: \\\"" + String.valueOf(quantity) + "\\\", expiration_date: \\\"" + exp + "\\\", purchase_date: \\\"" + purch + "\\\", consump_date: \\\"" + consmp  +"\\\" ) } \"}";
        
	
		System.out.println(json);
		
        json = json.replace("\n", " ").replace("  ", " ");
        
		URL url = new URL("http://localhost:8081/graphql");
		
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.addRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
       
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            
        in.close();
        conn.disconnect();
		      
        
	}
	
	
	public static String addList(int userId, String listname)  throws IOException{
		
	  
		String json ="{\"query\": \"mutation { addList ( user_id: \\\"" + String.valueOf(userId) + "\\\", list_name: \\\"" + listname +"\\\" ){list_id}}\"}";
        
		
		System.out.println(json);	
		
	        //json = json.replace("\n", " ").replace("  ", " ");
	        
			URL url = new URL("http://localhost:8081/graphql");
			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        conn.addRequestProperty("Accept", "application/json");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        
	        OutputStream os = conn.getOutputStream();
	        os.write(json.getBytes("UTF-8"));
	        os.close();
	        
	        InputStream in = new BufferedInputStream(conn.getInputStream());
	        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
	        
	        System.out.println(result);
	        
	        String[] listIds = StringUtils.substringsBetween(result , "\"list_id\":", "}");
	        if(listIds != null) {
	        	return listIds[0];
	        }
	        
	    
	        in.close();
	        conn.disconnect();
			
	       return "no list added";
	        
		}

	

	public static void removeItem(int reqId) throws IOException {
		
		String json ="{\"query\": \"mutation { deleteItem ( itemId: \\\"" + String.valueOf(reqId) +"\\\" ) } \"}";
        
		
		System.out.println(json);
		
        json = json.replace("\n", " ").replace("  ", " ");
        
		URL url = new URL("http://localhost:8081/graphql");
		
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.addRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
       
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            
        in.close();
        conn.disconnect();
		
	}
	
	
}
