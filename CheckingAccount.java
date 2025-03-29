import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable{
    double balance;

    public static void main(String[] args){
        CheckingAccount ca = new CheckingAccount();
        ca.start();
    }


    public String menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account Menu ");
        System.out.println("0) quit");
        System.out.println("1) check balance");
        System.out.println("2) make a deposit");
        System.out.println("3) make a withdrawal");
        return scanner.nextLine();
    }

    public void start(){
        boolean keepGoing = true;
        while(keepGoing){
            String response = menu();
            if(response.equals("1")){
                System.out.println("Checking Balance...");
                this.checkBalance();
            }
            else if(response.equals("2")){
                System.out.println("Making a deposit...");
                this.makeDeposit();
            }
            else if(response.equals("3")){
                System.out.println("Making a withdrawal...");
                this.makeWithdrawal();
            }
            else if(response.equals("0")){
                keepGoing = false;
            }
            else {
                System.out.println("Not a valid input");
            }
        }
    }

    double getDouble(){
        Scanner scanner = new Scanner(System.in);
        try{
            return Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Not a valid format");
        }
        return 0;
    }

    public String getBalance(){
        return Double.toString(this.balance);
    }
    public void setBalance(double balance){
        this.balance = balance;

    }
    public String getBalanceString(){
        String result = String.format("%,.2f", this.balance);
        return result;
    }
    public CheckingAccount(){
        this.balance = 0d;
    }

    public void checkBalance(){
        System.out.println(getBalanceString());

    }

    public void makeWithdrawal(){
        System.out.println("Enter how much to withdrawal:");
        double withdrawalAmount = getDouble();

        setBalance(this.balance - withdrawalAmount);

        
    }

    public void makeDeposit(){
        System.out.println("Enter how much to deposit:");
        double depositAmount = getDouble();
        setBalance(this.balance + depositAmount);
    }
    
}