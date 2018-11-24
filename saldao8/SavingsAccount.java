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

    /**
     * Constructor
     */
    public SavingsAccount()
    {
        super();
        this.setInterestRate4NegBalance(1); // saldao: är den så viktig för modellen så att vi måste göra på detta vis
        this.setAccountType("Saving account");
        
        neverWithdrawn = true;
        interestRate4Withdrawal = 2; // konsekvent
    }
    
    /**
     * Provides the amount of interest
     * 
     * @return amount of interest
     */
    public double getInterest()
    {
        return (this.getBalance() * (this.getInterestRate4NegBalance() / 100));
    }

    /**
     * Withdraws the amount from the account if the full amount exists
     * 
     * @param amount - the amount to withdraw
     * @return true if amount is withdrawn otherwise false
     */
    public boolean withdraw(double amount)
    {
        double balance = this.getBalance();
        
        if(neverWithdrawn)
        {
            if((balance - amount) < 0)
            {
                return false;
            }
            
            neverWithdrawn = false; // todo kan nere men d sätter jag den hela tiden till true kanske ej optimerat
        }
        else
        {
            amount += (amount * interestRate4Withdrawal/100);  
            
            if((balance - (amount)) < 0)
            {
                return false;
            }
        }
        
        balance -= amount;
//        System.out.println("balance: " + balance);
//        System.out.println("amount: " + amount);
        this.setBalance(balance);
        
        this.setTransaction(this.getTransactionDate() + " " + (0 - amount) + " " + balance); 
        
        return true;     
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
    }

}
