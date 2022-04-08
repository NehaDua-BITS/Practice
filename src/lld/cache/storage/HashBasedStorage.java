package lld.cache.storage;

import lld.cache.exception.KeyNotFoundException;
import lld.cache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HashBasedStorage<K, V> implements Storage<K, V> {

    private int cacheLimit;

    private Map<K, V> keyValueMap;

    private Logger logger = Logger.getLogger(HashBasedStorage.class.getName());

    public HashBasedStorage(int cacheLimit) {
        this.cacheLimit = cacheLimit;
        this.keyValueMap = new HashMap<>();
    }

    public V get(K key) {
        V value = keyValueMap.get(key);
        if (value == null) {
            throw new KeyNotFoundException("Key not found for retrieval");
        }
        return value;
    }

    public void add(K key, V value) {
        if (!keyValueMap.containsKey(key) && keyValueMap.size() == cacheLimit) {
            throw new StorageFullException("Cache is full. Failed to add new entry !");
        }
        keyValueMap.put(key, value);
    }

    public V remove(K key) {
        V val = keyValueMap.remove(key);
        if (val == null) {
            throw new KeyNotFoundException("Key not found for deletion !");
        }
        return val;
    }

    public void clear() {
        this.keyValueMap.clear();
    }

    public int getCacheLimit() {
        return cacheLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : keyValueMap.entrySet()) {
           sb.append(entry.getKey() + " : " + entry.getValue());
           sb.append("\n");
        }
        return sb.toString();
    }
}
