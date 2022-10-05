package src.model;

public class Enemy {

    private int id;
    private int score = (int) (Math.random() * 101);
    private Type type;
    private int xVal = (int) (Math.random() * 101);
    private int yVal = (int) (Math.random() * 101);


    public Enemy(int id) {
        this.id = id;
        this.score = score;
        this.type = Type.values()[(int) (Math.random() * 3)];
        this.xVal = xVal;
        this.yVal = yVal;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "id=" + id +
                ", score=" + score +
                ", type=" + type +
                ", xVal=" + xVal +
                ", yVal=" + yVal +
                '}';
    }
    public String guideEnemy(){
        return "Enemy{" +
                "id=" + id +
                ", score=" + score +
                ", type=" + type + "}\n";
    }
}
