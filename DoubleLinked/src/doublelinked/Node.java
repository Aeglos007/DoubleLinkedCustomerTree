/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinked;

/**
 *
 * @author Lenovo
 */
class LinkedListEmptyException extends RuntimeException{
       public LinkedListEmptyException(){
         super();
       }
      
     public LinkedListEmptyException(String message){
         super(message);
       }  
}
 
/**
 *Node class, which holds data and contains next which points to next Node.
 */
class Node {
    public CustomerInfo data; // data in Node.
    public Node next; // points to next Node in list.
    public Node previous; // points to previous Node in list.
 
    /**
     * Constructor
     */
    public Node(CustomerInfo data){
           this.data = data;
    }
 
    /**
     * Display Node's data
     */
    public void displayNode() {
           System.out.print( data + "\n ");
    }
}
 
 
/**
 * Sorted Doubly LinkedList class
 */
class LinkedList {
    private Node head; // ref to HEAD link on LinkedList
    private Node tail; // ref to TAIL link on LinkedList
 
    /**
     * LinkedList constructor
     */
    public LinkedList(){
           head = null;
    }
  
    /**
     * Insert New Node at TAIL position
     */
    
    public void insertFirst(CustomerInfo data){ // insert at front of list
           Node newNode = new Node(data); // creation of new node.
           if (head == null) // means LinkedList is empty.
                  tail = newNode; //  newNode <--- TAIL
           else
                  head.previous = newNode; // newNode <-- old Head
           newNode.next = head; // newNode --> old Head
           head = newNode; // Head --> newNode
    }
 
    /**
     * Delete first node.
     */
    public Node deleteFirst() { // (assumes non-empty list)
           Node tempNode = head;
           if (head.next == null) // if only one item
                  tail = null; // null <-- Tail
           else
                  head.next.previous = null; // null <-- old next
           head = head.next; // first --> old next
           return tempNode;
    }
 
    
    /**
     *Insert Node in Sorted DoublyLinkedList (in between of other Nodes).
     *Note:- Sorted DoublyLinkedList is arranged in ascending order.
     */
    public void insertSorted(CustomerInfo newKey){
           
           Node newNode=new Node(newKey);
           
           //Case1: when there is no element in LinkedList
           if(head==null){ //means LinkedList is empty, make Head point to new Node.
                  head=tail=newNode;
                  System.out.println(newNode.data+" inserted at HEAD.");
                  
                  return;
           }
           
           //Case2: when newNode should be placed at first.
           Node current=head;
           if(current.data.getAdSoyad().split(" ")[1].compareTo(newNode.data.getAdSoyad().split(" ")[1])>0){
                  newNode.next=head;
                  head.previous=newNode;
                  head=newNode;    //first ---> newNode
                  System.out.println(newNode.data+" inserted at HEAD Node, beacuse newNode is smallest of existing Nodes.");
                  return;
           }
           
           //Case3: when newNode should be at some position other than first.
           while(true){
                  if(newNode.data.getAdSoyad().split(" ")[1].compareTo(current.data.getAdSoyad().split(" ")[1])>0){ //entering inside if means we haven't find position for inserting node.
                        if(current.next==null){ //means current is the Tail node, insert node.
                               tail.next=newNode;
                               newNode.previous=tail;
                               tail=newNode;
                               System.out.println(newNode.data+" inserted successfully at TAIL of LinkedList.");
                               return;
                        }
                        current=current.next;   //move to next node.
                  }
                  else{  //we have find position for inserting node.
                        current=current.previous;  //make current point to previous node.
                        newNode.next=current.next; //make current's next point to newNode's next.
                        current.next.previous=newNode; //make previous of current's next node point to newNode.
                        newNode.previous=current;  //make newNode's previous point to current.
                        current.next=newNode;          //make current's next point to newNode.
                        System.out.println(newNode.data+" inserted successfully in middle of LinkedList.");
                        return;
                  }
           }
    }
    
    /**
     * Method deletes specific Node from DoublyLinkedList.
     */
    public void deleteSpecificNode(String adSoyad){
           
           //Case1: when there is no element in LinkedList
           if(head==null){  //means LinkedList in empty, throw exception.              
                  throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
           }
                        
           //Case2: when there are elements in LinkedList
           Node current=head;
           while(!current.data.getAdSoyad().equals(adSoyad)){
                  if(current.next==null){
                        System.out.println(adSoyad+" wasn't found for deletion.");
                        return;
                  }
                  current=current.next;   //move to next node.
           }
           
           if(current.data.getAdSoyad().equals(head.data.getAdSoyad())){
                  System.out.println(current.data+" was found on HEAD and has been deleted.");
                  head=head.next;
                  head.previous=null;
           }
           else if(current.data.getAdSoyad().equals(tail.data.getAdSoyad())){
                  System.out.println(current.data+" was found on TAIL has been deleted.");
                  tail=tail.previous;
                  tail.next=null;
           }
           else{
                  current.previous.next=current.next;
                  current.next.previous=current.previous;
                  System.out.println(current.data+" has been deleted.");
           }
    }
 
 
    /*
     * Display LinkedList in forward direction
     */
    public void displayFrwd() {
           System.out.print("Displaying in forward direction [HEAD--->TAIL] : ");
           Node tempDisplay = head; // start at the beginning of linkedList
           while (tempDisplay != null){ // Executes until we don't find end of list.
                  tempDisplay.displayNode();
                  tempDisplay = tempDisplay.next; // move to next Node
           }
           System.out.println("");
    }
 
 
    /*
     * Display LinkedList in backward direction
     */
    public void displayBckwrd() {
           System.out.print("Displaying in backward direction [TAIL-->HEAD] : ");
           Node tempDisplay = tail; // start at the end of linkedList
           while (tempDisplay != null) {// Executes until we don't find start of list.    
                  tempDisplay.displayNode();
                  tempDisplay = tempDisplay.previous; // move to previous Node
           }
           System.out.println("");
    }
    
 
}
