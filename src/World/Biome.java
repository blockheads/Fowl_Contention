package World;

public class Biome {

    enum BiomeType {GRASSLAND,FOREST,DESERT}

    //probability for biomes
    protected final static int GrassLandProbWeight =  3;
    protected final static int GrassLandNearbyGrowthInfluence = 1;
    protected final static char GrassLandVisualRepresentation = 'G';
    protected final static int DesertProbWeight = 3;
    protected final static int DesertNearbyGrowthInfluence = 1;
    protected final static char DesertVisualRepresentation = 'D';
    protected final static int ForestProbWeight = 3;
    protected final static int ForestNearbyGrowthInfluence = 1;
    protected final static char ForestVisualRepresentation = 'F';
    protected final static int DefaultProbWeight = 3;
    protected final static int DefaultNearbyGrowthInfluence = 1;
    protected final static char DefaultVisualRepresentation = '@';

    private BiomeType biomeType;

    public Biome(BiomeType biomeType){
        this.biomeType = biomeType;
    }

    //gets the weight of this biome
    //defaults to whatever
    //note you have to set this up or biome will default
    public int getWeight(){
        switch(this.biomeType){
            case GRASSLAND:
                return GrassLandProbWeight;
            case DESERT:
                return DesertProbWeight;
            case FOREST:
                return ForestProbWeight;
            default:
                return DefaultProbWeight;
        }
    }

    public int getNearbyGrowthInfluence() {
        switch(this.biomeType){
            case GRASSLAND:
                return GrassLandNearbyGrowthInfluence;
            case DESERT:
                return DesertNearbyGrowthInfluence;
            case FOREST:
                return ForestNearbyGrowthInfluence;
            default:
                return DefaultNearbyGrowthInfluence;
        }
    }

    public char getVisualRepresentation(){
        switch (this.biomeType){
            case GRASSLAND:
                return GrassLandVisualRepresentation;
            case DESERT:
                return DesertVisualRepresentation;
            case FOREST:
                return ForestVisualRepresentation;
            default:
                return DefaultVisualRepresentation;
        }
    }
}
