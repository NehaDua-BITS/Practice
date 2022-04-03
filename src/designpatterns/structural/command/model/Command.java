package designpatterns.structural.command.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Command {

    private CommandName name;

    private List<String> params;

    public Command(CommandName name, List<String> params) {
        this.name = name;
        this.params = params;
    }
}
