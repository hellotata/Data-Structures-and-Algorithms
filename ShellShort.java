
public class ShellSort {
	int[] theArray;
	
	public ShellSort(int[] theArray) {
		this.theArray = theArray;
	}
	
	public void sort() {
        
		int inner, outer, temp;
		
		int interval = 1;
		
        // Here we define the interval
		while(interval <= theArray.length / 3) {
			interval = interval * 3 + 1;
		}
		
        // If interval is less than 0, we break out of the sort
		while(interval > 0) {
			   
            // We set the outer to interval because it is where we will beging our sort, and then
            // we interate from the outer index all the way to the end of the array
			for(outer = interval; outer < this.theArray.length; outer++) {
				
                // Set the outer index value to temp so that we can insert into the array when we find appropriate location
				temp = theArray[outer];
				
				inner = outer;
				
                // If the inner is greater than interval - 1, there is no more number in the front of the array to compare
                // We then compare the temp with the values before the temp that falls in the interval constraint
				while(inner > interval - 1 && theArray[inner - interval] >= temp) {
					
                    // Move the values up the interal array until we find an approriate index to insert temp
					theArray[inner] = theArray[inner - interval];
					
                    // decrement inner each time so that we can move up the array to compare values
					inner -= interval;
					
				}
				
                // Once we reach here, we have found the location to insert the temp. The value before this inner index
                // is smaller than the temp
				theArray[inner] = temp;
				
			}
			
            // Decrement the interval and go again
			interval = (interval - 1) / 3;
			
		}
		
	}
	
    // Prints the array
	public void print() {
		for(int i = 0; i < theArray.length; i++) {
			if(i == this.theArray.length - 1) {
				System.out.print(theArray[i]);
			} else {
				System.out.print(theArray[i] + ", ");
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int[] theArray = {2, 21, 13, 40, 33, 32, 39, 42, 53, 21};
		
		ShellSort shellSort = new ShellSort(theArray);
		
		shellSort.print();
		
		shellSort.sort();
		
		shellSort.print();
		
	}

}
