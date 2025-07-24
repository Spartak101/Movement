package org.example.object;
import java.util.Map;

public interface UObject<K, V> {
    /**
     * Возвращает значение по ключу.
     *
     * @param key ключ элемента
     * @return значение по указанному ключу или null, если ключа нет
     */
    java.lang.Object get(String key) throws Exception;

    /**
     * Сохраняет пару ключ-значение в хранилище.
     *
     * @param key ключ
     * @param value значение
     */

    void set(String key, java.lang.Object value);
}
