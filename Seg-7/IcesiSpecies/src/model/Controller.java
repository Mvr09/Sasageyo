package model;

public class Controller {
    private final Species[] managery;
    public Controller() {
        this.managery = new Species[80];
    }
    public void editSpecies(String name, String scientificName, boolean isMigratory, double maxWeight, int indexSpecies){
        if (!name.equals("")) {
            managery[indexSpecies].setName(name);
        }
        if (!scientificName.equals("")){
            managery[indexSpecies].setScientificName(scientificName);
        }
        Fauna species = (Fauna) managery[indexSpecies];
        if (species.getIsMigratory()!= isMigratory){
            species.setMigrator(isMigratory);
        }
        if (maxWeight != -1.0) {
            species.setMaxWeight(maxWeight);
        }
        managery[indexSpecies] = species;
    }

    public void editSpecies(String name, String scientificName, boolean hasFlower, boolean hasFruit, double maxHeight, int indexSpecies){
        if (!name.equals("")){
            managery[indexSpecies].setName(name);
        }
        if (!scientificName.equals("")){
            managery[indexSpecies].setScientificName(scientificName);
        }
        Flora species = (Flora) managery[indexSpecies];
        if (species.getHasFlower() != hasFlower){
            species.setHasFlower(hasFlower);
        }
        if (species.getHasFruit() != hasFruit){
            species.setHasFruit(hasFruit);
        }
        if (maxHeight != -1.0) {
            species.setMaxHeight(maxHeight);
        }
        managery[indexSpecies] = species;
    }

    public String getClass(int iManagery){
        String classManagery = "";
        if (managery[iManagery] instanceof Flora){
            classManagery = "Flora";
        }
        if (managery[iManagery] instanceof Fauna) {
            classManagery = "Fauna";
        }
        return classManagery;
    }

    public boolean registerSpecies(String name, String scientificName, boolean isMigratory, double maxWeight){
        for (int i = 0; i < managery.length; i++){
            if (managery[i] == null) {
                managery[i] = new Fauna(name, scientificName, isMigratory, maxWeight);
                return true;
            }
        }
        return false;
    }

    public boolean registerSpecies(String name, String scientificName, boolean hasFlower, boolean hasFruit, double maxHeight){
        for (int i = 0; i < managery.length; i++){
            if (managery[i] == null) {
                managery[i] = new Flora(name, scientificName, hasFlower, hasFruit, maxHeight);
                return true;
            }
        }
        return false;
    }

    public String showSpecies(int option){
        String message = "";
        for (int i = 0; i < managery.length; i++){
            if(managery[i]!=null){
                if (option == 1) {
                    message += "\n" + (i + 1) + managery[i].toString();
                } else if (option == 2) {
                    if (managery[i] instanceof Fauna){
                        message += "\n" + (i + 1) + managery[i].toString();
                    }
                } else if (option == 3) {
                    if (managery[i] instanceof Flora){
                        message += "\n" + (i + 1) + managery[i].toString();
                    }
                }
            }
        }
        if (message.equals("")){
            message = "There are no Species registered yet";
        }
        return message;
    }

    public void deleteSpecies(int indexSpecies) {
        managery[indexSpecies] = null;
    }
}
