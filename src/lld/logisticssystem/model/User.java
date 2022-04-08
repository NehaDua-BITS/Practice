package lld.logisticssystem.model;

import lld.logisticssystem.exceptions.InvalidInputException;
import lld.logisticssystem.exceptions.InvalidOrderException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private final UUID id;

    private String name;

    private Address address;

    private List<Order> orderList;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.orderList = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order) {
        if (order == null) {
            throw new InvalidInputException("Order cannot be null");
        }
        if (order.getItems() == null || order.getPaymentDetails() == null) {
            throw new InvalidOrderException("Order items or payment details cannot be null");
        }
        this.orderList.add(order);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
