package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
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
    @Override public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }
    @Override public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size() + " ability(ies)");
        if (lootTable != null) System.out.println(lootTable.getLootInfo());
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        // Глубокое копирование способностей
        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) copy.abilities.add(a.clone());
        // Глубокое копирование лута
        if (this.lootTable != null) copy.lootTable = this.lootTable.clone();
        return copy;
    }


}
