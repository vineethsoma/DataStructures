
public class SelfBalancingTree {
	
	
	AVLNode root ;   // root of the whole tree. 
	
	
	SelfBalancingTree (){
		
		root = null ; 
	}
	
/* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear()
    {
        root = null;
    }	
	
    /* Function to insertNode element */
    public void insertNode(int element)
    {
        root = insertNode(element, root) ;
        
    }
  
    private int height( AVLNode t )
    {
    	return t == null ? -1 : t.height;
    }
    // Internal insert method , data = element and t=root ; 
    private AVLNode insertNode( int data , AVLNode t )
    {
    	Integer x = data ;
    	if( t == null )
    	return new AVLNode( x, null, null );
    	
    	 
    	
        Integer  compareResult = x.compareTo( t.element );

    	if( compareResult < 0 )
    		t.leftNode = insertNode( x, t.leftNode );
    	else if( compareResult > 0 )
    		t.rightNode = insertNode( x, t.rightNode );
    	else
    		; // Duplicate; do nothing
    	return balance( t );
    }

    private static final int ALLOWED_IMBALANCE = 1;

    // Assume t is either balanced or within one of being balanced
    private AVLNode balance( AVLNode t )
    {
    	if( t == null )
    		return t;
    	
    	if( height( t.leftNode ) - height( t.rightNode ) > ALLOWED_IMBALANCE )
    	if( height( t.leftNode.leftNode ) >= height( t.leftNode.rightNode ) )
    		t = rotateWithleftNodeChild( t );
    	else
    		t = doubleWithleftNodeChild( t );
    	else
    	if( height( t.rightNode ) - height( t.leftNode ) > ALLOWED_IMBALANCE )
    	if( height( t.rightNode.rightNode ) >= height( t.rightNode.leftNode ) )
    		t = rotateWithrightNodeChild( t );
    	else
    	t = doubleWithrightNodeChild( t );
    	
    	t.height = Math.max( height( t.leftNode ), height( t.rightNode ) ) + 1;
    	
    	return t;
    }
   
    /* Rotate binary tree node with leftNode child */     
    private AVLNode rotateWithleftNodeChild(AVLNode k2)
    {
        AVLNode k1 = k2.leftNode;
        k2.leftNode = k1.rightNode;
        k1.rightNode = k2;
        k2.height = Math.max( height( k2.leftNode ), height( k2.rightNode ) ) + 1;
        k1.height = Math.max( height( k1.leftNode ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with rightNode child */
    private AVLNode rotateWithrightNodeChild(AVLNode k1)
    {
        AVLNode k2 = k1.rightNode;
        k1.rightNode = k2.leftNode;
        k2.leftNode = k1;
        k1.height = Math.max( height( k1.leftNode ), height( k1.rightNode ) ) + 1;
        k2.height = Math.max( height( k2.rightNode ), k1.height ) + 1;
        return k2;
    }
   
    
    
    /**
     * Double rotate binary tree node: first leftNode child
     * with its rightNode child; then node k3 with new leftNode child */
    private AVLNode doubleWithleftNodeChild(AVLNode k3)
    {
        k3.leftNode = rotateWithrightNodeChild( k3.leftNode );
        return rotateWithleftNodeChild( k3 );
    }
    /**
     * Double rotate binary tree node: first rightNode child
     * with its leftNode child; then node k1 with new rightNode child */      
    private AVLNode doubleWithrightNodeChild(AVLNode k1)
    {
        k1.rightNode = rotateWithleftNodeChild( k1.rightNode );
        return rotateWithrightNodeChild( k1 );
    }    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.leftNode);
            l += countNodes(r.rightNode);
            return l;
        }
    }	
public static void main(String[] args) {
		
		SelfBalancingTree FirstTree = new SelfBalancingTree ();
		SelfBalancingTree SecondTree = new SelfBalancingTree ();
		FirstTree.insertNode(27);
		FirstTree.insertNode(20);
		FirstTree.insertNode(25);
		FirstTree.insertNode(15);
		FirstTree.insertNode(8);
		FirstTree.insertNode(7);
		FirstTree.insertNode(4);
		FirstTree.insertNode(5);
		FirstTree.insertNode(2);
		SecondTree.insertNode(20);
		SecondTree.insertNode(19);
		SecondTree.insertNode(15);
		SecondTree.insertNode(16);
		SecondTree.insertNode(27);
		SecondTree.insertNode(29);
		SecondTree.insertNode(28);
		SecondTree.insertNode(4);
		SecondTree.insertNode(5);
		SecondTree.insertNode(2);
		SecondTree.insertNode(1);

	}

}
