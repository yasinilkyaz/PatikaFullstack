package Locations.SafeLocations;

import Locations.BaseLocation;
import Locations.SafeLocations.Items.Armor;
import Locations.SafeLocations.Items.Weapon;
import Player.Player;

import java.util.Scanner;

public class Store extends BaseLocation {

    Scanner input = new Scanner(System.in);


    public Store(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation(Player player) {

        menu(player);
        return true;
    }

    public void menu(Player player) {
        Weapon pistol = new Weapon(1, "Tabanca", 2, 25);
        Weapon sword = new Weapon(2, "Kılıç", 3, 35);
        Weapon rifle = new Weapon(3, "Tüfek", 7, 45);
        Weapon[] weapons = {pistol, sword, rifle};

        Armor lightArmor = new Armor(1, "Hafif Zırh", 1, 15);
        Armor midArmor = new Armor(2, "Orta Zırh", 3, 25);
        Armor heavyArmor = new Armor(3, "Ağır Zırh", 5, 40);
        Armor[] armors = {lightArmor, midArmor, heavyArmor};
        boolean storeExit = false;
        System.out.println("Paranız :" + player.getMoney());
        while (!storeExit) {
            System.out.println("Kategori seçiniz");
            System.out.println("1-Silah");
            System.out.println("2-Zırh");
            System.out.println("3-Çıkış yap");

            int category = input.nextInt();
            switch (category) {
                case 1:

                    for (Weapon weapon : weapons
                    ) {
                        System.out.println(weapon.getId() + "-" + weapon.getName() + "\t" + "Hasar :" + weapon.getDamage() + "\t" + "Ücret :" + weapon.getCost());

                    }
                    System.out.println("Silah seçiniz");
                    int weaponId = input.nextInt();

                    switch (weaponId) {
                        case 1:
                            buyWeapon(player, pistol);
                            break;
                        case 2:
                            buyWeapon(player, sword);
                            break;
                        case 3:
                            buyWeapon(player, rifle);
                            break;
                        default:
                            break;
                    }
                    break;

                case 2:
                    for (Armor armor : armors
                    ) {
                        System.out.println(armor.getId() + "-" + armor.getName() + "\t" + "Bloklama :" + armor.getBlockedDamage() + "\t" + "Ücret :" + armor.getCost());

                    }
                    System.out.println("Zırh seçiniz");
                    int armorId = input.nextInt();
                    switch (armorId) {
                        case 1:
                            buyArmor(player, lightArmor);
                            break;
                        case 2:
                            buyArmor(player, midArmor);
                            break;
                        case 3:
                            buyArmor(player, heavyArmor);
                            break;
                        default:
                            break;

                    }
                case 3:
                    System.out.println("Mağazadan ayrıldınız.");
                    storeExit = true;
                default:

                    storeExit = true;
            }
        }


    }

    //Item abstract class yazmalıydım.
    public void buyWeapon(Player player, Weapon weapon) {

        if (player.getMoney() > weapon.getCost()) {
            player.setMoney(player.getMoney() - weapon.getCost());
            player.getInventory().setWeaponName(weapon.getName());
            player.getInventory().setWeaponDamage(weapon.getDamage());
            System.out.println("Satın alım gerçekleşti.");
        } else {
            System.out.println("Paranız yetersiz!");
        }
    }

    //buy armor yap
    public void buyArmor(Player player, Armor armor) {

        if (player.getMoney() > armor.getCost()) {
            player.setMoney(player.getMoney() - armor.getCost());
            player.getInventory().setArmorName(armor.getName());
            player.getInventory().setArmorDefence(armor.getBlockedDamage());
            System.out.println("Satın alım gerçekleşti.");

        } else {
            System.out.println("Paranız yetersiz!");
        }

    }

}
