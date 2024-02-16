package ThirdPackage;

public class Library {

    //Attributes :
    private String name;
    private String author;
    private int yearPublication;

    //Getter :
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
    public Library(String name, String author, int yearPublication){
        this.name=name;
        this.author=author;
        this.yearPublication=yearPublication;
    }
    //Default Constructor :
    public Library(){
        this.name="";
        this.author="";
        this.yearPublication=0000;
    }
    //Copy constructor :
    public Library(Library library){
        this.name= library.getName();
        this.author=library.getAuthor();
        this.yearPublication=library.getYearPublication();
    }
    //Method toString() :
    public String toString(){
        return "Name: " + name + "\nAuthor: " + "\nYear of Publication: " + yearPublication;
    }
    //Method equals() :
    public boolean equals(Library library){
        if(name==library.getName() && author==library.getAuthor() && yearPublication==library.getYearPublication()){
            return true;
        }else{return false;}
    }


}
