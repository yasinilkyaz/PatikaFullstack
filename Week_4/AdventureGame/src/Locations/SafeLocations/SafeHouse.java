package Locations.SafeLocations;

import Locations.BaseLocation;
import Player.Player;

public class SafeHouse extends BaseLocation {


    public SafeHouse(Player player) {
        super(player);

    }

    @Override
    public boolean onLocation(Player player) {
        house(player);
        return true;
    }

    public void house(Player player){
        System.out.println("Güvenli Evdesiniz.");
        player.setHealthy(player.getCharType().getHealth());
        System.out.println("Canınız yenilendi :"+player.getHealthy());
        System.out.println("Paranız : "+player.getMoney());
        System.out.println("Hasar Puanı : "+(player.getDamage()+player.getInventory().getWeaponDamage()));
        System.out.println("Silahınız : "+(player.getInventory().getWeaponName())+"\t Hasar :"+player.getInventory().getWeaponDamage());
        System.out.println("Zırhınız : "+(player.getInventory().getArmorName())+"\t Bloklanacak Hasar :"+player.getInventory().getArmorDefence());


    }



}
