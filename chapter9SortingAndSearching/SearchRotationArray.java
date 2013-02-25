package chapter9SortingAndSearching;

public class SearchRotationArray {
	public static void main(String[] args){
		int[] arr ={15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(searchInt(arr, 0, arr.length-1, 5));
	}
	
	public static int searchInt(int[] arr,int low,int high,int x){
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(x==arr[mid]) return mid;
		if(arr[mid]>=arr[low]&&arr[mid]>=arr[high]){
			if(x>=arr[low]&&x<arr[mid]) return searchInt(arr,low,mid-1,x);//could replace this with binarySearch
			else return searchInt(arr,mid,high,x);
		}else {
			if(x>arr[mid]&&x<=arr[high]) return searchInt(arr,mid+1,high,x);//could replace this with binarySearch
			else return searchInt(arr,low,mid,x);
				}
	}
	
	
	public static int binarySearch(int[] arr, int low, int high, int x){
		if(low>high) return -1;
		int mid =(low+high)/2;
		if(arr[mid]==x) return mid;
		if(x>arr[mid]) return binarySearch(arr, mid+1, high, x);
		else return binarySearch(arr, low, mid-1, x);
	}
}
