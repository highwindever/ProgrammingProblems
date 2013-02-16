package chapter4TreesAndGraphs;

import chapter4TreesAndGraphs.BTree.Node;

public class MirrorTree {
	public static void main(String[] args) {
		BTree bt = new BTree();
		Node n5 = bt.new Node(4,null,null);
		Node n6 = bt.new Node(3,null,null);
		Node n3 = bt.new Node(3,null,null);
		Node n4 = bt.new Node(4,null,null);
		Node n1 = bt.new Node(2,n3,n4);
		Node n2 = bt.new Node(2,n5,n6);
		Node root = bt.new Node(1,n1,n2);
		bt.root = root;
		System.out.println(MirrorTree.isMirrorTree(bt));
	}
	
	public static boolean isMirrorTree (BTree bt){
		if (bt.root == null) return false;
		return isMirror(bt.root.left, bt.root.right);
		
	}
	
	public static boolean isMirror(Node left, Node right) {
		if(left == right) return true;//left and right are both null;
		else if(left == null||right ==null) return false;
		else if(left.data != right .data) return false;
		else return isMirror(left.right,right.left) && isMirror(left.left,right.right);
		
	}
	
	//very concise code
	boolean mirrorEquals(Node left, Node right) {
		  if (left == null || right == null) return left == null && right == null;
		  return left.data == right.data && mirrorEquals(left.left, right.right) && mirrorEquals(left.right, right.left);
		}
	

}
