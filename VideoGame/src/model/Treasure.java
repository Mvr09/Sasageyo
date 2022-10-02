package src.model;
import java.lang.Math;
public class Treasure {
    private int score = (int)(Math.random() * 101);
    private String url = "https://img.freepik.com/premium-vector/treasure-chest-pixel-art-style_505135-49.jpg?w=2000";
    private int xVal = (int)(Math.random() * 101);
    private int yVal = (int)(Math.random() * 101);

    public Treasure() {
        this.score =  score;
        this.url = url;
        this.xVal = xVal;
        this.yVal = yVal;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getxVal() {
        return xVal;
    }

    public void setxVal(int xVal) {
        this.xVal = xVal;
    }

    public int getyVal() {
        return yVal;
    }

    public void setyVal(int yVal) {
        this.yVal = yVal;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "score=" + score +
                ", url='" + url + '\'' +
                ", xVal=" + xVal +
                ", yVal=" + yVal +
                '}';
    }
}
