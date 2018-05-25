package NPC.Body.Bodies;

import NPC.Body.BodyPart;

public class HumanoidBodyPartGenerator {
    /**
     * Class generates a body part, I didn't want to make specific
     * classes for each body part, so here goes nothing.
     */

    //TODO: definetly just make a generic body part generator which this uses

    //generates a arm
    public static BodyPart arm(){
        return new BodyPart("arm",null);

    }

    //generates a leg
    public static BodyPart leg(){
        return new BodyPart("leg",null);

    }

    //generates a torso
    public static BodyPart torso(){
        return new BodyPart("torso",null);

    }

    //generates a head
    public static BodyPart head(){
        return new BodyPart("head",null);

    }
}
