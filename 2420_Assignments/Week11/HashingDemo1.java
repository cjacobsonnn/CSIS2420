package Week11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HashingDemo1 {
    /*
    hashArray[0] -> Barnes
    hashArray[1] -> Andrews -> Mathison -> Jones
    hashArray[2] -> Yates   -> Carlson
    */
    public static String[] dataArray = new String[] {"Yates","Andrews","Barnes","Mathison","Jones","Carlson"};
    public static int[] customerIDsArray = new int[] {1111, 2222, 3333, 4444, 5555, 6666};
    public static HashNode hashArray[] = new HashNode[1000000];

    public static void main(String[] args) throws NumberFormatException, IOException
    {
      displayDataArray();
      displayHashExampleOutput();
      for (int j = 0; j < dataArray.length; j++)
      {
        appendNode(hashIt(dataArray[j]), customerIDsArray[j], dataArray[j]);
      }
      displayHashArray();
      
      HashNode m = search("Yates");
      
    /*   System.out.println(m.customerID);
      System.out.println(m.lastName); */
      String line = "";
      String path = "/Users/cjacobson/eclipse-workspace/2420_Assignments/src/Week11/HashingDemoDataFile.csv";
      BufferedReader br = new BufferedReader (new FileReader(path)); 

      while ((line = br.readLine()) != null) {
          String[] values = line.split(",");
         appendNode(hashIt(values[1]),Integer.valueOf(values[0]), values[1]);
      }
      
      //searches for random name
      long start = System.nanoTime();
      HashNode n = search("Yount");
      long stop = System.nanoTime();
      long total = (stop-start);
      System.out.println(n.lastName +" "+ total);

    }

    private static void displayHashExampleOutput()
    {
      int asciiTotal = 0;
      for (int j = 0; j < dataArray.length; j++)
      {
        for (int k = 0; k < dataArray[j].length(); k++)
        {
          char c = dataArray[j].charAt(k);
          System.out.println(c + "  " + (int)c);
          asciiTotal = asciiTotal + (int)c;
        }
        System.out.print("asciiTotal: " + asciiTotal);
        System.out.println("\t[" + asciiTotal % hashArray.length + "]\n");
        asciiTotal = 0;
      }
    }

    private static void displayDataArray()
    {
      for (int i = 0; i < dataArray.length; i++)
      {
        System.out.printf("dataArray[%d]: %s%n", i, dataArray[i]);
      }
      System.out.println();
      for (int i = 0; i < customerIDsArray.length; i++)
      {
        System.out.printf("customerIDsArray[%d]: %s%n", i, customerIDsArray[i]);
      }
      System.out.println();
    }

    public static int hashIt(String data)
    {
      int asciiTotal = 0;
      for (int n = 0; n < data.length(); n++)
      {
        char c = data.charAt(n);
        asciiTotal = asciiTotal + (int)c;
      }
      return asciiTotal % hashArray.length;
    }

    public static void appendNode(int arrayIndex, int customerID, String name)
    {
      if (hashArray[arrayIndex] == null)
      {
        hashArray[arrayIndex] = new HashNode(customerID, name);
      }
      else
      {
        HashNode current = hashArray[arrayIndex];
        while (current.next != null)
        {
          current = current.next;
        }
        current.next = new HashNode(customerID, name);
      }
    }

    public static void displayHashArray()
    {
      for (int i = 0; i < hashArray.length; i++)
      {
        System.out.printf("hashArray[%d]", i);
        if (hashArray[i] != null)
        {
          HashNode current = hashArray[i];
          System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
          while (current.next != null)
          {
            current = current.next;
            System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
          }
        }
        System.out.println();;
      }
    }
    
    /*
     * Encodes hashmap depending on result and then puts into array.
     */
    public static HashNode search(String search){
    	int hash = hashIt(search);
    	HashNode n = hashArray[hash];
    	
    	while (n != null) {
    		if (n.lastName.equalsIgnoreCase(search)) {
    			return n;
    		}	
    		n = n.next;
    	}
    	return null;
    } 
  }
