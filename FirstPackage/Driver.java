package FirstPackage;
import SecondPackage.Client;
import ThirdPackage.Library;
import ThirdPackage.Book;
import ThirdPackage.Journal;
import ThirdPackage.Media;

import java.util.Scanner;

public class Driver {
    //Attributes :
    public static Library[] allItemsArray;
    public static Book[] allBooksArray;
    public static Journal[] allJournalArray;
    public static Media[] allMediaArray;

    public static Client[] allClientsArray;

    static void createAllItemsArray()
    {
        allItemsArray = new Library[1];
    }
    static void createAllClientsArray()
    {
        allClientsArray = new Client[1];
    }
    //Method that asks the user if he wants the menu or a predefined Scenario menuOrPredefinedScenario(Scanner input):
    public static int menuOrPredefinedScenario(Scanner input)
    {
        System.out.print("Hello welcome to FunReadings Library what would you like to do ?\n1-Display the menu\n2-Run a predefined scenario"
        +"\nPlease enter your choice (1 or 2) >>");
        int choice = input.nextInt();
        while(choice!=1&&choice!=2)
        {
            System.out.print("\nThis is not a valid input please enter a valid choice >> ");
            choice = input.nextInt();
        }
        return choice;
    }

    //Method to display main menu displayMenu() :
    public static void displayMenu() {
        System.out.print("| What would you like to do?\n"
                + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                + "| 1 >> Add an item \n"
                + "| 2 >> Delete an item\n"
                + "| 3 >> Change information of an item \n"
                + "| 4 >> List all items in a specific category\n"
                +"| 5 >> List all items	\n"
                + "| 6 >> Add a client\n"
                +"| 7 >> Remove a client \n"
                + "| 8 >> Edit a client \n"
                +"| 9 >> Lease an item to a client  \n"
                + "|10 >> Return an item from a client \n"
                + "|11 >> Show all items leased by a client \n"
                + "|12 >> Show all leased items (by all clients)\n"
                + "|13 >> Display the biggest book \n"
                + "|14 >> Make a copy of the books array\n"
                + "|0 >> Quit\n"
                + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                + "\n Please enter your choice and press <Enter>: ");
    }


    //Gets the choice of action listed in the menu that the user wants to do (Soukay)
    public static int getChoiceMenu(Scanner input)
    {
        displayMenu();
        int choice =0;
        choice = input.nextInt();
        validateChoiceMenu(choice,input);
        return choice;
    }

    //This functions makes sure that the input of the user for the choice in the menu is valid(Soukay)
    public static int validateChoiceMenu(int choice,Scanner input)
    {
        while (choice>14||choice<0)
        {
            System.out.print("This is not a valid input please try again >>");
                choice = input.nextInt();
        }
        return choice;
    }

    //Method Add Item addItem() :(Soukay)
    public static void addItem(Scanner input,Library item){
        int index =0;
            if (allItemsArray[allItemsArray.length-1] == null) {
                allItemsArray[allItemsArray.length-1] = item;
            }
            else
            {
                Library[] tempArray = new Library[allItemsArray.length + 1];
                for (int i = 0; i < allItemsArray.length; i++) {
                    tempArray[i] = allItemsArray[i];
                }
                tempArray[tempArray.length - 1] = item;
                allItemsArray = tempArray;
            }

    }

