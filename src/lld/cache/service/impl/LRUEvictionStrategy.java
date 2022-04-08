package lld.cache.service.impl;

import lld.cache.service.CacheEvictionStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUEvictionStrategy<K> implements CacheEvictionStrategy<K> {

    private Queue<Node> linkedList;
    private HashMap<K, Node> keyMap;

    public LRUEvictionStrategy() {
        this.linkedList = new LinkedList<>();
        this.keyMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            linkedList.remove(node);
            linkedList.add(node);
        } else {
            Node node = new Node(key);
            linkedList.add(node);
            keyMap.put(key, node);
        }
    }

    @Override
    public K evictKey() {
        Node node = linkedList.poll();
        if(node == null) {
            return null;
        }
        return (K) node.key;
    }
}

class Node<K> {
    K key;

    public Node(K key) {
        this.key = key;
    }
}