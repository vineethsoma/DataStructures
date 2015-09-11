
package huffmancodiing;
import java.util.Scanner;

public class HuffmanCodiing {

    static String inputString ="" ; 
    static char[] input = {}  ; 
    static int [] frequency ; 
   static  int R = 256 ; 
   static String[] st ; 
    public static void main(String[] args) {
        
        readInput() ;
        countFrequency() ; 
        buildCodeTable() ; 
        displayTable() ; 
    }

    static void readInput(){
        
        Scanner in = new Scanner(System.in) ; 
        System.out.print( "Please enter your input string: ") ;
        
        inputString = in.nextLine() ;
        
        input = inputString.toCharArray() ; 
    }
    
    static void countFrequency(){
        
        frequency = new int[256] ; 
        for(int i = 0 ; i < input.length ; i++ ){
               frequency[input[i]]++ ;

        }
        
    
    } 
    
    static void displayTable(){
        
     System.out.println("ASCII Code\tLetter\t\tFrequency\tCodeword") ;    
     
     for( int i = 0 ; i < frequency.length ; i++ ){
         
         if ( frequency[i] != 0 )
            System.out.println(i + "\t\t"+(char)i +"\t\t"+frequency[i]+"\t\t"+st[i]) ;
         
     }
   
    }
    
    static void buildCodeTable(){
        
        
          Node root = Node.buildTrie(frequency);
        st = new String[R];
        Node.buildCode(st, root, "");
    }
    
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int frequency;
        private final Node left, right;

        Node(char ch, int frequency, Node left, Node right) {
            this.ch    = ch;
            this.frequency  = frequency;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert (left == null && right == null) || (left != null && right != null);
            return (left == null && right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.frequency - that.frequency;
        }
        
         private static Node buildTrie(int[] frequency) {

            // initialze priority queue with singleton trees
            MinPQ<Node> pq = new MinPQ<Node>();
            for (char i = 0; i < R; i++)
                if (frequency[i] > 0)
                    pq.insert(new Node(i, frequency[i], null, null));

            // special case in case there is only one character with a nonzero frequency
            if (pq.size() == 1) {
               if (frequency['\0'] == 0) 
                   pq.insert(new Node('\0', 0, null, null));
               else                 
                   pq.insert(new Node('\1', 0, null, null));
            }

            // merge two smallest trees
            while (pq.size() > 1) {
                Node left  = pq.delMin();
                Node right = pq.delMin();
                Node parent = new Node('\0', left.frequency + right.frequency, left, right);
                pq.insert(parent);
            }
            return pq.delMin();
        }

               private static void buildCode(String[] st, Node x, String s) {
            if (!x.isLeaf()) {
                buildCode(st, x.left,  s + '0');
                buildCode(st, x.right, s + '1');
            }
            else {
                st[x.ch] = s;
            }
    }
    }
    
    
}
