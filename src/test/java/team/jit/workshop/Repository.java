package team.jit.workshop;

import team.jit.workshop.data.Car;

import java.util.HashMap;
import java.util.Map;

public class Repository<T_KEY, T extends Entity> {

    private Map<T_KEY, T> store = new HashMap<>();

    public void create(T_KEY key, T createdObject) {
        store.put(key, createdObject);
    }

    public T get(T_KEY key) {
        return store.get(key);
    }

    public <Z> Z transform(T_KEY key) {


        return null;
    }
}
