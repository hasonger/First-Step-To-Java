/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package sort;

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
	
	public static void mergeSort(){
	
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	// TODO code application logic here
		float[] array = new float[]{1, 2, 2.3f, 1.6f, 0.3f, 67,20, 12.4f};
		bubbleSort(array);
		selectionSort(array);
	}
}
