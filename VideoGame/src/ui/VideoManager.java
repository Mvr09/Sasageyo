package src.ui;
import src.model.TypeT;
import src.model.VideoHandler;

import java.util.Scanner;
public class VideoManager {
    public static Scanner sc = new Scanner(System.in);
    public static VideoHandler videoH = new VideoHandler();

    public static void main(String[] args) {
        videoH.generate();
        System.out.println(videoH.toString());
        menu();

    }
    public static void menu(){
        int option = 100;
        while(option != 0){
            System.out.println("""
                    Digite que quiere hacer, dando su numero:
                    1: Crear un jugador
                    2: Registrar un enemigo a un nivel, sabiendo que entra como un cuarto enemigo
                    3: Registrar un tesoro extra a un nivel, entra como bonus
                    4: Modificar el puntaje de un jugador
                    5: Subir de nivel al jugador, si le alcanzan los puntos, sabiendo que esta en el 0 si no ha empezado
                    6: Solicitar informacion de un nivel en especifico
                    7: Informar cantidad de un tipo de tesoro 
                    8: Informar cantidad de un tipo de enemigo en todos los niveles
                    9: Informar el tipo de tesoro mas repetido en todos los niveles
                    10: Informar el enemigo que otorga mayor puntaje y el nivel donde se ubica
                    11: Informar la cantidad de consonantes encontradas en los nombres de los enemigos del juego.(name?)
                    12: Informar el top 5 de jugadores
                    13: Muestra todos los datos de la generacion y jugadores
                    0: Exit""");
            option = sc.nextInt();
            switch (option){
                case 0 -> {
                    break;
                }
                case 1 -> {
                    System.out.println("Digite su nickname");
                    sc.nextLine();
                    String nickname= sc.nextLine();
                    videoH.newPlayer(nickname);
                }
                case 2 -> {
                    videoH.displayEnemies();
                    System.out.println("Digite el id del enemigo que desea añadir");
                    int id = sc.nextInt();

                    videoH.displayLevels();
                    System.out.println("Digite el id del nivel al que desea añadir al enemigo");
                    int idL = sc.nextInt();

                    videoH.addEnemyLvl(id, idL-1);
                }
                case 3 -> {
                    videoH.displayTreasures();
                    System.out.println("Digite el id del tesoro que desea añadir");
                    int idT = sc.nextInt();

                    videoH.displayLevels();
                    System.out.println("Digite el id del nivel al que desea añadir al enemigo");
                    int idL = sc.nextInt();

                    videoH.addTreasureLvl(idT, idL-1);
                }
                case 4 -> {
                    videoH.displyPlayers();
                    System.out.println("Digite el numero de jugador a modificar");
                    int plId = sc.nextInt();

                    System.out.println("Digite el numero del puntaje nuevo");
                    int scoreChange = sc.nextInt();

                    videoH.modifyScorePlayer(plId, scoreChange);
                }
                case 5 -> {
                    videoH.displyPlayers();
                    System.out.println("Digite el numero de jugador a modificar");
                    int plId = sc.nextInt();
                    videoH.evalScore(plId);
                }
                case 6 -> {
                    videoH.displayLevels();
                    System.out.println("Digite el numero de su nivel");
                    int lvlId = sc.nextInt();
                    videoH.displayOneLevel(lvlId-1);

                }
                case 7 -> {
                    System.out.println("Digite el numero de su tipo de tesoro");
                    System.out.println("""
                            1. Diamond 
                            2. Ruby
                            3. Gold
                            4. Quartz
                            5. Ender Pearl
                            """);
                    TypeT choice = TypeT.values()[sc.nextInt()-1];
                    System.out.println(choice);
                    videoH.countTypeTreasure(choice);
                } //Need method
                case 8 -> {

                } //Need method
                case 9 -> {

                } //Need method
                case 10 -> {

                } //Need method
                case 11 -> {

                } //Need method
                case 12 -> {

                } //Need method
                case 13 -> {
                    System.out.println(videoH.toString());
                } //Need method
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }
}
