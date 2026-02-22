package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.combat.Ability;
import java.util.List;

public class BossBuilder implements EnemyBuilder {
    private Enemy enemy;

    public BossBuilder() { this.enemy = new DragonBoss(); }

    @Override
    public EnemyBuilder reset() {
        this.enemy = new DragonBoss();
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