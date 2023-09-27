package Locations.BattleLocations;

import MonsterTypes.BaseMonster;
import MonsterTypes.Bear;
import Player.Player;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, new Bear(),2,"Water");
    }
}
