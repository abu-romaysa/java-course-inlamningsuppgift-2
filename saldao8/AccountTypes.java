package saldao8;

public interface AccountTypes
{
    enum AccountType {
        SAVINGS_ACCOUNT,
        CREDIT_ACCOUNT
    } // todo https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    
    // todo p762 automatiskt public static final dvs underförstått då konstant i ett gränssnitt
    // todo kan oxå bara anv byte sa = 1 etc men...
}
