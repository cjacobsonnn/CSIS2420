package CSIS2420FinalProject;

/**
 * The class ListBSTNode instantiates a left and right node, an integer, and two strings one called nameOFTask and the other category.
 *  Public ListBSTNode uses int date, String nameOfTask, and String category. This will create a portion in our nodes which 
 * represent the date of a task, the name of a task, and a string which represents categories of a task. The class 
 * calls a super and users this statements to create the nodes for ListBSTNode.
 * 
 * @version 1.0
 * @author CJ Jacobson
 */
public class ListBSTNode {
	
	ListBSTNode left;
    ListBSTNode right;
    int date;
    String nameOfTask;
    String category;

    public ListBSTNode(int date, String nameOfTask, String category) {
        super();
        this.date = date;
        this.nameOfTask = nameOfTask;
        this.category = category;
    }
	
}