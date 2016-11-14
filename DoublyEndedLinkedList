
public class DoubleLinkedList {
	
	Link firstLink;
	Link lastLink;
	
	DoubleLinkedList() {
		this.firstLink = null;
		this.lastLink = null;
	}
	
	// Checks to see if the DoubleLinkedLIst is empty.
	public boolean isEmpty() {
		return(firstLink == null);
	}
	
	// Insert new link into the first position.
	public void insertInFirstPosition(String name, int key) {
		Link newLink = new Link(name, key);
		
		if(isEmpty()) {
			
			lastLink = newLink;
			
		} else {
			
			// Set the firstLink's previous to the new link. 
			firstLink.previous = newLink;
			
		}
		
		// Set the previous's first link to the new Link's next.
		newLink.next = firstLink;
		
		// Set the firstLink to the new link.
		firstLink = newLink;
		
	}
	
	// Insert new link into the last position.
	public void insertInLastPosition(String name, int key) {
		Link newLink = new Link(name, key);
		
		if(isEmpty()) {
			
			firstLink = newLink;
			
		} else {
			
			// Set the lastLink's next to the new link. This will connect the new link
			// to the DoublyLinkedList.
			lastLink.next = newLink;
			
			// Set the new link's previous to the last link.
			newLink.previous = lastLink;
			
		}
		
		// Set the lastLink to the new link.
		lastLink = newLink;
		
	}
	
	// Inserts a new Link after a given key.
	public boolean insertAfterKey(String name, int key, int afterThisKey) {
		Link newLink = new Link(name, key);
		
		// Start searching from the firstLink.
		Link currentLink = firstLink;
		
		// Keep searching the DoubleLinkedList until you have a match.
		while(currentLink.key != afterThisKey) {
			// This will iterate through the DoubleLinkedList
			currentLink = currentLink.next;
			
			// If the currentLink is null, there is no match for the afterThisKey. Return false.
			if(currentLink == null) {
				
				return false;
				
			}
		}
		
		// If we reached here, then there was a match for afterThisKey.
		
		// If the currentLink is lastLink, set the lastLink to newLink.
		if(currentLink == lastLink) {
			
			newLink.next = null;
			lastLink = newLink;
			
		} else {
			
			// If currentLink is not lastLink, set the new link's next to the current link's next
			// This will connect the newLink with link after the currentLink.
			newLink.next = currentLink.next;
			
			// Set the currentLink.next's previous to the new Link. This will ensure that
			// it is still a DoublyLinkedList
			currentLink.next.previous = newLink;
			
		}
		
		newLink.previous = currentLink;
		currentLink.next = newLink;
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		
		doubleLinkedList.insertInFirstPosition("Richard", 23);
		
		doubleLinkedList.insertInFirstPosition("Rocco", 1);
		
		doubleLinkedList.insertInFirstPosition("Nancy", 5);
		
		doubleLinkedList.insertInLastPosition("Nanette", 15);
		
		doubleLinkedList.insertInLastPosition("Cristina", 25);
		
		doubleLinkedList.insertAfterKey("Mom", 4, 1);
		
		doubleLinkedList.printList();
		
	}
	
	// Print the DoublyLinkedList.
	public void printList() {
		
		Link currentLink = firstLink;
		while(currentLink != null) {
			System.out.println(currentLink);
			currentLink = currentLink.next;
		}
	}

}

class Link {
	
	public int key;
	public String name;
	
	public Link next;
	public Link previous;
	
	public Link(String name, int key) {
		this.key = key;
		this.name = name;
	}
	
	public String toString() {
		return this.name + " " + this.key;
	}
	
}
