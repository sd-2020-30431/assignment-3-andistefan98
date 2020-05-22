package entities;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import entities.ColorType.colorTypes;



public interface Report {

	 
	String generateNewReport(List<Item> allItems,colorTypes color) throws ParseException, FileNotFoundException, DocumentException;
	
	colorTypes getColor();
	
	List<Item> getItems();

}
