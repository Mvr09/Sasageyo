package src.ui;
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
            System.out.println("Digite que quiere hacer, dando su numero:\n" +
                    "1: Crear un jugador\n" +
                    "2: Registrar un enemigo a un nivel, sabiendo que entra como un cuarto enemigo\n" +
                    "3: Registrar un tesoro extra a un nivel, entra como bonus\n" +
                    "4: Modificar el puntaje de un jugador\n" +
                    "5: Subir de nivel al jugador, si le alcanzan los puntos\n" +
                    "6: Solicitar informacion de un nivel en especifico\n" +
                    "7: Informar cantidad de un tipo de tesoro (No hay tipo creado)\n" +
                    "8: Informar cantidad de un tipo de enemigo en todos los niveles\n" +
                    "9: Informar el tipo de tesoro mas repetido en todos los niveles\n" +
                    "10: Informar el enemigo que otorga mayor puntaje y el nivel donde se ubica\n" +
                    "11: Informar la cantidad de consonantes encontradas en los nombres de los enemigos del juego.(name?)\n" +
                    "12: Informar el top 5 de jugadores\n" +
                    "13: Muestra todos los datos de la generacion y jugadores\n" +
                    "0: Exit");
            option = sc.nextInt();
            switch (option){
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

                    videoH.displayLevels();
                    System.out.println("Digite el id del nivel al que desea añadir al enemigo");
                    int idL = sc.nextInt();


                } //Need method
                case 4 -> {

                } //Need method
                case 5 -> {

                } //Need method
                case 6 -> {

                } //Need method
                case 7 -> {

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
