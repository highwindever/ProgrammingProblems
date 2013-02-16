package chapter1ArraysAndStrings;

import java.util.HashSet;


public class MatrixSetZero {
	public static void main(String[] args){
		int[][] matrix = {{1,2,3},{4,0,6}};
		matrix = MatrixSetZero.setZero(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] setZero (int[][] matrix) {
		HashSet<Integer> row = new HashSet<Integer>();
		HashSet<Integer> col = new HashSet<Integer>();
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==0) {
					row.add(i);
					col.add(j);
				}
			}
		
		for(int i=0;i<matrix.length;i++){
			if(!row.add(i)) 
				for(int j=0;j<matrix[i].length;j++){
					matrix[i][j] = 0;
				}				
		}
		
		for(int j=0;j<matrix[0].length;j++){
			if(!col.add(j))
				for(int i=0;i<matrix.length;i++){
					matrix[i][j] = 0;
				}
		}

		
		return matrix;
	}
}
