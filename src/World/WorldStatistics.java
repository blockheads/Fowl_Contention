package World;

import java.util.*;

public class WorldStatistics {
    /**
     * Static information regarding the world
     */


    private final NavigableMap<Double, Biome> map = new TreeMap<>();
    private final Random random;
    private double total = 0;
    private int addedElements = 0;

    public WorldStatistics() {
        this(new Random());
        for(Biome.BiomeType biomeType: Biome.BiomeType.values() ){
            add(new Biome(biomeType),false);
        }

    }

    public WorldStatistics(Random random) {
        this.random = random;
    }

    public WorldStatistics add(Biome biome, boolean borderingBiome) {

        int weight = biome.getWeight();
        if( borderingBiome ) {

            weight = biome.getNearbyGrowthInfluence();
            if (weight <= 0) return this;
            total += weight;
            addedElements++;
        }
        else {
            if (weight <= 0) return this;
            total += weight;
        }
        map.put(total, biome);
        return this;
    }

    public void reset(){
        for(int i=0; i < addedElements; i++){
            map.remove( map.lastKey() );
            addedElements = 0;
        }
    }

    public Biome next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }

}
