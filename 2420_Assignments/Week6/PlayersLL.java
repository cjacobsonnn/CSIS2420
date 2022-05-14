package Week6;

import java.util.ArrayList;

public class PlayersLL {
	
	pNode head;
	
	public void append(int playerID, String firstName, String lastName, String playerName, String playerType, float lifePoints,
			int totalScore) {
	    if (head == null)
	    {
	      head = new pNode(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
	      return;
	    }
	    pNode current = head;
	    while (current.next != null)
	    {
	      current = current.next;
	    }
	    current.next = new pNode(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
	}
	
	public void delete(int PlayerID) {
	  pNode current = head;
		  
		  while (current != null && current.next != null){

            if (PlayerID == current.next.playerID) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
          }
		  	System.out.println("Not in list.");
	}
	
	public void length() {
		  int count = 0;
		  pNode current = head;
		  
		  while(current != null) {
			count = count+1;
			current = current.next;
		  }
		  
		  System.out.println(count);
	}
	
	public void prepend(int playerID, String firstName, String lastName, String playerName, String playerType, float lifePoints,
			int totalScore) {
		  pNode nodeToPrepend = new pNode(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
		  nodeToPrepend.next = head;
		  head = nodeToPrepend;
	}
	
	public void printPlayerList() {
		  pNode current = head;
		  System.out.print("List Contents: ");
		  System.out.print(" ");
		  while (current != null)
		  {
		     System.out.print(current.playerID + " , ");
		     System.out.print(current.firstName + " , ");
		     System.out.print(current.lastName + " , ");
		     System.out.print(current.playerName + " , ");
		     System.out.print(current.lifePoints + " , ");
		     System.out.print(current.totalScore + " , ");

			    System.out.println("->");
			    current = current.next;
		     
		  }
		    System.out.println("null");
	}
	
	public pNode search(int playerID) {
		pNode current = head; 
		
		while  (current != null)
        {
			if(playerID == current.playerID) {
	              return current;
	          }
			
			current = current.next;
        }
		
		return null;
	}
	
	public pNode search(String firstName, String lastName) {
		pNode current = head; 
		
		while  (current != null)
        {
			if(firstName.equalsIgnoreCase(current.firstName)== true && lastName.equalsIgnoreCase(current.lastName) == true) {
	              return current;
	          }
			
			current = current.next;
        }
		
			return null;
		}
	
	public ArrayList<pNode> search(String n) {
		pNode current = head;
		
		ArrayList<pNode> playerName = new ArrayList<>();
		
		while (current != null)
        {
			if(n.equalsIgnoreCase(current.playerName) == true || n.equalsIgnoreCase(current.playerType) == true) {
				playerName.add(current);
			}
			current = current.next;
        }
		
		if(playerName.size() == 0) {
			return null;
        }
		
		return playerName;
		
	}
	
	public String highScore() {
		pNode current = head;
		
		if (current == null){System.out.println("List is empty.");
		
		return null;
		}
		
		int highScore = current.totalScore;
		pNode highestScore = current;
		
		while (current != null)
        {
			
			if(current.totalScore > highScore) {
				highScore = current.totalScore;
				
				highestScore = current;
				
			}
			
			
			current = current.next;
        }
		
		return highestScore.firstName + " " + " " + highestScore.lastName + " " + highestScore.totalScore;
		
	}
	
	public String lowScore() {
		pNode current = head;
		
		if (current == null){System.out.println("List is empty.");
		
		return null;
		}
		
		int lowScore = current.totalScore;
		pNode lowestScore = current;
		
		while (current != null)
        {
			if(current.totalScore < lowScore) {
				lowScore = current.totalScore;
				
				lowestScore = current;
				
			}
			
			current = current.next;
        }
		
		return lowestScore.firstName + " " + " " + lowestScore.lastName + " " + lowestScore.totalScore;
		
	}
		
}
