import java.io.FileNotFoundException;

/** @author Tyler Vultaggio
* Assignment 3
* Due Friday 11/5/2021
* Algorithms
*/


public class HashNode 
{
	
	public HashNode next = null;
	public String magicItem;
	
	public HashNode () 
	{
		
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setNext(HashNode next) 
	{
		this.next = next;
	}
	
	public void setmagicItem(String magicItem) 
	{
		this.magicItem = magicItem;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public String getmagicItem()
	{
		return magicItem;
	}
	
	public HashNode getNext()
	{
		return next;
	}
	//______________________________________________

	public static void main(String[] args) throws FileNotFoundException  
	{
		// TODO Auto-generated method stub

	}

}
