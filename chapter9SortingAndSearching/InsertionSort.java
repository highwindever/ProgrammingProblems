package chapter9SortingAndSearching;

public class InsertionSort {
	public static void main(String[] args){
		int[] a = {1,9,3,8,5,7,10,2};
		a= insertionSort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	
	public static int[] insertionSort(int[] arr){
        int temp=0;
        int index =0;
		for(int i=1;i<=arr.length-1;i++){
			index=i;
			for(int j=i-1;j>=0;j--){
				if(arr[index]<arr[j]){
					temp = arr[index];
					arr[index]=arr[j];
					arr[j] =temp;
					index =j;
				}
			}

		}
		return arr;
	}
}
