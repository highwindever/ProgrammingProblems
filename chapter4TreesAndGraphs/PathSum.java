package chapter4TreesAndGraphs;

import java.util.ArrayList;

public class PathSum {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node (int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
		
	}
	
	public static void main(String[] args){
		Node n5 = new Node(1,null,null);
		Node n6 = new Node(2,null,null);
		Node n3 = new Node(2,null,null);
		Node n4 = new Node(5,null,null);
		Node n1 = new Node(3,n3,n4);
		Node n2 = new Node(4,n5,n6);
		Node n0 = new Node(1,n1,n2);
		ArrayList<Node> lst = new ArrayList<Node>();
		findPath(n0, 6, 0, lst);
	}
	
	static void findPath(Node root, int sum, int level, ArrayList<Node> lst){
		if(root==null) return;
		lst.add(root);
		int tmp=0;
		for(int i=level;i>-1;i--){
			tmp +=lst.get(i).data;
			if(tmp==sum) print(lst,i,level);
		}
		
		ArrayList<Node> l = new ArrayList<Node>();
		ArrayList<Node> r = new ArrayList<Node>();
		l.addAll(lst);
		r.addAll(lst);
		findPath(root.left,sum,level+1,l);
		findPath(root.right,sum,level+1,r);
	}
	
	static void print(ArrayList<Node> lst, int i, int level){
		for(int j =i;j<level+1;j++){
			System.out.print(lst.get(j).data+" ");
		}
		System.out.println();
	}
}
