package ThirdPackage;

public class Library {

    private int id;
    private String name;
    private String author;
    private int yearPublication;

    //Getter :
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public int getYearPublication() {
        return yearPublication;
    }
    //Setter :
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    //Parametrized Constructor:
    public Library(int id, String name, String author, int yearPublication){
        this.id=id;
        this.name=name;
        this.author=author;
        this.yearPublication=yearPublication;
    }
    public Library(){
        this.id=0;
        this.name="";
        this.author="";
        this.yearPublication=0000;
    }

    public Library(Library library){
        this.id=library.getId();
        this.name= library.getName();
        this.author=library.getAuthor();
        this.yearPublication=library.getYearPublication();
    }

}
