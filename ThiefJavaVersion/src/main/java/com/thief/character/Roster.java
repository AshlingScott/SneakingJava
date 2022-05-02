package com.thief.character;

import java.util.*;

/*Rosters are the total collection of Units. */
public class Roster
{
    int maximum;
    ArrayList<Unit> unit_list;

    public Roster()
    {
        maximum = 10;
        unit_list = new ArrayList<Unit>();
    }

    /*Add a unit to the roster
          Returns a true if unit was added, returns a false if it failed*/
    public bool add_unit(Unit unit)
    {
        if (unit_list.size() < 10)
        {
            unit_list.add(unit);
            return true;
        }
        else
        {
            System.out.println("Roster size is full");
            return false;
        }
    }
}
