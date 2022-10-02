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
    private int difficulty;
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

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
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
                "Id=" + this.id +
                ", ptsNeed=" + this.ptsNeed +
                ", difficulty=" + this.difficulty +
                ", treasures=" + Arrays.toString(treasures) +
                ", enemies=" + Arrays.toString(enemies) +
                '}';
    }

    public void generate() {
        for (int i = 0; i < treasures.length; i++) {
            Treasure newTreasure = VideoManager.videoH.getTreasures()[(int) (Math.random() * 50)];
            treasures[i] = newTreasure;
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
