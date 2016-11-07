public class LinkedList {
	public Link firstLink;

	public LinkedList() {
		this.firstLink = null;
	}

	public Link add(String data) {
		Link newLink = new Link(data);
		
		// set the newLink's next to firstLink
		newLink.next = firstLink;
		
		// firstLink is now the newLink. firstLink is always the newest in the list
		firstLink = newLink;

		return newLink;

	}

	// prints the entire LinkedList
	public void print() {
		// note here that we are making a new reference to firstLink, a non primitive object.
		// firstLink and currentLink points to the same object, but the pointer for currentLink
		// changes as we iterate through the LinkedList. (firstLink reference remains the same)
		Link currentLink = firstLink;

		while (currentLink != null) {
			System.out.println(currentLink);
			currentLink = currentLink.next;
		}
	}

	public boolean isEmpty() {
		// returns true if the linkedList is empty
		return (firstLink == null);
	}

	public Link search(String data) {
		// starts search from firstLink;
		Link currentLink = firstLink;

		if (!isEmpty()) {
			while (currentLink.data != data) {

				if (currentLink.next == null) {
					return null;
				} else {
					// if currentLink is not desired data, go down the linkedList
					currentLink = currentLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}

		return currentLink;

	}

	public Link removeFirst() {
		Link removedLink = firstLink;

		if (!isEmpty()) {
			firstLink = firstLink.next;
		} else {
			System.out.println("Empty LinkedList");
		}

		return removedLink;
	}

	public Link removeLink(String data) {
		
		// Two pointers. one iterates through the LinkedList ahead of the other. we need this 
		// so we can connect the link together after removing the desired link
		Link current = firstLink;
		Link previous = firstLink;

		if (!isEmpty()) {

			while (current.data != data) {

				if (current.next == null) {
					System.out.println("Cannot find " + data + " in LinkedList");
					return null;
				} else {
					previous = current;
					current = current.next;
				}
			}
			
			// if the link desired link to remove is firstLink, we can simply set firstLink to next
			if (current == firstLink) {
				firstLink = firstLink.next;
			} else {
				previous.next = current.next;
			}

		} else {
			System.out.println("Empty LinkedList");
			return null;
		}

		return current;

	}
	
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		linkedList.add("6");
		
		linkedList.removeFirst();
		
		linkedList.removeLink("3");
				
		linkedList.print();
		
	}
}

class Link {
	public Link next;
	public String data;
	
	// initialize new link with data
	Link(String data) {
		this.data = data;
	}
	
	public String toString() {
		return this.data;
	}
	
}