    //(Soukay)
    static Library askTheUserForTheItemHeWantsToAdd(Scanner input)
    {
        System.out.print("What type of item do you want to add (book, journal or media) >>");
        String choice=takeValidChoiceOfTypeOfItem(input);
        Library item =null;
        String title;
        String author;
        int yearOfPublication;
        switch (choice)
        {
            case "book":{
                System.out.print("\nEnter the book information in the following order: Number of pages, title, author, year of publication >> ");
                int nbOfPages=input.nextInt();
                String trash = input.nextLine();
                title= input.nextLine();
                author=input.nextLine();
                yearOfPublication=input.nextInt();
                item = new Book(nbOfPages,title,author,yearOfPublication);
                //addBookToArray(newItem);
                //listAllBooks();
                break;
            }
            case "journal":
            {
                System.out.print("\nEnter the Journal information in the following order: Volume number, title, author, year of publication >> ");
                int volumeNumber=input.nextInt();
                String trash = input.nextLine();
                title= input.nextLine();
                author=input.nextLine();
                yearOfPublication=input.nextInt();
                item = new Journal(volumeNumber,title,author,yearOfPublication);
                //addJournalToArray(item);
                break;
                }
            case "media":{System.out.print("\nEnter the Media information in the following order: Type of media, title, author, year of publication >> ");
                String trash = input.nextLine();
                String typeMedia=input.nextLine();
                title= input.nextLine();
                author=input.nextLine();
                yearOfPublication=input.nextInt();
                item = new Media(typeMedia,title,author,yearOfPublication);
                //addMediaToArray(item);
                break;
            }
        }
        return item;
    }
    //Method to add a Book to the Book Array addBookToArray() :(wissem)
    static void addBookToArray(Book item){

    }
    //Method to add a Journal to the Journal Array addJournalToArray() :
    static void addJournalToArray(Journal item){

    }
    //Method to add a Media to the Media Array addMediaToArray() :
    static void addMediaToArray(Media item){

    }
    //This functions makes sure that the input of the user for the choice of the type of item he wants to add (SOukay)
    static String takeValidChoiceOfTypeOfItem(Scanner input)
    {
        String choice = input.next();
        while (choice.equals("book")==false&&choice.equals("journal")==false&&choice.equals("media")==false)
        {
            System.out.print("This is not a valid type please choose between book, journal or media >> ");
            choice = input.next();
        }
        return choice;
    }
    //Method Delete Item deleteItem() : (Soukay)
    static void deleteItem(Scanner input) {
        System.out.println("Here are all the items of the library:");
        listAllItems();
        System.out.print("What is the number of the one you want to delete enter here >>");
        int index = input.nextInt();

        if(index>=0&&index<allItemsArray.length)
        {
            for (int j = index; j < allItemsArray.length - 1; j++) {
                allItemsArray[j] = allItemsArray[j + 1];
            }
            Library[] tempArray = new Library[allItemsArray.length - 1];
            for (int n = 0; n < tempArray.length; n++) {
                tempArray[n] = allItemsArray[n];
            }
            allItemsArray = tempArray;
        }
            else {
                System.out.println("noooooooooooooo");
            }
    }

    //Method to change information of an Item changeInformationItem() :


    //Method to list all the books listAllBooks() : (Wissem)
    static void listAllBooks(){
        if(allItemsArray!=null) {
            System.out.println("Here's all the Books:");
            for (int i = 0; i < allBooksArray.length - 1; i++) {
                System.out.print(allBooksArray[i] + "\n");
            }
        }else{
            System.out.println("There's no book yet.");
        }
    }

    //Method to list all the journals listAllJournal() : (Wissem)
    static void listAllJournals(){
        if(allItemsArray!=null) {
            System.out.println("Here's all the Journals:");
            for (int i=0; i< allJournalArray.length-1;i++){
                System.out.print(allJournalArray[i] + "\n");
            }
        }else{
            System.out.println("There's no journal yet.");
        }
    }
    //Method to list all the medias listAllMedia() : (Wissem)
    static void listAllMedia(){
        if(allItemsArray!=null) {
            System.out.println("Here's all the Medias:");
            for (int i=0; i< allMediaArray.length-1;i++) {
                System.out.print(allMediaArray[i] + "\n");
            }
        }else{
            System.out.println("There's no media yet.");
        }
    }
    //Methods to list a specific category listSpecificCategory() : (Wissem)
    static void listSpecificCategory(Scanner input) {
        System.out.print("Enter the category of document you would like to display (\"Book\", \"Journal\", \"Media\"):");
        String category = input.next();
        if (category.equalsIgnoreCase("Book")){
            if (allJournalArray==null) {
                System.out.println("Sorry there's no Book for now.");
            } else{
                listAllBooks();
            }

        }else if (category.equalsIgnoreCase("Journal")) {
            if (allJournalArray==null) {
                System.out.println("Sorry there's no Journal for now.");
            } else{
                listAllJournals();
            }
        }else if (category.equalsIgnoreCase("Media")) {
            if (allMediaArray==null) {
                System.out.println("Sorry there's no media for now.");
            } else{
                listAllMedia();
            }
        }
    }
    //Method to list all items of the array library (soukay)
    static void listAllItems() {
        if(allItemsArray[allItemsArray.length-1]==null) {
            System.out.println("There's no item yet.");
        }else{
            for (int i = 0; i < allItemsArray.length; i++) {
                System.out.println("\nitem#" + i + "\n" + allItemsArray[i]);
            }
        }
    }
    //Method display all the clients displayAllClients(): (Wissem)
    static void displayAllClients(){
        System.out.println("Here's all your clients :");
        for (int i=0; i<allClientsArray.length; i++){
            System.out.println("Client#"+i+"\n"+allClientsArray[i]+ "\n");
        }
    }

