/*
 */
package com.thief.character;

import com.thief.map.Tile;

/* Golem is a durable Guard class, lacking mobility but threatening at close
range and difficult to disrupt*/
public class Golem extends Guard
{
    public Golem(int m, int v, int e_g, Tile loc)
    {
        super(m, v, e_g, loc);
    }
    
    @Override
    public String get_symbol()
    {
        return "G";
    }
    
    @Override
    public void print_stats()
    {
        System.out.printf("Golem%nMovement: " + movement + "%nVision: " +
            vision + "%nEnergy: " + energy + "%nEnergy Gain: " + energy_gain
            + "%n");
    }
    
    /* Lunge toward a target tile, travelling across fields only.  Disables
    all nearby Thieves around the landing point*/
    public void charge(Tile target)
    {
        energy -= 3;
        location = target;
        //TODO: check for nearby thieves and disable them
    }
    
    // Smash a rock tile, turning it into a field
    public void smash(Tile target)
    {
        if (target.type == 2)
        {
            energy -= 2;
            target.type = 0;
        }
    }
}
