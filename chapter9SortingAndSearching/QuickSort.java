package chapter9SortingAndSearching;



public class QuickSort {
	public static void main(String[] args){
		int[] a = {1,9,8,3,10,2,4};
		quickSort(a,0,a.length-1);
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	public static int partition(int[] arr,int low,int high,int ranidx){
		
		int storeidx=low;
		int temp = arr[ranidx];
		arr[ranidx]=arr[high];
		arr[high]=temp;
		for(int i=low;i<high;i++){
			if(arr[i]<temp){
				int t=arr[storeidx];
				arr[storeidx]=arr[i];
				arr[i]=t;
				storeidx++;
			}
		}
		arr[high]=arr[storeidx];
		arr[storeidx]=temp;
		return storeidx;		
	}
	
	
	public static void quickSort(int[] arr,int low, int high){
		if(low<high){
			int ranidx =(int)(Math.random()*(high-low)+low); 
			int NewRanidx = partition(arr, low, high, ranidx);
			quickSort(arr,low,NewRanidx-1);
			quickSort(arr,NewRanidx+1,high);
		}
	}
}
