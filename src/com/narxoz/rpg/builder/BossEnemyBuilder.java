package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private int phase1, phase2, phase3;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;
    @Override
    public EnemyBuilder reset() {
        this.name = null; this.health = 0; this.damage = 0;
        this.abilities = new ArrayList<>(); this.lootTable = null;
        return this;
    }

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = abilities; return this; }
    @Override public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    public BossEnemyBuilder setElement(String element) { this.element = element; return this; }
    public BossEnemyBuilder setPhases(int p1, int p2, int p3) {
        this.phase1 = p1; this.phase2 = p2; this.phase3 = p3; return this;
    }
    public BossEnemyBuilder setAIAndFlight(String ai, boolean fly, boolean breath, int span) {
        this.aiBehavior = ai; this.canFly = fly; this.hasBreathAttack = breath; this.wingspan = span;
        return this;
    }

    @Override
    public Enemy build() {
        return new DragonBoss(name, health, damage, defense, speed, element, abilities,
                phase1, phase2, phase3, lootTable, aiBehavior, canFly, hasBreathAttack, wingspan);
    }
}