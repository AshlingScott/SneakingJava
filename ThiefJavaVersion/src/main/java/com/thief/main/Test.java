package com.thief.main;

import com.thief.character.*;
import com.thief.map.*;
import com.thief.misc.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    
    public static void main(String[] args) throws FileNotFoundException{
        
        // Generate Map
        Map map = new Map();    
        ArrayList<Thief> thieves_list;
        
        // Create test Units, a druid and a golem
        Druid dru = new Druid(5, 7, 4, map.tile_list.get(0));
        map.tile_list.get(0).occupied = true;
        map.tile_list.get(0).occupant = dru;
        
        Golem gol = new Golem(4, 2, 7, map.tile_list.get(99));
        map.tile_list.get(99).occupied = true;
        map.tile_list.get(99).occupant = gol;
        
        // Test abstract implementations upkeep and print_stats
        dru.print_stats();
        dru.upkeep();
        gol.upkeep();
        gol.print_stats();
        
        // Test map updating after move command
        map.print_map();
        gol.move(map.tile_list.get(79), map);
        map.print_map();
                
        // Test disabling ability
        System.out.println(gol.disabled);
        dru.entangle(gol);
        System.out.println(gol.disabled);
        
        // Testing grab_square method
        // Confirm it works on literal edge cases
        ArrayList<Tile> testsquare = map.grab_square(map, map.tile_list.get(50), 2);
        for (Tile t : testsquare) 
        {
            System.out.println(t.id);
        }
        
        map = new Map("Horseshoe");
        map.print_map();
    }
}
