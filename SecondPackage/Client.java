package SecondPackage;

import ThirdPackage.Book;
import ThirdPackage.Media;

public class Client {

    //Attributes :
    private String idClient="Client";
    private String nameClient;
    private long phoneNumberClient;
    private String emailClient;
    private int numberOfClients;

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

    //Parametrized Constructor :
    public Client(String nameClient, long phoneNumberClient, String emailClient){
        this.nameClient=nameClient;
        this.phoneNumberClient=phoneNumberClient;
        this.emailClient=emailClient;
        numberOfClients++;
        this.idClient=idClient+numberOfClients;
    }

    //Default Constructor :
    public Client(){
        this.nameClient="";
        this.phoneNumberClient=000-000-0000;
        this.emailClient="";
        numberOfClients++;
        this.idClient=idClient+numberOfClients;
    }

    //Copy Constructor :
    public Client (Client client){
        this.nameClient=client.getNameClient();
        this.phoneNumberClient=client.getPhoneNumberClient();
        this.emailClient=client.getEmailClient();
        numberOfClients++;
        this.idClient=idClient+numberOfClients;
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
