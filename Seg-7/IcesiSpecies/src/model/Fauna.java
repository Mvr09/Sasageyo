package model;

public class Fauna extends Species{

    private boolean isMigratory;
    private double maxWeight;

    public Fauna(String name, String scientificName, boolean isMigratory, double maxWeight) {
        super(name, scientificName);
        this.isMigratory = isMigratory;
        this.maxWeight = maxWeight;
    }

    public boolean getIsMigratory() {
        return isMigratory;
    }

    public void setMigrator(boolean migrator) {
        isMigratory = migrator;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Fauna \n" +
                " Name= " + name + "\n" +
                " Scientific name= " + scientificName + "\n" +
                " isMigratory= " + isMigratory + "\n" +
                " maxWeight= " + maxWeight + "\n" +
                "----------------------------";
    }

    @Override
    public void grow(int rate) {
        double calculate = Growable.GROWTH*4;
    }
}
