package lld.logisticssystem.model;

import lld.logisticssystem.constants.OrderStatus;
import lld.logisticssystem.exceptions.InvalidInputException;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID orderId;

    private List<Item> items;

    private final ZonedDateTime creationTimestamp;

    private ZonedDateTime deliveryTimestamp;

    private OrderStatus orderStatus;

    private PaymentDetails paymentDetails;

    private Address source;

    private Address destination;

    public Order(List<Item> items, Address source, Address destination) {
        if (items == null) {
            throw new InvalidInputException("Items cannot be null for creating an order");
        }
        this.orderId = UUID.randomUUID();
        this.items = new ArrayList<>(items);
        this.creationTimestamp = ZonedDateTime.now();
        this.orderStatus = OrderStatus.CREATED;
        this.source = source;
        this.destination = destination;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public ZonedDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public ZonedDateTime getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    public void setDeliveryTimestamp(ZonedDateTime deliveryTimestamp) {
        this.deliveryTimestamp = deliveryTimestamp;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        if (orderStatus == OrderStatus.COMPLETED) {
            this.deliveryTimestamp = ZonedDateTime.now();
        }
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", items=" + items +
                ", creationTimestamp=" + creationTimestamp +
                ", deliveryTimestamp=" + deliveryTimestamp +
                ", orderStatus=" + orderStatus +
                ", paymentDetails=" + paymentDetails +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}
