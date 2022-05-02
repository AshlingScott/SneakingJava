package com.thief.character;

import java.util.*;

/*Teams are subsets of the roster that are sent on missions */
public class Team
{
    int maximum;
    ArrayList<Unit> unit_list;

    public Team()
    {
        maximum = 3;
        unit_list = new ArrayList<Unit>();
    }

    /*Add a unit to the Team
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
            System.out.println("Team size is full");
            return false;
        }
    }
}
