/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author princewilliroka
 */
public abstract class Player {
    protected String name;

    public abstract void play();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


