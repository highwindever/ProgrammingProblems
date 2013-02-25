package chapter9SortingAndSearching;

public class SearchStringsWithEmptyOnes {
	
	public static void main(String[] args){
		String[] strArr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		
		System.out.println(binarySearchStr(strArr, "ballcar", 0, strArr.length-1));
	}
	

	
	public static int binarySearchStr(String[] strArr, String str, int low, int high){
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(strArr[mid].equals(str)) return mid;
		else if(strArr[mid].equals("")){
			int temp = mid;
			while(mid<=high){
				if(strArr[mid].equals("")) mid++;
				else if (strArr[mid].equals(str)) return mid;
				else if(strArr[mid].compareTo(str)>0) return binarySearchStr(strArr, str, low, mid-1);
				else return binarySearchStr(strArr, str, mid+1, high);
			}
			
			while(temp>=low){
				if(strArr[temp].equals("")) temp--;
				else if (strArr[temp].equals(str)) return temp;
				else if(strArr[temp].compareTo(str)>0) return binarySearchStr(strArr, str, low, temp-1);
				else return binarySearchStr(strArr, str, temp+1, high);
			}
			
			return -1;
		}
		
		else if(strArr[mid].compareTo(str)>0) return binarySearchStr(strArr, str, low, mid-1);
		else return binarySearchStr(strArr, str, mid+1, high);
	}
	
	
}
