/*
 */
package com.thief.character;

import com.thief.map.Tile;

/* Shadow is a master of stealth, slipping through defenses easily and getting
out without a sound*/
public class Shadow extends Thief
{

    public Shadow() {
        super();
        location = null;
        hp = 2;

        // Shadow has permanent level 1 stealth
        stealth = 1;

        // Roll the random stats
        Random rand = new Random();
        int roll = rand.nextInt(3,5);
        movement = roll;
        roll = rand.nextInt(4,7);
        vision = roll;
        roll = rand.nextInt(3,5);
        energy_gain = roll;
    }

    @Override
    public String get_symbol()
    {
        return "W";
    }

    @Override
    public void print_stats()
    {
        System.out.println("Shadow");
        System.out.println("Movement: " + movement);
        System.out.println("Vision: " + vision);
        System.out.println("Energy: " + energy);
        System.out.println("Energy Gain: " + energy_gain);
    }

    // Shift into the void, becoming more stealthy for a duration
    public void shadow_dance()
    {
        energy -= 3;
        stealth = 2;
    }

    // Warp to a tile location
    public void dark_warp(Tile target)
    {
        energy -= 3;
        location = target;
    }
}
