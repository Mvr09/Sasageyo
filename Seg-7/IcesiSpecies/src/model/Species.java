package model;

import java.io.Serializable;

public abstract class Species implements Growable {
    protected String name;
    protected String scientificName;

    public Species(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getScientificName() {

        return scientificName;
    }

    public void setScientificName(String scientificName) {

        this.scientificName = scientificName;
    }
}
