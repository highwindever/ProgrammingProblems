package chapter9SortingAndSearching;

public class SearchInSortedMatrix {
	public static void main(String[] args){
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		findX(a,6);

	}
	
	//O(lg(M*N))
	public static void findX(int[][] a, int x){
		if(a==null) System.out.println("The input matrix is null.");
		int[] b = new int[a.length*a[0].length];
		int k=0;
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++){
				b[k++] = a[i][j];
			}
		int idx = binarySearch(b,0,b.length-1,x);
		if(idx==-1) System.out.println("Can't find number "+ x +" int the matix.");
		else{
			int m = idx/a[0].length;
			int n = idx%a[0].length;
			System.out.println("The position of number "+x+" is at ["+m+"]["+n+"].");
		}
	}
	
	public static int binarySearch(int[] b, int low, int high, int x){
		if(b==null||b.length==0) return -1;
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(x==b[mid]) return mid;
		else if(x<b[mid]) return binarySearch(b, low, mid-1, x);
		else return binarySearch(b, mid+1, high, x);
	}
	
	//Solution from the book. O(M+N)
	boolean FindElem(int[][] mat, int elem, int M, int N) {
		int row = 0;
		int col = N - 1;
		while (row < M && col >= 0) {
			if (mat[row][col] == elem) {
				return true;
			} else if (mat[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	

	
}
