package ThirdPackage;

public class Book extends Library{

    //Attributes
    int numberPages;
    String idBook="B";
    int numberOfBooks=0;

    //Getter :
    public int getNumberPages() {
        return numberPages;
    }
    public String getIdBook() {
        return idBook;
    }
    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    //Setter :
    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
    public void setNumberOfBooks() {
        this.numberOfBooks=numberOfBooks;
    }
    // Parametrized Constructor:
    public Book(int numberPages, String name, String author, int yearPublication) {
        this.numberPages = numberPages;
        super.setName(name);
        super.setAuthor(author);
        super.setYearPublication(yearPublication);
        numberOfBooks++;
        this.idBook = idBook+numberOfBooks;
    }
    //Default Constructor:
    public Book(){
        super();
        this.numberPages=0;
        numberOfBooks++;
        this.idBook=idBook+numberOfBooks;
    }
    // Copy Constructor:
    public Book(Book book){
        super(book);
        this.numberPages=book.getNumberPages();
        this.idBook=book.getIdBook();
        numberOfBooks++;
        this.idBook=idBook+numberOfBooks;
    }

    //toString() Method
    public String toString() {
        return ("\nBook's ID: " + idBook+
                "\n" + super.toString() +
                "\nNumber  of pages: " + numberPages);
    }

    //equals() Method
    public boolean equals(Book book){
        if(numberPages==book.getNumberPages()&&idBook==book.getIdBook()){
            return true;
        }else{return false;}
    }
}
