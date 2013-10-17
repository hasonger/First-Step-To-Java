/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author zhouhao
 */
public class Sort {
    
    public static void bubbleSort(float[] array){
        int length = array.length;
        for(int i = 0; i < length; i++){
            for(int j = 1; j < length - i; j++){
                if(array[i]> array[j]){
                    
                }
            }
        }
        
    }
    
    public static void slectionSort(){
        
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
    }
}
