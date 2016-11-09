public class QuickSort {
	int[] theArray;

	public static void main(String[] args) {
		int[] theArray = {7, 2, 1, 9, 11, 23, 100, 15, 54, 33, 9};
		QuickSort quickSort = new QuickSort(theArray);

		quickSort.print();
		
		quickSort.sort(0, 10);
		
		quickSort.print();
		
	}
	
	public QuickSort(int[] theArray) {
		this.theArray = theArray;
	}
	
    	// Use QuickSort to sort the sample array
	public void sort(int left, int right) {
        	// This is the condition to stop the recursion. There are no more numbers to partition when this is true.
		if(right - left <= 0) {
			return;
		}
		
        	// The pivot will be the rightmost value in the array and also the partitioned array.
		int pivot = theArray[right];
		
        	// Partition the array with the rightmost value as the pivot.
		int partitionArray = partitionArray(left, right, pivot);
		
        	// Sort the left side of the partitioned array.
		sort(left, partitionArray - 1);
        
        	// Sort the right side of the partitioned array.
		sort(partitionArray + 1, right);
		
	}
    
    	// This function will partition the array.
	public int partitionArray(int left, int right, int pivot) {
    
        	// We start with a leftpointer of -1 because the while loop below increments to include 0 index
		int leftPointer = left - 1;
		int rightPointer = right;


		while (true) {
        
           	 	// Find the leftPointer index of the array where the value is less than the pivot.
            		// Break out of this if we reach the end of the array.
			while (leftPointer < right && theArray[++leftPointer] < pivot)
				;

            		// Find the rightPointer index of the array where the value is greater than the pivot.
			while (rightPointer > left && theArray[--rightPointer] > pivot)
				;
				
            		// This condition will break out of the while loop. It means the array is partioned, but we still have
            		// to swap the value of the right index with the value of the leftPointer.
			if(leftPointer >= rightPointer) {
				
				break;
			
            
			} else {
				
                		// Swap value of leftPointer and rightPointer once we found their values from the while loop.
				swapValues(leftPointer, rightPointer);
				
			}
		}
		
        	// This is the last step to partition the array. Swap the value of the leftPointer index with the value of
        	// the right index (which is the pivot).
		swapValues(leftPointer, right);
		
		return leftPointer;
	}
	
    	// Swaps the value of the array in the leftPointer index and the rightPointer index.
	public void swapValues(int leftPointer, int rightPointer) {
		int temp = theArray[leftPointer];
		theArray[leftPointer] = theArray[rightPointer];
		theArray[rightPointer] = temp;
	}
	
    	// Prints the array.
	public void print() {
		for(int i = 0; i < this.theArray.length; i++) {
			if(i == this.theArray.length - 1) {
				System.out.print(this.theArray[i]);
			} else {
				System.out.print(this.theArray[i] + ", ");
			}
		}
		System.out.println();
	}

}
