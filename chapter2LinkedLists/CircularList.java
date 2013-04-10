package chapter2LinkedLists;

public class CircularList {
	class Node{
		String data;
		Node next;
		
		Node(String data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public static void main(String[] args){
		CircularList cl = new CircularList();
		
		Node c = cl.new Node("C",null);
		Node e = cl.new Node("E",c);
		Node d = cl.new Node("D",e);
		Node b = cl.new Node("B",c);
		Node a = cl.new Node("A",b);
		c.next =d;
		System.out.println(findStart(a).data);
	}
	
	static Node findStart(Node n){
		Node n1 =n;
		Node n2 =n;
		
		while(n2.next!=null){
			n1 = n1.next;
			n2 = n2.next.next;
			if(n1==n2) break;
		}
		
		if(n2.next==null) return null;
		n1 = n;
		while(n1!=n2){
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
		
	}
	
}
