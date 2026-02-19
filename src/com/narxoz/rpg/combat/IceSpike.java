package com.narxoz.rpg.combat;

public class IceSpike implements Ability {
    @Override
    public int getDamage() {return 30;};
    @Override
    public Ability clone(){
        return new IceSpike();
    }
    @Override
    public String getDescription() {return "Throws a sharp ice spike";};
    @Override
    public String getName() { return "Ice Spike"; }
}
