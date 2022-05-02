package com.thief.character;

import java.util.*;

/*The recruiting shop where you can purchase new units
# Currently offers 3 random units, with different prices*/
public class Recruit_Board()
{
    // List of recruits in the shop
    public ArrayList<Unit> recruits;
    // Prices of recruits
    int[] prices;

    // Set the initial 3 recruits on the board, randomized
    public Recruit_Board()
    {
        Random rand = new Random();
        for (int i = 0; i<3; i++)
        {
            // Grab a random unit and add to recruits
            recruits.add(random_unit());
            // set random price, add to corresponding slot
            prices[i] = rand.nextInt(5);
        }
    }

    // returns a randomized unit
    private Unit random_unit()
    {
        // the unit to be returned
        Unit unit;

        Random rand = new Random();
        int roll = rand.nextInt(6);

        if (roll == 0)
            unit = Druid();
        if (roll == 1)
            unit = Sprinter();
        if (roll == 2)
            unit = Shadow();
        if (roll == 3)
            unit = BloodHunter();
        if (roll == 4)
            unit = Golem();
        if (roll == 5)
            unit = Techie();

        return unit;
    }

    // Select a unit from the board and add it to the roster, then replace
    public void select_unit(Roster roster, int choice)
    {
        // Tries to add a unit, only on succeeding will it make a new one
        if (roster.add_unit(recruits.get(choice)) == true)
        {
              // replace a new unit in its slot
              recruits.set(choice, random_unit());

              // add price
              Random rand = new Random();
              prices[choice] = rand.nextInt(5);
        }
        else
        {
              System.out.println("Roster is full");
        }

    }

    // Print out the list of units currently on the board
   public void print_board()
   {
        for (int i = 0; i<3; i++)
        {
              System.out.println(recruits.get(i));
              System.out.println(prices[i]);
        }
   }
}
