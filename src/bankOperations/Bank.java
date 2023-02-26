package bankOperations;

import authentication.SignUp;

import java.util.Random;
import java.util.Scanner;

public class Bank implements Calculate_interest, Approve_Loan {
    private long accountNumber;

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    private int years;
    public boolean isSavings() {
        return isSavings;
    }

    public void setSavings(boolean savings) {
        isSavings = savings;
    }

    private boolean isSavings;

    private String accountHolderName;

    public Bank(String name,long number,int actype,int years){
        this.accountHolderName= name;
        this.accountNumber = number;
        if(actype==1){
            //this is savings account

            isSavings = true;
            if(actype==1){
                //it is saving account ask for time period as well
                this.years = years;
            }
        }else{
            //this is current account
            isSavings = false;
        }
    }
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
    private void interest(int amount,int years){
        double rate = 5.0;
        double interestAmount = (amount * years * rate) / 100;
        System.out.println("You will get an interest of "+interestAmount+" each year !");
    }

    public void deposit(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit :");
        int value = scan.nextInt();
        if(value<=0){
            System.out.println("Invalid choice");
            return;
        }
        balance+=value;
        if(isSavings)
            interest(balance,years);
        System.out.println("Deposit successfully!");
    }
    public void withDraw(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw :");
        int value = scan.nextInt();
        if(value<=0){
            System.out.println("Invalid choice");
            return;
        }
        //always keep 2000 as balance in account you cannot withdraw more than that
        if(value > balance){
            System.out.println("You don't have sufficient amount!");
            return;
        }
        else if(balance-2000 < value){
            System.out.println("You must keep atleast 2000 rupees in your account");
            return;
        }
        balance-=value;
        System.out.println("Withdraw successful!");
    }
    public void displayAccount(){
        System.out.println("Account Info ::");
        System.out.println("Account Holder Name :"+this.getAccountHolderName());
        System.out.println("Account Holder Number :"+this.getAccountNumber());
        System.out.println("Account Type :"+((isSavings)?" Savings":" Current"));
        System.out.println("Account Balance :"+this.getBalance());
    }

    public void approveOnSavings(int loanAmt){
        balance = this.getBalance();
        if(balance >= 100000){
            if(loanAmt>0 && loanAmt <= balance*1.5){
                System.out.println("Your Loan is Approved!");
            }else{
                System.out.println("Your request has been noted. Your branch will contact you for followup!");
            }
        }else{
            System.out.println("Your request has been noted. Your branch will contact you for followup!");
        }
    }

    public void approveOnCurrent(int loanAmt){
        balance = this.getBalance();
        if(balance >= 500000){
            if(loanAmt>0 && loanAmt <= balance*3){
                System.out.println("Your Loan is Approved!");
            }else{
                System.out.println("Your request has been noted. Your branch will contact you for followup!");
            }
        }else{
            System.out.println("Your request has been noted. Your branch will contact you for followup!");
        }
    }


}
