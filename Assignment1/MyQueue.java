/** @author Tyler Vultaggio
* Assignment 1
* Due Friday 9/24/2021
* Algorithms
*/

public class MyQueue extends Node
{
	public static Node head;
	public static Node tail;
	
	public MyQueue()
	{
		
	}
	
	//enqueue adds a new element to the tail end of the queue 
	//and if there is nothing in the queue it also makes it the head
	public void enqueue(char newLetter)
	{
		Node oldTail = tail;
		tail = new Node();
		tail.letter = newLetter;
		tail.next = null;
		if(isEmpty())
		{
			head = tail;
		}
		else
		{
			oldTail.next = tail;
		}
	}
	//dequeu takes off the first/head element that was put into the queue and then returns it
	public char dequeue()
	{
		if(isEmpty())
		{
			tail = null;
			throw new IllegalArgumentException("Stack is empty");
		}
		else
		{
			char deQueuedLetter = head.letter;
			head = head.next;
			return deQueuedLetter;
		}
	}
	
	//isEmpty checks to see if queue is empty ... 
	public boolean isEmpty()
	{
		return(head==null);
	}

	public static void main(String[] args) 
	{
		//This was test code to make sure queue worked how I wanted it to.
		/*
		MyQueue queue = new MyQueue();
		queue.enqueue('L');
		queue.enqueue('i');
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		*/
		//___________________________________________________________________

	}

}
