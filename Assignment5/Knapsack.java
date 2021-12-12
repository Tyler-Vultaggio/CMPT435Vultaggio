/** @author Tyler Vultaggio
* Assignment 5
* Due Friday 12/10/2021
* Algorithms
*/

//import java.util.ArrayList;

public class Knapsack 
{
	public int total_size;
	public double current_size;
	public double value;
	
	public Knapsack()
	{
		total_size = 0;
		current_size = 0;
		value = 0;
	}
	
	public Knapsack(int newSize)
	{
		total_size = newSize;
		current_size = 0;
		value = 0;
	}
	
	//This is for setting methods
	//_________________________________
	public void setTotal_Size(int size)
	{
		this.total_size = size;
	}
	public void addSize(double size)
	{
		current_size = current_size + size;
	}
	public void addValue(double newValue)
	{
		value = value + newValue;
	}
	//________________________________
	
	//This is for getting methods
	//________________________________
	public int getTotal_Size()
	{
		return total_size;
	}
	public double getCurrent_Size()
	{
		return current_size;
	}
	public double getValue()
	{
		return value;
	}
	//_________________________________
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
