public class Driver{
	public static void main(String[] args){
		Barcode a = new Barcode("10282");
		System.out.println(a);
		Barcode b = new Barcode("13111");
		System.out.println(a.compareTo(b));
	}
}
