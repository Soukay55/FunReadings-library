package ThirdPackage;

public class Journal extends Library{
    int volumeNumber;
    String idJournal;

    //Getter :
    public int getVolumeNumber() {
        return volumeNumber;
    }
    public String getIdJournal() {
        return idJournal;
    }

    //Setter :
    public void setVolumeNumber(int volumeNumber) {
        this.volumeNumber = volumeNumber;
    }
    public void setIdJournal(String idJournal) {
        this.idJournal = idJournal;
    }
    // Parametrized Constructor:
    public Journal(int volumeNumber, String idJournal, int id, String name, String author, int yearPublication) {
        this.volumeNumber = volumeNumber;
        this.idJournal = idJournal;
        super.setId(id);
        super.setName(name);
        super.setAuthor(author);
        super.setYearPublication(yearPublication);
    }
    //Default Constructor:
    public Journal(){
        super();
        this.volumeNumber =0;
        this.idJournal ="J";
    }
    // Copy Constructor:
    public Journal(Journal journal){
        //super(Journal journal);
        this.volumeNumber = journal.getVolumeNumber();
        this.idJournal = journal.getIdJournal();
    }

    //toString() Method
    public String toString() {
        return "The number  of volume=" + volumeNumber +
                ", id of the journal='" + idJournal;
    }

    //equals() Method
    public boolean equals(Journal journal){
        if(volumeNumber ==journal.getVolumeNumber()&& idJournal ==journal.getIdJournal()){
            return true;
        }else{return false;}
    }
}
