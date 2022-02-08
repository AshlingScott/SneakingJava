package com.thief.misc;

/* Effects that alter the properties of a Character.  Can be permanent, or
temporary, lasting a number of rounds*/
public class Alter 
{
    boolean position, permanent;
    int duration;
    
    public Alter (boolean pos, boolean perm, int dur)
    {
        position = pos;
        permanent = perm;
        duration = dur;
    }
    
    // Reduces the duration of temporary Alters, runs every turn
    public int tick_down()
    {
        if (permanent == false)
            duration --;
        
        return duration;
    }
}
