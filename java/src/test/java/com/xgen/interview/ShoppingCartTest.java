package com.xgen.interview;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * The tests were updated to work with the new requirements, a simple string was added to compensate the
 * new added lines
 * @author Bernard B.
 *
 */
public class ShoppingCartTest {

	@Test
	public void canAddAnItem() 
	{
		ShoppingCart sc = new ShoppingCart(new Pricer());

		sc.addItem("apple", 2);

		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		
		sc.printReceipt();
		
		String filler = myOut.toString();
		
		String[] sampletest = filler.split("\r");

		assertEquals("apple - 2 - â‚¬2.00", sampletest[0]);
	}

	@Test
	public void canAddMoreThanOneItem() 
	{
		ShoppingCart sc = new ShoppingCart(new Pricer());

		sc.addItem("apple", 2);

		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));

		sc.printReceipt();
		
		String filler = myOut.toString();
		
		String[] sampletest = filler.split("\r");
		
		assertEquals("apple - 2 - â‚¬2.00", sampletest[0]);
	}

	@Test
	public void canAddDifferentItems() 
	{
		ShoppingCart sc = new ShoppingCart(new Pricer());

		sc.addItem("apple", 2);
		sc.addItem("banana", 1);

		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));

		sc.printReceipt();

		String result = myOut.toString();
		
		String[] sampletest = result.split("\r\n");
			
		assertEquals("banana - 1 - â‚¬2.00", sampletest[1]);
		assertEquals("apple - 2 - â‚¬2.00", sampletest[0]);
        
        
	}
	
	@Test
	public void doesntExplodeOnMysteryItem() 
	{
		ShoppingCart sc = new ShoppingCart(new Pricer());

		sc.addItem("crisps", 2);

		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));

		sc.printReceipt();
		
		String filler = myOut.toString();
		
		String[] sampletest = filler.split("\r");
		
		assertEquals("crisps - 2 - â‚¬0.00", sampletest[0]);
	}
	
	@Test
	public void printToStdOut()
	{
		ShoppingCart sc = new ShoppingCart(new Pricer());
		
		//uncomment the line below and comment/remove the line above for testing the alternative print method
		//ShoppingCart sc = new ShoppingCart(new Pricer(),true);
		
		sc.addItem("apple", 2);
		
		sc.addItem("banana", 5);
		
		sc.addItem("pasta", 2);
		
		sc.addItem("tomato", 8);
		
		sc.printReceipt();
		
	}	

}


