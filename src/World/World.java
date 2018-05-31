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
        SimplexNoise simplexNoise = new SimplexNoise(200,0.2,142);

        tiles = new Tile[size][size];

        double[][] simplexArray = new double[size][size];

        double xStart=0;
        double XEnd=size;
        double yStart=0;
        double yEnd=size;

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

//        for(int i = 0; i < numBiomes; i++) {
//            Coordinate startCoord = new Coordinate(random.nextInt(size),random.nextInt(size));
//            Biome currBiome = worldStatistics.next();
//            //getting number of tiles to generate
//            int numTiles = random.nextInt(currBiome.getMaxSize() - currBiome.getMinSize());
//
//            //need to ensure don't go out of bounds
//            for(int j = 0; j < numTiles; j++){
//                //idk wtf I'm doing lul
//                int x=(int)(startCoord.getX()+i*((XEnd-xStart)/size));
//                int y=(int)(startCoord.getY()+j*((yEnd-yStart)/size));
//                int xcord = (int) (simplexNoise.getNoise(x,y)*size) + startCoord.getX();
//                int ycord = (int) (simplexNoise.getNoise(x,y)*size) + startCoord.getY();
//
//                System.out.println(xcord);
//                System.out.println(ycord);
//                xcord = MathHelper.ensureRange(xcord,0,size-1);
//                ycord = MathHelper.ensureRange(ycord,0,size-1);
//                tiles[xcord][ycord] = new Tile(currBiome);
//            }
//        }

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
                    System.out.print(tiles[i][j].getBiome().getVisualRepresentation());
                }
            }
        }
    }
}




