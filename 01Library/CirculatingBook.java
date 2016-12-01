class CirculatingBook extends LibraryBook{
  String currentHolder;
  String dueDate;

  public CirculatingBook(String author, String title, String ISBN, String call){
    super(author, title, ISBN, call);
    currentHolder = null;
    dueDate = null;
  }
  private String getCurrentHolder(){
    return currentHolder;
  }
  private void setCurrentHolder(String holder){
    currentHolder = holder;
  }
  private String getDueDate(){
    return dueDate;
  }
  private void setDueDate(String newDate){
    dueDate = newDate;
  }
  public void checkout(String patron, String dueDate){
    currentHolder = patron;
    this.dueDate = dueDate;
  }
  public void returned(){
    currentHolder = null;
    dueDate = null;
  }
  public String circulationStatus(){
    if(getDueDate() == null && getCurrentHolder() == null){
      return "book available on shelves";
    }
    else{
      return getCurrentHolder() + ", " + getDueDate();
    }
  }
  public String toString(){
    String rise = "";
    if(circulationStatus().equals("book available on shelves")){
      rise = circulationStatus();
    }
    return super.toString() + ", "+ rise;
  }
}
