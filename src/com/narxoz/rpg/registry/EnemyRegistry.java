package com.narxoz.rpg.registry;

import com.narxoz.rpg.enemy.Enemy;
import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> prototypes = new HashMap<>();

    public void addPrototype(String key, Enemy enemy) {
        prototypes.put(key, enemy);
    }

    public Enemy getClone(String key) {
        Enemy e = prototypes.get(key);
        return (e != null) ? e.clone() : null;
    }
}