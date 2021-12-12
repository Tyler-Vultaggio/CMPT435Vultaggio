/** @author Tyler Vultaggio
* Assignment 5
* Due Friday 12/10/2021
* Algorithms
*/

import java.util.Comparator;

public class Spices 
{
	public String color;
	public double total_price;
	public int qty;
	public static double price_per;
	
	Spices()
	{
		color = null;
		total_price = -1;
		qty = -1;
		price_per = -1;
	}
	
	Spices(String color, double total_price, int qty)
	{
		this.color = color;
		this.total_price = total_price;
		this.qty = qty;
		//price_per = total_price/qty;
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setTotal_Price(double total_price)
	{
		this.total_price = total_price;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	public void setPrice_Per(double total_price, int qty)
	{
		price_per = total_price/qty;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public String getColor()
	{
		return color;
	}
	public double getTotal_Price()
	{
		return total_price;
	}
	public int getQty()
	{
		return qty;
	}
	public double getPrice_per()
	{
		double total_price = getTotal_Price();
		int qty = getQty();
		return total_price/qty;
	}
	//______________________________________________
	
	//Prints out all of the info for a Spice
	//______________________________________________
	public void printSpice()
	{
		System.out.println("_______________________");
		System.out.println("Spice Color: " + getColor());
		System.out.println("Spice Total Price: " + getTotal_Price());
		System.out.println("Spice Qty: " + getQty());
		System.out.println("Spice Price per Qty: " + getPrice_per());
		
	}
	
	public static Comparator<Spices> SpicePricePer = new Comparator<Spices>() 
	{
        public int compare(Spices spice1, Spices spice2)
        {

            double Price_Per1 = spice1.getPrice_per();
            double Price_Per2 = spice2.getPrice_per();

            // For descending order
            return (int) (Price_Per2 - Price_Per1);

        }
    };
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
