package com.thief.map;

import java.io.*;  
import java.util.*;

/*Map is a collection of tiles which represents the game area.  Characters
move on tiles, each tile can only have one Character at a time*/
public class Map 
{
    // List of the tiles on the map
    public ArrayList<Tile> tile_list;
    
    // Creates map from csv file
    public Map(String file) throws FileNotFoundException
    {
        tile_list = new ArrayList<>();
        // Parse from CSV file in Map Files folder
        Scanner scan = new Scanner(new File("src/main/java/com/thief/map/MapFiles/" + file + ".csv"));
        scan.useDelimiter(",");
        // counter for passing id to new tiles
        int i = 0;
        while (scan.hasNext())
        {  
            // Remove white space from the scan, convert to int, 
            // Pass as tile type and add to tile_list
            tile_list.add(new Tile(i, Integer.parseInt(scan.next().replaceAll("\\s", ""))));
            i++;
        }   
    }
    
    // Creates a randomly generated map
    public Map()
    {
        tile_list = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i<100; i++)
        {
            int random = rand.nextInt(3);
            Tile tile = new Tile(i, random);
            tile_list.add(tile);            
        }
    }
    
    // Prints out the map in a grid
    public void print_map()
    {
        for (int i = 0; i < 10; i++)
        {
            String line = "";
            for (int j = 0; j <10; j++)
                line = line + tile_list.get(i * 10 + j).printout() + " ";
            
            System.out.println(line);
        }
        System.out.println();
    }
    
    public void simplify()
    {
        
    }
    
    // Returns set of tiles (in a square) within a range of a target tile
    public ArrayList<Tile> grab_square(Map map, Tile target, int range)
    {
        ArrayList<Tile> tileset = new ArrayList<>();
        for (int i = -range; i < range + 1; i++)
        {
            // Looks at tiles within range distance on x and y axis
            for (int j = -range; j < range + 1; j++)
            {
                // Checks that x value is between 0 and 9
                int x = (target.id / 10) + i;
                if ((0 <= x)  && (x < 10))
                {
                    // Checks that y value is between 0 and 9
                    int y = (target.id % 10) + j;
                    if ((0 <= y) && (y < 10))
                    {
                        tileset.add(map.tile_list.get((x*10) + y));
                    }
                        
                }
            }
        }
        return tileset;
    }
}
