package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    String getName();
    int getHealth();
    void setName(String name);
    void setHealth(int health);
    void setElement(String element);
    void setAbilities(List<Ability> abilities);
    void setLootTable(LootTable lootTable);
    void multiplyStats(double multiplier);
    void displayInfo();
    Enemy clone();
}
