package entities;

import java.text.ParseException;
import java.util.List;



public interface Report {

	void generateNewReport(List<Item> allItems) throws ParseException;
	
}
