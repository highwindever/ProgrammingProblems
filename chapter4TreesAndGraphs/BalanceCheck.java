package chapter4TreesAndGraphs;

import chapter4TreesAndGraphs.BTree.Node;

public class BalanceCheck {
	public static void main(String[] args){
		BTree bt = new BTree();
		Node n5 = bt.new Node(8,null,null);
		Node n6 = bt.new Node(9,null,null);
		Node n3 = bt.new Node(6,null,null);
		Node n4 = bt.new Node(7,null,null);
		Node n1 = bt.new Node(4,n3,n4);
		Node n2 = bt.new Node(5,n5,n6);
		Node root = bt.new Node(3,n1,n2);
		System.out.println(BalanceCheck.checkBalance(root));
		
	}
	
	public static int getMaxDepth(Node root) {
		if (root == null) return 0;
		return 1+Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
	}
	
	public static int getMinDepth(Node root) {
		if(root == null) return 0;
		return 1+Math.min(getMinDepth(root.left),getMinDepth(root.right));
	}
	
	public static boolean checkBalance(Node root) {
		return (getMaxDepth(root)-getMinDepth(root))<=1;
	}
}	