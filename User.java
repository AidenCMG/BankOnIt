import java.util.*;

abstract class user implements HasMenu{
    private String userName;
    private String PIN;

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String checkName = scanner.nextLine();
        System.out.print("PIN: ");
        String checkPIN = scanner.nextLine();
        if(userName.equals(checkName) && PIN.equals(checkPIN)){
            return true;
        }
        return false;
    }

    public boolean login(String userName, String PIN){
        if(this.userName.equals(userName) && this.PIN.equals(PIN)){
            return true;
        }
        return false;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPIN(String PIN){
        this.PIN = PIN;
    }

    public String getPIN(){
        return PIN;
    }

    abstract String getReport();



}