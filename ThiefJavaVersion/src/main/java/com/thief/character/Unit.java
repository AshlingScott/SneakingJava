package com.thief.character;

import com.thief.map.Tile;
import com.thief.misc.*;
import java.util.*;

/*Characters are the units controlled by players or by AI opponents.  The two
types of Characters are Thieves and Guards*/
public abstract class Unit
{
    public boolean visible, disabled, flying;
    int stealth, energy, movement, vision, energy_gain, talent_points;
    Tile location;
    HashSet<Tile> visible_tiles;
    ArrayList<Item> items;
    //ArrayList<Talent> talents;
    ArrayList<Alter> alter_list;
    ArrayList<Summon> summons;

    public Unit()
    {
        location = null;

        visible = false;
        disabled = false;
        flying = false;
        stealth = 0;
        energy = 0;

        visible_tiles = new HashSet<>();
        items = new ArrayList<Item>();
        //talents = new ArrayList<Talent>();
        alter_list = new ArrayList<Alter>();
        summons = new ArrayList<Summon>();
    }

    // Abstract methods for outputting data
    public abstract String get_symbol();
    public abstract void print_stats();
    // Method for killing thieves
    public abstract void kill();

    /* At the start of each round, upkeep runs to perform effects that occur
    on each turn.  Energy gain, alter duration, and summon duration*/
    public void upkeep()
    {
        energy += energy_gain;

        for (Alter alter : alter_list)
        {
            alter.tick_down();
        }
        for (Summon summon : summons)
        {
            summon.tick_down();
        }
    }

    public void end_turn()
    {
        disabled = false;
    }

    public void add_item(Item item)
    {
        items.add(item);
    }

    public void print_items()
    {

    }
}
