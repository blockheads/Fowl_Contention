package World;

public class Biome {

    enum BiomeType {WATER, GRASSLAND, FOREST, DESERT }

    //probability for biomes
    protected final static int WaterProbWeight = 3;
    protected final static char WaterVisualRepresentation = '~';
    protected final static int GrassLandProbWeight = 3;
    protected final static int GrassLandNearbyGrowthInfluence = 5;
    protected final static int GrassLandMaxSize = 500;
    protected final static int GrassLandMinSize = 10;
    protected final static char GrassLandVisualRepresentation = 'G';
    protected final static int DesertProbWeight = 3;
    protected final static int DesertNearbyGrowthInfluence = 5;
    protected final static int DesertMaxSize = 500;
    protected final static int DesertMinSize = 10;
    protected final static char DesertVisualRepresentation = 'D';
    protected final static int ForestProbWeight = 3;
    protected final static int ForestNearbyGrowthInfluence = 5;
    protected final static int ForestMaxSize = 500;
    protected final static int ForestMinSize = 10;
    protected final static char ForestVisualRepresentation = 'F';
    protected final static int DefaultProbWeight = 3;
    protected final static int DefaultNearbyGrowthInfluence = 1;
    protected final static int DefaultMaxSize = 500;
    protected final static int DefaultMinSize = 10;
    protected final static char DefaultVisualRepresentation = '@';

    private BiomeType biomeType;

    public Biome(BiomeType biomeType) {
        this.biomeType = biomeType;
    }

    //gets the weight of this biome
    //defaults to whatever
    //note you have to set this up or biome will default
    public int getWeight() {
        switch (this.biomeType) {
            case WATER:
                return WaterProbWeight;
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

    public int getMaxSize() {
        switch (this.biomeType) {
            case GRASSLAND:
                return GrassLandMaxSize;
            case DESERT:
                return DesertMaxSize;
            case FOREST:
                return ForestMaxSize;
            default:
                return DefaultMaxSize;
        }
    }

    public int getMinSize(){
        switch (this.biomeType) {
            case GRASSLAND:
                return GrassLandMinSize;
            case DESERT:
                return DesertMinSize;
            case FOREST:
                return ForestMinSize;
            default:
                return DefaultMinSize;
        }
    }

    public int getNearbyGrowthInfluence() {
        switch (this.biomeType) {
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

    public char getVisualRepresentation() {
        switch (this.biomeType) {
            case WATER:
                return WaterVisualRepresentation;
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

    /**
     * Marks off generatable biomes, water is a nono
     * @return
     */
    public boolean isGeneratable(){
        if(this.biomeType == BiomeType.WATER)
            return false;
        else
            return true;
    }
}
