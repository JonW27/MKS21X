public class Barcode implements Comparable<Barcode>{
// instance variables
   /*Map kek = new HashMap();
   kek.put("0", "||:::");
   kek.put("1", ":::||");
   kek.put("2", "::|:|");
   kek.put("3", "::||:");
   kek.put("4", ":|::|");
   kek.put("5", ":|:|:");
   kek.put("6", ":||::");
   kek.put("7", "|:::|");
   kek.put("8", "|::|:");
   kek.put("9", "|:|::");*/
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
      catch(NumberFormatException e){
        System.out.println("Zip contains a nondigit");
      }
    }
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
    String lol = _zip + _checkDigit;
    for(int i = 0; i < lol.length(); i++){
      switch(Character.getNumericValue(lol.charAt(i))){
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
    jo += "|";
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
  public static String toZip(String code){
    String jo = "";
    try{
      for(int i = 0; i < 5; i++){
        switch(code.substring(5*i+1, 5*i+7)){
          case "||:::":
            jo += 0;
            break;
          case ":::||":
            jo += 1;
            break;
          case "::|:|":
            jo += 2;
            break;
          case "::||:":
            jo += 3;
            break;
          case ":|::|":
            jo += 4;
            break;
          case ":|:|:":
            jo += 5;
            break;
          case ":||::":
            jo += 6;
            break;
          case "|:::|":
            jo += 7;
            break;
          case "|::|:":
            jo += 8;
            break;
          case "|:|::":
            jo += 9;
            break;
        }
      }
      return jo;
    }
    catch(IllegalArgumentException e){
      throw new IllegalArgumentException("Either your legth is wrong, you used an invalid set of symbols, had a bad checksum, sidebar is messed up, or had invalid characters. Good work man (Y)");
    }
  }

  public static String toCode(String zip){
    String jo = "|";
    int fix = 0;
    for(int i = 0; i < zip.length(); i++){
      fix += Character.getNumericValue(zip.charAt(i));
    }
    fix = fix % 10;
    String lol = zip + fix;
    for(int i = 0; i < lol.length(); i++){
      switch(Character.getNumericValue(lol.charAt(i))){
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
    jo += "|";
    return jo;
  }
}
