package Locations;

import Player.Player;

import java.util.Scanner;

public abstract class BaseLocation {

    private Player player;
    public static Scanner input = new Scanner(System.in);

    //Ata sınıf
    public BaseLocation(Player player) {
        this.player = player;

    }


    public abstract boolean onLocation(Player player);

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
