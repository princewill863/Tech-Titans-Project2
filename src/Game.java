/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author princewilliroka
 */
import java.util.ArrayList;

public abstract class Game {
    protected String name;
    protected ArrayList<Player> players;
    protected String gamename;

    public abstract String getName();

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract void play();

    public abstract void declareWinner();
}