package bankOperations;

import authentication.SignUp;

import java.util.Random;
import java.util.Scanner;

public class Bank {
    public boolean isNumberAssign;
    private long accountNumber;
    private String accountHolderName;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;
    private SignUp user;

    public Bank(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Account Holder Name :");
        String name = scan.nextLine();
        assignAccountNumber();
    }

    public void assignAccountNumber(){
        long minStart = 1000000000L;
        long maxEnd = 9999999999L;
        Random random = new Random();
        long randomNum = minStart + (long) (random.nextDouble() * (maxEnd - minStart));
        BankDB db = new BankDB();
        boolean numberExists=db.isNumberExists(randomNum);
        while(numberExists){
            randomNum = minStart + (long) (random.nextDouble() * (maxEnd - minStart));
            numberExists = db.isNumberExists(randomNum);
        }
        this.setAccountNumber(randomNum);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public SignUp getUser() {
        return user;
    }

    public void setUser(SignUp user) {
        this.user = user;
    }

    public void deposit(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposite :");
        int value = scan.nextInt();
        if(value<=0){
            System.out.println("invalide choice");
            return;
        }
        balance+=value;
    }
    public void withDraw(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw :");
        int value = scan.nextInt();
        if(value<=0){
            System.out.println("invalide choice");
            return;
        }
        //always keep 2000 as balance in account you cannot withdraw more than that
        if(value > balance){
            System.out.println("you dont have suffiecient amount!");
            return;
        }
        else if(balance-2000 < value){
            System.out.println("You must keep 2000 rupees in your account");
            return;
        }
        balance-=value;
    }
    public void displayAccount(){
        System.out.println("Account Info :");
        System.out.println("Account Holder Name :"+this.getAccountNumber());
        System.out.println("Account Holder Number :"+this.getAccountNumber());
        System.out.println("Account Balance :"+this.getBalance());
    }
}
