package com.solidCore.utils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

@Component
public class GuavaCacheUtils<K, V> {

    private static int duration = 86400;
    private Cache<K, V> cache;

    public GuavaCacheUtils() {
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(duration, TimeUnit.SECONDS)
                .build();
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getIfPresent(key);
    }

    public boolean containsKey(K key) {
        return cache.getIfPresent(key) != null;
    }

    public void remove(K key) {
        cache.invalidate(key);
    }

    public Set<K> keySet() {
        return cache.asMap().keySet();
    }

    public void clear() {
        cache.invalidateAll();
    }
}
