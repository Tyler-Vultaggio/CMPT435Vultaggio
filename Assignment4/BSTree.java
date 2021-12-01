/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class BSTree 
{
	
	private TreeNode root;
	private int count;
	private ArrayList<String> LeftsRights = new ArrayList<String>();
	
	public BSTree()
	{
		
	}
	
	public void setRoot(TreeNode root)
	{
		this.root = root;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	public TreeNode getRoot()
	{
		return root;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void addNode(String key)
	{
		TreeNode node = new TreeNode();
		node.magicItem = key;
		if(root == null)
		{
			root = node;
		}
		else
		{
			TreeNode nodeToLookAt = new TreeNode();
			nodeToLookAt = root;
			TreeNode parent;
            while(true) 
            {
                parent = nodeToLookAt;
                if(key.compareTo(nodeToLookAt.getmagicItem()) < 0)
                {
                    nodeToLookAt = nodeToLookAt.getLeft();
                    LeftsRights.add("L");

                    if(nodeToLookAt == null) 
                    {
                        parent.setLeft(node);
                        return;
                    }
                } 
                else 
                {
                    nodeToLookAt = nodeToLookAt.getRight();
                    LeftsRights.add("R");
                    
                    if(nodeToLookAt == null)
                    {
                        parent.setRight(node);
                        return;
                    }
                }
            }
		}
	}
	
	public TreeNode findNode(String target)
	{
		
		TreeNode magicitem = root;
		count = 0;
		while(magicitem.getmagicItem().compareToIgnoreCase(target) != 0)
		{
			if(target.compareToIgnoreCase(magicitem.getmagicItem()) < 0)
			{
				magicitem = magicitem.getLeft();
				LeftsRights.add("L");
				count++;
			}
			else
			{
				magicitem = magicitem.getRight();
				LeftsRights.add("R");
				count++;
			}
		}
		return magicitem;
	}
	
	public void printPath()
	{
		System.out.print("This was the path taken through the tree: ");
		for(int i = 0; i < LeftsRights.size(); i++)
		{
			System.out.print(LeftsRights.get(i) + " ");
		}
		System.out.println();
		System.out.println();
		LeftsRights.clear();
	}
	
	public void TreeTraverseinOrder(TreeNode target)
	{
		if(target !=null)
		{
			TreeTraverseinOrder(target.getLeft());
			System.out.println(target.getmagicItem());
			TreeTraverseinOrder(target.getRight());
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
