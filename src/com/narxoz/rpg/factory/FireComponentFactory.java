package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FireBreath;
import com.narxoz.rpg.loot.FireLoot;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        List<Ability> list = new ArrayList<>();
        list.add(new FireBreath());
        return list;
    }
    @Override
    public LootTable createLootTable() { return new FireLoot(); }
}
