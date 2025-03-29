import java.util.*;

class Bank{
    Admin admin = new Admin();
    CustomerList customers = new CustomerList();

    public Bank(){
        // uncomment the next two lines to refresh data

        //this.loadSampleCustomers();
        //this.saveCustomers();
        this.loadCustomers();
        this.start();
        this.saveCustomers();
     // end constructor
    }

    public static void main(String[] args){
        Bank bank = new Bank();
        bank.start();
    }

    public void loadSampleCustomers(){
        customers.add(new Customer("Alice","1234"));
        customers.get(customers.size()).checking.setBalance(1000);
        customers.get(customers.size()).savings.setBalance(1000);
        customers.add(new Customer("Bob","1234"));
        customers.add(new Customer("Cindy","1234"));
    }

    public void loadCustomers(){

    }

    public void saveCustomers(){
        
    }

    public void fullCustomerReport(){
        for(int i = 0; i < customers.size(); i++){
            System.out.println(customers.get(i).getReport());
        }
    }

    public void addUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name:");
        String name = scanner.nextLine();
        System.out.print("Enter password:");
        String pass = scanner.nextLine();
        customers.add(new Customer(name, pass));
    }

    public void applyInterest(){
        for(int i = 0; i < customers.size(); i++){
            customers.get(i).savings.calcInterest();
        }
    }

    public void loginAsCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name:");
        String name = scanner.nextLine();
        System.out.print("Enter password:");
        String pass = scanner.nextLine();

        Customer currentCustomer = null;
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getUserName().equals(name) && customers.get(i).getPIN().equals(pass)){
                currentCustomer = customers.get(i);
                currentCustomer.start();
            }
            // add message that no matching credentials were found if user is not in array
        }
    }

    public String menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bank Menu ");
        System.out.println("0) Exit");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        return scanner.nextLine();
    }

    public void start(){
        boolean keepGoing = true;
        while(keepGoing){
            String response = menu();
            if(response.equals("1")){
                System.out.println("Admin");
                startAdmin();
            }
            else if(response.equals("2")){
                System.out.println("Customer");
                loginAsCustomer();
            }
            else if(response.equals("0")){
                keepGoing = false;
            }
            else {
                System.out.println("Not a valid input");
            }
        }
    }

    public void startAdmin(){
        if(admin.login()){
            boolean keepGoing = true;
            while(keepGoing){
                String response = admin.menu();
                if(response.equals("1")){
                    System.out.println("Showing Customer report:");
                    fullCustomerReport();
                }
                else if(response.equals("2")){
                    System.out.println("New User");
                    addUser();
                }
                else if(response.equals("3")){
                    System.out.println("Apply interest");
                    applyInterest();
                }
                else if(response.equals("0")){
                    keepGoing = false;
                }
                else{
                    System.out.println("Not a valid input");
                }
            }
            
        }
        
    }
}