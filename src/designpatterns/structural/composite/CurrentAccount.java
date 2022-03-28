package designpatterns.structural.composite;

public class CurrentAccount implements Account {

    private int balance;

    public CurrentAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
