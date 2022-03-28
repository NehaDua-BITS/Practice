package designpatterns.creational.factory;

/*
Creational design pattern
Used when a super class has mutliple sub-classes
Provides abstraction between client code and implementation
Even if sub-class changes or more classes are added, client code won't be affected much.
Just name/type has to be passed for desired object
 */

public class FactoryHelper {

    public static void main(String[] args) {
        //get mobile object
        Device mobile = DeviceFactory.getInstance("mobile", "987654321");
        System.out.println("Mobile = " + mobile);

        //get landline object
        Device landline = DeviceFactory.getInstance("landline", "246228829");
        System.out.println("Landline = " + landline);

        Device random = DeviceFactory.getInstance("random", "68929222");
        System.out.println("Random = " + random);
    }
}
