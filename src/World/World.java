package World;

import World.helpers.Coordinate;
import World.helpers.MathHelper;
import World.helpers.SimplexNoise;

import java.util.Random;

public class World {

    private final int sizeBase = 255;
    private final int sizeBoundSeed = 20;
    private int size;
    private Random random;
    private Tile[][] tiles;


    //late of course can pass parameters
    public World() {
        random = new Random();
        //ehhhhhhhhhh
        size = sizeBase + random.nextInt(sizeBoundSeed) -  random.nextInt(sizeBoundSeed);
        generate();
    }

    /**
     * Generates a new world
     */
    public void generate() {
        size = sizeBase + random.nextInt(sizeBoundSeed) - random.nextInt(sizeBoundSeed);

        //generating the weighted list
        WorldStatistics worldStatistics = new WorldStatistics();

        //constructing simplex noise
        SimplexNoise simplexNoise = new SimplexNoise(200,0.6,342);

        tiles = new Tile[size][size];

        double[][] simplexArray = new double[size][size];

        double xStart=0;
        double XEnd=size;
        double yStart=0;
        double yEnd=size;

        //constructs 2d array filled with heightmap biomes
        for(int i = 0; i < size; i++){
            for(int j=0; j < size; j++){
                int x=(int)(xStart+i*((XEnd-xStart)/size));
                int y=(int)(yStart+j*((yEnd-yStart)/size));
                //basically this pulls out a biome based on a noise like pattern
                double simplexDouble = ((simplexNoise.getNoise(x,y)));
                Biome biome =  worldStatistics.next(simplexDouble);
                tiles[i][j] = new Tile(biome);

            }
        }

        int numClimates = 10;
        for(int i = 0; i < numClimates; numClimates++) {
            //now going through and selecting random points to generate the climates
            Coordinate rand = new Coordinate(random.nextInt(size), random.nextInt(size));
            //grabbing the tile at that point
            Tile selected = tiles[rand.getX()][rand.getY()];
            //select random climate
            Climate.generateClimate();

        }

    }

    public void display(){
        System.out.println("printing");
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if(tiles[i][j] == null){
                    System.out.print("X");
                }
                else {
                    System.out.print( tiles[i][j].getBiome().getColorString() +  tiles[i][j].getBiome().getVisualRepresentation());
                }
            }
        }
    }
}




