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

    public int countTypeTreasure(int input){
        int counter = 0;
        TypeT choice = TypeT.values()[input];
        for(int i = 0; i<levels.length; i++){
            for(int j=0; j<2; j++)
                if (levels[i].getTreasures()[j].getType()==choice){
                    counter++;
                }
        }
        return counter;
    }

    public int countTypeEnemy(int input){
        int counter = 0;
        Type choice = Type.values()[input];
        for(int i = 0; i<levels.length; i++){
            for(int j=0; j<3; j++)
                if (levels[i].getEnemyArr()[j].getType()==choice){
                    counter++;
                }
        }
        return counter;
    }

    public String maxValType(int[] inputLst){
        int max = 0;
        String output = "El tipo mas repetido es el: ";
        for(int i = 0; i<inputLst.length; i++){
            if(max < inputLst[i]){
                max = inputLst[i];
            }
        }
        for(int i = 0; i<inputLst.length; i++){
            if(max == inputLst[i]){
                output += i + "  ";
            }
        }
        return output;
    }

    public String topEnemy(){
        Enemy topEnemy = null;
        String output = "";
        int pX = 0;
        int pY = 0;
        //i nivel
        //j posicion en el nivel
        for(int i = 0; i < levels.length; i++){
            for(int j = 0; j<levels[i].getEnemyArr().length-1; j++){
                if(topEnemy==null){
                    topEnemy = levels[i].getEnemies()[j];
                    pX = i;
                    pY = j;
                } else if (topEnemy.getScore()<levels[i].getEnemyArr()[j].getScore()) {
                    topEnemy = levels[i].getEnemyArr()[j];
                    pX = i;
                    pY = j;
                }

                }
            }
        pX++;
        pY++;
        output = "Su top enemigo tiene un puntaje de: "+topEnemy.getScore()+ "\n" +
                "Esta en el nivel: " + pX + "\n"+
                "Esta en la posicion numero "+ pY + " del nivel";
        return output;
        }

        public int countConsonant(Type word) {
            String name = word.name();
            int count = 0;
            for (int i = 0; i < name.length(); i++) {
                char ch = name.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    //Dejo vacio para representar que no pasa nada
                } else {
                    count++;
                }
            }
            return count;
        }

        public int countNameConsonantEnemy(){
        int countTotal = 0;
        //i level
        //j enemy
            for (int i = 0; i < levels.length; i++) {
                for (int j = 0; j < levels[i].getEnemyArr().length-1; j++) {
                    countTotal += countConsonant(levels[i].getEnemyArr()[j].getType());
                }
            }
            return countTotal;
        }
        public Player[] removeNullPlayers(){
            int count = 0;
            for (Player player : players) {
                if (player != null) {
                    count++;
                }
            }
           Player[] output = new Player[count];

            for (int i = 0; i < players.length; i++) {
                if (players[i]!= null) {
                    output[i] = players[i];
                }
            }
            return output;
        }
    public int[] playersToInt(Player[] players2) {
        int[] output = new int[players2.length];
        for (int i = 0; i < players2.length; i++) {
            output[i] = players2[i].getPuntaje();
        }
        return output;
    }
    public Player[] intToPlayerArray(int[] scores) {
        Player[] output = new Player[5];
        for (int i = 0; i < 4; i++) {
            for (Player player : players) {
                //catch
                try{
                    if (scores[i] == player.getPuntaje()) {
                        output[i] = player;
                        break;
                }}catch(Exception e){
                    break;
                }
            }
        }
        return output;
    }
    public int[] maxValues(int[] values) {
        int tempMax =  0;//1
        int[] organizedValues = new int[values.length + 1];
        int[] finalValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            tempMax = maxInt(values);
            organizedValues[i] = tempMax;
            for (int j = 0; j < values.length; j++) {
                if (tempMax == values[j]) {
                    values[j] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < organizedValues.length-1; i++) {
            finalValues[i] = organizedValues[i];
        }
        return finalValues;
    }
    public int maxInt(int[] values){
        int tempMax = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > tempMax){
                tempMax = values[i];
            }
        }
        return tempMax;
    }
    public String displayTop5(Player[] lstTop5){
        String output = "";
        for (int i = 0; i < lstTop5.length; i++) {
            try{
            output +=i+ ". " + lstTop5[i].getNickname() + ": "+ lstTop5[i].getPuntaje() + "\n";}
            catch(Exception e){
                break;
            }
        }
        return output;
    }
    }



