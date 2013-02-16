package chapter2LinkedLists;


import java.util.LinkedList;


public class RemoveDuplicates {
	public static void main (String[] args) {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		lst.add(1);
		lst.add(10);
		lst.add(2);
		lst.add(10);
		lst.add(8);
		lst.add(2);
		lst.add(1);
		lst.add(5);
		lst.add(8);
		
		LinkedList<Integer> newLst = RemoveDuplicates.removeDuplicates(lst);
		for(Integer i:newLst) {
			System.out.print(i+" ");
		}
	}
	
	public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> lst){
		int len = lst.size();
		System.out.println(len);
		for(int i=0;i<len;i++)
			for(int j=0;j<i;j++) {
				if(lst.get(i) ==lst.get(j)){
					//remove element at index i
					lst.remove(i);
					len--;
					i--;
				}
			}
		
		
		return lst;
	}
	
}
