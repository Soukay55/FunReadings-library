package ThirdPackage;

public class Media extends Library{

    //Attributes :
    String typeMedia;
    String idMedia="M";
    int numberOfMedia=0;

    //Getter :
    public String getTypeMedia() {
        return typeMedia;
    }
    public String getIdMedia() {
        return idMedia;
    }
    public int getNumberOfMedia() {
        return numberOfMedia;
    }

    //Setter :
    public void setTypeMedia(String typeMedia) {
        this.typeMedia = typeMedia;
    }
    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }
    public void setNumberOfMedia(int numberOfMedia) {
        this.numberOfMedia = numberOfMedia;
    }

    // Parametrized Constructor:
    public Media(String typeMedia, String name, String author, int yearPublication) {
        super(name, author,yearPublication);
        this.typeMedia = typeMedia;
        numberOfMedia++;
        this.idMedia = idMedia+numberOfMedia;
    }
    //Default Constructor:
    public Media(){
        super();
        this.typeMedia="";
        numberOfMedia++;
        this.idMedia = idMedia+numberOfMedia;
    }
    // Copy Constructor:
    public Media(Media media){
        this(media.typeMedia, media.name,media.author,media.yearPublication);
        numberOfMedia++;
        this.idMedia=idMedia+numberOfMedia;
    }

    //Method toString()
    public String toString() {
        return ("\nMedia's ID: " + idMedia +
                "\n" + super.toString() +
                "\nType of media: " + typeMedia);
    }

    //Method equals()
    public boolean equals(Object otherObject){
        if (otherObject==null){ //Make sure that the compared object is not empty (null)
            return false;
        }
        if(this.getClass()!=otherObject.getClass()){ //Make sure that the compared object is from the same class
            return false;
        }
        Media otherMedia = (Media) otherObject;
        return (typeMedia==otherMedia.typeMedia);
    }
}

