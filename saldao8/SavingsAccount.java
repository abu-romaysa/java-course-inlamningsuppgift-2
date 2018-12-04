package saldao8;

/**
 * This class implements a saving account and it's needed support and management
 * as transactions, account information etc.
 * 
 * @author Salim Daoud, saldao-8
 */

public class SavingsAccount extends Account
{
    private boolean neverWithdrawn;
    private static double interestRate4Withdrawal;
    private static final AccountType ACCOUNT_TYPE = AccountType.SAVINGS_ACCOUNT; 

    /**
     * Constructor
     */
    public SavingsAccount()
    {
        super();
        this.setInterestRate(1);

        neverWithdrawn = true;
        interestRate4Withdrawal = 2;
    }
    
    /**
     * Provides the amount of interest
     * 
     * @return amount of interest
     */
    public double getInterest()
    {
        return (this.getBalance() * (this.getInterestRate() / 100));
    }

    /* (non-Javadoc)
     * @see saldao8.Account#withdraw(double)
     */
    public boolean withdraw(double amount)
    {
        double balance = this.getBalance();
        
        // checks if the full amount exists
        if(neverWithdrawn) // never withdrawn before i.e. no interest should be counted for
        {
            if((balance - amount) < 0)
            {
                return false;
            }
            
            neverWithdrawn = false;
        }
        else // withdrawn before and an interest should be counted for
        {
            amount += (amount * interestRate4Withdrawal/100);  
            
            if((balance - (amount)) < 0)
            {
                return false;
            }
        }
        
        balance -= amount;
        this.setBalance(balance);
        
        // add transaction to the transaction history
        this.setTransaction(this.getTransactionDate() + " " + (0 - amount) + " " + balance); 
        
        return true;     
    }
    
    /* (non-Javadoc)
     * @see saldao8.Account#getAccountType()
     */
    protected AccountType getAccountType()
    {
        return ACCOUNT_TYPE;
    }
    
    public static void main(String[] args)
    {
        System.out.println("testing");

        SavingsAccount sa = new SavingsAccount();   
//        SavingsAccount sa2 = new SavingsAccount();
//
//        System.out.println(sa.getBalance());
//        System.out.println(sa.getAccountId());
//        System.out.println(sa2.getAccountId());
//        System.out.println(sa.getInterestRate4NegBalance());
//        System.out.println(sa.toString());
        
        sa.deposit(1000);
        //System.out.println(sa.getInterest());
        
//        System.out.println("getBalance: " + sa.getBalance());
//        System.out.println("withdraw: " + sa.withdraw(500));
//        System.out.println("getBalance: " + sa.getBalance());
//        System.out.println("withdraw: " + sa.withdraw(500));
//        System.out.println("getBalance: " + sa.getBalance());
        
        sa.deposit(2000);
        System.out.println("Get transactions: " + sa.getTransactions());
        
        sa.withdraw(500);
        System.out.println("Get transactions: " + sa.getTransactions());
        
//        System.out.println(sa.getAccountType());
//        SavingsAccount sa2 = new SavingsAccount();
//        System.out.println(sa2.getAccountType());
//        CreditAccount ca = new CreditAccount();
//        System.out.println(ca.getAccountType());
//        System.out.println(sa.getAccountType());
//        System.out.println(sa2.getAccountType());
//        System.out.println(ca.getAccountType());
        
        System.out.println(sa.toString());
    }

}
