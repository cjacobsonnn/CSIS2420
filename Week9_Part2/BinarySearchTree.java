package Week9_Part2;
	
public class BinarySearchTree {
	
	public BSTNode root;
	public int BSTDepth = 0;

	/**
	 * Appends to BST.
	 * @param IPAddress
	 * @param userName
	 */
	public void insert(int IPAddress, String userName)
	{
		BSTNode newNode = new BSTNode(IPAddress, userName);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			BSTNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(IPAddress < current.IPAddress)
				{  
					current = current.left;  
					if(current == null)
					{  
						parent.left = newNode;  
						return;  
					}  
				}  
				else
				{  
					current = current.right;  
					if(current == null)
					{  
						parent.right = newNode;  
						return;  
					}  
				}  
			}  
		}  
	}

	/**
	 * Prints the entire tree in IP address order to the console.
	 * @param n
	 */
	public void inOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				inOrderTraverse(n.left);  
			}
			System.out.print("["+n.userName + " " + "10.0.0."+n.IPAddress+"] ");  
			if(n.right!= null)
			{
				inOrderTraverse(n.right);  
			}
		}  
	}  
	

	/**
	 * Returns total nodes
	 * @param n
	 * @return
	 */
	public int count(BSTNode n)
	{  
		if(n == null)
		{
			return 0;
		}
		return((1+ count(n.left)) + count(n.right));
	}  
	
	/**
	 * Returns node with IP entered
	 * @param n
	 * @param ip
	 * @return
	 */
	public BSTNode search(BSTNode n, int ip)
	{
		while (n != null && ip != n.IPAddress)
		{
			if (ip < n.IPAddress)
			{
				n = n.left;
			}
			else
			{
				n = n.right;
			}
		}
		return n;
	}
	
	/**
	 * Returns node of username entered
	 * Couldn't figure it out after a few hours:////
	 * @param n
	 * @param data
	 * @return
	 */
	public BSTNode searchString(BSTNode n, String data)
	{
		return n;
////		while (n != null && data != n.userName)
////		{
////			if (data < n.userName)
////			{
////				n = n.left;
////			}
////			else
////			{
////				n = n.right;
////			}
////		}
////		return n;
//		
//		 if (n == null || n.userName == data)
//		    {
//		    	return n;
//		    }
//		    if (n.userName < data)
//		    {
//		       return searchString(n.right, data);
//		    }
//		    return searchString(n.left, data);
//		
	}
	
}
