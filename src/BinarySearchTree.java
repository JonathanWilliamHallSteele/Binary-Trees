
/**
 * @author Malaka Walpola
 * @author Jonathan Steele jonwhsteele@gmail.com
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{

	BinTreeNode<E> parentNode;
	
	/**
	 * This method will return the node which contains value specified by value in the tree, if the value is present in the tree. If the value is not in the tree, it will return NULL.
	 * @param value - value to be searched.
	 * @return the node which contains value specified by value in the tree, if the value is present in the tree. If the value is not in the tree, it will return NULL.
	 */
	public BinTreeNode<E> search(E value) {
		return searchBST(this.getRoot(), value);
	}
	
	/**
	 * Recursive support method to implement search.
	 * @return the node that contains specified value if present. NULL otherwise.
	 */
	private BinTreeNode<E> searchBST (BinTreeNode<E> currRoot, E value){
		if(null == currRoot)
			return null;
		int comp = value.compareTo(currRoot.getValue());
		if(0 == comp) //Match found. Return the current answer.
			return currRoot;
		else if (comp < 0) //Value less than root. Search in the left sub-tree.
			return searchBST(currRoot.getLeft(), value);
		else //Value greater than root. Search in the right sub-tree.
			return searchBST(currRoot.getRight(), value);
	}

	/**
	 * This method will add the value specified by newValue to the tree, if the value is not present in the tree already.
	 * @param newValue - value to be added to the BST.
	 * @return Returns true if addition is successful and returns false in failure.
	 */
	public boolean insert (E newValue) {
		BinTreeNode<E> parent = null;
		BinTreeNode<E> curr = this.getRoot();
		
		while(curr != null) {
			parent = curr;
			int comp = newValue.compareTo(curr.getValue());
			if(0 == comp) //Value already present in the tree. Return false.
				return false;
			else if(comp < 0) //Value less than current value. Insert to left sub tree.
				curr = curr.getLeft();
			else //Value greater than current value. Insert to right sub tree.
				curr = curr.getRight();
		}
		
		if(null == parent) { //Tree is empty. Add value as root.
			this.setRoot(new BinTreeNode<E>(newValue));
			return true;
		}
		else {
			if(newValue.compareTo(parent.getValue()) < 0)//Add as the left child.
				parent.setLeft(new BinTreeNode<E>(newValue));
			else //Add as the right child.
				parent.setRight(new BinTreeNode<E>(newValue));
			return true;
		}
	}

	/**
	 * This method will delete the value specified by value from the tree, if the value is present in the tree.
	 * @param value - value to be deleted from the BST.
	 * @return It returns true if the deletion is successful and false in failure.
	 */
	public boolean delete (E value) {
		BinTreeNode<E> parentNode = null;
		BinTreeNode<E> nodeToDelete = this.getRoot();
		boolean isLeftChild = false; 
		//Find the node to be deleted and the parent node of that node.
		while(nodeToDelete != null) {
			if(nodeToDelete.getValue().equals(value))
				break;
			parentNode = nodeToDelete;
			if(parentNode.getValue().compareTo(value) > 0) {//Parent has a higher value. Go to left sub tree.
				nodeToDelete = parentNode.getLeft();
				isLeftChild = true;
			}
			else { //Parent has a lower value. Go to right sub-tree
				nodeToDelete = parentNode.getRight();
				isLeftChild = false;
			}
		}
		if(nodeToDelete == null)//Node not found.
			return false;
		else { //Node is in the tree.
			if(nodeToDelete.hasTwoChildren()) { //Case III. Complex deletion scenario. Covert it to a simple scenario.
				//Go to the left sub tree.
				BinTreeNode<E> originalNodeToDelete = nodeToDelete; 
				parentNode = nodeToDelete;
				nodeToDelete = nodeToDelete.getLeft();
				isLeftChild = true;
				//Go to the rightmost child of the left sub-tree.
				while(nodeToDelete.getRight() != null) {
					parentNode = nodeToDelete;
					nodeToDelete = nodeToDelete.getRight();
					isLeftChild = false;
				}
				originalNodeToDelete.setValue(nodeToDelete.getValue()); //Replace the node to be deleted with the rightmost child of left sub-tree. 
			}
		}

		//Simple deletion scenarios
		if(parentNode == null) {//We are deleting root. Special case.
			if(nodeToDelete.isLeaf())//Tree has only one node and we are deleting it.
				this.setRoot(null);
			else if(nodeToDelete.getRight() == null)//Root only has a left child.
				this.setRoot(nodeToDelete.getLeft());
			else
				this.setRoot(nodeToDelete.getRight());
			return true;
		}
		else { 
			if(nodeToDelete.isLeaf()) { //Node is a leaf node
				if(isLeftChild)
					parentNode.setLeft(null);
				else
					parentNode.setRight(null);
				return true;
			}
			else if(nodeToDelete.getRight() == null) {//Node only has a left child.
				if(isLeftChild)
					parentNode.setLeft(nodeToDelete.getLeft());
				else
					parentNode.setRight(nodeToDelete.getLeft());
				return true;
			}
			else if(nodeToDelete.getRight() == null) {//Node only has a right child.
				if(isLeftChild)
					parentNode.setLeft(nodeToDelete.getRight());
				else
					parentNode.setRight(nodeToDelete.getRight());
				return true;
			}
			else {//Node has two children.
				System.out.println("ERROR. Node should not ave two children when it comes here!");
				return false;
			}
		}
	}

	/**
	 * This method will print the values in the tree in sorted order.
	 * To print, this method calls the inOrder() method on the Root node
	 */
	public void printTreeInSortedOrder () {
		System.out.println("Printing Tree In Sorted Order");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		this.printInOrder();
		return;
	}

	/**
	 * This method returns the node with the smallest value in the BST.
	 * @return the node with the smallest value in the BST and null if tree is empty.
	 */
	public BinTreeNode<E> minimum(){
		if (this.getRoot() == null)
			return null;
		
		BinTreeNode<E> min = this.getRoot();
		
		while (min.hasLeft() == true)
			min = min.getLeft();
			
		return min;
	}

	/**
	 * This method returns the node with the largest value in the BST.
	 * @return the node with the largest value in the BST and null if tree is empty.
	 */
	public BinTreeNode<E> maximum(){
		if (this.getRoot() == null)
			return null;
		
		BinTreeNode<E> max = this.getRoot();
		
		while (max.hasRight() == true)
			max = max.getRight();
			
		return max;
	}
}

