package bankOperations;

import authentication.SignUp;

import java.util.HashMap;

public class BankDB {
    //class that holds database of bank users
    private HashMap<String,Bank> db;

    public BankDB(){
        db = new HashMap<>();
    }
    public void addUser(SignUp user){
        Bank bank = new Bank();
        bank.setUser(user);
        bank.assignAccountNumber();
        db.put(user.getUsername(),bank);
    }
     boolean isNumberExists(long num){
        return db.containsKey(num);
    }

    public HashMap<String, Bank> getDb() {
        return db;
    }

}
