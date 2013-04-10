package chapter5BitManipulation;

public class Count1Bits {
	public static void main(String[] args){
		int n=(int)(Math.random()*20);
		System.out.println(Integer.toBinaryString(n));
		
		int count =0;
		while(n>0){
			if((n&1)>0) count++;
			n= n>>1;
		}
		
		System.out.println(count);		
	}
}
