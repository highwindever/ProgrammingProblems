package chapter8Recursion;

import java.util.ArrayList;
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
	
		//printPowerSet(set);

		
	}
	
	 <T> HashSet<HashSet<T>> getSubset(HashSet<T> set){
		
		HashSet<HashSet<T>> sets = new HashSet<HashSet<T>>();
		if(set.isEmpty()) {
			sets.add(set);
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
	
	
	static HashSet<HashSet<Integer>> powerSet(HashSet<Integer> set){
		if(set==null) return null;
	    HashSet<HashSet<Integer>> sets = new HashSet<HashSet<Integer>>();
	    if(set.isEmpty()) {
	        sets.add(set);
	        return sets;
	    }
	    Iterator<Integer> itr = set.iterator();
	    
	    Integer i = itr.next();
	    set.remove(i);
	    
	    
	    HashSet<HashSet<Integer>> subsets = powerSet(set);
	    
	     
	    for(HashSet<Integer> s:subsets){
	        HashSet<Integer> newSet = new HashSet<Integer>();
	        newSet.addAll(s);
	        newSet.add(i);
	        sets.add(newSet);
	        sets.add(s);    
	    }
	    
	    return sets;
	    
	}
	
	//http://www.careercup.com/question?id=15886680
	 static void printPowerSet(HashSet<Integer> set){
		HashSet<HashSet<Integer>> sets = new HashSet<HashSet<Integer>>();
		//sets = powerSet(set);
		sets = powerSetBit(set);
		if(sets==null) System.out.print("Null Set");
		else{
		int count0 =sets.size();
		for (HashSet<Integer> s : sets) {
				System.out.print("{");
				int count = s.size();
				for (Integer i : s) {
					count--;
					System.out.print(i);
					if(count!=0)
						System.out.print(",");
				}
				count0--;
				System.out.print("}");
				if(count0!=0)
				System.out.print(",");
			
		}}
		
	}
	
	//bit manipulation
	static HashSet<HashSet<Integer>> powerSetBit(HashSet<Integer> set){
		if(set==null) return null;
		System.out.println("Use bit manipulation:");
		ArrayList<Integer> aset = new ArrayList<Integer>();
		aset.addAll(set);
		HashSet<HashSet<Integer>> sets = new HashSet<HashSet<Integer>>();
		int n= set.size();
		for(int i=0;i<(1<<n);i++){
			HashSet<Integer> newset = new HashSet<Integer>();
			for(int j=0;j<n;j++){
				if((i&(1<<j))>0){
					newset.add(aset.get(j));
				}
			}
			sets.add(newset);				
		}
		
		return sets;
		
	}

}
