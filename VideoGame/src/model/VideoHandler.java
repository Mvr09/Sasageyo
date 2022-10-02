package src.model;

import java.util.Arrays;

public class VideoHandler {
    private Player[] players;
    private Treasure[] treasures;
    private Level[] levels;
    private Enemy[] enemies;

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

    @Override
    public String toString() {
        return "VideoHandler{" +
                //"players=" + Arrays.toString(players) +
                ",\ntreasures=" + Arrays.toString(treasures) +
                "\n, levels=" + Arrays.toString(levels) +
                ",\n enemies=" + Arrays.toString(enemies) +
                ",\n resolution=" + resolution +
                '}';
    }

    public void generate(){
        levelCraft();
        treasureCraft();
    }
    public void newPlayer() {
        for (int i = 0; i<players.length;i++){
            if(players[i] == null){
                Player newPlayer = new Player("Jugador");
                players[i] = newPlayer;
                break;
            }
        }
    }
    public void levelCraft() {
        int id = 1;
        int ptsNeed = 30;
        for (int i = 0; i<levels.length;i++){
            Level newLevel = new Level(id,ptsNeed);
            newLevel.generate();
            id++;
            ptsNeed += 30;
            levels[i] = newLevel;
        }
    }
    public void treasureCraft(){
        for (int i = 0; i<treasures.length;i++){
            Treasure newTreasure = new Treasure();
            treasures[i] = newTreasure;
        }

    }

}

