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
	  int temp = 0;
	  if(check < data[i-1]){
	      int temp2 = check;
	      int temp3 = temp2;
	      for(int k = 0; k < i; k++){
		  temp3 = data[k];
		  data[k] = temp2;
		  temp2 = temp3;
	      }
	  }
      }
  }
  public static void main(String[] args){
	  int[] lol = {233, 34, 43, -3, 0, 4, 67};
	  System.out.println("What it should be"+Arrays.toString(Arrays.Sort(lol)));
	  insertionSort(lol);
	  System.out.println(Arrays.toString(lol));
  }

}
