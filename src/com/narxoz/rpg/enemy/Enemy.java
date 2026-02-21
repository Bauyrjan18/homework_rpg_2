package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    void setName(String name);
    void setHealth(int health);
    void setDamage(int damage);
    void setAbilities(List<Ability> abilities);
    void setLootTable(LootTable loot);
    String getName();
    int getHealth();
    void showInfo();
    Enemy clone();
}
