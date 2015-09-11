package trieStructure;

import java.util.* ;


class Node {
    boolean terminal;
    int outDegree;
    Node Node[] ; 
}
public class Trie {
    private Node root ;
    public Trie(){
        root = new Node() ;
        root.Node = new Node[10] ;
    }
    boolean insert(String s){
        int length = s.length() ;
        boolean status = false ;
        Node current = root ;
        int key ;
        if( length >= 31)
            status = false ;
        else if( length <= 0)
            status = false ; 
        else
            for( int i=0; i<length ; i++){
                key = Character.getNumericValue(s.charAt(i)) ;
               
              if( current.Node[key] == null ){
                    
                    current.Node[key] = new Node();
                   
                    current = current.Node[key] ;
                    current.Node = new Node[10] ;
                    
                    if( i == length - 1 ){
                        current.terminal = true ; 
                        status = true ;
                    }
                }
            else {
                    if(current.terminal == false && !(i == length - 1))
                        current = current.Node[key] ;
                    else if( i == length - 1 ){
                        current.terminal = true ; 
                        status = true ;
                    }
                    else
                        status = false ;
                }
            } 
        return status  ;
    }
    
   boolean isPresent( String s){
        int length = s.length() ;
        boolean status = false  ;
        Node current = root ;
        int key ; 
        
        if( length >= 31)
            status = false ;
        else if( length <= 0)
            status = false ; 
        
        else
        for( int i=0; i<length ; i++){
            key = Character.getNumericValue(s.charAt(i)) ;
            if( current.Node[key] == null ){
                status= false ;  
            }
            else {
               
                if(current.Node[key].terminal == false)
                    current = current.Node[key] ;
                else
                status = true;
            }
        } 
        return status ;  
    }
   
    boolean delete ( String s){
        int length = s.length() ;
        boolean status = false  ;
        Node current = root ;
        int key ; 
        
        if( length >= 31)
            status = false ;
        else if( length <= 0)
            status = false ; 
        
        else if( isPresent(s) ){

            for( int i=0; i<length ; i++){
                key = Character.getNumericValue(s.charAt(i)) ;
                
                   if( current.Node[key] == null ){
                       status = true ;
                   }
                   else if( current.Node[key].outDegree > 0 ){
                       if(current.Node[key].terminal && (key == length)){
                           current.Node[key].terminal = false ; 
                           status = true ;
                        }
                       else{ 
                           
                        current = current.Node[key] ; 
                        
                    } 
                   }
                   else if(current.Node[key].outDegree == 0){
                       
                        current.Node[key] = null ;
                        status = true ; 
                    }
                    
            }  
                
        }         
        return status ;
            } 
        
   
    
    int membership(){
        
        Node current = root ;
        int total =  membership( current ) ; 
         return total ; 
    }
        
    int membership(Node n ){
 
                int total = 0 ;
                for(int i = 0 ; i<10 ; i++){
 
 
                        if(n.Node[i] != null)
                                total +=   (n.Node[i].terminal ? 1 : 0) + membership( n.Node[i] );
 
 
                }
                return total ;
    }
    
    void listAll(){
        Node n= root ; 
        
        listAll(n); 
     
    }
    void listAll(Node n){
        
        for(int i = 0 ; i<10 ; i++){
            if(n.Node[i]!=null){
                
                System.out.print(i) ;
                
                listAll(n.Node[i]); 
                if(n.Node[i].terminal)
                    System.out.println();
                }
           
        } 
                  

        
    }

    
    public static void main( String [ ] args ){
        
    
        Trie tre = new Trie();
        Scanner in = new Scanner(System.in);
        boolean notDone = true;
        
        while(notDone) { // read commands and obey them
            
        
            String command = in.next();
            char com = command.charAt(0);
            switch(com) {
                
            case 'N': {
            System.out.println("Vineeth Soma");
            break;
            }
                
            case 'A': { // insert
            String toAdd = in.next();
            
                if(tre.insert(toAdd)) {
                    System.out.println("Key " + toAdd + " inserted");
            
                }
                else
                    System.out.println("Key " + toAdd + " already exists");
                break;
            }
            case 'D': {
                    String toAdd = in.next();
                   if(tre.delete(toAdd)) {
                       System.out.println("Key " + toAdd + " deleted");
                   }
                else
                       System.out.println("Key " + toAdd + " not found");
                   break;
            }
            case 'S': {
                   String toAdd = in.next();
                   if(tre.isPresent(toAdd)) {
                       System.out.println("Key " + toAdd + " found");
                   }
                else
                       System.out.println("Key " + toAdd + " not found");
                   break;
            }
            case 'E': {
                    notDone = false  ; 
                    break;
            }
            case 'M': {
                  
                   System.out.println("Membership is " + tre.membership());
                   break;
            }
            case 'L': {
                  
                   tre.listAll();
                   break;
            }
                 case 'C': {
                     
                   break;
            }
            }
            
        }
        
        
    }
    
    
    
}
            
            
            
    
