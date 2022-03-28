package designpatterns.creational.builder;

/**
 * Creational design pattern
 * Used when multiple parameters have to be passed to constructor &
 * it's difficult to maintain the order of parameters &
 * it's not mandatory to pass all parameters to constructor
 */
public class Vehicle {

    private String type;

    private int wheels;

    private int modelYear;

    //private constructor so that only builder class can create object
    private Vehicle(VehicleBuilder builder) {
        this.type = builder.type;
        this.modelYear = builder.modelYear;
        this.wheels = builder.wheels;
    }

    //should have only getters and not setters
    public String getType() {
        return type;
    }

    public int getWheels() {
        return wheels;
    }

    public int getModelYear() {
        return modelYear;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", wheels=" + wheels +
                ", modelYear=" + modelYear +
                '}';
    }

    //static inner builder class
    public static class VehicleBuilder {

        private String type;

        private int wheels;

        private int modelYear;

        //public constructor with required arguments
        public VehicleBuilder(String type, int wheels) {
            this.type = type;
            this.wheels = wheels;
            this.modelYear = 1900;
        }

        //setter method for optional param; but builder object should be returned
        public VehicleBuilder setModelYear(int modelYear) {
            this.modelYear = modelYear;
            return this;
        }

        //method that creates target class object
        public Vehicle build()  {
            return new Vehicle(this);
        }
    }
}
