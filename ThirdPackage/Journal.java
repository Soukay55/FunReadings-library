package ThirdPackage;

public class Journal extends Library{

    //Attributes
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

    //Parametrized Constructor:
    public Journal(int volumeNumber, String name, String author, int yearPublication) {
        super(name, author,yearPublication);
        this.volumeNumber = volumeNumber;
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
        this(journal.volumeNumber, journal.name,journal.author,journal.yearPublication);
        numberOfJournal++;
        this.idJournal=idJournal+numberOfJournal;
    }

    //Method toString()
    public String toString() {
        return ("\nJournal's ID: " + idJournal +
                "\n" + super.toString() +
                "\nVolume number: " + volumeNumber);
    }

    //Method equals()
    public boolean equals(Object otherObject){
        if (otherObject==null){ //Make sure that the compared object is not empty (null)
            return false;
        }
        if(this.getClass()!=otherObject.getClass()){ //Make sure that the compared object is from the same class
            return false;
        }
        Journal otherJournal = (Journal) otherObject; //
        return (volumeNumber ==otherJournal.volumeNumber);
    }
}
