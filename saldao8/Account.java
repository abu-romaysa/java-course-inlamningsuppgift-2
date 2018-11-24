package saldao8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Account
{
    private double balance;
    private int accountId;
    private double interestRate4NegBalance; // todo bara för att det e en del i
                                            // modellen/grunden - obs var static
                                            // innan
    private String accountType;
    private static int accountIdCounter = 1001;
    
    private ArrayList<String> transactions = new ArrayList<String>();

    public Account()
    {
        // assign an accountId and accumulate the counter that handles Ids
        accountId = accountIdCounter;
        accountIdCounter += 1;

        balance = 0;
        interestRate4NegBalance = 0; // todo behöver ge värde här? bara en del
                                     // av modellen ju
        // accountType = "account"; // todo se ovan
    }

    protected double getBalance()
    {
        return balance;
    }

    protected void setBalance(double amount)
    {
        balance = amount;
    }

    protected double getInterestRate4NegBalance()
    {
        return interestRate4NegBalance;
    }

    protected void setInterestRate4NegBalance(double interest)
    {
        interestRate4NegBalance = interest;
    }

    protected String getAccountType()
    {
        return accountType;
    }

    protected void setAccountType(String accountType)
    {
        this.accountType = accountType;
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
        return Integer.toString(accountId) + " " + Double.toString(balance) + " " + accountType + " "
                + Double.toString(this.getInterest());
    }

    abstract boolean withdraw(double amount);

    abstract double getInterest();
}
