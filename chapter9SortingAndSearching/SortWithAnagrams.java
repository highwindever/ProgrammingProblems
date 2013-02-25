package chapter9SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

public class SortWithAnagrams {
	public static void main(String[] args){
		String[] strArr ={"hello","word","ordw","elhlo","abc"};
		SortWithAnagrams swa = new SortWithAnagrams();
		Arrays.sort(strArr, swa.new AnagramComparator());
		for(String s:strArr)
			System.out.println(s);
		
	}
	
    
    public class AnagramComparator implements Comparator<String>{
    	public String sortChars(String s){
    		char[] content = s.toCharArray();
    		Arrays.sort(content);
    		return new String(content);
    	}
    	
    	public int compare(String s1, String s2){
    		return sortChars(s1).compareTo(sortChars(s2));
    	}
    }
    
}
