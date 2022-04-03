package designpatterns.structural.command.executor;

import designpatterns.structural.command.model.Command;
import designpatterns.structural.command.model.CommandName;
import designpatterns.structural.command.service.Database;

public class BalanceCommandExecutor extends CommandExecutor {

    private static Database database;

    public BalanceCommandExecutor() {
        this.database = Database.getDatabase();
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName() == CommandName.BALANCE;
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams() != null
                && command.getParams().size() == 1;
    }

    @Override
    protected String executeCommand(Command command) {
        Double balance = database.getUserBalance(command.getParams().get(0));
        System.out.println("User : " + command.getParams().get(0) + " ; Balance : " + balance);
        return String.valueOf(balance);
    }
}
