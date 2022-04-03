package designpatterns.structural.command.executor;

import designpatterns.structural.command.model.Command;
import designpatterns.structural.command.model.CommandName;
import designpatterns.structural.command.service.Database;

public class RechargeCommandExecutor extends CommandExecutor {

    private Database database;

    public RechargeCommandExecutor() {
        this.database = Database.getDatabase();
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName() == CommandName.RECHARGE;
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams() != null && command.getParams().size() == 2;
    }

    @Override
    protected String executeCommand(Command command) {
        Double balance = database.getUserBalance(command.getParams().get(0));
        balance += Double.parseDouble(command.getParams().get(1));
        database.upsertUser(command.getParams().get(0), balance);
        System.out.println("User : " + command.getParams().get(0) + " ; Updated = " + balance);
        return balance.toString();
    }
}
