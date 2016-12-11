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
      throw new IllegalArgumentException("Zip is not the correct length");
    }
    else{
      try{
        Integer.parseInt(_zip);
        _zip = zip;
        _checkDigit = checkSum(_zip)%10;
      }
      catch(NumberFormatException e){
        throw new IllegalArgumentException("Zip contains a nondigit");
      }
    }
  }

// postcondition: computes and returns the check sum for _zip
  private static int checkSum(String zip){
    int python = 0;
    for(int i = 0; i < zip.length(); i++){
      python += Character.getNumericValue(zip.charAt(i));
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
    return (_zip+_checkDigit).compareTo(other._zip+other._checkDigit);
  }
  public static String toZip(String code){
    if(code.length() != 32){
      throw new IllegalArgumentException("Your length is wrong.");
    }
    else if(code.charAt(0) != '|' || code.charAt(code.length()-1) != '|'){
      throw new IllegalArgumentException("Barcode does not start with and end with |");
    }
    String jo = "";
      for(int i = 0; i < 5; i++){
        switch(code.substring(5*i+1, 5*i+6)){
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
          default:
            throw new IllegalArgumentException("Your barcode is messed up in that it has parts that do not correspond to digits.");
        }
      }
      if(checkSum(jo.substring(4)) != Integer.parseInt(jo.substring(4))){
        throw new IllegalArgumentException("The checksum is not correct.");
      }
      return jo;
  }

  public static String toCode(String zip){
    if(zip.length() != 5){
      throw new IllegalArgumentException("Your zip code's length is not 5");
    }
    String jo = "|";
    String lol = zip + checkSum(zip);
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
        default:
          throw new IllegalArgumentException("Your zipcode contains non-numeric characters.");
      }
    }
    jo += "|";
    return jo;
  }
}
