package designpatterns.structural.command.executor;

import designpatterns.structural.command.model.Command;

public abstract class CommandExecutor {

    public String execute(Command command) {
        if (!isValid(command)) {
            throw new RuntimeException("Invalid command");
        }
        return executeCommand(command);
    }

    public abstract boolean isApplicable(Command command);

    protected abstract boolean isValid(Command command);

    protected abstract String executeCommand(Command command);
}
