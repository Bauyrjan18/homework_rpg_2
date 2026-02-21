package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.IceSpike;
import com.narxoz.rpg.loot.IceLoot;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        List<Ability> list = new ArrayList<>();
        list.add(new IceSpike());
        return list;
    }

    @Override
    public LootTable createLootTable() {
        return new IceLoot();
    }
}