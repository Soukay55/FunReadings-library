package ThirdPackage;

public class Journal extends Library{
    int volumeNumber;
    String idJournal="J";
    int numberOfJournal=0;

    //Getter :
    public int getVolumeNumber() {
        return volumeNumber;
    }
    public String getIdJournal() {
        return idJournal;
    }
    public int getNumberOfJournal() {
        return numberOfJournal;
    }

    //Setter :
    public void setVolumeNumber(int volumeNumber) {
        this.volumeNumber = volumeNumber;
    }
    public void setIdJournal(String idJournal) {
        this.idJournal = idJournal;
    }
    public void setNumberOfJournal(int numberOfJournal) {
        this.numberOfJournal = numberOfJournal;
    }

    // Parametrized Constructor:
    public Journal(int volumeNumber, String name, String author, int yearPublication) {
        this.volumeNumber = volumeNumber;
        super.setName(name);
        super.setAuthor(author);
        super.setYearPublication(yearPublication);
        numberOfJournal++;
        this.idJournal=idJournal+numberOfJournal;
    }
    //Default Constructor:
    public Journal(){
        super();
        this.volumeNumber =0;
        numberOfJournal++;
        this.idJournal=idJournal+numberOfJournal;
    }
    // Copy Constructor:
    public Journal(Journal journal){
        super(journal);
        this.volumeNumber = journal.getVolumeNumber();
        numberOfJournal++;
        this.idJournal=idJournal+numberOfJournal;
    }

    //toString() Method
    public String toString() {
        return ("\nJournal's ID: " + idJournal +
                "\n" + super.toString() +
                "\nVolume number: " + volumeNumber);
    }

    //equals() Method
    public boolean equals(Journal journal){
        if(volumeNumber ==journal.getVolumeNumber()&& idJournal ==journal.getIdJournal()){
            return true;
        }else{return false;}
    }
}
