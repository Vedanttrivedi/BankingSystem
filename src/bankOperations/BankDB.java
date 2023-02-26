package bankOperations;

import authentication.SignUp;

import java.awt.desktop.ScreenSleepEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class BankDB {
    //class that holds database of bank users
    private HashMap<String,Bank> db;
    private HashSet<Long> accountNums;
    public BankDB(){
        accountNums = new HashSet<>();
        db = new HashMap<>();
    }
    public void addUser(SignUp user){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Account Holder Name :");
        String acname = scan.nextLine();
        if(acname.length()==0)
            acname = scan.nextLine();
        System.out.println("Enter Account Type (1) for savings and (2) for current: ");
        int acType = scan.nextInt();
        int years=0;
        if(acType==1){
            //it is saving account ask for time period as well
            System.out.println("For Many Years You want Save your money in the bank  :");

            years = scan.nextInt();
        }
        long number = assignAccountNumber();
        accountNums.add(number);
        db.put(user.getUsername(),new Bank(acname,number,acType,years));
        System.out.println("Your "+((acType==1)?"Savings ":"Current ")+"Account number : "+number);

        System.out.println("keep note of the account number");
        System.out.println("Your Bank Account Is Linked! Login Again!");
    }

     boolean isNumberExists(long num){

        return accountNums.contains(num);
    }

    public HashMap<String, Bank> getDb() {
        return db;
    }

    public long assignAccountNumber(){
        long minStart = 1000000000L;
        long maxEnd = 9999999999L;
        Random random = new Random();
        long randomNum = minStart + (long) (random.nextDouble() * (maxEnd - minStart));
        boolean numberExists=this.isNumberExists(randomNum);
        while(numberExists){
            randomNum = minStart + (long) (random.nextDouble() * (maxEnd - minStart));
            numberExists = this.isNumberExists(randomNum);
        }
        return randomNum;
    }
}
