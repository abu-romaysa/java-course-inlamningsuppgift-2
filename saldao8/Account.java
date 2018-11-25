package saldao8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Account
{
    private double balance;
    private int accountId;
    private double interestRate; // todo bara för att det e en del i modellen/grunden - obs var static innan ej nu när den ändras pos/neg
    private static int accountIdCounter = 1001;
    private ArrayList<String> transactions = new ArrayList<String>();
    
    public Account()
    {
        // assign an accountId and accumulate the counter that handles Ids
        accountId = accountIdCounter;
        accountIdCounter += 1;

        balance = 0;
    }

    protected double getBalance()
    {
        return balance;
    }

    protected void setBalance(double amount)
    {
        balance = amount;
    }

    protected double getInterestRate()
    {
        return interestRate;
    }

    protected void setInterestRate(double interest)
    {
        interestRate = interest;
    }

    /**
     * Provides the account ID for this account
     * 
     * @return account ID
     */
    public int getAccountId()
    {
        return accountId;
    }

    /**
     * Deposits the amount to the account
     * 
     * @param amount
     *            - the amount to deposit
     */
    public void deposit(double amount)
    {
        balance += amount;

        transactions.add(getTransactionDate() + " " + amount + " " + balance); 
    }
    
    protected String getTransactionDate()
    {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());
        
        // Create an instance of SimpleDateFormat used for formatting 
        // the string representation of date (month/day/year)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Using SimpleDateFormat format method we can create a string 
        // representation of a date with the defined format.
        
        // todo https://stackoverflow.com/a/5683761
        // https://www.javatpoint.com/java-date-to-string
        // https://www.tutorialspoint.com/java/java_date_time.htm
        String transactionDate = dateFormat.format(date);  
        
//        System.out.println(transactionDate);
//             
        return transactionDate;
    }
    
    protected void setTransaction(String transaction)
    {
        transactions.add(transaction);
    }
    
    public ArrayList<String> getTransactions()
    {
        return transactions;
    }

    /**
     * Provides presentation information about the account
     * 
     * @return string containing information about the account
     */
    public String toString()
    {
        return Integer.toString(accountId) + " " + Double.toString(balance) + " " + getAccountType() + " "
                + Double.toString(interestRate);
    }

    // declaration of abstract methods
    protected abstract String getAccountType(); // https://stackoverflow.com/questions/4898736/java-static-field-in-abstract-class/4898769#4898769
    public abstract boolean withdraw(double amount);
    public abstract double getInterest();
}
