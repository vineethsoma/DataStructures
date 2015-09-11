
/**
 *
 * @author vineethsoma
 */
public class HeapSort {
    
    public static int [] A = { 6, 10, 1, 8, 7, 9, 3, 2, 4, 11 } ; 
    private static int N= 10;
    
    public static void main(String[] args) 
    {   
        long startTime, endTime ;
        double elapsedTime ; 
        startTime = System.nanoTime() ; 
        printArray(A) ;
        sort(A) ; 
        endTime = System.nanoTime() ; 
        
        elapsedTime = endTime - startTime ;  
        
        System.out.println("Total time to sort: "+ elapsedTime / 1000000 + " ms");
    }

    public static void sort(int A[])
    {       
        heapify(A);        
        for (int i = N; i > 0; i--)
        {
            swap(A,0, i);
            N = N-1;
            maxheap(A, 0);
            
           
            
        }
    }     
   
    public static void heapify(int A[])
    {
        N = A.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(A, i);        
    }
         
    public static void maxheap(int A[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && A[left] > A[i])
            max = left;
        if (right <= N && A[right] > A[max])        
            max = right;
 
        if (max != i)
        {
            swap(A, i, max);
            maxheap(A, max);
        }
    }    

    public static void swap(int A[], int i, int j)
    {   
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp; 
        printArray(A) ;
    }  
    public static void printArray(int [] A){
        
        for (int i = 0; i < 10; i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
}
