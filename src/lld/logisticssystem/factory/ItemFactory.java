package lld.logisticssystem.factory;

import lld.logisticssystem.constants.ItemCategory;
import lld.logisticssystem.model.Item;
import lld.logisticssystem.service.impl.PriceServiceImpl;

public class ItemFactory {

    public static Item getItem(String name, ItemCategory category) {
        return new Item(name, category, PriceServiceImpl.getPriceForItemType(category));
    }

}
