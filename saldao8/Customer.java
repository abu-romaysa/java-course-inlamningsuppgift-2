package saldao8;

/**
 * This class implements a customer and manages the customer's information and
 * accounts
 * 
 * @author Salim Daoud, saldao-8
 */

import java.util.ArrayList;

public class Customer implements AccountTypes
{
    private String firstName, lastName, personalIdentityNumber;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    /**
     * Constructor
     * 
     * @param firstName - new customer's first name
     * @param lastName - new customer's last name
     * @param personalIdentityNumber - new customer's personal identity number
     */
    public Customer(String firstName, String lastName, String personalIdentityNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
    }

    /**
     * Changes the customer's first name
     * 
     * @param firstName - name to change to
     */
    public void changeFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Changes the customer's last name
     * 
     * @param lastName - name to change to
     */
    public void changeLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Provides the customer's first name
     * 
     * @return string containing the customer's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Provides the customer's last name
     * 
     * @return string containing the customer's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Provides the customer's personal identity number
     * 
     * @return string containing the customer's personal identity number
     */
    public String getPersonalIdentityNumber()
    {
        return personalIdentityNumber;
    }

    /**
     * Creates a saving account for the customer
     * 
     * @return the account ID for the created account
     */
//    public int createSavingsAccount()
//    {
//        SavingsAccount account = new SavingsAccount();
//        accounts.add(account);
//
//        return account.getAccountId();
//    }
    
    public int createAccount(AccountType accountType)
    {
        Account account = null;
        
        if(accountType == AccountType.CREDIT_ACCOUNT)
        {
            account = new CreditAccount();
            System.out.println("created ca");
        }
        else if (accountType == AccountType.SAVINGS_ACCOUNT)
        {
            account = new SavingsAccount(); 
            System.out.println("created sa");
        }
        
        accounts.add(account);

        if(account != null)
        {
            return account.getAccountId();
        }
        else return -1;
    }
    
    public ArrayList<String> getTransactions(int accountId)
    {
        ArrayList<String> transactions = new ArrayList<String>();
        
        Account account = findAccount(accountId);
        if(account != null)
        {
            return account.getTransactions();
        }
        
        return transactions;
    }
    
    public static void main(String[] args)
    {
        Customer c = new Customer("salim", "daoud", "811113");
        int res = c.createAccount(AccountType.SAVINGS_ACCOUNT);
        System.out.println(res);
        
        c.deposit(1001, 1000);
        c.deposit(1001, 500);
        System.out.println(c.getTransactions(1001));
    }

    /**
     * Deletes all the accounts that belongs to the customer
     * 
     * @return string containing information about the customer's deleted
     *         accounts
     */
    public ArrayList<String> deleteAccounts()
    {
        ArrayList<String> deletedAccountsInfo = new ArrayList<String>();

        for(Account account : accounts)
        {
            deletedAccountsInfo.add(account.toString() + " " + Double.toString(account.getInterest()));
        }

        accounts.clear();

        return deletedAccountsInfo;
    }

    /**
     * Removes the customer's account
     * 
     * @param accountId - account ID to remove
     * @return string containing information about the customer's deleted
     *         account, otherwise null if it could not be deleted
     */
    public String removeAccount(int accountId)
    {
        Account account = findAccount(accountId);
        if(account != null)
        {
            String deletedAccountInfo = account.toString() + " " + Double.toString(account.getInterest());
            accounts.remove(account);

            return deletedAccountInfo;
        }

        return null;
    }

    /**
     * Provides information about a customer's account
     * 
     * @param accountId - the account ID in question
     * @return string containing information about the customer's account,
     *         otherwise null if it could not be found
     */
    public String getAccount(int accountId)
    {
        Account account = findAccount(accountId);
        if(account != null)
        {
            return account.toString();
        }

        return null;
    }

    /**
     * Provides the customer's account IDs
     * 
     * @return list with account IDs belonging to the customer
     */
    public ArrayList<Integer> getAccountIds()
    {
        ArrayList<Integer> accountIds = new ArrayList<Integer>();

        for(Account account : accounts)
        {
            accountIds.add(account.getAccountId());
        }

        return accountIds;
    }

    /**
     * Deposits the amount to the customer's account
     * 
     * @param accountId - account ID to deposit to
     * @param amount - the amount to deposit
     * @return true if the amount could be deposit
     */
    public boolean deposit(int accountId, double amount)
    {
        Account account = findAccount(accountId);
        if(account != null)
        {
            account.deposit(amount);
            return true;
        }

        return false;
    }

    /**
     * Withdraws the amount from the customer's account
     * 
     * @param accountId - account ID to withdraw from
     * @param amount - the amount to withdraw
     * @return true if the amount could be withdrawn
     */
    public boolean withdraw(int accountId, double amount)
    {
        Account account = findAccount(accountId);
        if(account != null)
        {
            return account.withdraw(amount);
        }

        return false;
    }

    /**
     * Provides presentation information about the customer
     * 
     * @return string containing information about the customer
     */
    public String toString()
    {
        return firstName + " " + lastName + " " + personalIdentityNumber;
    }

    /**
     * Searches for an account with a specific account ID
     * 
     * @param accountId - account ID to lookup
     * @return the account with a specific account ID, otherwise null if the
     *         account could not be found
     */
    private Account findAccount(int accountId)
    {
        for(Account account : accounts)
        {
            if(account.getAccountId() == accountId)
            {
                return account;
            }
        }

        return null;
    }

}