package ThirdPackage;

public class Book extends Library{
    int numberPages;
    String idBook;

    //Getter :
    public int getNumberPages() {
        return numberPages;
    }
    public String getIdBook() {
        return idBook;
    }

    //Setter :
    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
    // Parametrized Constructor:
    public Book(int numberPages, String idBook, int id, String name, String author, int yearPublication) {
        this.numberPages = numberPages;
        this.idBook = idBook;
        super.setId(id);
        super.setName(name);
        super.setAuthor(author);
        super.setYearPublication(yearPublication);

    }
    //Default Constructor:
    public Book(){
        this.numberPages=0;
        this.idBook="B";
    }
    // Copy Constructor:
    public Book(Book book){
        this.numberPages=book.getNumberPages();
        this.idBook=book.getIdBook();
    }

    //toString() Method
    public String toString() {
        return "The number  of pages=" + numberPages +
                ", id of the book='" + idBook;
    }

    //equals() Method
    public boolean equals(Book book){
        if(numberPages==book.getNumberPages()&&idBook==book.getIdBook()){
            return true;
        }else{return false;}
    }
}
