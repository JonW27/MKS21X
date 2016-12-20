import java.util.Arrays;
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME
  */
  public static String name(){
    return "09.Wong.Jonathan";
  }

  /**Selection sort of an int array.
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      int indice = 0;
      for(int i = 0; i < data.length; i++){
      int smallest = data[i];
          for(int j = 0; j < data.length - i; j++){
              if(data[i+j] < smallest){
                smallest = data[i+j];
                indice = i + j;
              }
          }
          data[indice] = data[i];
          data[i] = smallest;
      }
  }
  public static void insertionSort(int[] data){
      for(int i = 1; i < data.length; i++){
      	  int check = data[i];
      	  if(check < data[i-1]){
      	      int temp = check;
              int temp2;
      	      for(int k = 0; k < i+1; k++){
                if(check < data[k] || k == i){
                  temp2 = data[k];
            		  data[k] = temp;
                  temp = temp2;
                }
      	      }
      	  }
      }
  }
  public static void bubbleSort(int[] data){
    for(int i = 0; i < data.length; i++){
      for(int j = 0; j < data.length - i - 1; j++){
        int temp = 0;
        if(data[j+1] < data[j]){
          temp = data[j+1];
          data[j+1] = data[j];
          data[j] = temp;
        }
      }
    }
  }
  public static void main(String[] args){
	  int[] lol = {233, 34, 43, 11, -3, 0, 23, 36, 4, 67};
    int[] ideal = new int[lol.length];
    System.arraycopy(lol,0,ideal,0,lol.length);
    Arrays.sort(ideal);
	  System.out.println("What it should be:\n"+Arrays.toString(ideal)+"\nWhat it is:");
	  bubbleSort(lol);
	  System.out.println(Arrays.toString(lol));
  }

}
