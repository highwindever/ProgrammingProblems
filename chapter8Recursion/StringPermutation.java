/*
 * aaa
 * abcd
 * aab
 * aabb
 * a b c
 * Aa
 * null
 */

package chapter8Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class StringPermutation {
	public static void main(String[] args) {
		String str = "Aa";
		ArrayList<String> perms = StringPermutation.getPerms(str);
		System.out.println(perms.size());
		for(String s:perms)
			System.out.println(s);
		

		
	}
	
	public static ArrayList<String> getPerms(String s){
		ArrayList<String> perms = new ArrayList<String>();
		if(s==null) return null;
		else if(s.length()==0){
			perms.add("");
			return perms;
		}
		
		char first = s.charAt(0);
		String remainder = s.substring(1);
		for(String perm:getPerms(remainder)){
			for(int i=0;i<=perm.length();i++){
				perms.add(insert(first,i,perm));
			}
		}
		//use HashSet to get uniquePerms
//		HashSet<String> set = new HashSet<String>();
//		set.addAll(perms);
//		ArrayList<String> uniquePerms = new ArrayList<String>();
//		uniquePerms.addAll(set);
//		return uniquePerms;
		
		ArrayList<String> uniquePerms = new ArrayList<String>();
		Collections.sort(perms);
		String temp ="";
		for(String str:perms){
			if(!str.equals(temp)) uniquePerms.add(str);
			temp = str;
		}
		return uniquePerms;	
	}
	
	public static String insert (char first, int i, String perm){
		StringBuilder sb = new StringBuilder();
		sb.append(perm.substring(0, i));
		sb.append(first);
		sb.append(perm.substring(i));
		return sb.toString();
	}
}
