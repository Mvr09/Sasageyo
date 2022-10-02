package src.model;

/**De un nivel se tiene un número que lo identifica, los puntos que se requiere para pasar al siguiente nivel.
 *nivel de complejidad (alto, medio, bajo), si los puntos que otorgan los tesoros es mayor que los puntos de los
 * enemigos es nivel bajo, si es igual es medio, y si son más los puntos de los enemigos que los
 * puntos de los tesoros es alto.
 * */
import src.ui.VideoManager;

import java.util.Arrays;
import java.util.UUID;
public class Level {
    private int id;
    private int ptsNeed = 0;
    private Difficulty difficulty;
    private Treasure[] treasures;
    private Enemy[] enemies;

    public Level(int id, int ptsNeed) {
        this.id = id;
        this.treasures = new Treasure[2];
        this.enemies = new Enemy[3];
        this.ptsNeed = ptsNeed;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPtsNeed() {
        return ptsNeed;
    }

    public void setPtsNeed(int ptsNeed) {
        this.ptsNeed = ptsNeed;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    @Override
    public String toString() {
        return "Level{" +
                "\nId=" + this.id +
                ", ptsNeed=" + this.ptsNeed +
                ", difficulty=" + this.difficulty +
                ", treasures=" + Arrays.toString(treasures) +
                ", enemies=" + Arrays.toString(enemies) +
                '}';
    }
    public int scoreTreasures(){
        int scoreT = 0;
        for(int i = 0; i < treasures.length; i++){
            scoreT += treasures[i].getScore();
        }
        return scoreT;
    }
    public int scoreEnemies(){
        int scoreE = 0;
        for(int i = 0; i < enemies.length; i++){
            scoreE += enemies[i].getScore();
        }
        return scoreE;
    }

    public void calculateDif(){
        int scoreT = scoreTreasures();
        int scoreE = scoreEnemies();
        Difficulty difficulty = Difficulty.values()[0];
        if(scoreT>scoreE){
            difficulty = Difficulty.values()[0];
        } else if (scoreT == scoreE) {
            difficulty = Difficulty.values()[1];
        } else if (scoreT < scoreE) {
            difficulty = Difficulty.values()[2];
        }
        this.difficulty = difficulty;
    }
    public void addTreasure(Treasure newTreasure) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] == null) {
                treasures[i] = newTreasure;
                break;
            }
        }
    }
    public void addEnemy(Enemy newEnemy) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] == null) {
                enemies[i] = newEnemy;
                break;
            }
        }
    }
}
