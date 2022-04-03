package designpatterns.creational.builder;

import java.sql.Time;

public class BuilderHelper {

    public static void main(String[] args) {
        Vehicle auto = new Vehicle.VehicleBuilder("A", 3).build();
        Vehicle car = new Vehicle.VehicleBuilder("B", 4).setModelYear(2020).build();

        System.out.println(auto);
        System.out.println(car);

        new BuilderHelper().lombokBuilder();
    }

    private void lombokBuilder() {
        CarBuilderWithLombok car = CarBuilderWithLombok.builder().airbags(1).brand("Mercedes").seats(6).build();
        System.out.println("Number of seats = " + car.getSeats() + " ; Company = " + car.getBrand());
    }
}
