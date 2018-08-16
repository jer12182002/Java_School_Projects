/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

public class Account implements java.io.Serializable{
    
    private int account;
    private String firstName;
    private String lastName;
    private double balance;
    
    public Account(int acc, String fName, String lName, double bal){
        account=acc;
        firstName=fName;
        lastName=lName;
        balance= bal;
        
    }
    public void accountSetter(int accSetter){
        account=accSetter;
    }
    
    public void firstNameSetter(String fNameSetter){
        firstName=fNameSetter;
    }
    
    public void lastNameSetter(String lNameSetter){
        lastName=lNameSetter;
    }
    public void balanceSetter(double balSetter){
        balance=balSetter;
    }
    
    public int accountGetter(){
        return account;
    }
    
    public String fNameGetter(){
        return firstName;
    }
    
    public String lNameGetter(){
        return lastName;
    }
    
    public double balGetter(){
        return balance;
    }
    
    @Override 
    public String toString(){
        return ("Account: "+account
                +"\nFirst Name: "+firstName
                +"\nLast Name: " +lastName
                +"\nBalance: "+balance+'\n');
    }
}
