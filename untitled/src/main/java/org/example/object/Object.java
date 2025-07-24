package org.example.object;

import java.util.HashMap;

public class Object implements UObject {

    private HashMap map;

    public Object(HashMap map) {
        this.map = map;
    }

    public Object() {
    }

    @Override
    public java.lang.Object get(String key) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Такого ключа нет");
        }
        return map.get(key);
    }

    @Override
    public void set(String key, java.lang.Object value) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Такого ключа нет");
        }
        map.put(key, value);
    }
}

