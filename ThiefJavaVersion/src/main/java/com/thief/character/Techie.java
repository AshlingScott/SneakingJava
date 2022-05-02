package com.thief.character;

import com.thief.map.Tile;
import java.util.ArrayList;

/* Sentry that uses traps and technology to defend the fort*/
public class Techie extends Guard
{

    public Techie() {
        super();
        location = null;
        attack_range = 2;

        // Roll the random stats
        Random rand = new Random();
        int roll = rand.nextInt(2,4);
        movement = roll;
        roll = rand.nextInt(3,6);
        vision = roll;
        roll = rand.nextInt(3,6);
        energy_gain = roll;
    }

    @Override
    public String get_symbol()
    {
        return "T";
    }

    @Override
    public void print_stats()
    {
        System.out.println("Techie");
        System.out.println("Movement: " + movement);
        System.out.println("Vision: " + vision);
        System.out.println("Energy: " + energy);
        System.out.println("Energy Gain: " + energy_gain);
    }

    // Drop an invisible summon that disables a Thief who walks on the tile
    public void stasis_trap(Tile target)
    {
        if (target.type == 0)
        {
            energy -= 5;
            //TODO: create summon on tile
        }
    }

    // Gain vision of tiles around a target radius for a duration
    public void scan(Tile target)
    {
        energy -= 4;
        visible_tiles.add(target);
        //TODO: add surrounding tiles
    }

    // Reduce the vision range of all Thieves for a duration
    public ArrayList<Thief> hack(ArrayList<Thief> thief_list)
    {
        energy -= 5;
        for (Thief thief : thief_list)
        {
            thief.vision -= 2;
        }

        return thief_list;
    }
}
