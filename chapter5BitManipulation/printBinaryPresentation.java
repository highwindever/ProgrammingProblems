package chapter5BitManipulation;

public class printBinaryPresentation {
	public static void main (String[] args){
		printB("6.75");
	}
	
	public static void printB(String str){
		double num = Double.parseDouble(str);		
		int left = (int) num;
		double right = num-left;
		StringBuilder sb = new StringBuilder();
		while(left>0){
			sb.insert(0, left%2);
			left /=2;
		}
		
		if(right > 0){
			sb.append(".");
			int count =0;
			while(count<32){
				if (right*2>1) {
					sb.append(1);
					right = right*2-1;
				}else if(right*2==1){
					sb.append(1);
					break;
				}else {
					sb.append(0);
					right *=2;
				}
				count++;
			}
			if(count==32) {
				System.out.println("ERROR");
				return;
			}
		}
		
	   System.out.print(sb);
	}
}
