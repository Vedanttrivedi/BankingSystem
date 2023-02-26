package home;

import bankOperations.Bank;
import bankOperations.BankDB;

import java.util.Scanner;

public class DashBoard {
    Bank bankUser;
    BankDB db;
    public DashBoard(Bank bankUser){
        System.out.println("In the dashboard");
        this.bankUser = bankUser;
        initialize();
    }
    public int ask(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press (1) For WithDraw Amount | (2) For Deposit | (3) For Display Information | (4) Loan | (5) Logout");
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
                    System.out.println("Enter the amount you would like to take loan for: ");
                    int loanAmt = scan.nextInt();
                    if(this.bankUser.isSavings())
                        bankUser.approveOnSavings(loanAmt);
                    else
                        bankUser.approveOnCurrent(loanAmt);
                    break;

                case 5:
                    onDashBoard = false;
                    System.out.println("Thank You for visiting the bank!");
                    break;
            }

        }
    }
}
