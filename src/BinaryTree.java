/**
 * Implementation of a Binary Tree.
 */


/**
 * @author Malaka Walpola
 * Some parts of this class is taken from the Tree implementation of the textbook.
 * @author: Mark Allen Weiss
 * 
 */
public class BinaryTree<E extends Comparable<E>>{
	
	private BinTreeNode<E> root;

	//Constructors
	/**
	 * Create an empty binary tree.
	 */
	public BinaryTree() {
		super();
		this.root = null;
	}
	/**
	 * @param rootValue value of the root node.
	 */
	public BinaryTree(E rootValue) {
		super();
		this.root = new BinTreeNode<E>(rootValue);
	}

	//Getters and Setters
	/**
	 * @return the root
	 */
	public BinTreeNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BinTreeNode<E> root) {
		this.root = root;
	}

	//Tree Method implementations
	/**
     * Print the tree in preorder. 
     * root, left right
     */
    public void printPreOrder() {
    	if(null == this.root)
    		System.out.println("Tree is empty!");
    	else {
    		System.out.println("Preorder Traversal:");
    		this.root.printPreOrder(root);
    		System.out.println(" END");
    	}
    }
    
    /**
     * Print the tree in inorder. 
     * right, root, left
     */
    public void printInOrder() {
    	if(null == this.root)
    		System.out.println("Tree is empty!");
    	else {
    		System.out.println("Inorder Traversal:");
    		this.root.printInOrder(root);
    		System.out.println(" END");
    	}
    }

    /**
     * Print the tree in postorder. 
     * left right root
     */
    public void printPostOrder() {
    	if(null == this.root)
    		System.out.println("Tree is empty!");
    	else {
    		System.out.println("Postorder Traversal:");
    		this.root.printPostOrder(root);
    		System.out.println(" END");
    	}
    }
    
    /**
     * Returns the number of nodes in the tree.
     * Uses a recursive helper that recurs down the tree and counts the nodes.
     * @return number of nodes in the tree.
     */
    public int size() {
    	if(null == this.root)
    		return 0;
        return BinTreeNode.size(this.root);
    }

    /**
     * Returns the height (max root-to-leaf depth) of the tree.
     * Uses a recursive helper that recurs down to find the height (max depth).
     * @return the height of the tree.
     */
    public int height() {
    	if(null == this.root)
    		return -1;
    	return BinTreeNode.height(this.root);
    }
    
    /**
     * Merge routine for BinaryTree class.
     * Forms a new tree from rootItem, t1 and t2.
     * Does not allow t1 and t2 to be the same.
     * Avoids other aliasing conditions as well.
     */
    public void merge( E rootValue, BinaryTree<E> t1, BinaryTree<E> t2) {
    	if( null != t1.root && null != t2.root && t1.root == t2.root) {
            System.err.println( "leftTree==rightTree; merge aborted" );
            return;
        }
    	// Allocate new node
        root = new BinTreeNode<E>(rootValue, t1.root, t2.root);

        // Ensure that every node is in just one tree!
        if( this != t1 )
            t1.root = null;
        if( this != t2 )
            t2.root = null;
    }

}
