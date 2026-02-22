package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.*;

public class DragonBoss implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;
    public DragonBoss(String name, int health, int damage, int defense,
                      int speed, String element,
                      List<Ability> abilities,
                      int phase1Threshold, int phase2Threshold, int phase3Threshold,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.phases = new HashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public void setName(String name) { this.name = name; }
    @Override public void setHealth(int health) { this.health = health; }

    public void setDamage(int damage) { this.damage = damage; }
    @Override public void setElement(String element) { this.element = element; }
    @Override public void multiplyStats(double multiplier) {
        this.health *= multiplier;
        this.damage *= multiplier;
    }

    @Override public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }
    @Override public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }

    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey()
                    + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly
                + " | Breath Attack: " + hasBreathAttack
                + " | Wingspan: " + wingspan);
    }
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for(Ability a : this.abilities) clonedAbilities.add(a.clone());
        return new DragonBoss(name, health, damage, defense, speed, element,
                clonedAbilities, phases.get(1), phases.get(2), phases.get(3),
                lootTable != null ? lootTable.clone() : null,
                aiBehavior, canFly, hasBreathAttack, wingspan);
    }
}
