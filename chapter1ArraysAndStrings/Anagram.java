/*
 * Test Case
 * "a","a"
 * "aa","a"
 * "abc","cba"
 * "abcde","abcde"
 * null,"abc"
 */

package chapter1ArraysAndStrings;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		
		Anagram ana = new Anagram();
		String a = "ab";
		String b = "ba";
		System.out.println(ana.areAnagramsSort(a, b));
		System.out.println(ana.areAnagramsCount(a,b));


	}
		
    public static boolean isAnagram(String a, String b){
        if(a==null||b==null) return false;
        if(a.length()!=b.length()) return false;
        
        int[] charSet = new int[256];
        for(int i=0;i<a.length();i++){
            charSet[a.charAt(i)]++;
        }
        
        for(int j=0;j<b.length();j++){
            charSet[b.charAt(j)]--;
        }
        
        for(int k=0;k<charSet.length;k++){
            if(charSet[k]!=0) return false;
        }
        return true;
    }

		public boolean areAnagramsSort(String a, String b) {
			if(a==null&&b==null) return false;
			else if (a== null||b==null) return false;
			else {
				char[] ac = a.toCharArray();
				char[] bc = b.toCharArray();
				Arrays.sort(ac);
				Arrays.sort(bc);
				String aa = new String(ac);
				//System.out.println(aa);
				String bb = new String(bc);
				//System.out.println(bb);
				return aa.equalsIgnoreCase(bb);
			}
		}
		
		public boolean areAnagramsCount(String a, String b) {
			if(a==null&&b==null) return false;
			else if (a== null||b==null) return false;
			else {
				int[] count = new int[256];
				char[] ac = a.toCharArray();
				for(char c:ac) {
					count[c]++;
				}
				
				char[] bc = b.toCharArray();
				for(char c:bc){
					count[c]--;
				}
				
				for(int i:count){
					if(i!=0) return false;
				}
			}
			return true;
		}
		

		
		
	
}
