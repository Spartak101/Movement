package org.example.object;

import org.example.dmensionalityClasses.Argumenteble;
import org.example.exceptions.ObjectException;

import java.util.HashMap;

public class Object implements UObject {

    private HashMap<String, Argumenteble> map;

    public Object(HashMap<String, Argumenteble> map) {
        this.map = map;
    }


    @Override
    public java.lang.Object get(String key) {
        if (!map.containsKey(key)) {
            throw new ObjectException("Такого ключа нет");
        }
        return map.get(key);
    }

    @Override
    public void set(String key, Argumenteble value) {
        if (!map.containsKey(key)) {
            throw new ObjectException("Такого ключа нет");
        }
        map.put(key, value);
    }
}

