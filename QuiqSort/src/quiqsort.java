
public class quiqsort {
	
	public static void main(String[] args) {
		
		int arr [] = new int [5];
		
		// randomize array
		int i = 0;
		while (i < arr.length) {
			arr[i] = (int) (Math.random()*100+1);
			i++;
		}
		
		showArray(arr);
		quickSort(arr, 0, arr.length-1);
		System.out.println();
		//showArray(arr);
		
	}
	
	public static void quickSort(int arr[],int left, int right) {
		int i = left;
		int j = right;
		
		int index = partition(arr, i, j);
		if(i < index-1) quickSort(arr, i, index-1);
		if(index < j) quickSort(arr, index, j);
			
	}
	
	public static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2];
		int i = left;
		int j = right;
		int temp;
		
		while(i<=j) {
			while(arr[i]<pivot) i ++;
			while(arr[j]>pivot) j--;
			
			if(i<=j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}
			System.out.println();
			showArray(arr);
		}
		return i;
	}

	public static void showArray(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			System.out.print(arr[i] + " ");
			i++;
		}
	}
}
