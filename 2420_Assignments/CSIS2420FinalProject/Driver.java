package CSIS2420FinalProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	
	/**
	 * Creates the main method which creates an array called activityType used for when a user picks a task category 
	 * out of work, school, fitness, family, and other. The String path creates a path to a text file called file.txt
	 * which uses MakeFile.java to automatically create a number of amount of tasks that are input into the public
	 * class MakeFile. This creates tasks that automatically are populated into our Binary Search Tree and are outputted
	 * in "1. View Tasks". 
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {	
		ListBST bst = new ListBST();
		String activityType[] = new String[]{"Work","School","Fitness","Family","Other"};
		String line = "";
	    String path = "/Users/cjacobson/eclipse-workspace/2420_Assignments/src/CSIS2420FinalProject/file.txt";
	    BufferedReader br = new BufferedReader (new FileReader(path)); 

	      while ((line = br.readLine()) != null) {
	          String[] values = line.split(",");
	          
	          String f = values[0];
	          String fileDate = f.substring(6,8)+f.substring(0,2)+f.substring(3,5);
	          bst.insert(Integer.valueOf(fileDate), values[1],activityType[Integer.valueOf(values[2])]);
	      }
		
	    /*
	     * Used to manually create tasks to confirm bst (binary search tree) is functioning correctly
	     * in the following order: (date number, task name, and task category. 
	     */
	      
		bst.insert(210512, "2420_Week11Assignment", "School");
		bst.insert(220114, "EveningShift", "Work");
	    bst.insert(220101, "MathFinal", "School");
        
        Scanner input = new Scanner(System.in);
    
        String date;
        
        /*
         * Used to create the interface of the program, displayMenu will output the display menu followed
         * by another print statement, "Enter Selection: ". The user will then choose between the 4 cases
         * to choose what they would like to do in the program.
         */
        boolean quit = false;
        int choice;
        do {
            displayMenu();
            System.out.println("Enter Selection: ");
            choice = input.nextInt();
            switch(choice) {
      
            /*
             * Case 1 is "1. View Tasks", if the user chooses option 1 it will print the complete task list
             * of all the created tasks in the Binary Search Tree. Followed by how long the tree took to print
             * in nns. 
             */
            case 1:        
                long start = System.nanoTime();
            	bst.inOrderTraverse(bst.root);
            	
            	  
                long stop = System.nanoTime();
                long total = stop-start;
            	
                System.out.println("Time to Print List: " + total +"nns");
                
            	break;
            
            /**
             * Case 2 is "2. Add Task" which will create and add a new task into the Binary Search Tree. 
             * The user will be asked to enter the date of the task, the name of the task, then they will
             * be prompted to put their task into a chosen category out of 5. When the user finishes creating
             * their task the program will print "Entry Added " followed by the time it took in nns to 
             * add their task to the Binary Search Tree.
             */
             case 2:
            	 System.out.println("Enter Date of Task (00/00/00): ");
            	 date = input.next();
                 String n = date.substring(6,8)+date.substring(0,2)+date.substring(3,5);
                 System.out.println(n);
                 System.out.println("Enter Name of Activity: ");
                 String m = input.next();
                 System.out.println("Choose Category for Task: ");
                 System.out.println("0. Work");
                 System.out.println("1. School");
                 System.out.println("2. Fitness");
                 System.out.println("3. Family");
                 System.out.println("4. Other");
                 
                 int categoryChoice = input.nextInt();
                 start = System.nanoTime();
                 bst.insert(Integer.valueOf(n), m, activityType[categoryChoice]);
                 
                 stop = System.nanoTime();
                 total = stop-start;
                 System.out.println("Entry Added " + total +"nns");
              	 break;
            
             /*
              * Case 3 is "3. Delete Task" which prints a statement that asks the user to enter the
              * task date that they wish to delete. Once the user has entered in the date the task 
              * will be deleted from the Binary Search Tree, and the program will output "Entry Deleted "
              * followed by the total nns time it took to delete the task from the Binary Search Tree.
              */
             case 3:
            	 System.out.println("Enter Date of Task to Delete (00/00/00): ");
            	 date = input.next();
                 n = date.substring(6,8)+date.substring(0,2)+date.substring(3,5);
                 System.out.println(n);
                 
                 start = System.nanoTime();
                 
                 bst.deleteNode(bst.root, Integer.valueOf(n));
                 
                 stop = System.nanoTime();
                 total = stop-start;
                 System.out.println("Entry deleted " + total +"nns");
            
            	break;
            
             case 4:
            	quit = true;
             	break;

            default:
                System.out.println("invalid input");
            }
        } while(quit == false);
   }

	/**
	 * Creates the class displayMenu which prints the statements that make up 
	 * the programs interface. 
	 */
   private static void displayMenu() {
	   System.out.println("**************************");
	   System.out.println("       TASK CREATOR         ");
	   System.out.println("**************************");
	   System.out.println("1. View Tasks");
	   System.out.println("2. Add Task");
	   System.out.println("3. Delete Tasks");
	   System.out.println("4. End Program");
	   System.out.println("***************************");
	}

}
