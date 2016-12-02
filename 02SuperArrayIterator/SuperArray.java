//Jonathan Wong hackthe.tech
// This is copyrighted code. All rights are reserved. Any attempt to redistribute this code without prior permission or any attempt to gain commercial value of this software is prohibited. Removal of this notice is also strictly prohibited.
// You may execute this program, however, this may be revoked if you share this with another person.
// jk -> GPLv3
import java.util.Iterator;
public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;

  //0
  //constructor make an empty superArray should make size 0,
  //but the data capacity 10.
  public SuperArray(){
      size = 0;
      data = new String[10];
  }

  public SuperArray(int initialCapacity){
      if(initialCapacity >= 0){
          size = initialCapacity;
          data = new String[initialCapacity];
      }
      else{
        throw new IllegalArgumentException();
      }
  }

  public int size(){
    return size;
  }

  /*public void incSize(){
    size += 1; // this is needed or else add in OrderedSuperArray fails to order.
  }

  public void decSize(){
    size -= 1; // this is needed or else add in OrderedSuperArray fails to order.
  }*/

  public String get(int index){
      if(constrain(index)){
          String temp = data[index];
          return temp;
      }
      throw new IndexOutOfBoundsException();
  }

  public boolean isEmpty(){
      return size == 0;
  }

  public String[] toArray(){
      String[] temp = new String[size];
      for(int i = 0; i < size; i++){
          temp[i] = data[i];
      }
      return temp;
  }

  public int indexOf(String index){
      for(int i = 0; i < size; i++){
          if(data[i] == index){
              return i;
          }
      }
      return -1;
  }

  public int lastIndexOf(String index){
      for(int i = size-1; i > 0; i--){
          if(data[i] == index){
              return i;
          }
      }
      return -1;
  }

  //1
/**add the value n to the next available slot in the superArray.
 *this will change the size. This function should always work
 *And will resize the SuperArray if needed./*
  public void add(int n){
  }**/
  public void clear(){
     size = 0;
  }

  public String set(int index, String element){
      if(constrain(index)){
          String temp = data[index];
          data[index] = element;
          return temp;
      }
      // warning! user's own fault if they step out of constraints... mwahaha
      throw new IndexOutOfBoundsException();
  }

  public void add(int index, String element){
      size++;
      if(size > data.length){
              grow();
      }
      if(constrain(index)){ // your fault if you go over the bounds and try to cause an exception
          String[]temp = new String[data.length];
          for(int i = 0; i < size; i++){
             if(i < index){
                 temp[i] = data[i];
             }
             else if(i == index){
                 temp[index] = element;
             }
             else{
                 temp[i] = data[i-1];
             }
          }
          data = temp;
      }
      else {
        size--;
        throw new IndexOutOfBoundsException();
      }
  }

  public boolean add(String n){
      size++;
      if(size > data.length){
          grow();
      }
      data[size-1] = n;
      return true;
  }

  public String remove(int index){
      if(constrain(index)){
          String element = "";
          size--;
          String[]temp = new String[size];
          for(int i = 0; i < size; i++){
              if(i < index){
                 temp[i] = data[i];
              }
              else{
                 if(index == i){
                     element = data[i];
                 }
                 temp[i] = data[i+1];
              }
          }
          data = temp;
          return element;
      }
      throw new IndexOutOfBoundsException();
  }

  public void trimToSize(){
      String[]temp = new String[size];
      for(int i = 0; i < size; i++){
          temp[i] = data[i];
      }
      data = temp;
  }

  //2
/**Resize the data, by making a new array, then copying over elements, use this as your data.
*/

  private void grow(){
    String[] temp = new String[size*2];
    for(int i = 0; i < data.length; i++){
        temp[i] = data[i];
    }
    data = temp;
  }

    // BEGIN HELPER FXNS
    public boolean constrain(int param){
        return param >= 0 && param < size;
    }
    // END HELPER FXNS

  //3
   /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5]
    *commas between... square bracket start/end and no comma at end.*/
  public String toString(){
      String result = "[";
      for(int i = 0; i < size; i++){
          if(i == size - 1){
              if(size != 1){
                  result += " ";
              }
              result += data[i];
          }
          else{
              result = result + " " + data[i] + ",";
          }
      }
      return result+"]";
  }


  //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]
    *(capacity is 10, but only 6 are used)
    *commas between... square bracket start/end and no comma at end.
    *unused slots should be printed as _ (underscores) */
  public String toStringDebug(){
      String result = "[ ";
      for(int i = 0; i < data.length; i++){
          if(i > size){
              result += " _";
              if(i != data.length - 1){
                  result += ",";
              }
          }
          else{
                  result = result + " " + data[i] + ",";
          }
      }
      return result+"]";
  }

  public Iterator<String> iterator(){
    return new SuperArrayIterator(this);
  }
}
