import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

class Account
{
    String name;
    int net_total;
    String password;
    HashMap<Integer,String> transactions = new HashMap<>();
    int index = 1;
    Account(String name,String password,int net_total)
    {
        this.name = name; this.net_total = net_total;
        this.password = password;
        System.out.println("Congratulations!! "+this.name+" your account has been created!!");
        transactions.put(index++," First Deposit: "+net_total);
    }

    public int verifyPass(String password){
        if((this.password.equals(password))) return 1;
        return 0;
    }

    public void deposit(int money){

        this.net_total += money;
        System.out.println("\n Credited: "+money);
        System.out.println("\nThe Net Balance is: "+net_total);
        transactions.put(index++," Credited: "+money+" .Total Balance: "+net_total);
    }

    public void withdraw(int money){
        if(money > net_total){
            System.out.println("\nSorry Insuffient funds!!");
            transactions.put(index++," Transaction Failed!! Requested: "+money+ " .Balance: "+net_total);
            return;
        }
        else{
            System.out.println("\nThe amount: "+money+" has been deducted");
            this.net_total -= money;
            System.out.println("The Net Balance is: "+net_total);
            transactions.put(index++," Debited: "+money+" .Total Balance: "+net_total);
        }
    }

    public void viewBalance(){
        System.out.println("The Current Balance is: "+net_total);
    }

    public void viewTransactions(){
        for(int key : transactions.keySet()){
            System.out.println("Index: "+key+" Transaction: "+transactions.get(key));
        }
    }
}

class Practice
{
    static ArrayList<Account> users = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("\n\n----------------------WELCOME TO SWISS BANK-----------------------\n\n");
            System.out.println("What would like to do?: ");
            System.out.println("1. New Account\n2. Deposit\n3. WithDraw\n4. View Balance\n5. View Transactions\n6. Exit");
            System.out.println("\nSelect Option: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("\nPlease Enter the User Name:");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter the password:");
                    String password = sc.nextLine();
                    System.out.println("\nDesposit some amount to activate the account, enter the amount: ");
                    int amount = sc.nextInt();
                    users.add(new Account(name,password,amount)); break;
                case 2:
                    System.out.println("\nPlease Enter the User Name:"); sc.nextLine();
                    name = sc.nextLine();
                    if(findUser(name) != null){
                        Account ac = findUser(name);
                        System.out.println("Enter the password: ");
                        password = sc.nextLine();
                        if(ac.verifyPass(password) == 1){
                        System.out.println("\nEnter the amount: ");
                        amount = sc.nextInt(); ac.deposit(amount); break;}
                        else{
                            System.out.println("WRONG PASSWORD!!!!"); break;
                        }
                    }
                    else{
                        System.out.println("USER NOT FOUND!!"); break;
                    }
                case 3:// withdraw
                    System.out.println("\nPlease Enter the User Name:"); sc.nextLine();
                    name = sc.nextLine();
                    if(findUser(name) != null){
                        Account ac = findUser(name);
                        System.out.println("Enter the password: ");
                        password = sc.nextLine();
                        if(ac.verifyPass(password) == 1){
                            System.out.println("\nEnter the amount to DEBIT: ");
                            amount = sc.nextInt(); ac.withdraw(amount); break;}
                        else{
                            System.out.println("WRONG PASSWORD!!!!"); break;
                        }
                    }
                    else{
                        System.out.println("USER NOT FOUND!!"); break;
                    }
                case 4:// view balance
                    System.out.println("\nPlease Enter the User Name:"); sc.nextLine();
                    name = sc.nextLine();
                    if(findUser(name) != null){
                        Account ac = findUser(name);
                        System.out.println("Enter the password: ");
                        password = sc.nextLine();
                        if(ac.verifyPass(password) == 1){
                            ac.viewBalance(); break;}
                        else{
                            System.out.println("WRONG PASSWORD!!!!"); break;
                        }
                    }
                    else{
                        System.out.println("USER NOT FOUND!!"); break;
                    }
                case 5:// view transactions
                    System.out.println("\nPlease Enter the User Name:"); sc.nextLine();
                    name = sc.nextLine();
                    if(findUser(name) != null){
                        Account ac = findUser(name);
                        System.out.println("Enter the password: ");
                        password = sc.nextLine();
                        if(ac.verifyPass(password) == 1){
                            ac.viewTransactions(); break;}
                        else{
                            System.out.println("WRONG PASSWORD!!!!"); break;
                        }
                    }
                    else{
                        System.out.println("USER NOT FOUND!!"); break;
                    }
                case 6: exit(1);

            }
        }
    }
    public static Account findUser(String name){
        for(Account ac : users){
            if(ac.name.equals(name)){
                return ac;
            }
        }
        return null;
    }
}


















