package model;

public class Caregiver {
    private String caregiverName;
    private String caregiverRelationship;

    //REQUIRES:
    //Modifies:
    //EFFECT: Caregiver constructor
    public Caregiver(String name, String relationship) {
        this.caregiverName = name;
        this.caregiverRelationship = relationship;
    }

    //Modifies: this
    //EFFECT: Changes name of Caregiver
    public void changeName(String newName) {
        this.caregiverName = newName;
    }


    //EFFECT: returns Caregiver's name
    public String getCaregiverName() {
        return caregiverName;
    }

    //EFFECT: returns Caregiver's relationship to child
    public String getCaregiverRelationship() {
        return caregiverRelationship;
    }
}
