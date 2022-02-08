package com.thief.character;

import com.thief.map.Tile;

//Sprinter is the fastest thief, but lacks any talent in being sneaky
public class Sprinter extends Thief
{
    @Override
    public String get_symbol()
    {
        return "S";
    }
    
    @Override
    public void print_stats()
    {
        System.out.println("Sprinter");
        System.out.println("Movement: " + movement);
        System.out.println("Vision: " + vision);
        System.out.println("Energy: " + energy);
        System.out.println("Energy Gain: " + energy_gain);
    }
    
    // Gain a burst of speed for a duration
    public void sprint()
    {
        energy -= 3;
        movement += 3;
    }
    
    // Throw the treasure to another Thief
    public void toss(Thief target)
    {
        if (has_treasure)
        {
            energy -= 2;
            target.has_treasure = true;
            has_treasure = false;
        }        
    }
    
    // Leap into the air, can jump over rocks and trees
    public void vault(Tile target)
    {
        energy -= 3;
        location = target;
    }
}
