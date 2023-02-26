package home;
import authentication.SignUp;
import authentication.SignIn;
import bankOperations.Bank;
import bankOperations.BankDB;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.io.Console;
public class HomeScreen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Console cls = System.console();
        boolean isSystemOn = true;
        SignUp register=null;
        HashMap<String,SignUp> users = new HashMap<>();
        BankDB db = new BankDB();
        int totalUsers=0;
        SignIn login=null;
        while(isSystemOn)
        {
            System.out.println("Home->>Press 1 for Registration,\t 2 for Login,\t 3 for Forget password,\t 0 to exit the application");
            System.out.print("Enter choice :");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("\t\tRegistration Form!!");
                    System.out.print("Enter Username :");
                    String tempUsername = sc.next();

                    //check if user exists in hashmap of users
                    if(users.containsKey(tempUsername))
                    {
                        System.out.println("Username already exists! Cannot create account!");
                    }
                    else
                    {
                        //username does not exist . so we can create account
                        SignUp user = new SignUp(tempUsername);
                        users.put(tempUsername,user);
                        totalUsers++;
                        System.out.println("SignUp is successful! You can login now");
                    }
                    break;
                case 2:
                    System.out.println("\t\tLogin Form!!");
                    System.out.print("Enter username :");
                    sc.nextLine();
                    String name = sc.nextLine();
                    //check if the user exits in our list of users
                    SignUp tempLoggedUser = users.get(name);
                    if(tempLoggedUser!=null)
                    {
                        //username exists to we can ask for  password
                        System.out.print("Enter password :");
                        String pwd;
                        if(cls!=null)
                        {
                            char[] tempPass = cls.readPassword("");
                            pwd = String.valueOf(tempPass);
                            if(pwd.length()!=0)
                            {
                                for(char cd:tempPass)
                                    System.out.print("*");
                            }
                            System.out.println();
                        }
                        else
                        {
                            System.out.println("System.console is null. using scanner to input password");
                            pwd = sc.next();
                        }
                        login = new SignIn();
                        //now check for password matching
                        boolean checkForPassword = login.doLogin(name,pwd,tempLoggedUser);
                        if(checkForPassword){
                            //user is logged in show user dashboard
                            System.out.println("\t\tYou are logged In!");
                            register = users.get(name);
                            if(db.getDb().containsKey(name)){
                                //user is loggin  in bank 2nd time so user has account number and name
                                System.out.println("Enter Account Holder Name :");
                                String acName = sc.nextLine().toLowerCase();
                                if(acName.length()==0)
                                    acName = sc.nextLine().toLowerCase();
                                System.out.println("Enter Account Number : ");
                                long ans = sc.nextLong();
                                boolean rightAccountNumber = (ans==db.getDb().get(name).getAccountNumber());
                                boolean rightName = (acName.equals(db.getDb().get(name).getAccountHolderName().toLowerCase()));

                                if(rightName && rightAccountNumber){

                                    //details are valid show user dashboard
                                    DashBoard dashboard = new DashBoard(db.getDb().get(name));
                                }else{
                                    //invalid details
                                    System.out.println("Your account number and account holder name does not match!");
                                }
                            }else{
                                //user is registering first time in the bank
                                SignUp temp = new SignUp(register.getUsername(),register.getPassword(),register.getFullname());
                                db.addUser(temp);

                            }
                        }else{
                            System.out.println("Invalid Details");
                        }
                    }else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 3:
                    SignUp temp = new SignUp();
                    temp.forgetPassword(users);
                    break;
                case 0:
                    isSystemOn = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        System.out.println("Hey, Thank you for visiting to bank!");
    }
}