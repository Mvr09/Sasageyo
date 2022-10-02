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

    public Player(String nickname){
        this.name = name;
        this.nickname = nickname;
        this.lives = 5;
        this.puntaje = 10;
    }
}
