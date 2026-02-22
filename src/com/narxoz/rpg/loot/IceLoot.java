package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLoot implements LootTable {
    private List<String> items = new ArrayList<>();

    public IceLoot() {
        items.add("Ice Chunk");
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getGoldDrop() {
        return 100;
    }

    @Override
    public int getExperienceDrop() {
        return 250;
    }

    @Override
    public String getLootInfo() { return "Loot: Ice Items"; }

    @Override
    public LootTable clone() {
        IceLoot copy = new IceLoot();
        copy.items = new ArrayList<>(this.items);
        return copy;
    }
}