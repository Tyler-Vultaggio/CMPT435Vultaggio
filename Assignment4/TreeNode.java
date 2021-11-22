/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

public class TreeNode 
{
	
	public TreeNode left = null;
	public TreeNode right = null;
	public String magicItem;
	
	public TreeNode () 
	{
		left = null;
		right = null;
		magicItem = null;
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setLeft(TreeNode left) 
	{
		this.left = left;
	}
	
	public void setRight(TreeNode right)
	{
		this.right = right;
	}
	
	public void setmagicItem(String magicItem) 
	{
		this.magicItem = magicItem;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public TreeNode getLeft()
	{
		return left;
	}
	
	public TreeNode getRight()
	{
		return right;
	}
	
	public String getmagicItem()
	{
		return magicItem;
	}
	
	//______________________________________________

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}