/*Test case
 * a
 * abcdef
 * aabcdfchh
 * aaaaaa
 * null string
 * aaabbb
 * ababab
 * Aa
 * */


package chapter1ArraysAndStrings;

public class RemoveDuplicateChars {
	public static void main (String[] args) {
		RemoveDuplicateChars rdc = new RemoveDuplicateChars();
		System.out.println(rdc.removeDuplicates("Aaa"));
		System.out.println(rdc.removeDuplicatesWithExtraMemory("Aaa"));
	}
	
	public String removeDuplicates (String str) {
		if(str == null) return str;
		if(str.length()<2) return str;
		int tail = 0;
		char[] c = new char[str.length()];
		c[0] = str.charAt(0);
		
		for(int i=1;i<str.length();i++) {
			int j=0;
			c[i] = str.charAt(i);
			for(j=0;j<=tail;j++){
				if(c[i] == c[j]) break; 
			}
			if(j==tail+1)  c[++tail] = c[i]; 		
		}
		
		return new String(c).substring(0, tail+1);

		
	}
	
	
	 public String removeDuplicatesWithExtraMemory (String str) {
         if(str == null) return str;
         int strlen = str.length();
         if(strlen<2) return str;
         int tail = 0;
         boolean[] charset = new boolean[256];
         char[] c = new char[strlen];
         c[0] = str.toLowerCase().charAt(0);
         charset[c[0]] = true;
         for(int i=1; i<strlen;i++){
                 c[i] = str.toLowerCase().charAt(i);
                 if(!charset[c[i]]) {
                         c[++tail] = c[i];
                         charset[c[i]] = true;
                 }
         }

         return new String(c).substring(0,tail+1);

 }

}
