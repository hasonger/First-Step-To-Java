public class Search{

	public static int binarySearch(int[] array, int numberToBeFound){
		int left = 0;
		int right = array.length-1;
		int middle;
		while(left <= right){
			middle = (left+right)/2;
			if(array[middle] == numberToBeFound){
				return middle;
			}
			else if(array[middle] > numberToBeFound){
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}
		return -1;
	}
	public static void main(String argv[]){
		int[] array = new int[]{0, 1, 2, 13, 23, 71, 120, 433, 899};
		int returnValue = binarySearch(array, 721);
		if( returnValue == -1){
			System.out.println("No such number found in the array!");
		} else {
			System.out.println("The number is found of index = " + returnValue);
		}
	}
}