package lld.logisticssystem.service.impl;

import lld.logisticssystem.constants.ItemCategory;
import lld.logisticssystem.exceptions.LogisticsException;
import lld.logisticssystem.model.Item;
import lld.logisticssystem.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PriceServiceImpl {

    private static Logger logger = Logger.getLogger(PriceServiceImpl.class.getName());

    private static Map<ItemCategory, Double> priceMap;

    static {
        priceMap = new HashMap<>(ItemCategory.values().length);
        priceMap.put(ItemCategory.CLOTHING, 100.00);
        priceMap.put(ItemCategory.DOCUMENT, 50.00);
        priceMap.put(ItemCategory.EATABLES, 20.00);
        priceMap.put(ItemCategory.ELECTRONICS, 80.00);
    }

    public static Double getPriceForItemType(ItemCategory category) {
        if (!priceMap.containsKey(category)) {
            throw new LogisticsException("Price not found for given category");
        }
        return priceMap.get(category);
    }

    public static Map<ItemCategory, Double> getPrices() {
        return priceMap;
    }

    public static Double calculateOrderPrice(Order order) {
        List<Item> items = order.getItems();
        if (items == null) {
            logger.warning("calculateOrderPrice(): Order is empty !");
            return 0.0;
        }

        double amount = 0.0;
        for (int i = 0; i < items.size(); i++) {
            amount += items.get(i).getPrice();
        }

        return amount;
    }
}
