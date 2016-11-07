
public class BubbleSort {
	int[] theArray;
	
	BubbleSort(int[] theArray) {
		this.theArray = theArray;
	}
	
  // perform the bubble sort on the array
	public int[] sort() {
		for(int i = 0; i < theArray.length - 1; i++) {
			for(int j = 0; j < theArray.length - 1 - i; j++) {
				if(theArray[j] > theArray[j+1]) {
					swapValues(j, j+1);
				}
			}
		}
		return theArray;
	}
	
  // swaps the value of the array at index i and index j
	public void swapValues(int i, int j) {
		int temp = theArray[i];
		theArray[i] = theArray[j];
		theArray[j] = temp;
	}
	
  // prints the array
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
  
		int[] theArray = {2, 53, 4, 5, 14, 32, 23, 55, 5};
		
		BubbleSort bubbleSort = new BubbleSort(theArray);
		
		bubbleSort.print();
		
		bubbleSort.sort();
		
		bubbleSort.print();
		
	}
	
}
