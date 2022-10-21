package ui;

import model.Controller;

import java.util.Scanner;

public class Manager{

    private final Scanner sc;
    private final Controller controller;
    final String errorMessage1 = "option chosen does not exist";
    final String errorMessage2 = "Only type number is allowed in the input parameter";

    public Manager() {
        this.sc = new Scanner(System.in);
        this.controller = new Controller();
    }

    public static void main(String[] args) {
        Manager man = new Manager();
        boolean loop;
        System.out.println("Welcome to icesi Species");
        do {
            man.showMenu();
            loop = man.operation();
        }while (loop);
        System.out.println("Thanks for using the app");
    }
// The following method is called to check if the input is valid
    public int checkIn(int min, int max){
        boolean loop = false;
        int value = min -1;
        while (!loop){
            String aid = sc.nextLine();
            //Regex guide https://www.w3schools.com/java/java_regex.asp
            //If the input is not 0-9: errorMessage2
            if (!aid.matches("[0-9]+")) {
                System.err.println(errorMessage2);
            }
            else{
                value = Integer.parseInt(aid);
                loop = inRange(min,max,value);
                if (!loop) {
                    System.err.println(errorMessage1);
                }
            }
        }
        return value;
    }

    public boolean inRange(int min, int max, int n){
        return n <= max && n >= min;
    }

    public boolean operation() {
        boolean looping = true;
        int option = checkIn(0, 4);
        if (option == 0) {
            looping = false;
        } else if (option == 1) {
            register();
        } else if (option == 2) {
            edit();
        } else if (option == 3) {
            consult();
        } else if (option == 4) {
            delete();
        }
        return looping;
    }

    private void delete() {
        System.out.println("What species do you wish to delete?"+controller.showSpecies(1));
        int iSpecies = checkIn(1, 80);
        controller.deleteSpecies(iSpecies-1);
    }

    private void consult() {
        System.out.println(
                "what do you want to consult?\n"+
                        "1. Show all species\n"+
                        "2. Show all fauna species\n"+
                        "3. Show all flora species"
        );
        int show = checkIn(1, 3);
        System.out.println(controller.showSpecies(show));
    }

    private void edit() {
        System.out.println("What species do you want to edit?"+controller.showSpecies(1));
        int iSpecies = checkIn(1, 80);
        boolean loop;
        do {
            loop = editSpecies(iSpecies-1);
        } while (loop);
    }

    private boolean editSpecies(int iSpecies) {
        String name = "";
        String scientificName = "";
        boolean isMigratory = false;
        boolean hasFlower = false;
        boolean hasFruit = false;
        double maxWeight = -1.0;
        double maxHeight = -1.0;
        System.out.println("What do you wish to modify?\n1. Name \n2. Scientific Name ");
        if (controller.getClass(iSpecies).equals("Fauna")){
            System.out.println("3. Migratory \n4. Weigth");
        }
        if (controller.getClass(iSpecies).equals("Flora")){
            System.out.println("3. Flower \n4. Fruit \n5.Height");
        }
        System.out.println("0. Exit");
        String option = controller.getClass(iSpecies) + " " + checkIn(0, 5);
        if ("Fauna 0".equals(option)) {
            return false;
        } else if ("Flora 1".equals(option) || "Fauna 1".equals(option)) {
            System.out.println("Type: new Name");
            name = sc.nextLine();
        } else if ("Flora 2".equals(option) || "Fauna 2".equals(option)) {
            System.out.println("Type: new Scientific Name");
            scientificName = sc.nextLine();
        } else if ("Flora 3".equals(option)) {
            System.out.println("Type: new Flowers\n (1) Yes  (0) No");
            if (checkIn(0, 1) == 1) hasFlower = true;
        } else if ("Fauna 3".equals(option)) {
            System.out.println("Type: new Migratory\n (1) Yes  (0) No");
            if (checkIn(0, 1) == 1) isMigratory = true;
        } else if ("Flora 4".equals(option)) {
            System.out.println("Type: new Fruits\n (1) Yes  (0) No");
            if (checkIn(0, 1) == 1) hasFruit = true;
        } else if ("Fauna 4".equals(option)) {
            System.out.println("Type: new Weight");
            maxWeight = sc.nextDouble();
        } else if ("Flora 5".equals(option)) {
            System.out.println("Type: new Height");
            maxHeight = sc.nextDouble();
        }
        if (controller.getClass(iSpecies).equals("Fauna")){
            controller.editSpecies(name, scientificName, isMigratory, maxWeight, iSpecies);
        }
        if (controller.getClass(iSpecies).equals("Flora")){
            controller.editSpecies(name, scientificName, hasFlower, hasFruit, maxHeight, iSpecies);
        }
        return true;
    }

    private void register() {
        System.out.println(
                "What species do you want to register\n"+
                        "(1) Fauna\n"+
                        "(2) Flora\n"+
                        "(0) Exit"
        );
        int option = checkIn(0,2);
        if (option != 0) registerSpecies(option);
    }

    private void registerSpecies(int option) {
        boolean isMigratory = false;
        boolean hasFlower = false;
        boolean hasFruit = false;
        System.out.println("Type name");
        String name = sc.nextLine();
        System.out.println("Type Scientific name");
        String scientificName = sc.nextLine();
        switch (option){
            case 1:
                System.out.println("Is it a migratory species?\n  1. Yes  0. No");
                int chooseMigratory = checkIn(0, 1);
                if(chooseMigratory == 1) isMigratory = true;
                System.out.println("Type max weight");
                double maxWeight = sc.nextDouble();
                sc.nextLine();
                if (controller.registerSpecies(name,scientificName,isMigratory,maxWeight))
                    System.out.println("The species was successfully registered");
                else System.out.println("Sorry, there isn't any space left in the registry");
                break;
            case 2:
                System.out.println("Does the species have flowers?\n   1. Yes  0. No");
                int chooseFlowers = checkIn(0, 1);
                if (chooseFlowers == 1) hasFlower = true;
                System.out.println("Does the species bare fruits?\n   1. Yes  0. No");
                int chooseFruits = checkIn(0, 1);
                if (chooseFruits == 1) hasFruit = true;
                System.out.println("Type the max height");
                double maxHeight = sc.nextDouble();
                sc.nextLine();
                if (controller.registerSpecies(name, scientificName, hasFlower, hasFruit, maxHeight))
                    System.out.println("The species was successfully registered");
                else{
                    System.out.println("Not enough space left to register the species");
                }
                break;
        }

    }

    public void showMenu() {
        System.out.println(
                """
                        Menu
                        1. Register a species
                        2. Edit a species
                        3. Consult a species
                        4. Delete a species
                        0. Exit
                        """
        );
    }
}