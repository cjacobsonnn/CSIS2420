package Week5;

public class LinkedListDemo1 {

	public static void main(String[] args) {
		   LinkedList ll = new LinkedList();
		    ll.append(2);
		    ll.append(4);
		    ll.append(6);
		    ll.append(8);
		    ll.append(10);
		    ll.prepend(0);
		    ll.printList();
		    ll.length();
		    ll.search(8);
		    ll.search(9);
		    ll.delete(0);
		  }
	}