    //Method to add a client addClient() (wissem):
    static void addClient(Scanner input){
        System.out.print("Enter the client information in the following order: Client name, Phone-number, E-mail >> ");
        String trash = input.nextLine();
        String clientName = input.nextLine();
        String clientPhoneNumber = input.next();
        String clientEmail = input.next();
        Client newClient= new Client(clientName,clientPhoneNumber,clientEmail);
        if (allClientsArray[allClientsArray.length-1] == null) {
            allClientsArray[allClientsArray.length-1] = newClient;
        }
        else {
            //Copy the array and extend it of 1 place to add the client
            Client[] tempAllClientsArray = new Client[allClientsArray.length + 1];
            for (int i = 0; i < allClientsArray.length; i++) {
                tempAllClientsArray[i] = allClientsArray[i];
            }
            tempAllClientsArray[tempAllClientsArray.length-1] = newClient;
            allClientsArray = tempAllClientsArray;
        }
        System.out.println("Your client was successfully added.");
    }
    //Method to edit a client editClient() : (Wissem)
    static void editClient(Scanner input){
        int positionClient;
        do{
            System.out.print("Enter the number (#) of the client: ");
            positionClient = input.nextInt();
            if (positionClient<0||positionClient>allClientsArray.length){
                System.out.println("Error, try again. Please enter a number between 0"+ " and " + (allClientsArray.length-1));
            }
        } while (positionClient<0||positionClient>allClientsArray.length);

        System.out.print("What do you want to modify : \"Name\", \"Phone Number\" or \"Email\"? : ");
        String clientModification = input.next();
        if(clientModification.equalsIgnoreCase("Name")){
            System.out.print("Enter a new name: ");
            String newName = input.next();
            allClientsArray[positionClient].setNameClient(newName);
            System.out.println("This client's name was successfully modified");
            displayClientInfo(positionClient);
        } else if (clientModification.equalsIgnoreCase("Phone number")) {
            System.out.print("Enter a new phone number: ");
            String newPhoneNumber = input.next();
            allClientsArray[positionClient].setPhoneNumberClient(newPhoneNumber);
            System.out.println("This client's phone number was successfully modified");
            displayClientInfo(positionClient);
        } else if (clientModification.equalsIgnoreCase("Email")) {
            System.out.print("Enter a new name: ");
            String newEmail = input.next();
            allClientsArray[positionClient].setEmailClient(newEmail);
            System.out.println("This client's e-mail was successfully modified");
            displayClientInfo(positionClient);
        }

    }
    //Method to display a specific client's info displayClientInfo(): (wissem)
    static void displayClientInfo(int i){
        System.out.println("Here are the information of client #" + i + " :");
        System.out.println(allClientsArray[i]);
    }
    //Method to delete a client deleteClient() :
    static void deleteClient(Scanner input){
        int deleteClientPosition;
        if(allClientsArray[allClientsArray.length-1] !=null){
            do{
                displayAllClients();
                System.out.println("Enter the number (#) of the client you would like to remove:");
                deleteClientPosition=input.nextInt();
                if (deleteClientPosition<0||deleteClientPosition>allClientsArray.length){
                    System.out.println("Error, try again. Please enter a number between 0"+ " and " + (allClientsArray.length-1));
                }
            }while(deleteClientPosition<0||deleteClientPosition>allClientsArray.length);
            Client[] tempAllClientsArray = new Client[allClientsArray.length-1];
            for (int i =0; i<allClientsArray.length-1;i++){
                if(i<deleteClientPosition){
                    tempAllClientsArray[i]=allClientsArray[i];
                }else{
                    tempAllClientsArray[i]=allClientsArray[i+1];
                }
            }
            allClientsArray=tempAllClientsArray;
            displayAllClients();
        }else{
            System.out.println("There's no client yet.");
        }

    }

