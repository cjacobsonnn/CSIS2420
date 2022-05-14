package Week6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PlayersLL LL =  new PlayersLL();
		
		String line = "";
        String path = "/Users/cjacobson/eclipse-workspace/2420_Assignments/src/Week6/Players.csv";
        BufferedReader br = new BufferedReader (new FileReader(path));
        
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            LL.append(Integer.valueOf(values[0]), values[1], values[2], values[3],
                    values[4], Float.valueOf(values[5]),Integer.valueOf(values[6]));
        }
        
       /* LL.printPlayerList();
        LL.lowScore();
        LL.highScore();
        
        LL.delete(9999);
        LL.printPlayerList();
        
        System.out.println(LL.lowScore());
        System.out.println(LL.highScore());
        
        LL.length(); */

        Scanner input = new Scanner(System.in);
        
        int playerID;
        String firstName;
        String lastName;
        String playerName;
        String playerType;
        float lifePoints;
        int totalScore;
        
        boolean quit = false;
        int choice;
        do {
            displayMenu();
            System.out.println("Enter Selection");
            choice = input.nextInt();
            switch(choice) {
            
            //Add a new player
            case 1:                       
             	  System.out.println("Enter PlayerID: ");
             	  playerID = input.nextInt();
             	 
            	  System.out.println("Enter First Name: ");
            	  firstName = input.next();
            	 
            	  System.out.println("Enter Last Name: ");
            	  lastName = input.next();
            	  
               	  System.out.println("Enter Player Name: ");
               	  playerName = input.next();

               	  System.out.println("Enter Player Type: ");
                  playerType = input.next();
                  
               	  System.out.println("Enter Player Life Points: ");
                  lifePoints = input.nextFloat();

               	  System.out.println("Enter Player Total Score: ");
               	  totalScore = input.nextInt();
            	  
            	  LL.append(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
            	break;
            
            //Delete a player
            case 2:
           	  System.out.println("Enter PlayerID: ");
           	  playerID = input.nextInt();
           	  LL.delete(playerID);

            	break;
            
            //Report total number of players
            case 3:
            	LL.length();
            	break;

            //Print full player list
            case 4:
            	LL.printPlayerList();
            	break;

            //Search by Player ID
            case 5:
         	  System.out.println("Enter PlayerID: ");
         	  playerID = input.nextInt();

         	 if(LL.search(playerID) == null){
            	  System.out.println("Not Found");
         	 }
         	 
         	 else {
         		 System.out.println(LL.search(playerID));
         		 }
            	break;
            
            //Search by Player's Real Name
            case 6:
           	  System.out.println("Enter First Name: ");
           	  firstName = input.next();
           	  
           	  System.out.println("Enter Last Name: ");
           	  lastName = input.next();
           	  
           	if (LL.search(firstName, lastName)== null) {
                System.out.println("Name not in the list.");
            }
           	
           	else {
           		pNode n = LL.search(firstName, lastName);
           		
       	     System.out.print(n.playerID + " , ");
		     System.out.print(n.firstName + " , ");
		     System.out.print(n.lastName + " , ");
		     System.out.print(n.playerName + " , ");
		     System.out.print(n.lifePoints + " , ");
		     System.out.print(n.totalScore + " , ");
           	}

            	break;
           
            //Search by Player's Game Name
            case 7:
            	System.out.println("Enter Game Name");
                playerType = input.next();
                LL.search(playerType);

            	break;
            
            //Report Player with Highest Total Score
            case 8:
            	LL.highScore();
            	break;
            	
            //Report Player with Lowest Total Score
            case 9:
            	LL.lowScore();
            	break;
            
            //Exit
            case 10:
            	quit = true;
            	break; 

            default:
                System.out.println("invalid input");
            }
        } while(quit == false);
   }

   private static void displayMenu() {
	   System.out.println("1. Add new player");
	   System.out.println("2. Delete a player");
	   System.out.println("3. Report total number of players");
	   System.out.println("4. Print full player list");
	   System.out.println("5. Search by Player ID");
	   System.out.println("6. Search by Player's Real Name");
	   System.out.println("7. Search by Player's Game Name");
	   System.out.println("8. Report Player with Highest Total Score");
	   System.out.println("9. Report Player with Lowest Total Score");
	   System.out.println("10. Exit");

	}
	

}
















