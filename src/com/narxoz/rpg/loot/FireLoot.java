package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;
public class FireLoot implements LootTable {
    private List<String> items;
    private int gold;
    private int experience;
    public FireLoot() {
        this.items = new ArrayList<>();
        this.items.add("Fire Essence");
        this.items.add("Burnt Scroll");
        this.gold = 150;
        this.experience = 250;
    }

    @Override
    public List<String> getItems() { return items; }

    @Override
    public int getGoldDrop() { return gold; }

    @Override
    public int getExperienceDrop() { return experience; }

    @Override
    public String getLootInfo() {
        return "Fire Loot Set: " + items.size() + " items, " + gold + " gold, " + experience + " XP.";
    }

    @Override
    public LootTable clone() {
        FireLoot copy = new FireLoot();
        copy.items = new ArrayList<>(this.items);
        copy.gold = this.gold;
        copy.experience = this.experience;
        return copy;
    }
}