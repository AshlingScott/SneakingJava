/*
 */
package com.thief.character;

import com.thief.map.Tile;
import java.util.Random;

/* Golem is a durable Guard class, lacking mobility but threatening at close
range and difficult to disrupt*/
public class Golem extends Guard
{
    /* block can nullify attempts to disable this Guard
    overcharge lets the golem kill in one hit*/
    boolean block, overcharge;

    public Golem() {
        super();
        location = null;
        attack_range = 1;

        // Set special flags to false
        block = false;
        overcharge = false;

        // Roll the random stats
        Random rand = new Random();
        movement = rand.nextInt(2,5);
        vision = rand.nextInt(3,6);
        energy_gain = rand.nextInt(2,5);
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
