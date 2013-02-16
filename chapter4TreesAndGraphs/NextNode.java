package chapter4TreesAndGraphs;

public class NextNode {
	
	
	
	
	
	class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		public Node(int data, Node left, Node right, Node parent){
			this.data = data;
			this.left = left;
			this .right = right;
			this.parent = parent;
		}
		
		public Node(){
			this.data = 0;
			this.left = null;
			this .right = null;
			this.parent = null;
		}
	}
	

	
	public static void main(String[] args) {
		NextNode nn = new NextNode();
		Node n5 = nn.new Node(8,null,null,null);
		Node n6 = nn.new Node(9,null,null,null);
		Node n3 = nn.new Node(6,null,null,null);
		Node n4 = nn.new Node(7,null,null,null);
		Node n1 = nn.new Node(4,n3,n4,null);
		Node n2 = nn.new Node(5,n5,n6,null);
		Node root = nn.new Node(1,n1,n2,null);
		n5.parent = n2;
		n6.parent =n2;
		n3.parent = n1;
		n4.parent = n1;
		n2.parent = root;
		n1.parent = root;
		//System.out.println(root.data);
		//System.out.println(nn.findLeftMost(root).data);
		System.out.println(nn.findNextNode(n4).data);
		
	}
	
	public Node findNextNode (Node nd){
		
		if(nd.right != null) {
			return findLeftMost(nd.right);
		}else if(nd.parent==null) return null;
		else if (nd.parent.left == nd){
			return nd.parent;
		} else {
			while(nd.parent!=null&&nd.parent.right ==nd){
				nd = nd.parent;
			}
			return nd.parent==null?null:nd.parent;
		}
	}
	
	public Node findLeftMost (Node nd){
		
		while(nd.left!=null){
			nd = nd.left;
		}
		return nd;
	}
}
