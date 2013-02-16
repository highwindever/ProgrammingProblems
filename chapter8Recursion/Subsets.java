package chapter8Recursion;

import java.util.HashSet;
import java.util.Iterator;

public class Subsets {

	public  static void main (String[] args) {
		Subsets test = new Subsets();
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		HashSet<HashSet<Integer>> sets = new HashSet<HashSet<Integer>>();
		sets = test.getSubset(set);
		for (HashSet<Integer> s : sets) {
			if (s.isEmpty())
				System.out.println("null");
			else {
				System.out.print("{");
				for (Integer i : s) {
					System.out.print(i + " ");
				}
				System.out.println("}");
			}
		}
		

		
	}
	
	public <T> HashSet<HashSet<T>> getSubset(HashSet<T> set){
		
		HashSet<HashSet<T>> sets = new HashSet<HashSet<T>>();
		if(set.isEmpty()) {
			sets.add(new HashSet<T>());
			return sets;
		}
		
		Iterator<T> itr = set.iterator();

		T obj = itr.next();
		set.remove(obj);
		
		for (HashSet<T> s : getSubset(set)) {
			 HashSet<T> newSet = new HashSet<T>();
	            newSet.add(obj);
	            newSet.addAll(s);
	            sets.add(newSet);
	            sets.add(s);
		}
		return sets;

	}
	

	
	
	

}
