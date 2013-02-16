package chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import chapter4TreesAndGraphs.BTree.Node;

public class TreeToLinkedList {
	public ArrayList<LinkedList<Node>> lstArray;
	
	
	public static void main (String[] args) {
		BTree bt = new BTree();
		Node n5 = bt.new Node(4,null,null);
		Node n6 = bt.new Node(3,null,null);
		Node n3 = bt.new Node(3,null,null);
		Node n4 = bt.new Node(4,null,null);
		Node n1 = bt.new Node(2,n3,n4);
		Node n2 = bt.new Node(2,n5,n6);
		Node root = bt.new Node(1,n1,n2);
		bt.root = root; 
		TreeToLinkedList ttl = new TreeToLinkedList();
		ttl.lstArray = new ArrayList<LinkedList<Node>>();
		
		ttl.getList(bt.root, 0);
		
		for(LinkedList<Node> l:ttl.lstArray){
			for(int i=0;i<l.size();i++)
			System.out.print(l.get(i).data+" ");			
			System.out.println();
		}
		

	}

	public void getList(Node root, int height) {
		if(root == null) return;
		if(lstArray.size() == height){//here if we use lstArray.get(height) == null, would cause exception.
			LinkedList<Node>  lst = new LinkedList<Node>();
			lstArray.add(height, lst)  ;
			}
		lstArray.get(height).add(root);		
		height++;
		getList(root.left,height);
		getList(root.right,height);				
	}
	
}
