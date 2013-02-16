package chapter4TreesAndGraphs;

public class BTree {

	public Node root;
	
	class Node {
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

	public static void main (String[] args) {
		BTree bt = new BTree();
		Node n5 = bt.new Node(8,null,null);
		Node n6 = bt.new Node(9,null,null);
		Node n3 = bt.new Node(6,null,null);
		Node n4 = bt.new Node(7,null,null);
		Node n1 = bt.new Node(4,n3,n4);
		Node n2 = bt.new Node(5,n5,n6);
		Node root = null;
		bt.insertNode(root, 100);
		System.out.println(root);
		
		bt.insertNode(bt.root, 7);
		bt.insertNode(bt.root,8);
		
		
		
		
		
		System.out.println("Preorder:");
		bt.preorder(bt.root);
		System.out.println();
		System.out.println("Inorder:");
		bt.inorder(bt.root);
		System.out.println();
		System.out.println("Postorder:");
		bt.postorder(bt.root);
		
	}
	
	public void preorder (Node node) {
		if(node == null) return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
		
	}
	
	public void inorder (Node node) {
		if(node == null) return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);	
	}
	
	public void postorder (Node node) {
		if(node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	
	public void insertNode(Node root, int data){ 
		if(root == null) root = new Node(data); 
		else if(data<=root.data) {
			if(root.left==null) {
				root.left = new Node(data);
			}else
			insertNode(root.left, data);}
		else {
			if(root.right==null) {
				root.right = new Node(data);
			}else
			insertNode(root.right,data);			
		}
	}
	

}
