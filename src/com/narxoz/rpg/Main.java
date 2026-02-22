package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.GoblinBuilder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.registry.EnemyRegistry;
import com.narxoz.rpg.factory.ShadowComponentFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        System.out.println("Factories initialized: Fire and Ice themes available.");

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        BossEnemyBuilder bossBuilder = new BossEnemyBuilder();
        Enemy dragon = bossBuilder
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();

        GoblinBuilder basicBuilder = new GoblinBuilder();
        Enemy forestGoblin = basicBuilder
                .setName("Forest Goblin")
                .setHealth(200)
                .setDamage(30)
                .build();

        System.out.println("Custom Dragon Boss and Forest Goblin constructed.");
        dragon.displayInfo();
        forestGoblin.displayInfo();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();

        registry.registerTemplate("goblin", forestGoblin);
        registry.registerTemplate("dragon", dragon);

        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        if (eliteGoblin != null) {
            eliteGoblin.setName("Elite Goblin");
            eliteGoblin.multiplyStats(2.0); // 2x stats
            System.out.println("Created Elite variant from Goblin template.");
            eliteGoblin.displayInfo();
        }

        Enemy fireVariantDragon = registry.createFromTemplate("dragon");
        if (fireVariantDragon != null) {
            fireVariantDragon.setName("Inferno Drake");
            fireVariantDragon.setElement("FIRE");
            fireVariantDragon.setAbilities(fireFactory.createAbilities());
            System.out.println("\nCreated Elemental variant from Dragon template.");
            fireVariantDragon.displayInfo();
        }

        System.out.println("\n--- Deep Copy Proof ---");
        System.out.println("Original Dragon HP: " + dragon.getHealth());
        System.out.println("Cloned Dragon HP (before change): " + fireVariantDragon.getHealth());
        fireVariantDragon.setHealth(99999);
        System.out.println("Cloned Dragon HP (after change): " + fireVariantDragon.getHealth());
        System.out.println("Original Dragon HP (remains unchanged): " + dragon.getHealth());

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .build();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        if (greaterDemon != null) {
            greaterDemon.setName("Greater Demon Lord");
            greaterDemon.multiplyStats(2.5);
            System.out.println("Full pipeline result (Shadow Factory -> Builder -> Registry -> Clone):");
            greaterDemon.displayInfo();
        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();
            System.out.println("Abstract Factory: Themed component families (Fire, Ice, Shadow)");
            System.out.println("Builder: Complex step-by-step enemy construction with Fluent Interface");
            System.out.println("Factory Method: Embedded in Builder.build()");
            System.out.println("Prototype: Efficient template cloning with deep copy (verified)");

        System.out.println("\n=== Demo Complete ===");
    }
}
}

