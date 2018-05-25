package World;

public class Tile {
    /**
     * A world tile
     */

    private int nearbyGrowthInfluence;
    private Biome biome;

    public Tile(Biome biome){
        this.nearbyGrowthInfluence = nearbyGrowthInfluence;
        this.biome = biome;
    }

    public Biome getBiome() {
        return biome;
    }

}
