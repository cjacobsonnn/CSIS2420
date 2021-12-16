package Week9_Part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	 static BinarySearchTree bst = new BinarySearchTree();

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		 String line = "";
		 String path = "/Users/cjacobson/eclipse-workspace/2420_Assignments/src/Week9_Part2/users.csv";
		 BufferedReader br = new BufferedReader (new FileReader(path));
		 Scanner input = new Scanner(System.in);
		 boolean quit = false;
		 int choice;
		 
		 do {
			 displayMenu();
			 System.out.println("Enter 1, 2, 3, 4, 5 or 6:");
			 choice = input.nextInt();
			 switch(choice) {
			 case 1: 
				 
				 while ((line = br.readLine()) != null) {
					 String[] values = line.split(",");
					 bst.insert(Integer.valueOf(values[0]), values[1]);			 
				 }
				 
				 break;
			 case 2: 
				 
				 System.out.println("Enter IP ");
				 int answerCase2 = input.nextInt();
				 BSTNode n = bst.search(bst.root, answerCase2);
				 if (n == null) {
					 System.out.println("10.0.0."+answerCase2+ " not in list");
					 break;
				 }
				 
				 System.out.println(n.IPAddress +" "+ n.userName);
				
				 break;
			 case 3:
				 //Couldn't get this to work:((
				 System.out.println("Enter User name");
				 
				 String answerCase3 = input.next();
				 
				 BSTNode k = bst.searchString(bst.root, answerCase3);
				 
				 if(k == null ) {
					 System.out.println("Not in list");
					 break;

				 }
				 if(k.userName.equals(answerCase3)) {
					 System.out.println("Found: 10.0.0."+k.IPAddress +
							 " " + k.userName);
				 }
				 break;
				 
			 case 4:
				 System.out.println("# of Nodes: "+bst.count(bst.root));
				 break;
				 
			 case 5:
				bst.inOrderTraverse(bst.root);
				break;
				
			 case 6:
				 quit = true;
				 break;
		     default:
		    	 System.out.println("Invalid choice.");
			 }
			 System.out.print("\n\n\n");
		 }while(!quit);
		 		 
		}

	private static void displayMenu() {
		System.out.println("---------------------------");
		System.out.println("1 Build Users Tree");
		System.out.println("2 Find by IP Address");
		System.out.println("3 Find by Username");
		System.out.println("4 Report Number of Nodes");
		System.out.println("5 Print Entire Tree");
		System.out.println("6 Exit");
		System.out.println("---------------------------");
		
		
		
		
	}
	
	
	
	

	}

