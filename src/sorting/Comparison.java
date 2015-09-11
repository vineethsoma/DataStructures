/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vineethsoma
 */

public class Comparison {
    
    public static void main (String args[]) throws Exception{
        
        Comparison c = new Comparison() ; 
        
        c.compareRuntime(10) ; 
        c.compareRuntime(100) ; 
        c.compareRuntime(1000) ; 
        c.compareRuntime(10000) ;
        c.compareRuntime(100000) ; 
  
       
    }
    
    void compareRuntime(int n){
        
        int [] randomArray ; 
        int [] randomArray1 = new int[n] ;
    
        randomArray = generateRandomArray(n) ; 
         for(int i=0 ; i < n ; i++ ) {
        
           randomArray1 [i] = randomArray[i] ; 
        }
        insertionSort(randomArray) ; 
        mergeSort( randomArray1) ; 
        
    }
    
    int [] generateRandomArray(int n){
        
     int [] randomArray =  new int[n]; 
        
        for( int i  =0 ; i < n ; i++){
            
            randomArray[i] =  0 + (int)(Math.random()*n);
            
        }
        return randomArray    ;    
    }
    void insertionSort(int [] randomArray){
        
        double runtime = 0  ; 
        double startTime = System.nanoTime(); 
        
        for(int i=1; i<randomArray.length; i++ ){
            
            int key = randomArray[i] ; 
            int j = i-1 ; 
            
            while ( j>=0 && randomArray[j] > key){
                
                randomArray[j+1] = randomArray[j] ; 
                j-- ; 
            }
            
            randomArray[j+1] = key ; 
            
        }
        
        double stopTime = System.nanoTime() ; 
        
        runtime = stopTime - startTime ;  
        
        System.out.println(" The runtime for Insertion Sort for "+ randomArray.length +" elements is "+ runtime);
    }
    
    void mergeSort( int [] randomArray){
        
        double runtime = 0 ; 
        double startTime = System.nanoTime() ; 
        
        
        
        mergeSort1(  randomArray) ; 
        
        
       double stopTime = System.nanoTime()  ; 
        
        runtime = stopTime - startTime ;  
        
        System.out.println(" The runtime for Merge Sort for "+ randomArray.length +" elements is "+ runtime); 
        System.out.println(" "); 
        
    }
    
    int [] mergeSort1( int [] randomArray){
        
        
        if ( randomArray.length <=1 ){
            
            return randomArray ; 
            
        }
        int midpoint = randomArray.length/2  ; 
        int [] left = new int [midpoint] ; 
        int [] right ; 
        
        if(randomArray.length % 2 == 0){
            
            right = new int [midpoint] ; 
        }
        else
        {
            right = new int [midpoint+1 ] ; 
            
        }
        
        int [] result = new int [randomArray.length] ;
        
        for(int i=0 ; i < midpoint ; i++ ) {
        
            left [i] = randomArray[i] ; 
        }
        
        int x = 0 ; 
        for(int j=midpoint ; j < randomArray.length ; j++ ) {
            if( x < right.length){
                right [x] = randomArray[j] ;
                x++ ; 
            }
        }
        
        left = mergeSort1(left) ;
        
        right = mergeSort1(right) ; 
        
        result = merge(left,right)  ; 
        
        return result ; 
    }
    
    int [] merge (int [] left , int [] right){
        
        int lengthResult = left.length + right.length ; 
        int [] result = new int [lengthResult] ; 
        int indexL = 0 ; 
        int indexR= 0 ; 
        int indexRes = 0 ; 
        
        while ( indexL < left.length || indexR < right.length){
        
            if(indexL < left.length && indexR <right.length){
                
                
                if ( left[indexL] <= right[indexR]){

                        result [indexRes] = left[indexL] ; 
                        indexL++;
                        indexRes++ ; 
                }
                else{
                    result [indexRes] = right[indexR] ; 
                    indexR++;
                    indexRes++ ; 
                }   
            }
            else if ( indexL < left.length){
                result [indexRes] = left[indexL] ; 
                indexL++;
                indexRes++ ; 
            }
            else if ( indexR < right.length){
                result [indexRes] = right[indexR] ; 
                indexR++;
                indexRes++ ; 
            }
            
            
    }
        return result ; 
    }
    
    
    
    
}
