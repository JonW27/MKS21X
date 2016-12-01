class ReferenceBook extends LibraryBook{
  String collection;

  public ReferenceBook(String author, String title, String ISBN, String call, String collection){
    super(author, title, ISBN, call);
    this.collection = collection;
  }
  public String getCollection(){
    return collection;
  }
  public void setCollection(String collection){
    this.collection = collection;
  }
  public void checkout(String patron, String due){
    System.out.println("Cannot check out a reference book.");
  }
  public void returned(){
    System.out.println("Reference book could not have been checked out");
  }
  public String circulationStatus(){
    return "Non-circulating reference book";
  }
  public String toString(){
    return super.toString() + ", " + collection;
  }
}
