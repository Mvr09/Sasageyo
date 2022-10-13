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

    /**
     *
     * @return players[]
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     *
     * @return treasures[]
     */
    public Treasure[] getTreasures() {
        return treasures;
    }

    /**
     *
     * @param treasures
     */
    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    /**
     *
     * @return levels[]
     */
    public Level[] getLevels() {
        return levels;
    }

    /**
     *
     * @param levels[]
     */
    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    /**
     *
     * @return enemies[]
     */
    public Enemy[] getEnemies() {
        return enemies;
    }

    /**
     *
     * @param enemies []
     */
    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    /**
     *
     * @return resolution
     */
    public Resolution getResolution() {
        return resolution;
    }

    /**
     *
     * @param resolution
     */
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    /**
     *
     * @return toString
     */
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

    /**
     * Description: a method that runs all initial generation methods
     */
    public void generate() {
        treasureCraft();
        enemyCraft();
        levelCraft();
        enemyAppend();
        treasureAppend();
        genDifficultyLvl();
    }

    /**
     *
     * @param nickname
     */
    public void newPlayer(String nickname) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                Player newPlayer = new Player(nickname, i);
                players[i] = newPlayer;
                break;
            }
        }
    }

    /**
     * Descrption: generates all 10 levels and fills them
     */
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

    /**
     * Descrption: generates all treasure variations
     */
    public void treasureCraft() {
        for (int i = 0; i < treasures.length; i++) {
            Treasure newTreasure = new Treasure(i);
            treasures[i] = newTreasure;
        }

    }

    /**
     * Descrption: generates all enemy variations
     */
    public void enemyCraft() {
        for (int i = 0; i < enemies.length; i++) {
            Enemy newEnemies = new Enemy(i);
            enemies[i] = newEnemies;
        }
    }

    /**
     * Descrption: adds all enemy variations needed to each level. Without repeating.
     */
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

    /**
     * Descrption: adds treasures from list to the levels
     */
    public void treasureAppend(){
        for(int i=0; i< levels.length;i++) {
            levels[i].addTreasure(treasures[(int)(Math.random() * 50)]);
            levels[i].addTreasure(treasures[(int)(Math.random() * 50)]);
        }
    }

    /**
     *  Descrption: adds the difficulty by calculating it from the enemy score and the treasure score
     */
    public void genDifficultyLvl(){
        for(int i=0; i< levels.length;i++){
            levels[i].calculateDif();
        }
    }

    /**
     * Descrption: shows the list of all players
     */
    public void displyPlayers(){
        System.out.println("Lista completa de jugadores con su id y puntaje");
        for(int i = 0; i<players.length; i++){
            if(players[i] != null) {
                System.out.println(players[i].guidePlayers());
            }
        }
    }

    /**
     * Descrption: Shows all levels
     */
    public void displayLevels(){
        System.out.println("Lista completa de niveles con su id y dificultad");
        for(int i = 0; i<levels.length; i++){
            System.out.println(levels[i].guideLevel());
        }
    }

    /**
     * Descrption: shows 1 level given by the user
     * @param lvlId
     */
    public void displayOneLevel(int lvlId){
        System.out.println("Su informacion del nivel pedido");
        System.out.println(levels[lvlId].guideLevel());
    }

    /**
     * Descrption: shows all enemies with their id, type and score
     */
    public void displayEnemies(){
        System.out.println("Lista completa de enemigos con su id, puntaje y tipo");
        for(int i = 0; i<enemies.length; i++){
            System.out.println(enemies[i].guideEnemy());
        }
    }

    /**
     * Descrption: shows all treasures
     */
    public void displayTreasures(){
        System.out.println("Lista completa de tesoros con su id, puntaje y tipo");
        for(int i = 0; i<treasures.length; i++){
            System.out.println(treasures[i].guideTreasures());
        }
    }

    /**
     * Descrption: adds an enemy from the enemy generation list of the users choosing to a level
     * @param idE
     * @param idL
     */
    public void addEnemyLvl(int idE, int idL){
        Enemy copyEnemy = enemies[idE];
        levels[idL].addEnemy(copyEnemy);
        System.out.println("Nivel modificado con un enemigo extra");
        System.out.println(levels[idL].toString());
    }

    /**
     * Descrption: adds a treasure from the treasure generation list of the users choosing to a level
     * @param idT
     * @param idL
     */
    public void addTreasureLvl(int idT, int idL){
        Treasure copyTreasure = treasures[idT];
        levels[idL].addTreasure(copyTreasure);
        System.out.println("Nivel modificado con un tesoro extra");
        System.out.println(levels[idL].toString());
    }

    /**
     * Descrption: Changes a player score of the users choosing
     * @param plId
     * @param newScore
     */
    public void modifyScorePlayer(int plId, int newScore){
        players[plId].setPuntaje(newScore);
    }

    /**
     * Descrption: Evaluates if a player can level up and up to which level
     * @param plId
     */
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

    /**
     * Descrption: Counts the number of a type of treasures
     * @param input
     * @return
     */
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

    /**
     * Descrption: Counts the number of enemies of a given type
     * @param input
     * @return
     */
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

    /**
     * Descrption: Finds the most repeated type of treasure
     * @param inputLst
     * @return
     */
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

    /**
     * Descrption:Finds the hardest enemy
     * @return
     */
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

    /**
     * Descrption: Counts consonts in a word
     * @param word
     * @return
     */
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

    /**
     * Descrption: Counts consonants in the name (type) of an enemy
     * @return
     */
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

    /**
     * Descrption: Removes null positions of players and generates a new list without the nulls
     * @return
     */
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

    /**
     * Descrption: turns all players in a list to their scores
     * @param players2
     * @return int[] output
     */
    public int[] playersToInt(Player[] players2) {
        int[] output = new int[players2.length];
        for (int i = 0; i < players2.length; i++) {
            output[i] = players2[i].getPuntaje();
        }
        return output;
    }

    /**
     * Descrption: uses the scores to get the player responsible after sorting
     * @param scores
     * @return
     */
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

    /**
     * Descrption: Returns the max values (large to small)
     * @param values
     * @return
     */
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

    /**
     * Returns the max int in a range of values
     * @param values
     * @return
     */
    public int maxInt(int[] values){
        int tempMax = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > tempMax){
                tempMax = values[i];
            }
        }
        return tempMax;
    }

    /**
     * Descrption: Cuts extra spots off players in order and returns them. If it fails it returns whatever number
     *              of players less than 5 it has
     * @param lstTop5
     * @return
     */
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



