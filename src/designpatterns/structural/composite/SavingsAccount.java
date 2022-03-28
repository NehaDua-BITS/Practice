package designpatterns.structural.composite;

public class SavingsAccount implements Account {

    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
