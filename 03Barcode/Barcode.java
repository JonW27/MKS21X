public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
    if(zip.length() != 5){
      System.out.println("Zip is not the correct length");
    }
    else{
      try{
        _zip = zip;
        _checkDigit = checkSum()%10;
      }
      finally{
        System.out.println("Zip contains a nondigit");
      }
    }
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
    Barcode a = new Barcode(_zip);
    return a;
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
    int python = 0;
    for(int i = 0; i < _zip.length(); i++){
      python += Character.getNumericValue(_zip.charAt(i));
    }
    return python;
  }

//postcondition: format zip + check digit + Barcode
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
  public String toString(){
    String jo = "|";
    for(int i = 0; i < _zip.length(); i++){
      switch(_zip.charAt(i)){
        case 0:
          jo += "||:::";
          break;
        case 1:
          jo += ":::||";
          break;
        case 2:
          jo += "::|:|";
          break;
        case 3:
          jo += "::||:";
          break;
        case 4:
          jo += ":|::|";
          break;
        case 5:
          jo += ":|:|:";
          break;
        case 6:
          jo += ":||::";
          break;
        case 7:
          jo += "|:::|";
          break;
        case 8:
          jo += "|::|:";
          break;
        case 9:
          jo += "|:|::";
          break;
      }
    }
    jo = jo + _checkDigit + "|";
    return jo;
  }


// postcondition: compares the zip + checkdigit, in numerical order.
  public int compareTo(Barcode other){
    for(int i = 0; i<_zip.length(); i++){//bar code lengths should be same length so _zip length is fine
      if(_zip.charAt(i) != other._zip.charAt(i)){
        return _zip.compareTo(other._zip);
      }
    }
    if(_checkDigit > other._checkDigit){
      return 1;
    }
    else if(_checkDigit < other._checkDigit){
      return -1;
    }
    else{
      return 0;
    }
  }

}
