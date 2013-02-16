package chapter4TreesAndGraphs;


public class BinarySearchTree<T extends Comparable<T>> {
	
	   private static class BinaryNode<T> {
		      private T item;
		      private BinaryNode<T> left;
		      private BinaryNode<T> right;
		    
		    
		    /** 
		      * constructor to build a node with no subtrees
		      * @param the value to be stored by this node
		      */
		      private BinaryNode(T value) {
		        item = value;
		        left = null;
		        right = null;
		      }
		    
		    
		    /** 
		      * constructor to build a node with a specified (perhaps null) subtrees
		      * @param the value to be stored by this node
		      * @param the left subtree for this node
		      * @param the right subtree for this node
		      */
		      private BinaryNode(T value, BinaryNode<T> l, BinaryNode<T> r) {
		        item = value;
		        left = l;
		        right = r;
		      }
		    }
	   
	protected BinaryNode<T> root = null;

	public BinarySearchTree() {
		super();
	}

	/*
	 * constructs a tree with one element, as given
	 * 
	 * @param value to be used for the one element in the tree
	 */
	public BinarySearchTree(T value) {
		super();
		root = new BinaryNode<T>(value);
	}
		    
	public BinarySearchTree(BinaryNode<T> newRoot) {
		super();
		root = newRoot;
	}

	/*
	 * find a value in the tree
	 * 
	 * @param key identifies the node value desired
	 * 
	 * @return the node value found, or null if not found
	 */
	public T get(T key) {
		BinaryNode<T> node = root;
		while (node != null) {
			if (key.compareTo(node.item) == 0) {
				return node.item;
			}
			if (key.compareTo(node.item) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}

	/*
	 * add a value to the tree, replacing an existing value if necessary
	 * 
	 * @param value to be inserted
	 */
	public void add(T value) {
		root = add(value, root);
	}

	/*
	 * add a value to the tree, replacing an existing value if necessary
	 * 
	 * @param value to be inserted
	 * 
	 * @param node that is the root of the subtree in which to insert
	 * 
	 * @return the subtree with the node inserted
	 */
	protected BinaryNode<T> add(T value, BinaryNode<T> node) {
		if (node == null) {
			return new BinaryNode<T>(value);
		}
		if (value.compareTo(node.item) == 0) {
			// replace the value in this node with a new value
			node.item = value;
			// alternative code creates new node, leaves old node unchanged:
			// return new BinaryNode<T>(value, node.left, node.right);
		} else {
			if (value.compareTo(node.item) < 0) { // add to left subtree
				node.left = add(value, node.left);
			} else { // add to right subtree
				node.right = add(value, node.right);
			}
		}
		return node;
	}

	/*
	 * remove a value from the tree, if it exists
	 * 
	 * @param key such that value.compareTo(key) == 0 for the node to remove
	 */
	public void remove(T key) {
		root = remove(key, root);
	}

	/*
	 * remove a value from the tree, if it exists
	 * 
	 * @param key such that value.compareTo(key) == 0 for the node to remove
	 * 
	 * @param node the root of the subtree from which to remove the value
	 * 
	 * @return the new tree with the value removed
	 */
	protected BinaryNode<T> remove(T value, BinaryNode<T> node) {
		if (node == null) { // key not in tree
			return null;
		}
		if (value.compareTo(node.item) == 0) { // remove this node
			if (node.left == null) { // replace this node with right child
				return node.right;
			} else if (node.right == null) { // replace with left child
				return node.left;
			} else {
				// replace the value in this node with the value in the
				// rightmost node of the left subtree
				node.item = getRightmost(node.left);
				// now remove the rightmost node in the left subtree,
				// by calling "remove" recursively
				node.left = remove(node.item, node.left);
				// return node; -- done below
			}
		} else { // remove from left or right subtree
			if (value.compareTo(node.item) < 0) {
				// remove from left subtree
				node.left = remove(value, node.left);
			} else { // remove from right subtree
				node.right = remove(value, node.right);
			}
		}
		return node;
	}

	protected T getRightmost(BinaryNode<T> node) {
		assert (node != null);
		BinaryNode<T> right = node.right;
		if (right == null) {
			return node.item;
		} else {
			return getRightmost(right);
		}
	}

	/*
	 * toString
	 * 
	 * @returns the string representation of the tree.
	 */
	public String toString() {
		return toString(root);
	}

	protected String toString(BinaryNode<T> node) {
		if (node == null) {
			return "";
		}
		return node.item.toString() + "(" + toString(node.left) + ", "
				+ toString(node.right) + ")";
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	}

}
