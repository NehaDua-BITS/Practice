package designpatterns.creational.factory;

public class DeviceFactory {

    public static Device getInstance(String type, String id) {
        if (type.equalsIgnoreCase(Mobile.class.getSimpleName())) {
            return new Mobile(id);
        } else if (type.equalsIgnoreCase(Landline.class.getSimpleName())) {
            return new Landline(id);
        }
        return null; //or throw exception
    }

}
