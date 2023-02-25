package authentication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import java.io.Console;
public class SignUp {
    private String username;
    private String password;
    private String fullname;
    private int points;
    private int itemsBought;
    public SignUp(){}

    public void registerUser(String username){
        //for multiple user
        Scanner scan = new Scanner(System.in);
        this.username = username;
        System.out.print("Enter fullname :");
        this.fullname = scan.nextLine();
        if(this.fullname.length()==0)
            this.fullname = scan.nextLine();
        System.out.print("Enter password : ");
        String password="";
        Console cls = System.console();
        if(cls!=null)
        {
            char[] tempPass = cls.readPassword("");
            password = String.valueOf(tempPass);
            if(password.length()!=0)
            {
                for(char cd:tempPass)
                    System.out.print("*");
            }
            while(password.length()==0)
            {
                System.out.println("password cannot be empty!!");
                System.out.print("Enter password :");
                char[] temp= cls.readPassword("");
                for(char c:temp)
                    System.out.print("*");
                System.out.println();
                password = String.valueOf(temp);
            }
            System.out.println();
        }
        else
        {
            System.out.println("console is null");
            System.out.println("Enter password :");
            password = scan.next();
            while(password.length()==0)
            {
                System.out.println("password cannot be empty!!");
                System.out.print("Enter password :");

                password = scan.next();
            }
        }
        this.password = password;
        itemsBought = 0;
        points = 500000;

    }
    public SignUp(String name,String password,String fullname){
        this.fullname = fullname;
        this.username = name;
        this.password = password;
    }
    public void forgetPassword(HashMap<String,SignUp> users){
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\tPassword Reset Form!!");
        System.out.print("Enter Username to reset password : ");
        String tempname = scan.next();
        //check if the user exists with that username
        boolean check = users.containsKey(tempname);
        if(check){
            //user exists so we can change the password
            System.out.print("Enter new password : ");
            String password="";
            Console cls = System.console();
            if(cls!=null)
            {
                char[] tempPass = cls.readPassword("");
                for(char c:tempPass)
                    System.out.print("*");
                password = String.valueOf(tempPass);
                while(password.length()==0)
                {
                    System.out.println("password cannot be empty!!");
                    System.out.print("Enter new password :");
                    char[] temp= cls.readPassword("");
                    for(char c:temp)
                        System.out.print("*");
                    System.out.println();
                    password = String.valueOf(temp);
                }
            }
            else
            {
                System.out.println("console is null");
                System.out.println("Enter new password :");
                password = scan.next();
                while(password.length()==0)
                {
                    System.out.println("password cannot be empty!!");
                    System.out.print("Enter new password :");
                    password = scan.next();
                }
            }
            users.get(tempname).setPassword(password);

            System.out.println("Your password has been updated! You can login now");
        }else{
            //username does not exists
            System.out.println("Account does not exists with that username! Try again");
        }
    }

    public String getUsername(){
        return this.username;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPoints() {
        return points;
    }

    public int getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(int itemsBought) {
        this.itemsBought = itemsBought;
    }
    public SignUp(String name){
        this.registerUser(name);
    }
    public String getPassword(){
        return this.password;
    }    public String getName(){
        return this.username;
    }

    public String getFullname(){
        return this.fullname;
    }

}
