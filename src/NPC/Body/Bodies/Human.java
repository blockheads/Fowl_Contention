package NPC.Body.Bodies;

import NPC.Body.Body;
import NPC.Body.BodyPart;

import java.util.ArrayList;

public class Human extends Body {
    /**
     * Generic human body, this might get changed later, just fleshing out
     * what's going on baby :))
     */

    public Human(){
        super();

        ArrayList<BodyPart> humanBodyParts = new ArrayList<>();

        //generating the human body parts and adding them to the list

        //a head
        humanBodyParts.add(HumanoidBodyPartGenerator.head());

        //a torso
        humanBodyParts.add(HumanoidBodyPartGenerator.torso());

        //two arms?
        humanBodyParts.add(HumanoidBodyPartGenerator.arm());
        humanBodyParts.add(HumanoidBodyPartGenerator.arm());

        //two legs
        humanBodyParts.add(HumanoidBodyPartGenerator.leg());
        humanBodyParts.add(HumanoidBodyPartGenerator.leg());

        //adding the body parts to the bodypart list
        super.addBodyParts(humanBodyParts);

    }



}
