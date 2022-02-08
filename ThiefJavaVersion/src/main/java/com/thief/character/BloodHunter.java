package com.thief.character;

import com.thief.map.*;
import java.util.ArrayList;

/* Blood Hunter lacks much vision, and seeks out enemies using his sense of 
smell, tracking them where other Guards cannot go, like through forests*/
public class BloodHunter extends Guard
{
    @Override
    public String get_symbol()
    {
        return "B";
    }
    
    @Override
    public void print_stats()
    {
        System.out.println("Blood Hunter");
        System.out.println("Movement: " + movement);
        System.out.println("Vision: " + vision);
        System.out.println("Energy: " + energy);
        System.out.println("Energy Gain: " + energy_gain);
    }
    
    public void track(Map map)
    {
        energy -= 3;
    }
    
    // Detect nearby Thieves and reveal their location
    public void blood_scent()
    {
        energy -= 3;
        //TODO: find if thieves are in the area
    }
    
    // Destroy all Thieves in a radius around a tile
    public void blood_rite(Tile target, Map map)
    {
        energy -= 5;
        // Grab a square of range 2 and look for enemies in it
        // and killll them
        ArrayList<Tile> blood = map.grab_square(map, target, 2);
        blood.stream().filter(t -> (t.occupied == true)).forEachOrdered(t -> {
            t.occupant.kill();  // Todo: remove unit from game
        });
    }
}

