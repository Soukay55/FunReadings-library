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

    public static Client[] allClients;

    static void createAllItemsArray()
    {
        allItemsArray = new Library[1];
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
                +"| 7 >> Remove a client n"
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
                break;
                }
            case "media":{System.out.print("\nEnter the Media information in the following order: Type of media, title, author, year of publication >> ");
                String trash = input.nextLine();
                String typeMedia=input.nextLine();
                title= input.nextLine();
                author=input.nextLine();
                yearOfPublication=input.nextInt();
                item = new Media(typeMedia,title,author,yearOfPublication);
                break;
            }
        }
        return item;
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

    //Method to list all the books listAllBooks() :

    //Method to list all the journals listAllJournal() :

    //Method to list all the medias listAllMedia() :

    //Method to list all items of the array library
    static void listAllItems()
    {
        for(int i=0;i<allItemsArray.length;i++)
        {
            System.out.println("\nitem#"+i+"\n"+allItemsArray[i]);
        }
    }

    //Method to add a client addClient() :

    //Method to edit a client editClient() :

    //Method to delete a client deleteClient() :

    //Method to lease an item to client leaseItemToClient() :

    //Method to return an item of a client returnItemFromClient() :

    //Method to display the leased items of a client displayLeasedItemOfClient() :

    //Method to display the returned items of all the clients displayReturnedItemsOfAllClients() :

    //Display the biggest book getBiggestBook() :

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
            Client client1 = new Client("Soukayna",514550287,"haitamis@hotmail.com",items);
            Client client2 = new Client("Wissem",51489887,"wissem@hotmail.com",items);
            Client client3 = new Client("Tasneem",439307,"haitamit@hotmail.com",items);


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
            do {
                menuChoice = getChoiceMenu(input);
                switch(menuChoice)
                {
                    case 1:
                    {
                        Library item = askTheUserForTheItemHeWantsToAdd(input);
                        addItem(input,item);
                        listAllItems();
                        for (int i=0;i<allItemsArray.length;i++)
                        {
                            System.out.println(allItemsArray[i].getID());
                        }
                        break;
                    }
                    case 2:
                    {

                        deleteItem(input);
                        listAllItems();
                        break;
                    }

                    case 3:
                    {

                        break;
                    }

                    case 4:
                    {

                        break;

                    }
                    case 5:
                    {
                        listAllItems();
                        break;
                    }
                    case 6:
                    {

                        break;
                    }

                    case 7:
                    {

                        break;
                    }

                    case 8:
                    {

                        break;
                    }

                    case 9:
                    {

                        break;
                    }
                    case 10:
                    {

                        break;
                    }
                    case 11:
                    {
                        break;
                    }
                    case 12:
                    {

                        break;
                    }
                    case 13:
                    {

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


