import java.util.*;
import java.io.*;

class Customer extends User implements Serializable{
    CheckingAccount checking = new CheckingAccount();
    SavingsAccount savings = new SavingsAccount();
    
    public static void main(String[] args){
       Customer cu = new Customer();
       if(cu.login() == true){
        cu.start();
       } 
       else{
        System.out.println("Bad username or password");
       }

    }

    public Customer(){
        PIN = "0000";
        userName = "Alice";
    }

    public Customer(String userName, String PIN){
        this.setUserName(userName);
        this.setPIN(PIN);
    }

    public void start(){
        boolean keepGoing = true;
        while(keepGoing){
            String response = menu();
            if(response.equals("1")){
                System.out.println("Checking Account");
                checking.start();
            }
            else if(response.equals("2")){
                System.out.println("Savings Account");
                savings.start();
            }
            else if(response.equals("3")){
                System.out.println("Change PIN");
                this.changePin();
            }
            else if(response.equals("0")){
                keepGoing = false;
            }
            else {
                System.out.println("Not a valid input");
            }
        }
    }

    public String menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customer Menu ");
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) Change PIN");
        return scanner.nextLine();
    }

    public void changePin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter current PIN: ");
        if(scanner.nextLine().equals(this.getPIN())){
            System.out.println("Enter a new PIN: ");
            this.setPIN(scanner.nextLine());
        }
        else{
            System.out.println("Incorrect");
        }
    }

    public String getReport(){

        return this.getUserName() + ", " + this.getPIN() + ", " + checking.getBalanceString() + ", " + savings.getBalanceString();
    }
}