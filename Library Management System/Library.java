
import java.util.*;

import static java.lang.System.exit;

class Book
{
    String name;
    int number;
    String author;
    static ArrayList<Book> Books = new ArrayList<>(); // doubt

    Book(int number,String name,String author)
    {
        this.name = name;
        this.author = author;
        this.number = number;
    }

    public static void add(Book Book){
        Books.add(Book);
        System.out.println(Book.name + " has been added!!");
    }
    public static void removeBook(Book B){
        Books.remove(B);
    }

    public static void viewBooks()
    {
        if(Books.size() == 0){ System.out.println("\nLIBRARY EMPTY!!\n"); }
        else {
            System.out.println("\nBOOK \t\t\t\t\t AUTHOR \t\t\t\t\t NUMBER:");
            for (Book b : Books) {
                System.out.println(b.name + " \t\t\t\t " + b.author + " \t\t\t\t " + b.number);
            }
        }
    }

}

class User
{
    String name;
    int contact;
    static ArrayList<User> users = new ArrayList<>(); // doubt
    ArrayList<Book> issued = new ArrayList<>(); //doubt

    User(String name,int number) {
        this.name = name;
        this.contact = number;
    }

    public static void viewUsers()
    {
        if(users.size() == 0) System.out.println("\nNO USERS!!\n\n");
        else{
            System.out.println("\nNAME \t\t\t\t CONTACT:");
            for(User u : users){
                System.out.println("\nNAME: " + u.name + "\t\t\t\t CONTACT : " + u.contact);
            }
        }
    }

    public  void BorrowBook(Book book){
        issued.add(book);
    }

    public static void addUsers(User u){
        users.add(u);
        System.out.println("\nUser: "+u.name+" has been added!");
    }

    public  void BorrowedBooks(){
        if(issued.size() == 0){ System.out.println("\nNO BOOKS TAKEN!!\n"); return;}
        else {
            System.out.println("\nBOOK \t\t\t\t\t AUTHOR \t\t\t\t\t NUMBER:");
            for (Book B : issued) {
                System.out.println(B.name + "\t\t\t\t" + B.author + "\t\t\t\t" + B.number);
            }
        }
    }

    public  void returnBook(String name){
        Iterator<Book> it = issued.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Book b = it.next();
            if (b.name.equals(name)) {
                it.remove();
                Book.add(b);
                System.out.println(name + " has been Returned!\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(name + " NOT FOUND!!");
        }
    }

}

class Practice
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("\n1. View Books\n2. View Users\n3. Add Books\n4. Add Users\n5. Issue Book\n6. Return Book\n7. Exit");
            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1: Book.viewBooks(); break;
                case 2: User.viewUsers(); break;
                case 3: // add books
                    sc.nextLine();
                    System.out.println("\nEnter the Book Name: ");
                    String name = sc.nextLine();
                    System.out.println("\nEnter the Author: ");
                    String auth = sc.nextLine();
                    System.out.println("\nEnter the Book ID: ");
                    int number = sc.nextInt();
                    Book.add(new Book(number,name,auth)); break;
                case 4: // add users
                    System.out.println("\nEnter User Name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("\nEnter User Contact: ");
                    number = sc.nextInt();
                    User.addUsers(new User(name,number)); break;
                case 5: // issue books
                    System.out.println("\nEnter user name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    User u = getUser_byName(name);
                    if(u != null){
                        System.out.println("\nEnter the book name: ");
                        String B = sc.nextLine();
                        Book b = getBook_ByName(B);
                        if(b != null) { u.BorrowBook(b); System.out.println(B+" has been issued to: "+name); Book.removeBook(b); break; }
                        else { System.out.println("\nBOOK NOT FOUND!!\n"); break;}
                    }
                    else{
                        System.out.println("\nUser NOT FOUND!!! Register First!!!\n"); break;
                    }
                case 6: // return books
                    System.out.println("\nEnter the User Name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    u = getUser_byName(name);
                    u.BorrowedBooks();
                    System.out.println("\nEnter the Book to Return: ");
                    name = sc.nextLine();
                    u.returnBook(name);
                break;
                case 7: exit(1);
                default:
                    System.out.println("INVALID INPUT!!!");
            }
        }
    }
    public static User getUser_byName(String name){
        for(User u: User.users){
            if(u.name.equals(name)) return u;
        }
        return null;
    }
    public static Book getBook_ByName(String name){
        for(Book b : Book.Books){
            if(b.name.equals(name)) return b;
        }
        return null;
    }
}
