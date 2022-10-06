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
                "\nplayers=" + Arrays.toString(players) +
                ",\ntreasures guide=" + Arrays.toString(treasures) +
                ",\n enemy guide=" + Arrays.toString(enemies) +
                "\n, levels=" + Arrays.toString(levels) +
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

    public void newPlayer(String nickname) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                Player newPlayer = new Player(nickname, i);
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
            Treasure newTreasure = new Treasure(i);
            treasures[i] = newTreasure;
        }

    }

    public void enemyCraft() {
        for (int i = 0; i < enemies.length; i++) {
            Enemy newEnemies = new Enemy(i);
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
    public void displyPlayers(){
        System.out.println("Lista completa de jugadores con su id y puntaje");
        for(int i = 0; i<players.length; i++){
            if(players[i] != null) {
                System.out.println(players[i].guidePlayers());
            }
        }
    }

    public void displayLevels(){
        System.out.println("Lista completa de niveles con su id y dificultad");
        for(int i = 0; i<levels.length; i++){
            System.out.println(levels[i].guideLevel());
        }
    }
    public void displayOneLevel(int lvlId){
        System.out.println("Su informacion del nivel pedido");
        System.out.println(levels[lvlId].guideLevel());
    }

    public void displayEnemies(){
        System.out.println("Lista completa de enemigos con su id, puntaje y tipo");
        for(int i = 0; i<enemies.length; i++){
            System.out.println(enemies[i].guideEnemy());
        }
    }
    public void displayTreasures(){
        System.out.println("Lista completa de tesoros con su id, puntaje y tipo");
        for(int i = 0; i<treasures.length; i++){
            System.out.println(treasures[i].guideTreasures());
        }
    }
    public void addEnemyLvl(int idE, int idL){
        Enemy copyEnemy = enemies[idE];
        levels[idL].addEnemy(copyEnemy);
        System.out.println("Nivel modificado con un enemigo extra");
        System.out.println(levels[idL].toString());
    }

    public void addTreasureLvl(int idT, int idL){
        Treasure copyTreasure = treasures[idT];
        levels[idL].addTreasure(copyTreasure);
        System.out.println("Nivel modificado con un tesoro extra");
        System.out.println(levels[idL].toString());
    }

    public void modifyScorePlayer(int plId, int newScore){
        players[plId].setPuntaje(newScore);
    }

    public void evalScore(int plId){
       int[] lstLScores = new int[levels.length];
       int playerScore = players[plId].getPuntaje();
       for(int i = 0; i< levels.length;i++){
           lstLScores[i] = levels[i].getPtsNeed();
       }
       for (int i = 0;i<lstLScores.length;i++){
           if (playerScore>=lstLScores[i]){
               int lvl = i+1;
               System.out.println("Subio de nivel al: "+lvl);
               players[plId].setLevel(i +1);
           } else if (playerScore<lstLScores[i]) {
               System.out.println("No le alcanzan los puntos para avanzar");
               break;
           }
       }
    }

    public void countTypeTreasure(TypeT choice){
        int counter = 0;
        for(int i = 0; i<levels.length; i++){
            for(int j=0; j<2; j++)
            if (levels[i].getTreasureArr()[j]{

            }
        }
    }
}


