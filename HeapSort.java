import java.util.Arrays;

public class Heap {
	int maxSize;
	Node1[] heapArray;
	int itemsInArray = 0;
	
	Heap(int maxSize) {
		this.maxSize = maxSize;
		this.heapArray = new Node1[maxSize];
	}
	
	// Insert what was popped off (highest value) into the array
	public void insert(int index, Node1 node) {
		
		heapArray[index] = node;
		
	}

	// Pops off the highest value, which is the root. Replaces with the last item in the tree
	// Heap the tree so that children values are always less than or equal to parent values
	public Node1 pop() {
		Node1 root = heapArray[0];

		heapArray[0] = heapArray[--itemsInArray];

		heapTheArray(0);

		return root;

	}

	// Heaps the array at a specific index. Usually starts at the root.
	public void heapTheArray(int index) {
		Node1 root = heapArray[index];
		int largestIndex;
		
		while(index < itemsInArray / 2) {
			
			// This formula tells you the index of the leftChild
			int leftChild = index * 2 + 1;
			// This formula tells you the index of the rightChild
			int rightChild = leftChild + 1;
			
			// Find the child with the largest value and set the index to largestIndex
			if(rightChild < itemsInArray && heapArray[rightChild].data > heapArray[leftChild].data) {
			
				largestIndex = rightChild;
			
			} else {
			
				largestIndex = leftChild;
			
			}
			
			// If the root is a larger value, then break because we don't need to switch anything
			if(root.data >= heapArray[largestIndex].data) {
				break;
			}
			
			heapArray[index] = heapArray[largestIndex];
			
			// Set the index to largestIndex
			index = largestIndex;
			
		}
	
		// If we reach here, we have found the new index/location for the root value
		heapArray[index] = root;
		
	}
	
	// Generates an array with random numbers
	public void generateFilledArray(int randNum) {

		Node1 randomData;

		for (int i = 0; i < this.maxSize; i++) {

			randomData = new Node1((int) (Math.random() * randNum) + 1);

			this.insert(i, randomData);

			// Separate increment function because when we sort, we need to insert
			// without incrementing the array
			incrementTheArray();

		}

	}
	
	// Increments the number of items in the array
	public void incrementTheArray() {
		itemsInArray++;
	}
	
	// Use HeapSort to sort the array
	public void heapSort() {
		
		while(itemsInArray != 0) {
			
			Node1 node = pop();
			
			insert(itemsInArray, node);
			
		}
		
	}

	public static void main(String[] args) {

		Heap heap = new Heap(7);
		
		heap.generateFilledArray(99);
		
		System.out.println(Arrays.toString(heap.heapArray));
		
		// We do not need to heap the last row of items in the binary tree
		for(int i = heap.maxSize / 2 - 1; i >= 0; i--) {
			
			heap.heapTheArray(i);
			
		}
		
		System.out.println(Arrays.toString(heap.heapArray));		
		
		heap.heapSort();
		
		System.out.println(Arrays.toString(heap.heapArray));
		
		
	}
}

class Node1 {
	int data;

	public Node1(int data) {
		this.data = data;
	}

	public String toString() {
		return this.data + "";
	}

}
