package chapter5BitManipulation;

public class SetBitNM {
	public static void main(String[] args){
		//System.out.println(Integer.toBinaryString(1<<2-1));
		//System.out.println(Integer.toBinaryString(21));
		System.out.println(Integer.toBinaryString(setBit(2048, 21, 2, 6)));
	}
	
	
	public static int setBit(int N, int M, int i, int j){
		int max =~0;
		int left = max-((1<<j)-1);
		int right = (1<<i)-1;
		int mask = right |left;
		return mask & N |(M<<i);
		
	}
	
	
	

}
