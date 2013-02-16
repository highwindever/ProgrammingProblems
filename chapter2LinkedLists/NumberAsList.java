/*
 * Test Case
 * 513+295
 * 1+99
 * 3456+34
 */
package chapter2LinkedLists;


import java.util.Iterator;
import java.util.LinkedList;

public class NumberAsList {
	public static void main (String[] args) {
		LinkedList<Integer> lst1 = new LinkedList<Integer>();
		lst1.add(6);
		lst1.add(5);
		lst1.add(4);
		lst1.add(3);
		
		LinkedList<Integer> lst2 = new LinkedList<Integer>();
		lst2.add(4);
		lst2.add(3);

		
		Iterator<Integer> itr1 = lst1.iterator();
		Iterator<Integer> itr2 = lst2.iterator();
		LinkedList<Integer> res = new LinkedList<Integer>();
		int sum = 0;
		int extra = 0;
		while(lst1.size()>lst2.size()?itr1.hasNext():itr2.hasNext()){
			if(lst1.size()>lst2.size()?itr2.hasNext():itr1.hasNext()){
				sum = itr1.next()+itr2.next()+extra;
				res.add(sum%10);
				extra = sum/10;
			}else{
				sum = (lst1.size()>lst2.size()?itr1:itr2).next() + extra;
				res.add(sum % 10);
				extra = sum / 10;
			}
		}
		if(extra!=0) res.add(extra);
		
		for(int i:res){
			System.out.print(i);
		}

	}
}
