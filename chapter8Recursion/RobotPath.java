package chapter8Recursion;

public class RobotPath {
	public int count;
	public static void main(String[] args) {
		RobotPath rp = new RobotPath();
		rp.count =0;
		rp.calculatePath(1, 1, 3);
		System.out.println(rp.count);
	}
	
	public void calculatePath(int right, int down,int n){
		if(right == n&&down == n) {
			count++;
		}
		else if(right<=n&&down<=n){
			calculatePath(right+1,down,n);
			calculatePath(right,down+1,n);
		}
		
	}
}
