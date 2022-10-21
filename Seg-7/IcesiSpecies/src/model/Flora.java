package model;

public class Flora extends Species {

    private boolean hasFlower;
    private boolean hasFruit;
    private double maxHeight;

    public Flora(String name, String scientificName, boolean hasFlower, boolean hasFruit, double maxHeight) {
        super(name, scientificName);
        this.hasFlower = hasFlower;
        this.hasFruit = hasFruit;
        this.maxHeight = maxHeight;
    }

    public boolean getHasFlower() {

        return hasFlower;
    }

    public void setHasFlower(boolean hasFlower) {

        this.hasFlower = hasFlower;
    }

    public boolean getHasFruit() {

        return hasFruit;
    }

    public void setHasFruit(boolean hasFruit) {

        this.hasFruit = hasFruit;
    }

    public double getMaxHeight() {

        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {

        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return "Flora \n" +
                " Name= " + name + "\n" +
                " Scientific name= " + scientificName + "\n" +
                " hasFlower= " + hasFlower + "\n" +
                " hasFruit= " + hasFruit + "\n" +
                " maxHeight= " + maxHeight + "\n" +
                "----------------------------";
    }

    @Override
    public void grow(int rate) {
        double calculate = Growable.GROWTH*5;
    }
}
