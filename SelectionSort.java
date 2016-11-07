
public class SelectionSort {
	int[] theArray;
	
	SelectionSort(int[] theArray) {
		this.theArray = theArray; 
	}
	
    // search for the smallest number in the array and place in minimum index
    // repeat and search through the rest of the entire array each time
	public void sort() {
		
		for(int i = 0; i < theArray.length; i++) {
			
			int minimum = i;
			
			for(int j = i; j < theArray.length; j++) {
				if(theArray[j] < theArray[minimum]) {
					minimum = j;
				}
			}

		swapValues(i, minimum);
        
		}
	}
	
    // swap the value of index i with index j
	public void swapValues(int i, int j) {
		int temp = theArray[i];
		theArray[i] = theArray[j];
		theArray[j] = temp;
	}
	
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
		int[] theArray = {2, 5, 22, 16, 18, 45, 54, 32, 1};
		SelectionSort selectionSort = new SelectionSort(theArray);
		
		selectionSort.print();
		
		selectionSort.sort();
		
		selectionSort.print();
		
		
	}

}
