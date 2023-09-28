package Locations.BattleLocations;

import MonsterTypes.BaseMonster;
import MonsterTypes.Zombie;
import Player.Player;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(player, new Zombie(), 3, "Yemek");
    }


    @Override
    public void sectorClear(int loop) {
        getPlayer().getInventory().setFood(true);
    }
}
