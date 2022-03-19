package com.xgen.interview;

import java.util.HashMap;


/**
 * A stub implementation - for this exercise, you may disregard that this is incomplete.
 */

/**
 * I've decided to add more examples of products to the pricing database as I felt that 2 weren't enough	
 * for testing.
 * 
 * I've also decided to implement getTotal() and addtoTotal() in Pricer.java because I think it's more
 * intuitive in terms of the structure of this program and that it avoids adding more clutter code into 
 * ShoppingCart.java.
 * 
 * @author Bernard B.
 *
 */
public class Pricer {
	HashMap<String, Integer> pricingDatabase = new HashMap<>(); // stub
	Float finalPrice;

	public Pricer() 
	{
		pricingDatabase.put("apple", 100);
		pricingDatabase.put("banana", 200);
		pricingDatabase.put("pasta", 150);
		pricingDatabase.put("tomato", 50);

	}

	/**
	 * Returns the price of the item passed, in Euro-cent. Eg. if an item costs â‚¬1, this will return 100
	 * If itemType is an unknown string, store policy is that the item is free.
	 */
	public Integer getPrice(String itemType) 
	{
		if (!pricingDatabase.containsKey(itemType)) {
			return 0;
		}
		return pricingDatabase.get(itemType);
	}
	
	public void addtoTotal(float price)
	{
		finalPrice = price;
	}
	
	public Float getTotal()
	{
		return finalPrice/100;
	}

}
