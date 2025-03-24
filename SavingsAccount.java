import java.util.*;

class SavingsAccount extends CheckingAccount{

    double interestRate;

    public static void main(String[] args){
        SavingsAccount sa = new SavingsAccount();
        sa.start();
    }

    public void calcInterest(){
        double interest = (balance * (interestRate/100));
    }

    public void setInterestRate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the interest rate: ");
        interestRate = getDouble();
    }

    public void getInterestRate(){
        System.out.println(interestRate);
    }
}