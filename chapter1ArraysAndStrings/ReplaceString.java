package chapter1ArraysAndStrings;

public class ReplaceString {
	public static void main(String[] args) {
		System.out.println(ReplaceString.replaceSpace(" ni hao ma "));
		System.out.println(ReplaceString.replaceSpace2(" ni hao ma "));
		System.out.println(ReplaceString.replaceSpace3(" ni hao ma "));
	}
	
	
	public static String replaceSpace(String str){
		if(str == null) return str;
		else
		return str.replaceAll(" ", "%20");
	}
	
	public static String replaceSpace2(String str){
		if(str == null) return str;
		else {
			String[] strArray = new String[str.length()];
			//String result =new String(); 
			StringBuilder res = new StringBuilder();			
			for(int i=0;i<str.length();i++){
				strArray[i] = String.valueOf(str.charAt(i));
				if(strArray[i].equals(" ")) strArray[i] ="%20";
				//result = result.concat(strArray[i]);
				res.append(strArray[i]);
			}
			return res.toString();
			
		}
	}
	
	//Another method is to count space first. Then generate a new char[], assign value from the end.
	
	public static String replaceSpace3(String str){
		if(str == null) return str;
		else {
			int spaceCount = 0;
			char[] ch = str.toCharArray();
			for(char c:ch) {
				if(c==' ') spaceCount++;
			}
			
			int newLen = str.length() + spaceCount *2;
			char[] newCh = new char[newLen];
			for(int i=ch.length-1;i>=0;i--){
				if(ch[i]==' ') {
					newCh[newLen-1] = '0';
					newCh[newLen-2] = '2';
					newCh[newLen-3] = '%';
					newLen -= 3;
				} else {
					newCh[newLen-1] = ch[i];
					newLen -= 1;
				}							
			
			}
			return new String(newCh);			
			
		}
	}	
	
}
