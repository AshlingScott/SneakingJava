package com.thief.misc;

import com.thief.map.Tile;
import java.util.ArrayList;

/*Units spawned by Characters.  They share many properties with Characters,
but are not core units of the game*/
public class Summon
{
    boolean visible, disabled, flying, permanent;
    int stealth, movement, vision, duration;
    Tile location;
    ArrayList<Tile> visible_tiles;

    public Summon ()
    {
    }

    // Reduces the duration of temporary Summons, runs every turn
    public int tick_down()
    {
        if (permanent == false)
            duration --;

        return duration;
    }
}
