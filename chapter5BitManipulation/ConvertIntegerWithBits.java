/*
 * Test Case
 * 1111(15) 10(2)
 * 1010(10) 10(2)
 * 111(7) 0
 */





package chapter5BitManipulation;

import chapter5BitManipulation.printBinaryPresentation;

public class ConvertIntegerWithBits {
	public static void main (String[] args){
		int a =7;
		int b =0;

		printBinaryPresentation.printB(String.valueOf(a));
		printBinaryPresentation.printB(String.valueOf(b));
		
		System.out.println(bitsRequired(a, b));
		System.out.println(bitsRequiredUsingXor(a, b));
	}
	
	public static int bitsRequired(int a, int b){
		if(a==b) return 0;
		String str1 = Integer.toBinaryString(a>b?a:b);
		String str2 = Integer.toBinaryString(a<b?a:b);
		
		int len1 = str1.length();
		int len2 = str2.length();
		int n=0;
		for(int i=0;i<len2;i++){
			if(str1.charAt(len1-1-i)!=str2.charAt(len2-1-i))
				n++;
		}
		
		for(int i=0;i<(len1-len2);i++){
			if(str1.charAt(i)=='1')
				n++;
		}
		
		return n;
	}
	
	public static int bitsRequiredUsingXor(int a, int b){
		int count =0;
		for(int c= a^b; c!=0;c=c>>1){
			count +=c&1;
		}
		return count;
	}
}
