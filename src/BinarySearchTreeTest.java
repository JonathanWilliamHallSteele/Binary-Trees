
/**
 * @author Malaka Walpola
 * 
 * edited by
 * @author Jon Steele jonwhsteele@gmail.com
 *
 */
public class BinarySearchTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	/**
	 * This method tests the implemented methods of Binary trees.
	 */
	private static void test2() {
		int [] values = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		BinarySearchTree<Integer> myBST = new BinarySearchTree<Integer>();
		for(int i=0; i<values.length; i++) {
			myBST.insert(values[i]);
		}
		myBST.printTreeInSortedOrder();
		System.out.println(myBST.search(8).getValue());
		System.out.println(myBST.search(10).getValue());

		System.out.println(myBST.search(16));
		System.out.println(myBST.search(9999));

		System.out.println(myBST.minimum().getValue());

		System.out.println(myBST.maximum().getValue());

		myBST.insert(0);

		myBST.insert(16);

		myBST.printInOrder();

		myBST.delete(8);
		myBST.printInOrder();

		myBST.delete(1);
		myBST.printInOrder();

		myBST.delete(9);
		myBST.printInOrder();

		myBST.printInOrder();
		myBST.printPreOrder();
		myBST.printPostOrder();		
	}
	
	private static void test1() {
		int [] values = {50, 20, 80, 70, 90, 10, 30, 40, 44, 66, 55, 77};
		BinarySearchTree<Integer> myBST = new BinarySearchTree<Integer>();
		for(int i=0; i<values.length; i++) {
			myBST.insert(values[i]);
		}
		
		myBST.printTreeInSortedOrder(); //Order of Nodes: 10 20 30 40 44 50 55 66 70 77 80 90 END
		myBST.delete(50);
		myBST.printInOrder();	//Order of Nodes: 10 20 30 40 44 55 66 70 77 80 90 END
		myBST.printPreOrder();	//Order of Nodes: 44 20 10 30 40 80 70 66 55 77 90 END
		myBST.printPostOrder();	//Order of Nodes: 10 40 30 20 55 66 77 70 90 80 44 END
		
		BinTreeNode<Integer> minNode = myBST.minimum();
		System.out.println("Minimum Value in tree: " + ((null == minNode) ? "NOT PRESENT" : minNode.getValue())); //10
		BinTreeNode<Integer> maxNode = myBST.maximum();
		System.out.println("Maximum Value in tree: " + ((null == maxNode) ? "NOT PRESENT" : maxNode.getValue())); //90
		
		myBST.delete(55);
		myBST.printInOrder();	//Order of Nodes: 10 20 30 40 44 66 70 77 80 90 END
		myBST.printPreOrder();	//Order of Nodes: 44 20 10 30 40 80 70 66 77 90 END
		myBST.printPostOrder();	//Order of Nodes: 10 40 30 20 66 77 70 90 80 44 END
		
		myBST.delete(90);
		myBST.printInOrder();	//Order of Nodes: 10 20 30 40 44 66 70 77 80 END
		myBST.printPreOrder();	//Order of Nodes: 44 20 10 30 40 80 70 66 77 END
		myBST.printPostOrder();	//Order of Nodes: 10 40 30 20 66 77 70 80 44 END
		
		myBST.delete(70);
		myBST.printInOrder();	//Order of Nodes: 10 20 30 40 44 66 77 80 END
		myBST.printPreOrder();	//Order of Nodes: 44 20 10 30 40 80 66 77 END
		myBST.printPostOrder();	//Order of Nodes: 10 40 30 20 77 66 80 44 END
		minNode = myBST.minimum();
		System.out.println("Minimum Value in tree: " + ((null == minNode) ? "NOT PRESENT" : minNode.getValue())); //10
		maxNode = myBST.maximum();
		System.out.println("Maximum Value in tree: " + ((null == maxNode) ? "NOT PRESENT" : maxNode.getValue())); //80
		
		myBST.insert(99);
		myBST.printInOrder();	//Order of Nodes: 10 20 30 40 44 66 77 80 99 END
		myBST.insert(5);
		myBST.printInOrder();	//Order of Nodes: 5 10 20 30 40 44 66 77 80 99 END
		minNode = myBST.minimum();
		System.out.println("Minimum Value in tree: " + ((null == minNode) ? "NOT PRESENT" : minNode.getValue())); //5
		maxNode = myBST.maximum();
		System.out.println("Maximum Value in tree: " + ((null == maxNode) ? "NOT PRESENT" : maxNode.getValue())); //99

		int [] searchValues = { 55, 99, 44, 20, 22};
		for(int i=0; i<searchValues.length;i++) {
			BinTreeNode<Integer> resultNode = myBST.search(searchValues[i]);
			System.out.println((resultNode==null)?("Value " + searchValues[i] + " Not Found!"):("Value " + resultNode.getValue() + " Found!"));
		}
	}

}
