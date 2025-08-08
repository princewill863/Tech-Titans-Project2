
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author princewilliroka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GoFishGame game = new GoFishGame("Go Fish");
        GoFishPlayer player1 = new GoFishPlayer("Player 1");
        GoFishPlayer player2 = new GoFishPlayer("Player 2");
        game.setPlayers(new ArrayList<>());
        game.getPlayers().add(player1);
        game.getPlayers().add(player2);
        game.play();
    }
    
}
