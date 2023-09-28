package Locations.BattleLocations;


import MonsterTypes.Bear;
import Player.Player;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, new Bear(), 2, "Su");
    }

    @Override
    public void sectorClear(int loop) {
        getPlayer().getInventory().setWater(true);
    }
}
