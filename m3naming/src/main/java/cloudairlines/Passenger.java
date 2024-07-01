package cloudairlines;

public class Passenger {

    String name;
    String surname;
    int bagCount;
    boolean isAdult;

    public boolean hasBags() {
        return bagCount > 0;
    }

}
