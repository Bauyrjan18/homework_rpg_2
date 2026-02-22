package com.narxoz.rpg.registry;

import com.narxoz.rpg.enemy.Enemy;
import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy enemy) {
        templates.put(key, enemy);
    }

    public Enemy createFromTemplate(String key) {
        Enemy e = templates.get(key);
        return (e != null) ? e.clone() : null;
    }
}