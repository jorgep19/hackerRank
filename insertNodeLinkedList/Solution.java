/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node Insert(Node head,int data) {
	// in the case the link is empty
	Node h = head;
	if(h == null) {
		h = new Node();
		h.data = data;
		return h;
	}

	// add the new node to a non-empty list
	Node current = head;
	while(current.next != null) {
		current = current.next;
	}
 	
 	Node newTail = new Node()
 	newTail.data = data;
	current.next = newTail;
	return h;
}
