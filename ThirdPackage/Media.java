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
        this.typeMedia = typeMedia;
        super.setName(name);
        super.setAuthor(author);
        super.setYearPublication(yearPublication);
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
        super(media);
        this.typeMedia=media.getTypeMedia();
        numberOfMedia++;
        this.idMedia = idMedia+numberOfMedia;
    }

    //Method toString()
    public String toString() {
        return ("\nMedia's ID: " + idMedia +
                "\n" + super.toString() +
                "\nType of media: " + typeMedia);
    }

    //Method equals()
    public boolean equals(Media media){
        if(typeMedia==media.getTypeMedia()&&idMedia==media.getIdMedia()){
            return true;
        }else{return false;}
    }
}

