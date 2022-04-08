package lld.logisticssystem.service.impl;

import lld.logisticssystem.constants.OrderStatus;
import lld.logisticssystem.constants.PaymentMode;
import lld.logisticssystem.exceptions.InvalidOrderException;
import lld.logisticssystem.model.Address;
import lld.logisticssystem.model.Item;
import lld.logisticssystem.model.Order;
import lld.logisticssystem.model.User;
import lld.logisticssystem.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;

    private OrderServiceImpl() {}

    public static OrderService getInstance() {
        if(instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    public Order placeOrder(User user, List<Item> items, Address address1, Address address2) {
        Order order = new Order(items, address1, address2);
        order.setPaymentDetails(PaymentServiceImpl.generatePaymentDetails(order, PaymentMode.UPI));
        user.addOrder(order);
        return order;
    }

    public void cancelOrder(User user, String orderId) {
        Order order = getOrderById(user, orderId);
        if (order == null) {
            throw new InvalidOrderException("Order id does not exists");
        }
        order.setOrderStatus(OrderStatus.CANCELLED);
    }

    public void removeOrderItem(User user, String orderId, String itemId) {
        Order order = getOrderById(user, orderId);
        if (order == null) {
            throw new InvalidOrderException("Order id does not exists");
        }

        List<Item> items = order.getItems()
                .stream()
                .filter(i -> i.getId().toString().equals(itemId))
                .collect(Collectors.toList());
        order.setItems(items);
    }

    public void addOrderItem(User user, String orderId, Item item) {
        Order order = getOrderById(user, orderId);
        if (order == null) {
            throw new InvalidOrderException("Order id does not exists");
        }
        order.addItem(item);
    }

    public Order getOrderById(User user, String orderId) {
        Optional<Order> optionalOrder = user.getOrderList()
                .stream()
                .filter(o -> o.getOrderId().toString().equals(orderId))
                .findFirst();

        return optionalOrder.isPresent() ? optionalOrder.get() : null;
    }
}
