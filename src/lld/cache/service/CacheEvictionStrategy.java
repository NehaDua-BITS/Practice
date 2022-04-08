package lld.cache.service;

public interface CacheEvictionStrategy <K> {

    void keyAccessed(K key);

    K evictKey();

}
