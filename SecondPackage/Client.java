package SecondPackage;

import ThirdPackage.Book;
import ThirdPackage.Library;
import ThirdPackage.Media;

public class Client {

    //Attributes :
    private String idClient="Client";
    private String nameClient;
    private long phoneNumberClient;
    private String emailClient;
    private int numberOfClients;
    private Library [] itemsLeasedByClient;

    //Getter :
    public String getIdClient() {
        return idClient;
    }
    public String getNameClient() {
        return nameClient;
    }
    public long getPhoneNumberClient() {
        return phoneNumberClient;
    }
    public String getEmailClient() {
        return emailClient;
    }
    public int getNumberOfClients() {
        return numberOfClients;
    }
    public Library[] getItemsLeasedByClient() {return itemsLeasedByClient;}

    //Setter :
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    public void setPhoneNumberClient(long phoneNumberClient) {
        this.phoneNumberClient = phoneNumberClient;
    }
    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }
    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public void setItemsLeasedByClient(Library [] items)
    {
        this.itemsLeasedByClient = new Library[items.length];
        for(int i=0;i<items.length;i++) {
            this.itemsLeasedByClient[i] = items[i];
        }
    }

    //Parametrized Constructor :
    public Client(String nameClient, long phoneNumberClient, String emailClient, Library[] items){
        this.nameClient=nameClient;
        this.phoneNumberClient=phoneNumberClient;
        this.emailClient=emailClient;
        numberOfClients++;
        this.idClient=idClient+numberOfClients;
        this.itemsLeasedByClient = new Library[items.length];
        for(int i=0;i<items.length;i++) {
            this.itemsLeasedByClient[i] = items[i];
        }
    }

    //Default Constructor :
    public Client(){
        this.nameClient="";
        this.phoneNumberClient=000-000-0000;
        this.emailClient="";
        numberOfClients++;
        this.idClient=idClient+numberOfClients;
        this.itemsLeasedByClient = null;
    }

    //Copy Constructor :
    public Client (Client client){
        this.nameClient=client.getNameClient();
        this.phoneNumberClient=client.getPhoneNumberClient();
        this.emailClient=client.getEmailClient();
        numberOfClients++;
        this.idClient=idClient+numberOfClients;
        this.itemsLeasedByClient = new Library[client.getItemsLeasedByClient().length];
        for(int i=0;i<this.itemsLeasedByClient.length;i++) {
            this.itemsLeasedByClient[i] = client.getItemsLeasedByClient()[i];
        }
    }

    //Method toString() :
    public String toString(){
        return "Client's ID: " + idClient +
                "\n Client's Name: " + nameClient +
                "\n Client's phone number: " + phoneNumberClient +
                "\n Client's Email: " + emailClient;
    }

    //Method equals() :
    public boolean equals(Object otherObject){
        if (otherObject==null){ //Make sure that the compared object is not empty (null)
            return false;
        }
        if(this.getClass()!=otherObject.getClass()){ //Make sure that the compared object is from the same class
            return false;
        }
        Client otherClient = (Client) otherObject;
        return (nameClient==otherClient.nameClient && phoneNumberClient==otherClient.phoneNumberClient && emailClient==otherClient.emailClient);
    }
}
