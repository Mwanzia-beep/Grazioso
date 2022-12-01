public class Monkey extends RescueAnimal {

    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    public Monkey(String name, String species, String gender, String age,
            String weight, String height, String tailLength, String bodyLength,
            String acquisitionDate, String acquisitionCountry,
            String trainingStatus, boolean reserved, String inServiceCountry) {
        // inherited from the  RescueAnimal class
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

        // Monkey class attributes are explained here
        setSpecies(species);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
    }

    // Accessor (used Getter) and Mutator (in our case Setter) methods
    // Accessor (Getter) method for species variable
    public String getSpecies() {
        return species;
    }

    // Mutator (Setter) method for species variable
    public void setSpecies(String species) {
        this.species = species;
    }

    // Accessor (Getter) method for tail length variable
    public String getTailLength() {
        return tailLength;
    }

    // Mutator (Setter) method for tail length variable
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // Accessor (Getter) method for height variable
    public String getHeight() {
        return height;
    }
   //Mutator (Setter) method for height variable
    // Mutator (Setter) method for height variable
    public void setHeight(String monkeyHeight) {
        height = monkeyHeight;
    }

    // Accessor (Getter) method for body length variable
    public String getBodyLength() {
        return bodyLength;
    }

    // Mutator (Setter) method for body length variable
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }
}