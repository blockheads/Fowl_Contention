package Game;

import World.World;

public class Game {

    /**
     * runs the game
     */
    public static void start(){
        //generate world
        World world = new World();
        world.display();

    }


}
