//Test case
//"!abs hj*&;"
//"ldshh dkhs"
//"aabcdefg"
//"abcdefgg"


package chapter1ArraysAndStrings;

import java.util.HashSet;

public class UniqueCharacter {
	public static void main (String args[]) {
		String a = "!abs hj*&;";
		UniqueCharacter uc = new UniqueCharacter();
		uc.determineUniqueCharacter(a);
		uc.notUseExtraDataStructure(a);
		System.out.println(uc.isUniqueChars(a));
	}


	public void determineUniqueCharacter(String a){//if character only means alphabet letters
		int strlen = a.length();
		char[] b = new char[strlen];
		int i = 0;

		HashSet<Character> d = new HashSet<Character>();
		for(Character c:b){
			c = a.charAt(i++);
			//System.out.println(c);
			d.add(c);
		}

		if(strlen ==d.size()){
			System.out.println("The string:\""+a+"\" has all unique characters.");
		}else if (strlen >d.size()){
			System.out.println("The string:\""+a+"\" doesn't have all unique characters.");
		}	

	}

	public void notUseExtraDataStructure(String a){
		int strlen = a.length();

		boolean flag =true;
		char[] b = a.toCharArray();

		for(int i=1;i<strlen;i++){
			for(int j=i-1;j>=0;j--){

				if(b[i]==b[j]) {
					flag = false;
				}
			}
		}
		if(flag ==true) System.out.println("The string:\""+a+"\" has all unique characters.");
		else System.out.println("The string:\""+a+"\" doesn't have all unique characters.");
	}

	public boolean isUniqueChars(String a) {
		if(a == null) return true;
		if(a.length() <2) return true;
		boolean[] char_set = new boolean[256];
		for (int i=0;i<a.length();i++){
			int val = a.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}

}