    //Method to lease an item to client leaseItemToClient() :
    static void leaseItemToClient(Scanner input) {
        int clientPositionToLeaseTo;
        if (allItemsArray[allItemsArray.length-1] != null && allClientsArray[allClientsArray.length-1] != null) {
            do {
                System.out.println("Here are all the clients: ");
                displayAllClients();
                System.out.println("Enter the number (#) of the client you would like to lease an item to:");
                clientPositionToLeaseTo = input.nextInt();
                if (clientPositionToLeaseTo < 0 || clientPositionToLeaseTo > allClientsArray.length) {
                    System.out.println("Error, try again. Please enter a number between 0" + " and " + (allClientsArray.length - 1));
                }
            } while (clientPositionToLeaseTo < 0 || clientPositionToLeaseTo > allClientsArray.length);
            int itemPositionToLease;
            do {
                System.out.println("Here are all the items available: ");
                listAllItems();
                System.out.println("Enter the number (#) of the item you would like to lease : ");
                itemPositionToLease = input.nextInt();
                if (itemPositionToLease < 0 || itemPositionToLease > allItemsArray.length) {
                    System.out.println("Error, try again. Please enter a number between 0" + " and " + (allItemsArray.length - 1));
                }
            } while (itemPositionToLease < 0 || itemPositionToLease > allItemsArray.length);
            Library[] leasedItemByClient = allClientsArray[clientPositionToLeaseTo].getItemsLeasedByClient();
            if(leasedItemByClient[leasedItemByClient.length-1]==null)
            {
                leasedItemByClient[leasedItemByClient.length-1]=allItemsArray[clientPositionToLeaseTo];
                System.out.println("The item #"+itemPositionToLease+" has been leased successfully to client #"+clientPositionToLeaseTo);
            }
            else {
                Library[] newLeasedItemByClient = new Library[leasedItemByClient.length + 1];
                for (int i = 0; i < leasedItemByClient.length; i++) {
                    newLeasedItemByClient[i] = leasedItemByClient[i];
                }
                newLeasedItemByClient[newLeasedItemByClient.length - 1] = allItemsArray[clientPositionToLeaseTo];
                leasedItemByClient = newLeasedItemByClient;
                allClientsArray[clientPositionToLeaseTo].setItemsLeasedByClient(leasedItemByClient);
                System.out.println("The item #"+itemPositionToLease+" has been leased successfully to client #"+clientPositionToLeaseTo);
            }
            //rajouter code qui delete le item du array pour que ce soit plus possible de le lease
        }else{
            if(allClientsArray[allClientsArray.length-1] == null) {
                System.out.println("There's no client yet.");
            }else if(allItemsArray[allItemsArray.length-1] == null){
                System.out.println("There's no item yet.");
            }
        }
    }

    //Method to display the leased items of a client displayLeasedItemOfClient() :
    static void displayLeasedItemOfClient(Scanner input){
        int clientPosition;
        do{
            System.out.println("Enter the number of the client you would like to display their leased items :");
            clientPosition=input.nextInt();
            if(clientPosition < 0 || clientPosition > allClientsArray.length){
                System.out.println("Error, try again. Please enter a number between 0"+ " and " + (allClientsArray.length-1));
            }
        }while(clientPosition < 0 || clientPosition > allClientsArray.length);
        Library[] leasedItemByClient=allClientsArray[clientPosition].getItemsLeasedByClient();
        for(int i =0; i<leasedItemByClient.length;i++){
            System.out.println(leasedItemByClient[i] + "\n");
        }
        System.out.println("All the leased items were successfully displayed.");
    }

