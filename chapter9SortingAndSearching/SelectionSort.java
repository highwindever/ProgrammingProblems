package chapter9SortingAndSearching;

public class SelectionSort {
	public static void main (String[] args){
		int[] a = {1,9,3,8,5,7,10,2};
		a= selectionSort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	public static int[] selectionSort(int[] arr){

		int index;
		int temp;
		for(int i=0;i<arr.length-1;i++){
			index=i;
			for(int j=i;j<arr.length;j++){
				if(arr[j]<arr[index]){
					index=j;
				}
			}
			temp = arr[index];
			arr[index] =arr[i];
			arr[i] = temp;
			
		}
		
		return arr;
	}
}
