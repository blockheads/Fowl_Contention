package World;

import World.helpers.Coordinate;
import World.helpers.SimplexNoise;

import java.util.Random;

public class Climate {

    enum ClimateType{WINTER,SUMMER}
    private ClimateType climateType;
    private static float terrainThreshold = 0.5f;

    public Climate(ClimateType climateType){this.climateType = climateType;}

    public int getClimateSize(){
        switch (this.climateType){
            case WINTER:
                return 50;
            case SUMMER:
                return 50;
            default:
                return 50;
        }
    }

    public static Climate getRandomClimate(Random random){
        ClimateType[] climates = ClimateType.values();
        return new Climate(climates[random.nextInt(climates.length )]);
    }

    //generates a climate given the heightmap,
    public static void generateClimate(Tile[][] tiles, Coordinate start, Random random, SimplexNoise simplexNoise){
        //selecting random climate
        Climate climate = getRandomClimate(random);
        for(int i=start.getY();i<climate.getClimateSize()+start.getY(); i++){
            for(int j=start.getX(); j<climate.getClimateSize()+start.getX(); j++){
                if( j > tiles.length)
                    break;
                double noise = simplexNoise.getNoise(i,j);
                if(noise > terrainThreshold){
                    tiles[i][j].getBiome().setClimate(climate);
                    
                            //make recursive call
                }

            }
            if(i > tiles.length)
                break;
        }

    }
}
