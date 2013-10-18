/**
 *
 * @author zhouhao
 */
public class Sort {
	
	public static void bubbleSort(float[] array){
		int length = array.length;
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length - i-1; j++){
				if(array[j+1] > array[j]){
					float tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}

		for(int i = 0; i < length; i++){
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	
	}
	
	public static void selectionSort(float[] array){
		int length = array.length;
		for(int i = 0; i < length; i++){
			int k = i;
			for(int j = i+1; j < length; j++){
				if(array[k] > array[j]){
					k = j;
				}
			}
			if(k != i){
				float tmp = array[i];
				array[i] = array[k];
				array[k] = tmp;
			}
			
		}

		for(int i = 0; i < length; i++){
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	
	}
	
	public static void mergeSort(float[] array, int low, int high){
		//float[] helper = new float[array.length];
		if(low < high){
			int middle = (low + high)/2;
			mergeSort(array, low, middle);
			mergeSort(array, middle+1, high);
			merge(array, low, middle, high);
		}

		// output the sorted result
		if(low == 0 && high == array.length-1){
			for(int i = 0; i < array.length; i++){
				System.out.print(array[i] + "  ");
			}
			System.out.println();
		}

	}
	
	public static void merge(float[] array, int low, int middle, int high){
		float[] tmp = new float[array.length];
		for(int i = low; i <= high; i++){
			tmp[i] = array[i];
		}

		int left = low;
		int right = middle+1;
		int current = low;

		while(left <= middle && right <= high){
			if(tmp[left] < tmp[right]){
				array[current++] = tmp[left];
				left++;
			} else {
				array[current++] = tmp[right];
				right++;
			}
		}

		// if there are still some nodes in [left ~ middle]
		int remain = middle - left;
		for(int i = 0; i < remain; i++){
			array[current+i] = tmp[left+i];
		}
	}


	public static void quickSort(float[] array, int left, int right){
		int index = partition(array, left, right);
		if(left < index-1){
			quickSort(array, left, index-1);
		}
		if(index < right){
			quickSort(array, index, right);
		}

		if(left == 0 && right == array.length-1){
			for(int i = 0; i < array.length; i++){
				System.out.print(array[i] + "  ");
			}
			System.out.println();
		}
	}

	public static int partition(float[] array, int left, int right){
		float pivot = array[(left+right)/2];
		while(left <= right){
			while(array[left] < pivot) left++;
			while(array[right] > pivot) right--;
			if(left <= right){
				float tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				left++;
				right--;
			}

		}
		return left;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	// TODO code application logic here
		float[] array = new float[]{1, 2, 2.3f, 1.6f, 0.3f, 67,20, 12.4f};
		bubbleSort(array);
		selectionSort(array);
		mergeSort(array, 0, array.length-1);
		quickSort(array, 0, array.length-1);
	}
}
