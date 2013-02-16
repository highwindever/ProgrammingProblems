package chapter8Recursion;

public class Fibonacci {
	public static void main (String[] args){
		Fibonacci fb = new Fibonacci();
		System.out.println(fb.fn(3));
		System.out.println(fb.iterativeFn(3));
	}
	
	public int fn(int n){
		if(n==0) return 0;
		else if(n==1) return 1;
		else return fn(n-1)+fn(n-2);
	}
	
	public int iterativeFn(int n){
		if(n==0) return 0;
		else if(n==1) return 1;
		else{
			int n1=0;
			int n2=1;
			int temp;
			for(int i=1;i<n;i++){
				temp = n2;
				n2 = n1 + n2;
				n1 = temp;
			}
			return n2;
		}
	}
}
