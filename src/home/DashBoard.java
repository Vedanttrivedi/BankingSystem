package home;

import bankOperations.Bank;
import bankOperations.BankDB;

import java.util.Scanner;

public class DashBoard {
    Bank bankUser;
    public DashBoard(Bank bankUser){
        bankUser = this.bankUser;
        initialize();
    }
    public int ask(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press (1) For WithDraw Amount| (2) For WithDraw|(3) For Display Information");
        System.out.println("Enter choice :");
        int choice = scan.nextInt();
        return choice;
    }
    public void initialize(){
        boolean onDashBoard = false;
        int choice ;
        while(onDashBoard){
            choice = ask();
            switch (choice){
                case 1:
                    //withdraw amount
                    break;
                case 2:
                    //deposit amount
                    break;
                case 3:
                    //display information
                    break;
                case 4:
                    onDashBoard = false;
                    System.out.println("You are logout!");
                    break;
            }
            choice = ask();
        }
    }
}
