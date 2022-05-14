package CSIS2420FinalProject;

/**
 * ListBST creates the following methods: insert which creates a users task by using date, nameOfTask, and category. The next method
 * inOrderTraverse takes a normal date entered in from a user (00/00/0000) and turns the date into a corresponding node number that 
 * removes the first two digits of the year date, and the / / in order to implement each task into a Binary Search Tree. The node
 * number is used in further tasks in the program. The method getDate uses a substring that functions to actually remove the first 
 * two digits of a users input year along with the / / and creates a node number that responds with each task date. The method searchRecursive
 * is used to return the left and right branch from our Binary Search Tree. The next method deleteNode functions as the delete function
 * in the program which will delete a node in the Binary Search Tree in the user enters in a correct date that corresponds with a task
 * in the Binary Search Tree. 
 * 
 * 
 * @author CJ Jacobson
 *
 */
public class ListBST {

	//Gets the root and depth for the Binary Search Tree
	public ListBSTNode root;
	public int BSTDepth = 0;
	
	/**
	 * The insert class uses the parameter date, nameOfTask, and category to create new nodes for the 
	 * Binary Search Tree List to create new tasks for the program. 
	 * Class insert creates left and right parent nodes for each parameter.
	 * 
	 * @param date
	 * @param nameOfTask
	 * @param category
	 */
	public void insert(int date, String nameOfTask, String category)
	{
		ListBSTNode newNode = new ListBSTNode(date, nameOfTask, category);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			ListBSTNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(date < current.date)
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
	 * The class inOrderTraverse takes the users entered date (00/00/0000), name of task, and category 
	 * from the user to create a new task in the system which can be output to the user when the
	 * user selects "1. View Tasks" in the Driver.java file. 
	 * 
	 * @param n
	 */
	public void inOrderTraverse(ListBSTNode n)
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
			
			//Gets 00/00/00 Dates to Print
			System.out.println(getDate(n.date) + ", " +n.nameOfTask+", "+n.category);
			
			if(n.right!= null)
			{
				inOrderTraverse(n.right);  
			}
		}  
	}  
	
	/**
	 * The public string getDate takes the String from a users input date (00/00/0000) and uses n.inOrderDate
	 * to create a substring of the date that outputs a date number that corresponds with the users input date. 
	 * The date number is stored as a node number for each dated task in the program. 
	 * 
	 * @param date
	 * @return
	 */
	public String getDate(int date) {
		String n = String.valueOf(date);
		String inOrderDate = n.substring(2,4)+"/"+n.substring(4,6)+"/"+n.substring(0,2);
        return inOrderDate;
	}
	
	/**
	 * public ListBSTNode creates the method searchRecursive which calls n (number) and date which are used to return a
	 * search on the left and right node numbers and the date that the user entered. 
	 * 
	 * @param n
	 * @param date
	 * @return
	 */
	public ListBSTNode searchRecursive(ListBSTNode n, int date)
	{
	    if (n == null || n.date == date)
	    {
	    	return n;
	    }
	    if (n.date < date)
	    {
	       return searchRecursive(n.right, date);
	    }
	    return searchRecursive(n.left, date);
	}

	/**
	 * The public static method deleteNode uses n and int date to find the 
	 * date a user enters into the program, which will delete the node that corresponds 
	 * with the date (00/00/0000)and remove the task from printing in "1. View Task"
	 * in Driver.java. 
	 * 
	 * @param n
	 * @param date
	 * @return
	 */
	public static ListBSTNode deleteNode(ListBSTNode n, int date) 
	{
        if(n == null) return n;
        if(date > n.date)
        {
        	// Traverse right
            n.right = deleteNode(n.right, date);
        }
        else if(date < n.date)
        {
        	// Traverse left
            n.left = deleteNode(n.left, date);
        }
        else
        {
        	// Found the node
            if(n.left == null && n.right == null)
            {
            	// It is a leaf, set it to null (delete it)
                n = null;
            }
            else if(n.right != null)
            {
            	// It has a right-child, get the successor 
                n.date = getSuccessor(n);
                n.right = deleteNode(n.right, n.date);
            }
            else
            {
            	// No successor so go back
                n.date = getPredecessor(n);
                n.left = deleteNode(n.left, n.date);
            }
        }
        return n;
    }
	
	//Returns n.date from n.right from ListBSTNode
    private static int getSuccessor(ListBSTNode n){
        n = n.right;
        while(n.left != null){
            n = n.left;
        }
        return n.date;
    }
	
	//Returns n.date from n.left from ListBSTNode
    private static int getPredecessor(ListBSTNode n){
        n = n.left;
        while(n.right != null){
            n = n.right;
        }
        return n.date;
    }
	
}
