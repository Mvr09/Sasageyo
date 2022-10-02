package src.ui;
import src.model.VideoHandler;

import java.util.Scanner;
public class VideoManager {
    public static Scanner sc = new Scanner(System.in);
    public static VideoHandler videoH = new VideoHandler();

    public static void main(String[] args) {
        videoH.generate();
        System.out.println(videoH.toString());
    }

}
