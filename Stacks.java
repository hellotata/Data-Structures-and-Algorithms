import java.util.Arrays;

public class Stacks {
	String[] theStack;
    
    	// A value of -1 indicates that the stack is empty.
	int topOfStack = -1;
	int arraySize;

	public Stacks(int arraySize) {
		this.arraySize = arraySize;
		this.theStack = new String[arraySize];
        
        	// Fills the empty array with "X". "X" indicates an empty index in the array.
		Arrays.fill(theStack, "X");

	}
    
    	// Push new strings into the array
	public void push(String theStringToPush) {
        	// Indicates that the array is empty
		if(this.arraySize <= 0) {
			System.out.println("The array is empty.");
			return;
		}
		
        	// Checks to see if there is enough room in the array to push a new string
		if(topOfStack + 1 < arraySize) {
            		// Increment topOfStack so that the index will be able to search for the new string in the right index
			topOfStack++;
            
			theStack[topOfStack] = theStringToPush;
			System.out.println(theStringToPush + " was added to the stack.");
		} else {
			System.out.println("The array is full.");
		}
	}
	
    	// Pops off the first item in the array (Last In First Out)
	public void pop() {
		if(topOfStack <= -1) {
			System.out.println("The stack is empty.");
		} else {
            		// Set the value of the stack to "X" to show that it is now empty
			this.theStack[topOfStack] = "X";
            		// Decrement topOfStack
			topOfStack--;
		}
	}
	
    	// Peeks at the item on the top of the Stack
	public String peek() {
		String peek = theStack[topOfStack];
		System.out.println(peek);
		return peek;
	}

    // Prints the array
    public void print() {
		System.out.print("[" );
		for (int i = 0; i < theStack.length; i++) {
			if (i == theStack.length - 1) {
				System.out.print(theStack[i] + "]");
			} else {
				System.out.print(theStack[i] + ", ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Stacks stacks = new Stacks(10);

		stacks.print();
		
		stacks.push("10");
		stacks.print();
		stacks.push("99");
		stacks.print();
		
		stacks.peek();
		stacks.print();
		stacks.pop();
		
		stacks.print();
		
		stacks.push("100");
		
		stacks.peek();
		stacks.print();
		
	}

}
