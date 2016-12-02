import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  SuperArray flattered;
  int element = 0;
  public SuperArrayIterator(SuperArray in){
    flattered = in;
  }
  public String next(){
    if(hasNext()) return flattered.get(element++);
  }
  public boolean hasNext(){
    return element < flattered.size();
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }
}
