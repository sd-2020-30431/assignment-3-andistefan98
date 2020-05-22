package entities;

import java.text.ParseException;
import java.util.List;

import entities.ColorType.colorTypes;

public class PlainReport implements Report{

	List<Item> items ; 
	
	public PlainReport(List<Item> itemss) {
		this.items = itemss;
	}
	
	@Override
	public String generateNewReport(List<Item> allItems, colorTypes color) throws ParseException {
		return generateNewReport(this.items , this.getColor());
	}

	@Override
	public colorTypes getColor() {
		return getColor();
	}

	@Override
	public List<Item> getItems() {
		return this.items;
	}

}
