package NPC.Body;

import NPC.Bone;

import java.util.ArrayList;

public class BodyPart {

    //the bones within this body part
    private ArrayList<Bone> bones;
    //consider which bones this body part needs to function, if all broken then it stops working
    //or what effect a bone breaking has on the body part...

    //What is this body part called???
    private String name;

    //Int representing the health of this body part, ( idk how this affects bones ect... )
    private int health;

    public BodyPart( String name, ArrayList<Bone> bones ){
        this.name = name;
        this.bones = bones;
    }

    public ArrayList<Bone> getBones() {
        return bones;
    }

    public String getName() {
        return name;
    }
}
