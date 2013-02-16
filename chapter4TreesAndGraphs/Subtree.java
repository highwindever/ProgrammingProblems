package chapter4TreesAndGraphs;

import chapter4TreesAndGraphs.BTree.Node;

public class Subtree {
	 
	public static void main (String[] args) {
		BTree bt = new BTree();
		Node n5 = bt.new Node(4,null,null);
		Node n6 = bt.new Node(3,null,null);
		Node n3 = bt.new Node(3,null,null);
		Node n4 = bt.new Node(4,null,null);
		Node n1 = bt.new Node(2,n3,n4);
		Node n2 = bt.new Node(2,n5,n6);
		Node root = bt.new Node(2,n1,n2);
		bt.root = root;
		
		BTree bt1 = new BTree();
//		Node n51 = bt1.new Node(4,null,null);
//		Node n61 = bt1.new Node(3,null,null);
//		Node n31 = bt1.new Node(3,null,null);
//		Node n41 = bt1.new Node(4,null,null);
		Node n11 = bt1.new Node(4,null,null);
		Node n21 = bt1.new Node(3,null,null);
		Node root1 = bt1.new Node(2,n11,n21);
		bt1.root = root1;
		System.out.println(Subtree.isSubtree(bt.root, bt1.root));
		
	 }
	 
	public static boolean isEqual(Node a, Node b){
		if(a==null||b==null) return a == b;
		return (a.data == b.data) && isEqual(a.left,b.left) && isEqual(a.right,b.right);
		
	}
	
	public static boolean isSubtree(Node node, Node sub){
		if(sub==null) return true;
		if(node==null) return false;
		return isEqual(node,sub)||isSubtree(node.left,sub)||isSubtree(node.right,sub);
	}
	
	
}
