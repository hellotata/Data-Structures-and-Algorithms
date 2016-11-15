public class BinaryTree {
	Node root;

	// Adds a new node to the binaryTree
	public void addNode(int data) {
		Node newNode = new Node(data);
		
		// Make the root the newNode if the root is null
		if (root == null) {

			root = newNode;

		} else {
			
			Node focusNode = root;
			Node parent;

			while (true) {

				parent = focusNode;

				// If data is less than focusNode, go down the left side of the tree.
				if (data < focusNode.data) {

					focusNode = focusNode.leftChild;

					// Insert the new node once we find the bottom of the tree (where the focusNode is null)
					if (focusNode == null) {

						parent.leftChild = newNode;
						return;
					}

				// If data is more than focusNode, go down the right side of the tree.
				} else {

					focusNode = focusNode.rightChild;

					if (focusNode == null) {

						parent.rightChild = newNode;
						return;
					}
				}

			}
		}
	}
	
	// Prints in order. Begins at leftmost node and ends at right most node.
	public void inOrderTraverseTree(Node node) {

		if (node != null) {

			inOrderTraverseTree(node.leftChild);

			System.out.println(node);

			inOrderTraverseTree(node.rightChild);

		}

	}
	
	
	// Begins at the root and ends at the right most node.
	public void preOrderTraverseTree(Node node) {

		if (node != null) {

			System.out.println(node);

			inOrderTraverseTree(node.leftChild);

			inOrderTraverseTree(node.rightChild);

		}
	}

	// Begins at left most node and ends at the root.
	public void postOrderTraversalTree(Node node) {

		if (node != null) {

			inOrderTraverseTree(node.leftChild);

			inOrderTraverseTree(node.rightChild);

			System.out.println(node);

		}
	}

	// Finds a node in the binary tree with the given parameters
	public Node findNode(int data) {

		Node node = root;
		
		// Continue to traverse through the node until we find a match.
		while (data != node.data) {

			if (data < node.data) {
				node = node.leftChild;
			} else {
				node = node.rightChild;
			}

			// If no match, return null.
			if (node == null) {
				return null;
			}

		}

		return node;
	}

	// Removes a node from the binary tree.
	public boolean remove(int data) {
		Node focusNode = root;
		Node parent = root;

		// Boolean to determine if the node to remove is a left child or right child.
		boolean isALeftChild = true;

		// If the root is null, return false so that we don't go through the entire function.
		if (focusNode == null) {

			return false;

		} else {

			// Traverse through the binary tree to find the node to delete.
			while (focusNode.data != data) {
				parent = focusNode;

				if (data < focusNode.data) {

					focusNode = focusNode.leftChild;
					isALeftChild = true;

				} else {

					focusNode = focusNode.rightChild;
					isALeftChild = false;

				}
				
				// If focusNode is null, we were not able to find the node to delete.
				if (focusNode == null) {
					return false;
				}

			}

			// If we reached here, then we found a Node to delete.
			// There are three main scenarios to consider here.
			// 0 Child, 1 Child, and 2 Child
			
			// If the node has no child, then connect the parent to null.
			if (focusNode.rightChild == null && focusNode.leftChild == null) {
				if (focusNode == root) {
					root = null;
				}

				else if (isALeftChild) {
					parent.leftChild = null;
				} else {
					parent.rightChild = null;
				}

			// If the node has a right child, connect parent to the node's rightChild.
			} else if (focusNode.leftChild == null) {
				if (focusNode == root) {
					root = focusNode.rightChild;
				}

				else if (isALeftChild) {

					parent.leftChild = focusNode.rightChild;

				} else {

					parent.rightChild = focusNode.rightChild;

				}

			// If the node has a left child, connect parent to the node's leftChild.
			} else if (focusNode.rightChild == null) {
				if (focusNode == root) {

					root = focusNode.leftChild;

				}

				if (isALeftChild) {

					parent.leftChild = focusNode.leftChild;

				} else {

					parent.rightChild = focusNode.leftChild;

				}

			// When the node has both leftChild and rightChild, determine the node to replace the node.
			} else {

				// Use this function to find the replacement node.
				Node replacement = getReplacementNode(focusNode);

				if (focusNode == root) {
					root = replacement;
				}

				else if (isALeftChild) {

					parent.leftChild = replacement;

				} else {

					parent.rightChild = replacement;

				}
				
				// Set the replacement's leftChild to the focusNode's leftChild.
				// This is to connect whatever is on the leftChild of the node that is to be removed.
				replacement.leftChild = focusNode.leftChild;

			}

		}

		return true;

	}

	public Node getReplacementNode(Node replacedNode) {

		Node replacement = replacedNode;
		Node parent = replacedNode;
		Node focusNode = replacedNode.rightChild;

		// Find the lower amount in the replacedNode.rightChild subtree
		while (focusNode != null) {
			parent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;

		}

		// If replacement == replacedNode.rightChild, then replacedNode.rightChild was the lowest
		if (replacement != replacedNode.rightChild) {

			//  Connect the parent's left child with the replacement's right child. This will take out
			// the node that is to be replaced (so that there are no duplicates),
			parent.leftChild = replacement.rightChild;
			
			// Set the replacement's rightChild to the replacedNode's rightChild.
			// This will connect the entire right node together with replacement at the "root."
			replacement.rightChild = replacedNode.rightChild;
		}

		return replacement;
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		binaryTree.addNode(10);
		binaryTree.addNode(20);
		binaryTree.addNode(30);
		binaryTree.addNode(40);
		binaryTree.addNode(15);

		binaryTree.inOrderTraverseTree(binaryTree.root);

		binaryTree.remove(20);

		System.out.println();

		binaryTree.inOrderTraverseTree(binaryTree.root);

	}

}


// Node object with data, leftChild, and rightChild
class Node {
	public int data;
	public Node rightChild;
	public Node leftChild;

	public Node(int data) {
		this.data = data;
	}

	public String toString() {
		return this.data + "";
	}
}
