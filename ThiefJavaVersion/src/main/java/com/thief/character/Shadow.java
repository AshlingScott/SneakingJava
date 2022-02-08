/*
 */
package com.thief.character;

import com.thief.map.Tile;

/* Shadow is a master of stealth, slipping through defenses easily and getting
out without a sound*/
public class Shadow extends Thief
{
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
