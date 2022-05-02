package com.thief.character;

import com.thief.map.*;
import java.util.ArrayList;
import java.util.HashSet;

/*Guards are Units that defend treasure from the attacking Thieves.  Guards
win by killing all Thieves or delaying them long enough*/
public abstract class Guard extends Unit
{
    // The light radius around each Guard.  Visible by thieves
    HashSet<Tile> light_area;
    // Attack range of the Guard
    int attack_range;

    public Guard()
    {
        super();
        light_area = new HashSet<>();
    }

    //fails to kill the guard
    @Override
    public void kill()
    {
    }

    // Guards can walk only on fields
    // Refreshes vision on movement through visible_tiles
    public void move(Tile target, Map map)
    {
        // If terrain walkable
        if (target.type == 0)
        {
            // Remove from old location
            location.occupied = false;
            location.occupant = null;
            // Update to new location
            location = target;
            target.occupied = true;
            target.occupant = this;

            // Refresh base visible tiles
        }
        else
            System.out.println("Guard can't move there.");

        // Todo: Prevent vision inside trees and rocks
    }

    // Get set of tiles in vision range of type 0
    public HashSet<Tile> get_vision(Map map)
    {
        HashSet<Tile> vision_tiles = new HashSet<>();
        // Grab a square based on Units vision
        ArrayList<Tile> grab_vision = map.grab_square(map, this.location,
                                        this.vision);
        // Adds only tiles of type 0 to returning set
        for (Tile tile : grab_vision)
        {
            if (tile.type == 0)
                vision_tiles.add(tile);
        }

        return vision_tiles;
    }
}
