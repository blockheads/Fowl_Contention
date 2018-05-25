package World;

import java.util.ArrayList;
import java.util.Random;

public class World {

    private final int sizeBase = 255;
    private final int sizeBoundSeed = 20;
    private int size;
    private Random random;
    private ArrayList<ArrayList<Tile>> tiles;


    //late of course can pass parameters
    public World() {
        random = new Random();
        tiles = new ArrayList<ArrayList<Tile>>();
        generate();
    }

    /**
     * Generates a new world
     */
    public void generate() {
        size = sizeBase + random.nextInt(sizeBoundSeed) - random.nextInt(sizeBoundSeed);

        //generating the weighted list
        WorldStatistics worldStatistics = new WorldStatistics();

        //the bounding box for this world
        for (int i = 0; i < size; i++) {

            //initializing this row in the arraylist
            tiles.add(new ArrayList<Tile>());

            for (int j = 0; j < size; j++) {


                //checking to up down left right
                if (i > 0) {
                    Tile up = tiles.get(i - 1).get(j);
                    worldStatistics.add(up.getBiome(), true);

                }
                if (j > 0) {
                    Tile left = tiles.get(i).get(j - 1);
                    worldStatistics.add(left.getBiome(), true);
                }
                if( i > 0 && j > 0){
                    Tile upleft = tiles.get(i-1).get(j - 1);
                    worldStatistics.add(upleft.getBiome(), true);
                }

                Tile newTile = new Tile(worldStatistics.next());

                // maybe check for a reset or set a flag from within...
                tiles.get(i).add(newTile);

                //now removing the added biomes
               worldStatistics.reset();

            }
        }
    }

    public void display(){
        System.out.println("printing");
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(tiles.get(i).get(j).getBiome().getVisualRepresentation());
            }
        }
    }
}


