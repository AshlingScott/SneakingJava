package com.thief.character;

import com.thief.map.Tile;
import com.thief.misc.*;
import java.util.*;

/*Characters are the units controlled by players or by AI opponents.  The two
types of Characters are Thieves and Guards*/
public abstract class Unit
{
    public boolean visible, disabled, flying, has_treasure;
    int stealth, energy, movement, vision, energy_gain;
    Tile location;
    HashSet<Tile> visible_tiles;
    ArrayList<Item> items;
    ArrayList<Alter> alter_list;
    ArrayList<Summon> summons;
    
    public Unit(int m, int v, int e_g, Tile loc)
    {
        movement = m;
        vision = v;
        energy_gain = e_g;
        location = loc;
        
        visible = false;
        disabled = false;
        flying = false;
        has_treasure = false;
        stealth = 0;
        energy = 0;
        
        visible_tiles = new HashSet<>();
        items = new ArrayList<>();
        alter_list = new ArrayList<>();
        summons = new ArrayList<>();
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
