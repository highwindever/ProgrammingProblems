package chapter9SortingAndSearching;

public class BubbleSort {
	public static void main(String[] args){
		int[] a = {1,9,3,8,5,7,10,2};
		a= bubbleSort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
		
	}
	
	
	public static int[] bubbleSort(int[] arr){
		int temp=0;
		for(int i=arr.length-2;i>=1;i--)
			for(int j=0;j<=i;j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		return arr;
		
	}
}
