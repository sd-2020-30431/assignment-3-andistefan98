package requests;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import entities.Item;
import entities.User;

public class UserRequests {
	
	public static List<User> getAll() throws IOException{
		
		
		List<User> lists = new ArrayList<User>();
		
		String query = "query" +
		" { "  + "\n allUsers "  + 
				" { " +"\n id " + "\n username " +"\n password " + "\n } " + 
		"\n }";
		
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
        
        String[] listIds = StringUtils.substringsBetween(result , "\"id\":", ",");
        String[] listUsernames = StringUtils.substringsBetween(result , "\"username\":", ",");
        String[] listPasswords  = StringUtils.substringsBetween(result,"\"password\":\"", "\"");
        
       
        
        if(listUsernames!=null) {
        int size = listUsernames.length;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        while(size>0) {
        	User usr = new User();
        	usr.setId(Integer.parseInt(listIds[size-1]));
        	usr.setUsername(listUsernames[size-1]);
        	usr.setPassword(listPasswords[size-1]);

        	lists.add(usr);
        	
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

	
	
	public static void addUser(String username, String password) throws IOException {
		
		
		 String query = "mutation" + " { "  + "\n addUser " + "(" + "username: " + "\"" + username + "\""+", " + "password: " + "\"" + password + "\"" + " ) " + " { " + "\n username " + "\n password" + "\n } " + "\n }";
			
			//String json= "{query \n{ ";
			//json += query;
	       // json +=  "}";
	        
	        String json ="{\"query\": \"mutation { addUser ( username: \\\"" + username + "\\\", password: \\\"" + password +"\\\" ){username} } \"}";
	        
	        
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
	
	
	public static void updateUser(int user_id, int new_goal) throws IOException {
		
		    
	        String json ="{\"query\": \"mutation { updateGoal ( user_id: \\\"" + String.valueOf(user_id) + "\\\", new_goal: \\\"" + String.valueOf(new_goal) +"\\\" ) } \"}";
	        
	   
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
