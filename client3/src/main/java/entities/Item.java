package entities;

import java.time.LocalDate;
import java.util.Date;



public class Item {
	

	int id;

	//@Column(name="list_id")
	//int list_id;
	

	String name;

	int quantity;

	float calorieValue;

	String purchaseDate;

	String expirationDate;

	String consumptionDate;

	int list;
	
	
	
	

	
	
	
	
	public int getList() {
		return list;
	}

	public void setList(int list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int idd) {
		id = idd;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCalorieValue() {
		return calorieValue;
	}

	public void setCalorieValue(float calorieValue) {
		this.calorieValue = calorieValue;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expiration) {
		this.expirationDate = expiration;
	}

	public String getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(String consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

    @Override
	public String toString() {
		return "Product:  " + name + "  expires:   " + expirationDate;
		
	}

}
