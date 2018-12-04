package saldao8;

/**
 * This class implements a credit account and it's needed support and management
 * as transactions, account information etc.
 * 
 * @author Salim Daoud, saldao-8
 */

public class CreditAccount extends Account
{
    private double creditLimit;
    private final static AccountType ACCOUNT_TYPE = AccountType.CREDIT_ACCOUNT; 
    
    /**
     * Constructor
     */
    public CreditAccount()
    {
        super();
        
        this.setInterestRate(0.5);
        creditLimit = 5000;
    }
    
    /* (non-Javadoc)
     * @see saldao8.Account#getInterest()
     */
    public double getInterest()
    {
        if(this.getBalance() < 0)
        {
            return (this.getBalance() * (this.getInterestRate() / 100));
        }
        else
        {
            return (this.getBalance() * (this.getInterestRate() / 100));
        }
    }
    
    /* (non-Javadoc)
     * @see saldao8.Account#withdraw(double)
     */
    public boolean withdraw(double amount)
    {
        double balance = this.getBalance();
        
        // check if the amount isn't exceeding the credit limit
        if((balance - amount) < (0 - creditLimit))
        {
            return false;
        }
        
        balance -= amount;
        this.setBalance(balance);
        
        // add transaction to the transaction history
        this.setTransaction(this.getTransactionDate() + " " + (0 - amount) + " " + balance);
        
        // change the interest rate if the balance has become lower than 0
        if(balance < 0)
        {
            this.setInterestRate(7);
        }
        
        return true;
    }
    
    /* (non-Javadoc)
     * @see saldao8.Account#deposit(double)
     */
    public void deposit(double amount)
    {
        // first run the common code in the superclass
        super.deposit(amount);

        // add specific subclass code that change interest rate if the new balance is 0 or larger
        if(this.getBalance() >= 0)
        {
            this.setInterestRate(0.5);
        }
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
        System.out.println("testing-ca");

        CreditAccount ca = new CreditAccount();
//        CreditAccount ca2 = new CreditAccount();
//
//        System.out.println(ca.getBalance());
//        System.out.println(ca.getAccountId());
//        System.out.println(ca2.getAccountId());
//        
//        SavingsAccount sa = new SavingsAccount();
//        System.out.println(sa.getAccountId());
//        
//        System.out.println(ca.getInterestRate4NegBalance());
//        
//        System.out.println(ca.toString());
//        
//        ca.deposit(-1000);
//        System.out.println(ca.getInterest());
        
//        System.out.println("Get transactions: " + ca.getTransactions());
//        ca.deposit(1000);
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println("Get transactions: " + ca.getTransactions());
//        System.out.println("withdraw: " + ca.withdraw(6000));
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println("Get transactions: " + ca.getTransactions());
        
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println(ca.getInterestRate());
//        ca.deposit(500);
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println(ca.getInterestRate());
//        ca.withdraw(600);
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println(ca.getInterestRate());
//        ca.deposit(1100);
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println(ca.getInterestRate());
//        ca.withdraw(1100);
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println(ca.getInterestRate());
//        ca.deposit(100);
//        System.out.println("getBalance: " + ca.getBalance());
//        System.out.println(ca.getInterestRate());
        
        System.out.println(ca.toString());
    }
}
