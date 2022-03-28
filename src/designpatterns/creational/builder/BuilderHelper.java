package designpatterns.creational.builder;

public class BuilderHelper {

    public static void main(String[] args) {
        Vehicle auto = new Vehicle.VehicleBuilder("A", 3).build();
        Vehicle car = new Vehicle.VehicleBuilder("B", 4).setModelYear(2020).build();

        System.out.println(auto);
        System.out.println(car);
    }
}
