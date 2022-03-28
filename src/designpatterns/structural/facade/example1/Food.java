package designpatterns.structural.facade.example1;

import java.util.List;

public interface Food {

    void prepareFood(List<String> ingredients);

    String deliverFood();
}
