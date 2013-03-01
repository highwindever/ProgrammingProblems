package chapter5BitManipulation;

public class SwapOddAndEvenBits {
	public static void main(String[] args){
		int a = 19;
		int b = swapBits(a);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
	}
	
	public static int swapBits(int a){
		return (((a&0xaaaaaaaa)>>1)|((a&0x55555555)<<1));
	}
}
