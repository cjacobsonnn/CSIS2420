package Week5;

public class LinkedList {
	 Node head;

	  public void append(int data)
	  {
	    if (head == null)
	    {
	      head = new Node(data);
	      return;
	    }
	    Node current = head;
	    while (current.next != null)
	    {
	      current = current.next;
	    }
	    current.next = new Node(data);
	  }

	  public void printList()
	  {
	    Node current = head;
	    System.out.print("List Contents: ");
	    while (current != null)
	    {
	      System.out.print(current.data + " -> ");
	      current = current.next;
	    }
	    System.out.println("null");
	  }
	  
	  public void prepend(int data) {
		  Node nodeToPrepend = new Node(data);
		  nodeToPrepend.next = head;
		  head = nodeToPrepend;

	  }
	  
	  public void delete(int data) {
		  Node current = head;
		  
		  while (current != null && current.next != null){

            if (data == current.next.data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
          }
		  	System.out.println("Not in list.");
		 }
	  
	  public void search(int data) {
		  int count = 0;
		  Node current = head;
		  
		  while(current != null) {
			  if(data == current.data ){
				  System.out.println(count);
				  
				  return;
			  }
			  
			  count = count+1;
			  current = current.next;
		  }
		  
		  System.out.println("Not in list.");
	  }
	  
	  public void length() {
		  int count = 0;
		  Node current = head;
		  
		  while(current != null) {
			count = count+1;
			current = current.next;
		  }
		  
		  System.out.println(count);
	  }
}
