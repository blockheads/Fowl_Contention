package World;

public class Biome {

    enum BiomeType {WATER, DEEPWATER, BEACH, GRASSLAND, FOREST, DESERT, RARE }

    //probability for biomes
    protected final static int WaterProbWeight = 3;
    protected final static char WaterVisualRepresentation = '~';
    protected final static String WaterColorString = "\u001b[36;1m";
    protected final static int GrassLandProbWeight = 3;
    protected final static int GrassLandNearbyGrowthInfluence = 5;
    protected final static int GrassLandMaxSize = 500;
    protected final static int GrassLandMinSize = 10;
    protected final static char GrassLandVisualRepresentation = 'G';
    protected final static String GrassLandColorString = "\u001b[32;1m";
    protected final static int DesertProbWeight = 1;
    protected final static int DesertNearbyGrowthInfluence = 5;
    protected final static int DesertMaxSize = 100;
    protected final static int DesertMinSize = 10;
    protected final static char DesertVisualRepresentation = 'D';
    protected final static String DesertColorString = "\u001b[33;1m";
    protected final static int ForestProbWeight = 3;
    protected final static int ForestNearbyGrowthInfluence = 5;
    protected final static int ForestMaxSize = 500;
    protected final static int ForestMinSize = 10;
    protected final static char ForestVisualRepresentation = 'F';
    protected final static String ForestColorString = "\u001b[32m";
    protected final static int DefaultProbWeight = 3;
    protected final static int DefaultNearbyGrowthInfluence = 1;
    protected final static int DefaultMaxSize = 500;
    protected final static int DefaultMinSize = 10;
    protected final static char DeepWaterVisualRepresentation = '~';
    protected final static String DeepWaterColorString = "\u001b[34m";
    protected final static char BeachVisualRepresentation = '*';
    protected final static String BeachColorString = "\u001b[33;1m";
    protected final static char DefaultVisualRepresentation = '@';
    protected final static String DefaultColorString = "\u001b[37;1m";
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
            case BEACH:
                return BeachVisualRepresentation;
            case DEEPWATER:
                return DeepWaterVisualRepresentation;
            default:
                return DefaultVisualRepresentation;
        }
    }

    public String getColorString(){
        switch (this.biomeType){
            case WATER:
                return WaterColorString;
            case DEEPWATER:
                return DeepWaterColorString;
            case BEACH:
                return BeachColorString;
            case GRASSLAND:
                return GrassLandColorString;
            case FOREST:
                return ForestColorString;
            case DESERT:
                return DesertColorString;
            default:
                return DefaultColorString;
        }
    }

    /**
     * Marks off generatable biomes, water is a nono
     * @return
     */
    public boolean isGeneratable(){
        if(this.biomeType == BiomeType.WATER || this.biomeType == BiomeType.DEEPWATER
                || this.biomeType == BiomeType.RARE || this.biomeType == BiomeType.BEACH)
            return false;
        else
            return true;
    }
}
