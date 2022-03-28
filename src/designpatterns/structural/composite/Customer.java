package designpatterns.structural.composite;

/**
 * Used when multiple independent classes can be combined to give an outcome
 * It follows tree-like structure
 * where a node can be - leaf node (independent class), composite node (composite class)
 * All nodes act as same object
 */
public class Customer {

    public static void main(String[] args) {
        //root
        BankAccount bankAccount = new BankAccount();

        //adding leaf nodes
        bankAccount.addAccount(new SavingsAccount(3000));
        bankAccount.addAccount(new CurrentAccount(7000));
        bankAccount.addAccount(new SavingsAccount(1000));

        //creating composite node
        BankAccount otherBankAccount = new BankAccount();
        otherBankAccount.addAccount(new SavingsAccount(2000));
        otherBankAccount.addAccount(new CurrentAccount(600));
        //adding composite node
        bankAccount.addAccount(otherBankAccount);

        System.out.println("Total Balance (individuals + other account) : " + bankAccount.getBalance());
    }

}
