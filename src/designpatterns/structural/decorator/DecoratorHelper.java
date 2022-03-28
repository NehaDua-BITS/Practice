package designpatterns.structural.decorator;

/**
 * Structural Design Pattern
 * Improves structure of code - improves code quality, reability, maintainability, etc
 *
 * Decortor pattern is used when there is need to modify functionality of object at runtime
 * It should not change individual object functionality
 * ex: adding different functionalities/features to car/dress/cake
 *
 * OBJECT IS DECORATED AS PER REQUIREMENT
 */


//INTERFACE -> BASE CLASS -> CHILD CLASSES 1,2,3,...
    //INTERFACE -> BASE CLASS
//              -> DECORATOR CLASS (TAKES INTERFACE AS ARG) -> CHILD CLASSES 1,2,3,...
public class DecoratorHelper {

    public static void main(String[] args) {
        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }

}
