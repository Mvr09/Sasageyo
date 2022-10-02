package src.model;

import java.util.Arrays;

public class VideoHandler {
    private Player[] players;
    private Treasure[] treasures;
    private Level[] levels;
    private Enemy[] enemies;

    private static VideoHandler instance = new VideoHandler();
    private Resolution resolution;

    public VideoHandler() {
        this.players = new Player[20];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
        this.levels = new Level[10];
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public static VideoHandler getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "VideoHandler{" +
                //"players=" + Arrays.toString(players) +
                ",\ntreasures bible=" + Arrays.toString(treasures) +
                "\n, levels=" + Arrays.toString(levels) +
                ",\n enemy bible=" + Arrays.toString(enemies) +
                ",\n resolution=" + resolution +
                '}';
    }

    public void generate() {
        treasureCraft();
        enemyCraft();
        levelCraft();
        enemyAppend();
        treasureAppend();
        genDifficultyLvl();
    }

    public void newPlayer() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                Player newPlayer = new Player("Jugador");
                players[i] = newPlayer;
                break;
            }
        }
    }

    public void levelCraft() {
        int id = 1;
        int ptsNeed = 30;
        for (int i = 0; i < levels.length; i++) {
            Level newLevel = new Level(id, ptsNeed);
            id++;
            ptsNeed += 30;
            levels[i] = newLevel;
        }
    }

    public void treasureCraft() {
        for (int i = 0; i < treasures.length; i++) {
            Treasure newTreasure = new Treasure();
            treasures[i] = newTreasure;
        }

    }

    public void enemyCraft() {
        for (int i = 0; i < enemies.length; i++) {
            Enemy newEnemies = new Enemy();
            enemies[i] = newEnemies;
        }
    }

    public void enemyAppend(){
        for(int i=0; i< levels.length;i++) {
            Enemy enemyA = enemies[(int)(Math.random() * 25)];
            Enemy enemyB = enemies[(int)(Math.random() * 25)];
            Enemy enemyC = enemies[(int)(Math.random() * 25)];
            levels[i].addEnemy(enemyA);
            while(enemyA == enemyB){
                enemyB = enemies[(int)(Math.random() * 25)];
            }
            levels[i].addEnemy(enemyB);
            while((enemyA == enemyC)||(enemyB == enemyC)){
                enemyC = enemies[(int)(Math.random() * 25)];
            }

            levels[i].addEnemy(enemies[(int)(Math.random() * 25)]);
        }
    }
    public void treasureAppend(){
        for(int i=0; i< levels.length;i++) {
            levels[i].addTreasure(treasures[(int)(Math.random() * 50)]);
            levels[i].addTreasure(treasures[(int)(Math.random() * 50)]);
        }
    }

    public void genDifficultyLvl(){
        for(int i=0; i< levels.length;i++){
            levels[i].calculateDif();
        }
    }
}


