package lld.cache;

import java.util.HashMap;
import java.util.LinkedList;

//TODO
public class LRU {

    private LinkedList<Integer> linkedList;
    private HashMap<Integer, Integer> itemIndexMap;

    public LRU() {
        linkedList = new LinkedList<>();
        itemIndexMap = new HashMap<>();
    }

    public static void main(String[] args) {
        //add new element
        //linkedList.addLast();
        //linkedList.remove(9);
    }

    public boolean addToCache(Integer element) {
        if (itemIndexMap.containsKey(element)) {
            return false;
        }
        linkedList.addLast(element);
        return true;
    }

    public Integer getFromCache() {
        return 1;
    }
}
