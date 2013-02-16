package chapter2LinkedLists;

public class LinkedList {
	private Link first;
	
	public LinkedList() {
		first = null;
	}
	
	public void insert(int d1, double d2){
		Link link = new Link(d1, d2);
		link.nextLink = first;
		first = link;
	}
	
	public Link delete() {
		Link temp =first;
		first = first.nextLink;
		return temp;
	}
	
	 public void printList() {
		    Link currentLink = first;
		    System.out.print("List: ");
		    while(currentLink != null) {
			    currentLink.printLink();
			    currentLink = currentLink.nextLink;
		    }
		    System.out.println("");
	    }
	
	class Link {
		public int data1;
		public double data2;
		public Link nextLink;
		
		public Link(int d1, double d2) {
			data1 = d1;
			data2 = d2;
		}
		
	    public void printLink() {
		    System.out.print("{" + data1 + ", " + data2 + "} ");
	    }
				
	}
	
	public static void main (String[] args) {
		LinkedList lst = new LinkedList();
		lst.insert(1, 1.01);
		lst.insert(2, 2.02);
		lst.insert(3, 3.03);
		lst.printList();
	}
	

	
	
}
