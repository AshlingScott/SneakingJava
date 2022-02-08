package com.thief.character;

import com.thief.map.*;
import java.util.ArrayList;
import java.util.HashSet;

/* Thieves are Units that are attacking to steal treasure.  They win by
getting a treasure back to their base*/
public abstract class Thief extends Unit
{
    // Whether the thief is alive or dead
    boolean alive;

    public Thief(int m, int v, int e_g, Tile loc) 
    {
        super(m, v, e_g, loc);
        alive = true;
    }
    
    //kills the thief
    @Override
    public void kill()
    {
        alive = false;
    }
    
    // Thieves can walk through field and forest
    // refreshes their vision through visible_tiles set
    public void move(Tile target, Map map)
    {
        // If terrain walkable
        if (target.type <= 1)
        {
            // Remove from old location
            location.occupied = false;
            location.occupant = null;
            // Update to new location
            location = target;
            target.occupied = true;
            target.occupant = this;
        }
        else
            System.out.println("Thief can't move there.");
        
        
    }
    
    // Get set of tiles in vision range of type 0 or 1
    public HashSet<Tile> get_vision(Map map)
    {
        HashSet<Tile> vision_tiles = new HashSet<>();
        // Grab a square based on Units vision
        ArrayList<Tile> grab_vision = map.grab_square(map, this.location, 
                                        this.vision);
        // Adds only tiles of type 1 or 0 to returning set
        for (Tile tile : grab_vision) 
        {
            if (tile.type <= 1)
                vision_tiles.add(tile);
        }
        
        return vision_tiles;
    }
}
