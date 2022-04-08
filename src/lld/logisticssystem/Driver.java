package lld.logisticssystem;

import lld.logisticssystem.constants.ItemCategory;
import lld.logisticssystem.factory.ItemFactory;
import lld.logisticssystem.model.Address;
import lld.logisticssystem.model.Item;
import lld.logisticssystem.model.Order;
import lld.logisticssystem.model.User;
import lld.logisticssystem.service.OrderService;
import lld.logisticssystem.service.impl.OrderServiceImpl;

import java.util.Arrays;

public class Driver {

    private static OrderService orderService = OrderServiceImpl.getInstance();

    public static void main(String[] args) {

        //create users
        User user1 = new User("Neha");
        User user2 = new User("Parth");

        //create addresses
        Address address1 = new Address.AddressBuilder()
                .setLine1("line1")
                .setLine2("line2")
                .setCountry("India")
                .setZipcode("560103").build();

        Address address2 = new Address.AddressBuilder()
                .setLine1("line1")
                .setLine2("line2")
                .setCountry("India")
                .setZipcode("560122")
                .build();

        //create items
        Item docItem = ItemFactory.getItem("Rent Agreement", ItemCategory.DOCUMENT);
        Item shoesItem = ItemFactory.getItem("Shoes", ItemCategory.CLOTHING);
        Item pizzaItem = ItemFactory.getItem("Pizza", ItemCategory.EATABLES);

        //placeOrder
        Order order1 = orderService.placeOrder(user1, Arrays.asList(docItem, shoesItem), address1, address2);
        orderService.placeOrder(user2, Arrays.asList(pizzaItem, shoesItem), address2, address1);

        //display details
        System.out.println("User 1 Details : " + user1);
        System.out.println("User 2 Details : " + user2);

        //cancel order
        System.out.println("Cancelled order of user 1 ...");
        orderService.cancelOrder(user1, order1.getOrderId().toString());

        //display details
        System.out.println("User 1 Details : " + user1);
        System.out.println("User 2 Details : " + user2);
    }

}
