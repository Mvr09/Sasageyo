package src.model;
/**jugadores, de ellos se maneja un nickname que lo identifica, un nombre, el puntaje inicial (el jugador inicia con 10),
*tiene un número de vidas (inicia con 5). El sistema debe permitir establecer el nivel en el que va el jugador teniendo
* en cuenta su puntaje y el puntaje requerido para pasar del nivel. Recuerde que el nickname es el identificador por lo que no podrá repetirse.
 * */
public class Player {
    private String name;
    private String nickname;
    private int puntaje;
    private int lives;
    private int level;

    public Player(String nickname, int id){
        this.name = "Player "+id;
        this.nickname = nickname;
        this.level = 0;
        this.lives = 5;
        this.puntaje = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", puntaje=" + puntaje +
                ", level=" + level +
                ", lives=" + lives +
                '}'+"\n";
    }

    /**
     * Descrption: Simple to string representation
     * @return
     */
    public String guidePlayers(){
        return "Player{" +
                "Numero de jugador='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", puntaje=" + puntaje +
                '}'+"\n";

    }

}
