package Locations.BattleLocations;

import MonsterTypes.BaseMonster;
import MonsterTypes.Vampire;
import Player.Player;

public class Forest extends BattleLocation{
    public Forest(Player player ) {
        super(player, new Vampire(),3,"Firewood");
    }
}
