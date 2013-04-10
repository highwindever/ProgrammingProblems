package chapter4TreesAndGraphs;


public class LCA {

	public static void main(String[] args){
		LCA bt = new LCA();
		Node n5 = bt.new Node(6,null,null);
		Node n6 = bt.new Node(7,null,null);
		Node n3 = bt.new Node(4,null,null);
		Node n4 = bt.new Node(5,null,null);
		Node n1 = bt.new Node(2,n3,n4);
		Node n2 = bt.new Node(3,n5,n6);
		Node root = bt.new Node(1,n1,n2);
		System.out.println(getLCA(root, n1, n3).data);
	}
	
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
	
	static Node getLCA(Node root, Node p, Node q){
		if(root==null) return null;
		if(root==p || root==q) return root;
		Node L = getLCA(root.left,p,q);
		Node R = getLCA(root.right,p,q);
		if(L!=null&&R!=null) return root;
		return (L!=null)?L:R;
	}
	
	
}
