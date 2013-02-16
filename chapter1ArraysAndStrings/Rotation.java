/*
 * Test Case
 * "bc","cb"
 * "cbc","bc"
 * "bc","bc"
 */

package chapter1ArraysAndStrings;

public class Rotation {
	public static void main(String[] args) {
		 
		
		System.out.println(Rotation.isRotation2("", "bc"));
		
	}
	
	public static boolean isRotation(String a, String b) {
		if(a==null||b==null) return false;
		if(a.length()!=b.length()) return false;
		//if(a.equals(b)) return false;
		for(int i=0;i<a.length();i++){
			if(Rotation.isSubstring(a.substring(0, i+1),b)&&Rotation.isSubstring(a.substring(i+1, a.length()),b)) return true;
		}
		return false;
	}
	
	public static boolean isRotation2(String a, String b) {
		if(a.length()==b.length()&&b.length()>0){
			String bb= b+b;
			return Rotation.isSubstring(a, bb);
		}
		return false;
	}
	
	public static boolean isSubstring(String a, String b) {
		if(a==null&&b==null) return false;
		else if (a==null || b==null) return false;
		else if (a.length()>b.length()) return false;
		else if (a.length()==0) return false;//maybe true
		else if(b.indexOf(a)==-1) return false;
		else return true;	
	}
	
	
}
