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
  public static void main(String[] args){
	  int[] lol = {233, 34, 43, -3, 0, 4, 67};
	  selectionSort(lol);
	  System.out.println(Arrays.toString(lol));
  }

}
