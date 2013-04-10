package chapter4TreesAndGraphs;

import java.util.LinkedList;
/*
 * 		 10
 * 		/  \
 * 	   6    16
 *    / \   /  \
 *   4  8  13   18
 *  /\ /\  /\   /\
 *1 5 7 9 11 14 17 19
 */




import chapter4TreesAndGraphs.BTree.Node;

public class PrintAllPaths {
	public static void main(String[] args){
		BTree bt = new BTree();
		Node n5 = bt.new Node(13,null,null);
		Node n6 = bt.new Node(16,null,null);
		Node n3 = bt.new Node(4,null,null);
		Node n4 = bt.new Node(8,null,null);
		Node n1 = bt.new Node(6,n3,n4);
		Node n2 = bt.new Node(15,n5,n6);
		Node root = bt.new Node(10,n1,n2);
		LinkedList<Node> lst = new LinkedList<Node>();
		printPaths(root, lst);
	}
	
	static void printPaths(Node root,LinkedList<Node> lst){
		if(root==null) return;
		LinkedList<Node> newLst = new LinkedList<Node>();
		newLst.addAll(lst);
		newLst.add(root);
		if(root.left==null&&root.right==null) {
			for(Node n:newLst)
				System.out.print(n.data+" ");
			System.out.println();
		}
		else {
			printPaths(root.right, newLst);
			printPaths(root.left,newLst);	
		}	
	}
	
	static void printPaths2(Node root){
		
	}
	
	
}
