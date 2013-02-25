package chapter4TreesAndGraphs;

import java.util.Stack;

import chapter4TreesAndGraphs.BTree.Node;

public class DFS {
	public static void main(String[] args){
		BTree bt = new BTree();
		Node n5 = bt.new Node(7,null,null);
		Node n6 = bt.new Node(6,null,null);
		Node n3 = bt.new Node(5,null,null);
		Node n4 = bt.new Node(4,null,null);
		Node n1 = bt.new Node(2,n3,n4);
		Node n2 = bt.new Node(3,n5,n6);
		Node root = bt.new Node(1,n1,n2);
		bt.root = root; 
		DFS d = new DFS();
		d.stack = new Stack<Node>();
		d.doDFS(bt.root);
	}
	
	public Stack<Node> stack;
	public void doDFS(Node root){
		if(root==null) return;
		System.out.print(root.data+" ");
		if(root.left!=null){
			if(root.right!=null) stack.push(root.right);
			doDFS(root.left);			
		}else if(!stack.isEmpty()){
			doDFS(stack.pop());
		}
		
		
	}
	
}
