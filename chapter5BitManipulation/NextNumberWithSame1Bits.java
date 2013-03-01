/*
 * Test Case
 * 11->101   ERROR
 * 10->100    1
 * 1010->1100   110
 * 101->110   11
 * 1100
 * 
 */
//Not sure if this code works for all cases

package chapter5BitManipulation;

public class NextNumberWithSame1Bits {
	public static void main(String[] args){
		System.out.println(nextBig(12));
		System.out.println(nextSmall(12));
	}
	
	
	public static String nextBig(int num){//find the most right 1, on its leftside, find the most right 0, then switch this 0 with its first rightside 1
		if(num==0) return "ERROR";
		String str = Integer.toBinaryString(num);
		int idx1 = str.lastIndexOf("1");
		int idx0 =str.lastIndexOf("0",idx1-1);
		if(idx0!=-1){
			int idx01 = str.indexOf("1",idx0+1);
			char[] arr = str.toCharArray();
			char temp = arr[idx0];
			arr[idx0] = arr[idx01];
			arr[idx01] =temp;
			return new String(arr);
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append("10");
			sb.append(str.substring(idx1+1));
			sb.append(str.substring(1,idx1+1));
			return sb.toString();
		}

	}
	
	public static String nextSmall(int num){
		if(num==0) return "ERROR";
		String str = Integer.toBinaryString(num);
		if(str.indexOf("0")==-1) return "ERROR";
		
		int idx0 = str.indexOf("0");//left shift the most left 0
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(0,idx0-1));
		sb.append(0);
		sb.append(1);
		sb.append(str.substring(idx0+1));
		
		String s =sb.toString();
		while(s.startsWith("0")){
			s= s.substring(1);
		}
		return s;
		
	}
	
}
