package lld.cache.service;

import lld.cache.exception.CacheException;
import lld.cache.exception.StorageFullException;
import lld.cache.storage.Storage;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cache<K,V> {

    private Storage storage;

    private CacheEvictionStrategy evictionStrategy;

    private Logger logger = Logger.getLogger(Cache.class.getName());

    public Cache(Storage storage, CacheEvictionStrategy evictionStrategy) {
        this.storage = storage;
        this.evictionStrategy = evictionStrategy;
    }

    public void add(K key, V value) {
        try {
            storage.add(key, value);
            evictionStrategy.keyAccessed(key);
        } catch (StorageFullException ex) {
            logger.log(Level.WARNING, ex.getMessage());
            K evictionKey = (K) evictionStrategy.evictKey();
            logger.info("Evicting key : " + evictionKey);
            storage.remove(evictionKey);
            this.add(key, value); //try adding again
        }
    }

    public V get(K key) {
        Object value = null;
        try {
            value = storage.get(key);
            evictionStrategy.keyAccessed(key);
        } catch(CacheException ex) {
            logger.log(Level.WARNING, "get() Failed : " + ex.getMessage());
            return null;
        }

        return (V)value;
    }

    public boolean remove(K key) {
        Object val = null;
        try {
            val = storage.remove(key);
        } catch (CacheException ex) {
            logger.log(Level.SEVERE, "remove() Failed : " + ex.getMessage());
        }
        return !Objects.isNull(val);
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
