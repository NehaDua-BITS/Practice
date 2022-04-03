package multithreading.printoddeven;

import lombok.Getter;
import lombok.Setter;
import multithreading.printoddeven.PrintType;

@Getter
@Setter
public class State {

    private PrintType printType;

    public State(PrintType type) {
        this.printType = type;
    }
}
