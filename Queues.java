import java.util.Arrays;

public class Queues {
	int arraySize;
	String[] theQueue;
	int numberOfItems, front, rear = 0;

	public Queues(int arraySize) {
		this.arraySize = arraySize;
		theQueue = new String[arraySize];
    
        // Fill the array with "X" to indicate that it is empty.
		Arrays.fill(theQueue, "X");
	}

    // Insert another string into the array
	public void insert(String input) {
        
        // Check to see whether or not the array is full.
		if (numberOfItems + 1 <= this.arraySize) {
            // If the array is not full, insert the item into the array.
			theQueue[rear] = input;
            
            // Increment the number of items
			numberOfItems++;

            // Increment rear because it gives us the index of the item at the end of the Array
			rear++;
		} else {
			System.out.println("The queue is full.");
		}

	}
    
    // Insert items into the array from highest to lowest.
	public void priorityInsert(String input) {

		int i;
		
		if (numberOfItems == 0) {
			insert(input);
			
		} else {
			if (numberOfItems + 1 <= arraySize) {
				for (i = numberOfItems - 1; i >= 0; i--) {
                    // If the input is greater than the array at i, we shift the array until we find a spot
                    // to insert the desired input
					if (Integer.parseInt(input) > Integer.parseInt(theQueue[i])) {
						theQueue[i + 1] = theQueue[i];
					} else {
						break;
					}
				}
                
                // Once we are out of the for loop, it means we found the place to insert.
				theQueue[i + 1] = input;
				rear++;
				numberOfItems++;
			} else {
				System.out.println("The queue is full.");
			}

		}

	}
    
    // Removes an item from the array. Queues use FIFO (First in first out).
	public void remove() {
		if (numberOfItems <= 0) {
			System.out.println("The queue is empty.");
		} else {
            // Set the item we want to remove to "X" to indicate an empty item in the array
			theQueue[front] = "X";
            // Increment front
			front++;
			numberOfItems--;
		}
	}
    
    // Peek at the item at the top of the array
	public String peek() {
		String peek = theQueue[front];
		System.out.println(peek);
		return peek;
	}
    
    // Print the array
	public void print() {
		System.out.print("[ ");
		for (int i = 0; i < theQueue.length; i++) {
			if (i == theQueue.length - 1) {
				System.out.print(theQueue[i] + " ]");
			} else {
				System.out.print(theQueue[i] + ", ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queues queues = new Queues(10);
		// queues.print();
		// queues.insert("10");
		// queues.insert("20");
		// queues.print();
		// queues.peek();
		// queues.print();
		// queues.remove();
		// queues.print();

		queues.priorityInsert("15");
		queues.priorityInsert("15");
		queues.priorityInsert("20");
		queues.print();
		queues.insert("10");
		queues.print();
		queues.insert("99");
		queues.print();
		queues.remove();
		queues.print();
		
	}

}
