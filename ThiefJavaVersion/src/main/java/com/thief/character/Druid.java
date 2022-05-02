package com.thief.character;

import com.thief.map.Tile;
import java.util.Random;

/* Druids are a flexible Thief class, able to change forms to suit different
situations, as well as obstruct enemies with plants*/
public class Druid extends Thief
{
    // The current druid form: 0 for base, 1 for Hawk, 2 for Squirrel
    int form;

    public Druid() {
        super();
        location = null;
        hp = 3;

        // Starts in base form
        form = 0;

        // Roll the random stats
        Random rand = new Random();
        movement = rand.nextInt(3,6);
        vision = rand.nextInt(4,7);
        energy_gain = rand.nextInt(2,5);
    }

    @Override
    public String get_symbol()
    {
        return "D";
    }

    @Override
    public void print_stats()
    {
        System.out.printf("Druid%nMovement: " + movement + "%nVision: " +
            vision + "%nEnergy: " + energy + "%nEnergy Gain: " + energy_gain
            + "%nForm: " + form + "%n");
    }

    // Roots rise up around target Guard, disabling them for one turn
    public void entangle(Guard target)
    {
        energy -= 3;
        target.disabled = true;
    }

    // Transform into a hawk, gaining flying and extra vision
    public void hawk_form()
    {
        energy -= 3;
        vision += 2;

        flying = true;
        form = 1;
    }

    // Transform into a squirrel, gaining speed and stealth
    public void squirrel_form()
    {
        energy -= 3;
        movement += 4;

        stealth = 1;
        form = 2;
    }

    // Grow a crop of trees at target location, turning fields into forests
    public void overgrowth(Tile target)
    {
        energy -= 5;
        target.type = 1;
    }
}
