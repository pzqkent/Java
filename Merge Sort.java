public class Solution {
	public int[] mergeSort(int[] array) {
	    // Write your solution here
	    if (array == null || array.length == 0 || array.length == 1)
	      return array;
	    //int left = 0;
	    //int right = array.length - 1;
	    //if (array.length == 2)
	      
	    int mid = 0 + (array.length - 1) / 2;
	  
	    int[] arrayLeft = new int[mid+1];
	    int[] arrayRight = new int[array.length - (mid+1)];
	    for (int i = 0; i < mid + 1; i++){
	      arrayLeft[i] = array[i];
	    }
	    for (int j = 0; j < array.length - (mid + 1); j ++) {
	      arrayRight[j] = array[mid + 1 + j];
	    }
	    if (array.length == 2) {
	      return merge(arrayLeft, arrayRight);
	    }else
	      return merge(mergeSort(arrayLeft),mergeSort(arrayRight));
	      
	    
	      
	    
	  }
		  public int[] merge(int[] arrayA, int [] arrayB){
			    if (arrayA == null || arrayA.length == 0)
			      return arrayB;
			    if (arrayB == null || arrayB.length == 0)
			      return arrayA;
			    int[] result = new int[arrayA.length + arrayB.length];
			    int A = 0, B = 0, i;
			   
			    for (i = 0; i < arrayA.length + arrayB.length; i++) {
			      if (A == arrayA.length) {
			        result[i] = arrayB[B];
			        B++;
			      }else if (B == arrayB.length) {
			        result[i] = arrayA[A];
			      	A++;
			      }else {
			        if (arrayA[A] <= arrayB[B]) {
			          result[i] = arrayA[A];
			          A++;
			        }else {
			          result[i] = arrayB[B];
			          B++;
			        } 
			      }
			    }
			    return result;
			        
			  }
  }


