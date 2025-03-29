import java.util.*;

class Admin extends User{
    public Admin(){
        userName = "admin";
        PIN = "0000";
    }

    public String menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin Menu ");
        System.out.println("0) Exit");
        System.out.println("1) Full Customer report");
        System.out.println("2) Add user");
        System.out.println("3) Apply interest to savings accounts");
        return scanner.nextLine();
    }

    public String getReport(){
        return this.getUserName() + ", " + this.getPIN();
    }
    public void start(){
        
    }
}