
/**
 *
 * @author vineethsoma
 */
public class QuickSort {
    public static int [] A = { 6, 10, 1, 8, 7, 9, 3, 2, 4, 11 } ; 
    private static int N;
    
    public static void main(String[] args) 
    {   
        long startTime, endTime ;
        double elapsedTime ; 
        startTime = System.nanoTime() ; 
        sort(A) ; 
        endTime = System.nanoTime() ; 
        
        elapsedTime = endTime - startTime ;  
        
        System.out.println("Total time to sort: "+ elapsedTime / 1000000 + " ms");
    }
    
     public static void sort(int[] A) {

    
    N = A.length;
    quicksort(0, N - 1);
    
  }

  private static void quicksort(int low, int high) {
    int i = low, j = high;

    int pivot = A[low + (high-low)/2];
    

    while (i <= j) {
        
      while (A[i] < pivot) {
        i++;
      }
      
      while (A[j] > pivot) {
        j--;
      }


      if (i <= j) {
        swap(i, j);
        i++;
        j--;
      }
    }
    
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
    
    
  }

  private static void swap(int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
    printArray(A) ;
  }
  
      public static void printArray(int [] A){
        
        for (int i = 0; i < 10; i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
}
