package lld.logisticssystem.service;

import lld.logisticssystem.model.Address;
import lld.logisticssystem.model.Item;
import lld.logisticssystem.model.Order;
import lld.logisticssystem.model.User;

import java.util.List;

public interface OrderService {

    Order placeOrder(User user, List<Item> items, Address source, Address destination);

    void cancelOrder(User user, String orderId);

    void removeOrderItem(User user, String orderId, String itemId);

    Order getOrderById(User user, String orderId);

    void addOrderItem(User user, String orderId, Item item);
}
