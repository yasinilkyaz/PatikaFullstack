package Locations.BattleLocations;

import Locations.SafeLocations.Items.Armor;
import Locations.SafeLocations.Items.Weapon;
import MonsterTypes.Snake;
import Player.Player;

import java.util.Random;

public class Mine extends BattleLocation {
    public Mine(Player player) {
        super(player, new Snake(), 6, "İtem veya para araştırıyorsun...");

    }

    @Override
    public void sectorClear(int loop) {
        //rastgele eşya düşme için Random sayı üretecek sınıf çağrılır
        Random random = new Random();

        for (int i = 0; i < loop; i++) {
            int chance = random.nextInt(0, 100);

            if (chance < 46) {//hiçbirşey çıkmama olasılığı
                System.out.println((i + 1) + ".yılanın bölgesinde birşey çıkmadı");
            } else if (chance > 46 && chance < 71) {//Para çıkma olasılığı
                int chanceMoney = random.nextInt(0, 100);

                if (chanceMoney < 51) {
                    System.out.println((i + 1) + ".yılanın bölgesinde 1 tane para buldunuz");
                    getPlayer().setMoney(getPlayer().getMoney() + 1);
                } else if (chanceMoney > 51 && chanceMoney < 81) {
                    System.out.println((i + 1) + ".yılanın bölgesinde 5 tane para buldunuz");
                    getPlayer().setMoney(getPlayer().getMoney() + 5);
                } else {
                    System.out.println((i + 1) + ".yılanın bölgesinde 10 tane para buldunuz");
                    getPlayer().setMoney(getPlayer().getMoney() + 10);
                }

                //para
            } else if (chance > 71 && chance < 86) {
                int chanceWeapon = random.nextInt(0, 100);

                if (chanceWeapon < 51) {//Silah çıkma olasılığı
                    System.out.println((i + 1) + ".yılanın bölgesinde Tabanca buldunuz");
                    Weapon pistol = new Weapon(1, "Tabanca", 2, 25);
                    getPlayer().getInventory().setWeaponName(pistol.getName());
                    getPlayer().getInventory().setWeaponDamage(pistol.getDamage());
                } else if (chanceWeapon > 51 && chanceWeapon < 81) {
                    System.out.println((i + 1) + ".yılanın bölgesinde Kılıç buldunuz");
                    Weapon sword = new Weapon(2, "Kılıç", 3, 35);
                    getPlayer().getInventory().setWeaponName(sword.getName());
                    getPlayer().getInventory().setWeaponDamage(sword.getDamage());
                } else {
                    System.out.println((i + 1) + ".yılanın bölgesinde Tüfek buldunuz");
                    Weapon rifle = new Weapon(3, "Tüfek", 7, 45);
                    getPlayer().getInventory().setWeaponName(rifle.getName());
                    getPlayer().getInventory().setWeaponDamage(rifle.getDamage());
                }
                //silah
            } else {
                int chanceArmor = random.nextInt(0, 100);
                if (chanceArmor < 51) {//Zırh çıkma olasılığı
                    System.out.println((i + 1) + ".yılanın bölgesinde Hafif Zırh buldunuz");
                    Armor lightArmor = new Armor(1, "Hafif Zırh", 1, 15);
                    getPlayer().getInventory().setArmorName(lightArmor.getName());
                    getPlayer().getInventory().setArmorDefence(lightArmor.getBlockedDamage());
                } else if (chanceArmor > 51 && chanceArmor < 81) {
                    System.out.println((i + 1) + ".yılanın bölgesinde Orta Zırh buldunuz");
                    Armor midArmor = new Armor(2, "Orta Zırh", 3, 25);
                    getPlayer().getInventory().setArmorName(midArmor.getName());
                    getPlayer().getInventory().setArmorDefence(midArmor.getBlockedDamage());
                } else {
                    System.out.println((i + 1) + ".yılanın bölgesinde Ağır Zırh buldunuz");
                    Armor heavyArmor = new Armor(3, "Ağır Zırh", 5, 40);
                    getPlayer().getInventory().setWeaponName(heavyArmor.getName());
                    getPlayer().getInventory().setWeaponDamage(heavyArmor.getBlockedDamage());
                }

            }

        }
    }
}
