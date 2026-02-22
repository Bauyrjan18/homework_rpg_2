package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;

public class Goblin implements Enemy {
    private String name;
    private int health = 100;
    private int damage = 15;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.abilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    @Override public void setElement(String element) {};
    public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }
    public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }
    @Override public void multiplyStats(double m) { this.health *= m; this.damage *= m; }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: ");
        System.out.println("Abilities: " + abilities.size() + " ability(ies)");
        if (lootTable != null) System.out.println(lootTable.getLootInfo());
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) copy.abilities.add(a.clone());
        if (this.lootTable != null) copy.lootTable = this.lootTable.clone();
        return copy;
    }
}
