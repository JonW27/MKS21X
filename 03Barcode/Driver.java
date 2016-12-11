public class Driver{
	public static void main(String[] args){
		Barcode a = new Barcode("108a2");
		System.out.println(a);
		Barcode b = new Barcode("13111");
		System.out.println(a.compareTo(b));
		Barcode c = new Barcode("08451");
		System.out.println(c.toString().compareTo("|||:::|::|::|::|:|:|::::|||::|:|"));
		System.out.println(Barcode.toCode("00000"));
		System.out.println(Barcode.toCode("08451"));
		System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
		System.out.println(Barcode.toCode("0a451"));
		//System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
		//System.out.println(Barcode.toZip("|||:::|:|::||:|:|::::||:|:|"));
	}
}
