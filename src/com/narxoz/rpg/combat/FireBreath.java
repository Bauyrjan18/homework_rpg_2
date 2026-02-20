package com.narxoz.rpg.combat;

public class FireBreath implements Ability {
    @Override
    public String getName(){return "FireBreath";}
    @Override
    public String getDescription(){return "Spews fire at the enemy";}
    @Override
    public int getDamage() {return 50;}
    @Override
    public Ability clone(){return new FireBreath();}
}
