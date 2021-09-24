/**
 * 
 */
import java.util.*;
/**
 * @author Tyler Vultaggio
 *
 */
public class MyStack
{
	public StackNode Top;
	
	
	public class StackNode
	{
		public StackNode next;
		public StackNode prev;
		public String sName;
		
		public StackNode(StackNode next, StackNode prev, String sName)
		{
			this.next = next;
			this.prev = prev;
			this.sName = sName;
		}
		
		public void setNext(StackNode next)
		{
			this.next = next;
		}
		
		public void setPrev(StackNode prev)
		{
			this.prev = prev;
		}
		
		public void setName(String sName)
		{
			this.sName = sName;
		}
		
		public StackNode getNext()
		{
			return next;
		}
		
		public String getName()
		{
			return sName;
		}
		/*
		public boolean isEmpty()
		{
			return this.prev == null;
		}
		*/
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		String badString = "Tome of leadership and influence +4";
		
		badString = badString.replaceAll("[0-9+-,_()/]", "");
		badString = badString.replaceAll("\\s", "");
		badString = badString.replaceAll("'", "");
		
		
		System.out.print(badString);

	}

}
