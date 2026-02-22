package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class GoblinBuilder implements EnemyBuilder {
    private Goblin goblin;

    public GoblinBuilder() { this.goblin = new Goblin("Unknown Goblin"); }

    @Override
    public EnemyBuilder reset() { this.goblin = new Goblin("Unknown Goblin"); return this; }

    @Override public EnemyBuilder setName(String name) { goblin.setName(name); return this; }
    @Override public EnemyBuilder setHealth(int health) { goblin.setHealth(health); return this; }
    @Override public EnemyBuilder setDamage(int damage) { goblin.setDamage(damage); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) { goblin.setAbilities(abilities); return this; }
    @Override public EnemyBuilder setLootTable(LootTable lootTable) { goblin.setLootTable(lootTable); return this; }

    @Override
    public Enemy build() { return goblin; }
}