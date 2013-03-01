package chapter5BitManipulation;

import java.util.ArrayList;

public class FindMissingNumber {
	public static void main(String[] args){
		FindMissingNumber fmn = new FindMissingNumber();
		fmn.arr = new ArrayList<BitInteger>();
		int max = fmn.generateArray(20);
		int num = fmn.findMissingNum(fmn.arr, 00, max);
		System.out.println(num);
//		for(BitInteger b: fmn.arr){
//			for(int i:b.bits) System.out.print(i+" ");
//			System.out.println();
//		}
		
	}
	
	
	public class BitInteger{
		int[] bits;
		
		public BitInteger(int n){
			String str =Integer.toBinaryString(n);

			bits =new int[str.length()];
			for(int i=0;i<bits.length;i++){
				bits[i] = Integer.parseInt(String.valueOf(str.charAt(str.length()-1-i)));
			}			
		}
		
		public int fetch(int idx){
			if (idx>=bits.length) return 0;
			return bits[idx];
		}
		
	}
	
	ArrayList<BitInteger> arr;
	public int generateArray(int n){
		int max =0;
		int m = (int)(Math.random()*n);
		System.out.println(m);
		for(int i=0;i<n;i++){
			if(i==m) continue;
			BitInteger b = new BitInteger(i);
			arr.add(b);
			if(b.bits.length>max) max=b.bits.length;
			
		}
		return max;
	}
	
	
	public int findMissingNum (ArrayList<BitInteger> arr, int column,int max){
		if(column>=max) return 0;
		ArrayList<BitInteger> evenArr = new ArrayList<BitInteger>();
		ArrayList<BitInteger> oddArr = new ArrayList<BitInteger>();
		
		for(BitInteger b:arr){
			if(b.fetch(column)==0) evenArr.add(b);
			else oddArr.add(b);
		}
		if(evenArr.size()>oddArr.size()){
			return (findMissingNum(oddArr, column+1,max)<<1)|1;
		}else return (findMissingNum(evenArr, column+1,max)<<1)|0;
		
	}
	
}
