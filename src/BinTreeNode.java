/**
 * Node for the Binary Tree
 */


/**
 * @author Malaka Walpola
 * Some parts of this class is taken from the Tree implementation of the textbook.
 * @author: Mark Allen Weiss
 * 
 */
public class BinTreeNode <E extends Comparable<E>> {

	private E value;
	private BinTreeNode<E> left; 
	private BinTreeNode<E> right;
	
	/**
	 * Constructor with only the value.
	 * @param value - Value of the node.
	 */
	public BinTreeNode(E value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
	}
	/**
	 * Constructor with the value and left and right child nodes.
	 * @param value - value of the node
	 * @param left - left-child node
	 * @param right - right-child node
	 */
	public BinTreeNode(E value, BinTreeNode<E> left, BinTreeNode<E> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	//Getters and Setters
	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}
	/**
	 * @return the left
	 */
	public BinTreeNode<E> getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinTreeNode<E> left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinTreeNode<E> getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinTreeNode<E> right) {
		this.right = right;
	}

	/**
	 * Set a new node with value specified by newValue as the left child of the node given by parent
	 * @param parent
	 * @param newValue
	 */
	public void addLeftChild (E newValue){
		BinTreeNode<E> newNode = new BinTreeNode<E>(newValue);
		this.setLeft(newNode);
	}
	
	/**
	 * Set a new node with value specified by newValue as the right child of the node given by parent
	 * @param parent
	 * @param newValue
	 * @return
	 */
	public void addRightChild (E newValue){
		BinTreeNode<E> newNode = new BinTreeNode<E>(newValue);
		this.setRight(newNode);
	}
	
	/**
	 * This method returns whether the node is a leaf node or not. 
	 * @return true if node is a leaf node and false otherwise.
	 */
	public boolean isLeaf() {
		return( null == this.left && null == this.right);
	}
	
	/**
	 * This method returns whether the node has two child nodes or not.
	 */
	public boolean hasTwoChildren() {
		return (this.left != null && this.right != null);
	}

	/**
     * Return the size of the tree rooted at t.
     * Note that the method is static, so we can call 
     * even before any object is created.
     */
    public static <E extends Comparable<E>> int size( BinTreeNode<E> t )
    {
        if( null == t)
            return 0;
        else {
        	int retSize = 1;
        	//Add size of left-subtree
        	retSize += BinTreeNode.size(t.left);
        	//Add size of right-subtree
        	retSize += BinTreeNode.size(t.right);
        	return retSize;
        }
    }

    /**
     * Return the height of the tree rooted at t.
     */
    public static <E extends Comparable<E>> int height( BinTreeNode<E> t )
    {
    	if(null == t) //Node null, return -1; - special case in case root is null.
    		return -1;
    	if(t.isLeaf())//This is a leaf. Height is 0;
    		return 0;
    	//Height of the left-subtree
    	int leftHeight = BinTreeNode.height(t.left);
    	//Height of the right-subtree
    	int rightHeight = BinTreeNode.height(t.right);
    	//Get max of the heights of two sub trees and add 1 to get the height of this tree. 
    	int treeHeight = Math.max(leftHeight, rightHeight) + 1;
    	return treeHeight;
    }
    
    /**
     * Return a reference to a node that is the root of a
     * duplicate of the binary tree rooted at the current node.
     * In other words, create a copy of the tree rooted at
     * the current node.
     */
    public BinTreeNode<E> duplicate( )
    {
    	BinTreeNode<E> root = new BinTreeNode<E>(this.value); //Duplicate current node
    	//Duplicate child nodes
    	root.left = this.left.duplicate();
    	root.right = this.right.duplicate();
        return root; // Return resulting tree
    }

    //Incomplete methods.
    /**
     * Print binary tree rooted at current node using preorder traversal.
     * this method will print the parameterized node's value then recursively call itself 
     * for the left node, then the right
     */
    public void printPreOrder(BinTreeNode<E> node)
    {   
    	if (node == null) //if the node is null, we do nothing but continue on to the next node
    		return;
    	else {
    	System.out.print(node.value + ", ");
    	printPreOrder(node.left);
    	printPreOrder(node.right);
    	}
    }
    
    /**
     * Print binary tree rooted at current node using inorder traversal.
     * this method will recursively call itself on the parameterized node's left node,
     * then print its own root, then recursively call itself on the right node
     * 
     */
    public void printInOrder(BinTreeNode<E> node)
    {   
    	if (node == null)//if the node is null, we do nothing but continue on to the next node
    		return;
    	else {
    	printInOrder(node.left); 
    	System.out.print(node.value + ", ");
    	printInOrder(node.right);
    	}
    }

    /**
     * Print tree rooted at current node using postorder traversal.
     * this method will recursively call itself onto the lft node, then right node,
     * then it will print the parameterized node's value. 
     */
    public void printPostOrder(BinTreeNode<E> node)
    {   
    	if (node == null)//if the node is null, we do nothing but continue on to the next node
    		return;
    	else {
        printPostOrder(node.left);
       	printPostOrder(node.right);
       	System.out.print(node.value + ", ");
    	}
    }
	public boolean hasLeft() {
		if (left == null)
			return false;
		
		return true;
	}
	
	public boolean hasRight() {
		if (right == null)
			return false;
		
		return true;
	}

    
}
