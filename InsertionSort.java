
public class InsertionSort {
	int[] theArray;

	public InsertionSort(int[] theArray) {
		this.theArray = theArray;
	}
	
    // Sort the array using Insertion Sort
	public void sort() {
		
		for(int i = 1; i < theArray.length; i++) {
			
            // This is the number we are using to compare with other numbers in prior indexes. 
			int toInsert = theArray[i];
			
			int j = i;
			
            // j > 0 ensures that we break out of the while loop if we reach the front of the array
            // theArray[j-1] ensures that we are comparing the value of the index prior to the toInsert index
			while(j > 0 && theArray[j-1] > toInsert) {
				
                // If the prior index value is greater, change the value and continue comparing until we find
                // the desired index for the toInsert value
				theArray[j] = theArray[j-1];
				j--;
				
			}
			
            // Once we break out of the while loop, it is beause we have found the index to insert the toInsert value
			theArray[j] = toInsert;
			
		}
		
	}
	
    // Print the array
	public void print() {
		for(int i = 0; i < theArray.length; i++) {
			if(i == theArray.length - 1) {
				System.out.print(theArray[i]);
			} else {
				System.out.print(theArray[i] + ", ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] theArray = {2, 55, 23, 34, 16, 5, 43, 9};
		
		InsertionSort insertionSort = new InsertionSort(theArray);
		
		insertionSort.print();
		
		insertionSort.sort();
		
		insertionSort.print();
	}

}
