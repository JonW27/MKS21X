abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    String callNumber;

    public LibraryBook(String author, String title, String ISBN, String call){
    	this.author = author;
    	this.title = title;
    	this.ISBN = ISBN;
    	callNumber = call;
    }
    public String getCall(){
    	return callNumber;
    }
    public void setCall(String call){
    	callNumber = call;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public int compareTo(LibraryBook uganda){
    	return getCall().compareTo(uganda.getCall());
    	// im smart - this works since its string params
    }
    public String toString(){
      return super.toString() + ", " + circulationStatus() + ", " + callNumber;
    }

}
