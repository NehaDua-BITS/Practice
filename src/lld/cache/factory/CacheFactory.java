package lld.cache.factory;

import lld.cache.service.Cache;
import lld.cache.service.impl.LRUEvictionStrategy;
import lld.cache.storage.HashBasedStorage;

public class CacheFactory<K, V> {

    public Cache<K, V> getDefaultCache(int capacity) {
        return new Cache<K, V>(new HashBasedStorage<K, V>(capacity), new LRUEvictionStrategy<K>());
    }
}
