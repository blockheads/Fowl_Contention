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
    private Biome selectedBiome;
    private Biome taperBiome;
    private final static int biomeRotationDelayBase = 10000;
    private final static int biomeRotationDelaySeed = 2000;
    //how long before a new biome should be selected
    private int biomeRotationDelay;
    private int biomeRotationNum = 0;
    private int noiseTotal = 0;

    //how many tiles should the biome taper off for, makes it appear to "fade"
    private int biomeTaper = 100;

    public WorldStatistics() {
        this(new Random());

        biomeRotationDelay = biomeRotationDelayBase + random.nextInt(biomeRotationDelaySeed) - random.nextInt(biomeRotationDelaySeed);
        for(Biome.BiomeType biomeType: Biome.BiomeType.values() ){
            Biome biome = new Biome(biomeType);
            if (biome.isGeneratable()) {
                add(biome,false);
            }
        }

        double value = random.nextDouble() * total;
        selectedBiome = map.higherEntry(value).getValue();

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
        noiseTotal++;
        map.put(total, biome);
        return this;
    }

    public void reset(){
        for(int i=0; i < addedElements; i++){
            map.remove( map.lastKey() );
            addedElements = 0;
        }
    }

    public Biome next(double simplexDouble) {

        if(biomeRotationNum >= biomeRotationDelay){
            //storing previous biome for taper effect
            taperBiome = selectedBiome;
            //System.out.println("statement reached");
            double value = random.nextDouble() * total;
            selectedBiome = map.higherEntry(value).getValue();
            biomeRotationNum = biomeRotationDelayBase + random.nextInt(biomeRotationDelaySeed) - random.nextInt(biomeRotationDelaySeed);
            biomeRotationNum = 0;
        }
        else {

            biomeRotationNum++;
        }
        //TODO: fix magic numbers, no idea wtf is going on rn lol time to spaghetti this shit up tho
        double value = (simplexDouble );

        //higher value determines higher depth
        if(value < .1 ){
            return new Biome(Biome.BiomeType.DEEPWATER);
        }
        if( value < .2 ){
            return new Biome(Biome.BiomeType.WATER);
        }
        if( value < .28) {
            return new Biome(Biome.BiomeType.BEACH);
        }

        else if(value < .35){

            if (biomeRotationNum < biomeTaper && taperBiome != null){
                int rand = random.nextInt(3);
                if( rand > 1){
                    return taperBiome;
                }

            }
            return selectedBiome;
        }
        //example of making rarer terrarin "elevation can be = rarity in a sense too, of course
        //place it in between other similar features at the proper elevation
        else if( value < .4){
            if(random.nextInt(2) == 1)
                return new Biome(Biome.BiomeType.RARE);
            else{
                if (biomeRotationNum < biomeTaper && taperBiome != null){
                    int rand = random.nextInt(3);
                    if( rand > 1){
                        return taperBiome;
                    }

                }
                return selectedBiome;
            }

        }
        else{

            if (biomeRotationNum < biomeTaper && taperBiome != null){
                int rand = random.nextInt(3);
                if( rand > 1){
                    return taperBiome;
                }

            }
            return selectedBiome;
        }



    }

}
