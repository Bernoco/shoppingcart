package com.xgen.interview;

import java.util.*;


/**
 * This is the current implementation of ShoppingCart.
 * Please write a replacement
 */

/**
 * For the first requirement, I'm using the methods addtoTotal() and getTotal() mentioned previously to keep
 * track of the total price.
 * 
 * For the second requirement a simple array list was implemented which is definitely not the most efficient
 * method since the itemType element gets duplicated which is inefficient, a PriorityQueue would be a much
 * better option but I felt like it would change the structure of ShoppingCart.java a bit too much
 * 
 * A boolean flag was added as to allow the alternative print method to be used, the ShoppingCart() method 
 * may be called with a second boolean argument which enables this alternative.
 * 
 * @author Bernard B.
 *
 */
public class ShoppingCart implements IShoppingCart 
{
	HashMap<String, Integer> contents = new HashMap<>();
	
	ArrayList<String> scanOrder = new ArrayList<>();
	
	Pricer pricer;
	
	boolean altPrint = false;

	public ShoppingCart(Pricer pricer) 
	{
		this.pricer = pricer;
	}
	
	public ShoppingCart(Pricer pricer, boolean altPrint) 
	{
		this.pricer = pricer;
		
		this.altPrint = altPrint;
	}

	public void addItem(String itemType, int number) 
	{
		if (!contents.containsKey(itemType)) {
			contents.put(itemType, number);
			scanOrder.add(itemType);
		} else {
			int existing = contents.get(itemType);
			contents.put(itemType, existing + number);
		}
	}

	public void printReceipt() 
	{
		
		float totalprice = 0;
		
		if(!this.altPrint)
		{
			for (int i = 0; i < scanOrder.size() ; i++) 
			{				
				Integer price = pricer.getPrice(scanOrder.get(i)) * contents.get(scanOrder.get(i));
				Float priceFloat = new Float(new Float(price) / 100);
				String priceString = String.format("â‚¬%.2f", priceFloat);
				
				totalprice += pricer.getPrice(scanOrder.get(i)) * contents.get(scanOrder.get(i));
				
				System.out.println(scanOrder.get(i) + " - " + contents.get(scanOrder.get(i)) + " - " + priceString);
			}
		}
		else
			for (int i = 0; i < scanOrder.size() ; i++) 
			{				
				Integer price = pricer.getPrice(scanOrder.get(i)) * contents.get(scanOrder.get(i));
				Float priceFloat = new Float(new Float(price) / 100);
				String priceString = String.format("â‚¬%.2f", priceFloat);
				
				totalprice += pricer.getPrice(scanOrder.get(i)) * contents.get(scanOrder.get(i));
				
				System.out.println(priceString + " - " + contents.get(scanOrder.get(i)) + " - " + scanOrder.get(i));
			}
		
		
		pricer.addtoTotal(totalprice);
		
		printTotal();

	}
	
	public void printTotal()
	{
		System.out.println("--------------------------------");
		System.out.println("TOTAL: " + pricer.getTotal());
	}
	
}
