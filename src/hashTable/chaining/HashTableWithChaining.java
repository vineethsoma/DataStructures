/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

/**
 *
 * @author vineethsoma
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List ; 
import java.util.LinkedList ; 
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import part1.HashTableWithOpenAddressing;

public class HashTableWithChaining<AnyType> {
    
    private List<AnyType> [ ] theLists;
    private int currentSize;
    private static final int DEFAULT_TABLE_SIZE  = 25 ; 
    
    HashTableWithChaining(){
        
        this( DEFAULT_TABLE_SIZE );
    }
    
    HashTableWithChaining(int size ){
        theLists = new LinkedList[ nextPrime( size ) ];
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ] = new LinkedList<>( );
        
    }
    
    public void insert(AnyType x){
    
        List<AnyType> whichList = theLists[ myhash( x ) ];

        if( !whichList.contains( x ) )

        {
	
            whichList.add( x );



            if( ++currentSize > theLists.length )
                rehash( );  
        }
        
    }
    
    public void remove(AnyType x){
    
        List<AnyType> whichList = theLists[ myhash( x ) ];
        if( whichList.contains( x ) )
        {
            whichList.remove( x );
            currentSize--;
        }
        
    }
    
    public boolean constains(AnyType x){
        
        List<AnyType> whichList = theLists[ myhash( x ) ];
        return whichList.contains( x ); 
    }
    
    public void makeEmpty(){
        
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ].clear( );
	currentSize = 0;
        
    }
    
    private void rehash( ) // didn't implement this part 
    { 
        
    }
    
    private int myhash( AnyType x )
    {
        int hashVal = x.hashCode( );

        hashVal %= theLists.length;
        if( hashVal < 0 )
            hashVal += theLists.length;

        return hashVal;
    }
    
    private static int nextPrime( int n ) // dind't implement this part 
    { 
        
        return 1 ; 
    }
    
    private static boolean isPrime( int n ) // didn't implement this part 
    { 
        
        return false ; 
    }
    
    public void print() //didn't implement
    {
        
        
    }
    
    public  void menuSystem() //need to put in specific functions call for the menu options 
        {
		
		
		
		boolean notDone = true  ; 
		Scanner in = new Scanner(System.in) ; 
		
		while(notDone) { //reads commands 
                System.out.println ( "") ;    
                System.out.println ( "\t \t Hash Mapping with Sepearte Chaining ") ;
		System.out.println ( "\t\t Please select from the following option: ") ;
		System.out.println ( "\t\t (d) display hash table ") ; 
		System.out.println ( "\t\t (r) rehash  ") ; 
		System.out.println ( "\t\t (!) To exit  ") ; 
		System.out.print( "Enter your option: ") ;
			String command = in.next() ; 
			char com = command.charAt(0) ; 
			switch(com){
			
			
			case 'd':{
				
			print() ; 	
				
				
				
				break ; 
			}
			
			case 'r':{
				
				
                            try {	
                                rehash();
                            } catch (Exception ex) {
                                Logger.getLogger(HashTableWithOpenAddressing.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				
				break ; 
			}

			case '!':{
				
				
				
				notDone = false ; 
				
				break ; 
			}
			default :{
				
			System.out.println ("Command not recognized please try again")	;
				
			}
			
			
			
                    }
			
                }
        }
    
    public static void main(String[] args) throws IOException {

		
		HashTableWithChaining<String> table = new HashTableWithChaining<>();
		
		String fileName = "src/patients.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String input = br.readLine();
	        
	        
	        while (input != null) {
	            String[] splited = input.split(","); 
	            String lastName = splited[0];
	            
	            try{
	            	table.insert(lastName);
	            }catch (Exception e){
	            	
	            }
	            input = br.readLine();
	        }
	      
	    } finally {
	        br.close();
	    }
	    
	    table.menuSystem(); 
		
	
	}
}
