package saldao8;

public class CreditAccount extends Account
{
    private double creditLimit; // should I initialize static values here? https://beginnersbook.com/2013/05/static-variable/ - Static variables are initialized before any object of that class is created.
                                // antar ej static för olika för olika kunder
    /**
     * Constructor
     */
    public CreditAccount()
    {
        super();
        
        this.setInterestRate(0.5); // saldao: är den så viktig för modellen så att vi måste göra på detta vis // iom saldo 0
        this.setAccountType("Credit account");
        creditLimit = 5000;
    }
    
    /**
     * Provides the amount of interest
     * 
     * @return amount of interest
     */
    public double getInterest()
    {
        if(this.getBalance() < 0)
        {
            return (this.getBalance() * (this.getInterestRate() / 100)); // todo om saldo e neg? abs värde?
        }
        else
        {
            return (this.getBalance() * (this.getInterestRate() / 100));
        }
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
        
        if((balance - amount) < (0 - creditLimit))
        {
            return false;
        }
        
        balance -= amount;
        this.setBalance(balance);
        this.setTransaction(this.getTransactionDate() + " " + (0 - amount) + " " + balance);
        
        if(balance < 0)
        {
            this.setInterestRate(7);
        }
        
        return true;
    }
    
    /**
     * Deposits the amount to the account
     * 
     * @param amount
     *            - the amount to deposit
     */
    public void deposit(double amount)
    {
        super.deposit(amount); // todo antingen detta eller kolla typ i superklassen. detta med super fins i boken för att spara kodrader
        
        if(this.getBalance() >= 0)
        {
            this.setInterestRate(0.5);
        }
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
    }
}
