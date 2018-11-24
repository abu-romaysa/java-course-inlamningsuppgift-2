package saldao8;

public class CreditAccount extends Account
{
    private static double interestRate4PosBalance; // todo iom att det kan ändras och då ska alla av dessa typer ändras
    private double creditLimit; // should I initialize static values here? https://beginnersbook.com/2013/05/static-variable/ - Static variables are initialized before any object of that class is created.
                                // antar ej static för olika för olika kunder
    /**
     * Constructor
     */
    public CreditAccount()
    {
        super();
        
        this.setInterestRate4NegBalance(7); // saldao: är den så viktig för modellen så att vi måste göra på detta vis
        this.setAccountType("Credit account");
        
        interestRate4PosBalance = 0.5;
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
            return (this.getBalance() * (this.getInterestRate4NegBalance() / 100)); // todo om saldo e neg? abs värde?
        }
        else
        {
            return (this.getBalance() * (interestRate4PosBalance / 100));
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
        
        return true;
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
        
        System.out.println("Get transactions: " + ca.getTransactions());
        ca.deposit(1000);
        System.out.println("getBalance: " + ca.getBalance());
        System.out.println("Get transactions: " + ca.getTransactions());
        System.out.println("withdraw: " + ca.withdraw(6000));
        System.out.println("getBalance: " + ca.getBalance());
        System.out.println("Get transactions: " + ca.getTransactions());
    }
}
