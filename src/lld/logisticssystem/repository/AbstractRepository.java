package lld.logisticssystem.repository;

import java.util.Map;

public class AbstractRepository<T> {

    protected Map<String, T> repository;

    public AbstractRepository(Map<String, T> repository) {
        this.repository = repository;
    }

    public T getData(String key) {
        return this.repository.get(key);
    }

    public void addData(String key, T data) {
        repository.put(key, data);
    }
}
