public class AVLNode {
	
	AVLNode root; 
	
	int element;
	AVLNode leftNode;
	AVLNode rightNode;
	int height;
   
	/* Constructor */
	     public AVLNode()
	     {
	         leftNode = null;
	         rightNode = null;
	         element = 0;
	         height = 0;
	     }
	     /* Constructor */
	     public AVLNode(int n)
	     {
	         leftNode = null;
	         rightNode = null;
	         element = n;
	         height = 0;
	     }     
	 
	
	AVLNode (int element, AVLNode leftElement, AVLNode rightElement)// haven't used this constructor anywhere.. 
{
		
		this.element = element ;
		this.leftNode = leftElement ; 
		this.rightNode = rightElement ; 
		
	}
	

   
}
