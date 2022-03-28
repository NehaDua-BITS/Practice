package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Account {

    private List<Account> accountList;

    @Override
    public double getBalance() {
        double balance = 0.0;
        for (Account account : accountList) {
            balance += account.getBalance();
        }
        return balance;
    }

    public void addAccount(Account account) {
        if (accountList == null) {
            accountList = new ArrayList<>();
        }
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        if (accountList != null) {
            accountList.remove(account);
        }
    }
}
