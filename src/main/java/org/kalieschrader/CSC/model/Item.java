package org.kalieschrader.CSC.model;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Model class for Item
//It is mapped to the table with annotations and contains all the column values, constructors, and getters/setters
//It has the overridden Hashcode, Equals, and toString methods for testing 

@Entity
public class Item {

	@Id
	private String itemName;
	@Column(length = 800)
	private String details;

	public Item(String itemName, String details) {
		super();
		this.itemName = itemName;
		this.details = details;
	}

	public Item() {
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, itemName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(details, other.details) && Objects.equals(itemName, other.itemName);
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", details=" + details + "]";
	}

}