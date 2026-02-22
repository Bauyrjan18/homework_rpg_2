package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface EnemyBuilder {
    EnemyBuilder reset();
    EnemyBuilder setName(String name);
    EnemyBuilder setHealth(int health);
    EnemyBuilder setDamage(int damage);
    EnemyBuilder setAbilities(List<Ability> abilities);
    EnemyBuilder setLootTable(LootTable lootTable);
    Enemy build();
}