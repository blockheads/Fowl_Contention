package NPC.Body;

import java.util.ArrayList;

public class Body {
    /**
     * A body composes the man, HAH! What sheer skill!
     */

    private ArrayList<BodyPart> bodyParts;

    //constructs a body

    public Body(){

    }

    public void addBodyParts(ArrayList<BodyPart> bodyParts){
        bodyParts.addAll(bodyParts);
    }
}
