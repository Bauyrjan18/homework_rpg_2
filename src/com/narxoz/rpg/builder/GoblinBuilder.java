package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.combat.Ability;
import java.util.List;

public class GoblinBuilder implements EnemyBuilder {
    private Enemy enemy;

    public GoblinBuilder() { this.enemy = new Goblin(); }

    @Override
    public EnemyBuilder reset() {
        this.enemy = new Goblin();
        return this;
    }

    @Override public EnemyBuilder setName(String name) { enemy.setName(name); return this; }
    @Override public EnemyBuilder setHealth(int health) { enemy.setHealth(health); return this; }
    @Override public EnemyBuilder setDamage(int damage) { enemy.setDamage(damage); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) { enemy.setAbilities(abilities); return this; }
    @Override public EnemyBuilder setLootTable(LootTable loot) { enemy.setLootTable(loot); return this; }

    @Override
    public Enemy build() { return enemy; }
}