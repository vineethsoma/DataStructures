
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vineethsoma
 */
public class ShortestPath {
    
    int distanceMatrix[][] ; 
    vertex vertexArray[] ; 
    class vertex {
        public boolean known; // the known column
        public int distance; // the dv column
        public int previousVertex; // the pv column
    }
    
    void acceptDistanceMatrixData(String file) throws FileNotFoundException{
    	
		
        FileInputStream fstream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fstream);
       
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
			
            while ((line = reader.readLine()) != null) {
		    	
                System.out.println(line);
		        
                intitializeDistanceMatrix( line ) ; 
            }
        } 
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }	
		
    }
        
    
     void intitializeDistanceMatrix(String line){
         
         if ( line != null ){
			
           String[] intsToParse = line.split(" "); 
           int[] info = new int[intsToParse.length];
           // Now just parse each part in turn
            for (int i = 0; i < info.length; i++)
            {
                info[i] = Integer.parseInt(intsToParse[i]);
            }
            distanceMatrix[info[0]][info[1]] = info[2] ;  
        }
	    
    }
     
     
     void initializeVertexArray(){
        vertexArray[0] = new vertex() ; 
        vertexArray[0].known = false ; 
        vertexArray[0].distance = 0 ; 
        vertexArray[0].previousVertex = 0 ; 
         
        for( int i = 1 ; i <48 ; i++){
            vertexArray[i] = new vertex() ; 
            vertexArray[i].known = false ; 
            vertexArray[i].distance = 9999 ; 
            vertexArray[i].previousVertex = 0 ;  
         }
         
         
     }
 
     void dijkstraAlgorithm(  ){
        
         initializeVertexArray() ; 
         int k =0 ; 
         while( !(vertexArray[k].known)){
             
             vertex v = vertexArray[k] ; 
             
             for(int i = 0 ; i < 48 ; i++)
                 for( int j= 0 ; j< 48 ; j++ )
                     if( distanceMatrix[i][j] != 0 )
                     {
                         
                     }
                         
                         
             /* 
            v = a vertex in toBeChecked with minimal currDist(v);
            remove v from toBeChecked;
            for all vertices u adjacent to v and in toBeChecked
                if currDist(u) > currDist(v) + weight(edge(vu))
                    currDist(u) = currDist(v) + weight(edge(vu))
                    predecessor(u) = v;
             */
        }
         //need to complete the algortihm 
         
     }
     
     void printShortestDistances(){
         
        for (int i=0 ;  i<48 ; i++){
            System.out.println( "The shortest distance between state[0] and state[" +i+ "] is: " + vertexArray[i].distance);
        }
         
         
         
     }
     
    public static void main(String[] args) throws FileNotFoundException{
       
        ShortestPath s = new ShortestPath() ; 
        String filepath = "build/datavalues.txt" ; 
        s.acceptDistanceMatrixData(filepath) ; 
        s.dijkstraAlgorithm() ;
        s.printShortestDistances() ; 
        
    }
}
