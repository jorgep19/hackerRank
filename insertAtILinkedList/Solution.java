/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
// This is a "method-only" submission. 
// You only need to complete this method. 
Node InsertNth(Node head, int data, int position) {
  Node h = head;

  Node prev = null;
  Node current = head;  
  Node tmp; 

  for(int i = 0; i < position; ++i) {
    tmp = current;
    current = current.next;
    prev = tmp;
  }

  Node newNode = new Node();
  newNode.data = data;

  if(prev != null) {
    prev.next = newNode;
  }
  newNode.next = current;

  return position == 0 ? newNode : h;
}
