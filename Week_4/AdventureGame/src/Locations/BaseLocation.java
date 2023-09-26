package Locations;

import Player.Player;

public abstract class BaseLocation {

    private Player player;


    public BaseLocation(Player player) {
        this.player = player;

    }


    public abstract boolean onLocation(Player player);
}
