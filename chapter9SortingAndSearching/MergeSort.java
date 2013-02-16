package chapter9SortingAndSearching;

public class MergeSort {
	public static void main(String[] args){
		int[] a = {1,9,3,8,5,7,10,2};
		a= mergeSort(a,0,a.length-1);
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	public static int[] mergeSort(int[] arr, int low, int high){
		if(low==high) {
			int[] a = {arr[low]};
			return a;
		}
				
		int mid = (low+high)/2;
		int[] left = mergeSort(arr,low ,mid);
		int[] right = mergeSort(arr,mid+1,high);
		int[] merge = new int[left.length+right.length];
		int l=0;
		int r=0;
		for(int i=0;i<merge.length;i++){
			if (l < left.length && r < right.length) {

				if (left[l] <= right[r]) {
					merge[i] = left[l++];					
				} else {
					merge[i] = right[r++];					
				}
			}
			else if(l==left.length){
				merge[i] = right[r++];
			}
			else if(r==right.length){
				merge[i] = left[l++];
			}
			
			
		}
		
		return merge;
		
		
		
	}
}
