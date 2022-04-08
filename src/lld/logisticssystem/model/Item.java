package lld.logisticssystem.model;

import lld.logisticssystem.constants.ItemCategory;

import java.util.UUID;

public class Item {

    private final UUID id;

    private String name;

    private ItemCategory category;

    private Double price;

    public Item(String name, ItemCategory category, Double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
