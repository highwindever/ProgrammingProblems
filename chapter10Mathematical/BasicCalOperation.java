//not so good

package chapter10Mathematical;

public class BasicCalOperation {
	public static void main(String[] args){
		int a=0;
		int b=-2;
		System.out.println(multiply(a, b));
		System.out.println(substract(a, b));
	}
	
	
	static int multiply(int a, int b){
		int sum =0;
		int flag=1;
		if(a==0||b==0) return 0;
		if(a>0&&b<0){
			b=-b;
			flag=-1;
		}else if(a<0&&b>0){
			a=-a;
			flag=-1;
		}else if(a<0&&b<0){
			a=-a;
			b=-b;
		}
		
		while(b>0){
			sum +=a;
			b--;
		}
	
		if(flag==1) return sum;
		else return -sum;
		
		
		
	}
	
	
	static int substract(int a, int b) throws java.lang.ArithmeticException{
		return a+multiply(-1, b);
	}
	
	static int divide(int a, int b){
		if(b==0) {throw new java.lang.ArithmeticException("Divide by 0.");}
		
		if(abs(a)<abs(b)) return 0;
		int count=0;
		a=abs(a);
		b=abs(b);
		while(a>=b){
			a=a-b;
			count++;
		}
		if(a<0&&b>0||a>0&&b<0) count = -count;
		return count;
		
	}
	
	static int abs(int a){
		if(a>=0) return a;
		else return multiply(a,-1);
	}
}
