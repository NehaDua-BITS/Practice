package lld.cache.storage;

public interface Storage<K,V> {

    V get(K key);

    void add(K key, V value);

    V remove(K key);
}