    //Method to display the leased items of all the clients displayLeasedItemsOfAllClients():
    static void displayLeasedItemsOfAllClients(Scanner input){
        for(int j=0; j<allClientsArray.length;j++){
            Library[] leasedItemByClient=allClientsArray[j].getItemsLeasedByClient();
            System.out.println("Client#" + j);
            for(int i =0; i<leasedItemByClient.length;i++){
                System.out.println(leasedItemByClient[i] + "\n");
            }
            System.out.println("\n");
        }
    }
    //Method to return an item of a client returnItemFromClient() :

    //Method to display the returned items of all the clients displayReturnedItemsOfAllClients() :

    //Display the biggest book getBiggestBook() :
    static void getBiggestBook(){
        Book biggestBook=allBooksArray[0];
        int biggestBookPosition=0;
        for(int i=1; i<allBooksArray.length;i++){
            if(allBooksArray[i].getNumberPages()>biggestBook.getNumberPages()){
                biggestBook=allBooksArray[i];
                biggestBookPosition=i;
            }
        }
        System.out.println("The biggest book is the Book #" + biggestBookPosition);
    }
    //Copy books copyBooks() :

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choiceMenuOrScenario =menuOrPredefinedScenario(input);

        if(choiceMenuOrScenario==2) {
            //Create 3 objects from each type
            Book book = new Book(350,"Harry Potter","JK Rowling",2001);
            Journal journal = new Journal(25,"The New York Times","Soukay",2024);
            Media media = new Media("Movie","Interstellar","Christopher Nolan",2012);
            Media media1 = new Media("Movie","Interstellar","Christopher Nolan",2012);

            Library[] items = {book,journal,media};


            //PROBLEM : THE ID DOES NOT CHANGE ITS ALWAYS WITH A 1
            System.out.println(book);
            System.out.println(journal);
            System.out.println(media);
            System.out.println(media1);

            //Create 3 users
            Client client1 = new Client("Soukayna","514550287","haitamis@hotmail.com");
            Client client2 = new Client("Wissem","51489887","wissem@hotmail.com");
            Client client3 = new Client("Tasneem","4393070000","haitamit@hotmail.com");


            //Display the user's information
            System.out.println(client1);
            System.out.println(client2);
            System.out.println(client3);

            //Test equals() of 2 objects of different classes
            System.out.println(book.equals(journal));

            //Test equals() of 2 objects of same class with different values
            Book book2 = new Book(450,"After","Anna",2001);
            System.out.println(book.equals(book2));

            //Test equals() of 2 objects of same class with same values
            Journal journal2 = new Journal(25,"The New York Times","Soukay",2024);
            System.out.println(journal.equals(journal2));

            //Create an array for Book
            Book [] books = {book,book2};

            //Create an array for Journal
            Journal [] journals = {journal, new Journal()};

            //Create an array for Media
            Media[] medias = {media,new Media()};

            //Create an array for all the items(Book, Journal and Media)
            Library[] allItems = {book,journal,media};
        }
        else {
            int menuChoice=0;
            createAllItemsArray();
            createAllClientsArray();
            do {
                menuChoice = getChoiceMenu(input);
                switch(menuChoice)
                {
                    case 1: {
                        Library item = askTheUserForTheItemHeWantsToAdd(input);
                        addItem(input,item);
                        listAllItems();
                        break;
                    }
                    case 2: {

                        deleteItem(input);
                        listAllItems();
                        break;
                    }

                    case 3: {

                        break;
                    }

                    case 4: {
                        listSpecificCategory(input);
                        break;

                    }
                    case 5: {
                        listAllItems();
                        break;
                    }
                    case 6: {
                        addClient(input);
                        displayAllClients();
                        break;
                    }

                    case 7: {
                        deleteClient(input);
                        break;
                    }

                    case 8:
                    {
                        editClient(input);
                        break;
                    }

                    case 9:
                    {
                        leaseItemToClient(input);
                        break;
                    }
                    case 10:
                    {

                        break;
                    }
                    case 11:
                    {
                        displayLeasedItemOfClient(input);
                        break;
                    }
                    case 12:
                    {
                        displayLeasedItemsOfAllClients(input);
                        break;
                    }
                    case 13:
                    {
                        getBiggestBook();
                        break;
                    }
                    case 14:
                    {

                        break;
                    }
                }

            }while(menuChoice!=0);
        }
        }
    }


