package ThirdPackage;

public class Media extends Library{
    String typeMedia;
    String idMedia="M";

    //Getter :
    public String getTypeMedia() {
        return typeMedia;
    }
    public String getIdMedia() {
        return idMedia;
    }

    //Setter :
    public void setTypeMedia(String typeMedia) {
        this.typeMedia = typeMedia;
    }
    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }
    // Parametrized Constructor:
    public Media(String typeMedia, String idMedia, int id, String name, String author, int yearPublication) {
        this.typeMedia = typeMedia;
        this.idMedia = idMedia;
        super.setId(id);
        super.setName(name);
        super.setAuthor(author);
        super.setYearPublication(yearPublication);
    }
    //Default Constructor:
    public Media(){
        this.typeMedia="";
        this.idMedia="M";
    }
    // Copy Constructor:
    public Media(Media media){
        this.typeMedia=media.getTypeMedia();
        this.idMedia=media.getIdMedia();
    }

    //toString() Method
    public String toString() {
        return "Type of media =" + typeMedia +
                ", id of media='" + idMedia;
    }

    //equals() Method
    public boolean equals(Media media){
        if(typeMedia==media.getTypeMedia()&&idMedia==media.getIdMedia()){
            return true;
        }else{return false;}
    }
}

