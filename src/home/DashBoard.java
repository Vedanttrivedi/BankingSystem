package home;

import bankOperations.Bank;
import bankOperations.BankDB;

import java.util.Scanner;

public class DashBoard {
    Bank bankUser;
    public DashBoard(Bank bankUser){
        System.out.println("IN the dashboard");
        this.bankUser = bankUser;
        initialize();
    }
    public int ask(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press (1) For WithDraw Amount| (2) For Deposit|(3) For Display Information|(4) t logouto");
        System.out.println("Enter choice :");
        int choice = scan.nextInt();
        return choice;
    }
    public void initialize(){
        boolean onDashBoard = true;
        int choice ;
        Scanner scan = new Scanner(System.in);
        while(onDashBoard){
            choice = ask();
            System.out.println("Choice :"+choice);
            switch (choice){
                case 1:
                    //withdraw amount
                    bankUser.withDraw();
                    break;
                case 2:
                    bankUser.deposit();
                    //deposit amount
                    break;
                case 3:
                    //display information
                    bankUser.displayAccount();
                    break;
                case 4:
                    onDashBoard = false;
                    System.out.println("Thank You for visiting the bank!");
                    break;
            }
        }
    }
}
