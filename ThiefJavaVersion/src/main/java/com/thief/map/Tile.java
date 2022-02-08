package com.thief.map;
import com.thief.character.Unit;

/*Tiles are the spaces that characters occupy.  Only one Unit can occupy
each Tile.  Tiles have 3 types: field(0), forest(1), and rock(2)*/
public class Tile 
{
    // The character who is standing on the tile
    public Unit occupant;
    public boolean occupied;
    public int type, id;
    
    public Tile(int id, int type)
    {
        this.id = id;
        this.type = type;
        occupied = false;
    }
    
    // Prints out a Unit symbol if occupied, or a tile type if not
    public String printout()
    {
        if (occupied)
            return occupant.get_symbol();
        else
            return String.valueOf(type);
    }
    
    // Equals method compares by tile id
    public boolean equals(Tile t)
    {
        return t.id == this.id;
    }
}
