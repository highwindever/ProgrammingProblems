package chapter8Recursion;




public class PlaceQueens {
	public static void main(String[] args){
		PlaceQueens pq=new PlaceQueens();
		pq.placeQueen(0);
	}
	
	int columnForRow[] = new int[8];
	boolean check(int row){
		for(int i=0;i<row;i++){
			int diff = Math.abs(columnForRow[i]-columnForRow[row]);
			if(diff==0||diff==row-i) return false;
		}
		
		return true;
	}

	void placeQueen(int row){
		if(row==8){
			for(int i:columnForRow){
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<8;i++){
			columnForRow[row]=i;
			if(check(row)){
				placeQueen(row+1);
			}
		}
	}
		
	
	
	
	
}
