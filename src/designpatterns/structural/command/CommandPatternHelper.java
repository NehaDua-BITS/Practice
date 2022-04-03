package designpatterns.structural.command;

import designpatterns.structural.command.executor.BalanceCommandExecutor;
import designpatterns.structural.command.executor.CommandExecutor;
import designpatterns.structural.command.executor.RechargeCommandExecutor;
import designpatterns.structural.command.model.Command;
import designpatterns.structural.command.model.CommandName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandPatternHelper {

    private static List<CommandExecutor> commandExecutorList;

    public static void main(String[] args) {

        commandExecutorList = new ArrayList<>();
        commandExecutorList.add(new BalanceCommandExecutor());
        commandExecutorList.add(new RechargeCommandExecutor());

        Command command1 = new Command(CommandName.BALANCE, new ArrayList<>(Arrays.asList("Neha")));
        Command command2 = new Command(CommandName.RECHARGE, new ArrayList<>(Arrays.asList("Neha", "100")));
        Command command3 = new Command(CommandName.RECHARGE, new ArrayList<>(Arrays.asList("Neha", "-20")));

        CommandPatternHelper obj = new CommandPatternHelper();
        obj.executeCommand(command1);
        obj.executeCommand(command2);
        obj.executeCommand(command1);
        obj.executeCommand(command3);
        obj.executeCommand(command1);
    }

    private void executeCommand(Command command) {
        for (CommandExecutor executor : commandExecutorList) {
            if (executor.isApplicable(command)) {
                executor.execute(command);
                return;
            }
        }
    }

}
