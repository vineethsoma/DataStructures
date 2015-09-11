

public class MyLinkedList<AnyType> implements Iterable<AnyType>{		

	private int theSize;												 
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;  				 //link next 
	
	//Node description 
	public class Node<AnyType>{ // Node class		//public class Link
		public AnyType myData;								//public string bookName 
		public Node<AnyType> myHead;
		public Node<AnyType> myTail;
		
		
		public Node (AnyType data, Node<AnyType> head, Node<AnyType> tail){ //Node Constructor
			
			 this.myData=data;
			 this.myHead=head;
			 this.myTail=tail;
		} 
	}
	
	public MyLinkedList(){ 
		
		clear();
	}
	
	public void clear(){
		
		beginMarker = new Node<AnyType>( null, null, null );
		endMarker = new Node<AnyType>( null, beginMarker, null );
		beginMarker.myTail = endMarker;
		theSize = 0;
	}
	public int size(){
		
		return theSize;
	}
	public boolean exist(int newVal){ //check is the value already exists 
		
		//if
		return false ;
	}
	public boolean add(AnyType newVal){ 
		
		add( size( ), newVal ); 
		return true;
		
	}
	public boolean add(int index, AnyType newVal) { //add at position
			
		addBefore( getNode( index, 0, size( ) ), newVal );
		
		
		
		return false;
	}
	private void addBefore(Node<AnyType> previousMarker, AnyType x){
		
		Node<AnyType> newNode = new Node<AnyType>( x, previousMarker.myHead, previousMarker );
		newNode.myHead.myTail = newNode;
		previousMarker.myHead = newNode;
		theSize++;
		
	}
	public Node<AnyType> getNode( int index, int lower, int upper ){
		Node<AnyType> currentMarker;

		if( index < lower || index > upper )
			throw new IndexOutOfBoundsException( );
		
		if( index < size( ) / 2 ){
			currentMarker = beginMarker.myTail;
			for( int i = 0; i < index; i++ )
				currentMarker = currentMarker.myTail;
		}
		else{
			currentMarker = endMarker;
			for( int i = size( ); i > index; i-- )
				currentMarker = currentMarker.myHead;
		}
		return currentMarker;
	}
	
	public void printList(){
		
		Node<AnyType> currentMarker = beginMarker;
		
		while(currentMarker != null){
			
			System.out.println(currentMarker.myData);
			currentMarker=currentMarker.myTail;
			System.out.println();
		}
	}

	public void remove(AnyType removeVal){
	
		Node<AnyType> previousMarker = beginMarker ;
		Node<AnyType> currentMarker = previousMarker.myTail ; 
		while( currentMarker.myTail !=null && currentMarker.myData != removeVal){
			
			currentMarker = currentMarker.myTail ;
			//previousMarker = currentMarker.myHead;
		}
		
		if( currentMarker.myData == removeVal ){
			
			previousMarker.myTail = currentMarker.myTail ;
			currentMarker=null;
			theSize--;
		}
		
		
		
		
	}

	public java.util.Iterator<AnyType> iterator(){
		
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<AnyType>{
		
		Node<AnyType> currentMarker = beginMarker;
		Node<AnyType> previousMarker = endMarker;
		
	
		public void remove(){
			
			if(previousMarker == null){
				
				beginMarker = currentMarker.myTail;
			}
			else{
				previousMarker.myTail = currentMarker.myTail;
				
				if(currentMarker.myTail == null){
					
					currentMarker = beginMarker ;
					previousMarker=null;
				} else {
					
					currentMarker = currentMarker.myTail;
					
				}
			}
			 
		 }
		public boolean hasNext() {
			
			 if(beginMarker !=null){
				 return true;
			 }
			 
			 return false;
		 }
		public AnyType next() {
			 
			if(hasNext()){
				
				previousMarker=currentMarker ;
				currentMarker=currentMarker.myTail;
				
				return currentMarker.myData;
			}
			return null; 
			
		 }
	}
	
	
	private void testListIntegers(){ //test to check if integer list works
		 
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		
		testList.add(new Integer(5));
		testList.add(new Integer(4));
		testList.add(new Integer(3));
	 
		System.out.println(" We have so far inserted " + testList.size() + " elements in the list");
		testList.remove(4);
		
		System.out.println(" Now, there is only " + testList.size() + " elements left in the list");testList.add(1, new Integer(7));
		testList.add(2, new Integer(8));
		
		System.out.println(" About to print content of the list");
		testList.printList();
		
	 }
	private void testListStrings(){ //test to check if string list works
		
		MyLinkedList<String> testList = new MyLinkedList<String>();
		
		testList.add(new String("hello"));
		testList.add(new String("this is"));
		testList.add(new String("cs3345 project 2"));
		
		System.out.println(" We have so far inserted " + testList.size() + " elements in the list");
		testList.remove("this is");
		
		System.out.println(" Now, there is only " + testList.size() + " elements left in the list");
		testList.add(1, "a modified version of");
		testList.add(2, "cs3345 project 2, call it version 2" );
		
		System.out.println(" About to print content of the list");
		testList.printList();
		
	}
	
	
	
	public static void main (String args[]) throws Exception {
		
		MyLinkedList<Integer> testInt = new MyLinkedList<Integer>();
		testInt.testListIntegers();
		
		 // and testListStrings()
		MyLinkedList<String> testString= new MyLinkedList<String>();
		testString.testListStrings();
		
	}

}




