
import Locations.BaseLocation;
import Locations.BattleLocations.Cave;
import Locations.BattleLocations.Forest;
import Locations.BattleLocations.Mine;
import Locations.BattleLocations.River;
import Locations.SafeLocations.SafeHouse;
import Locations.SafeLocations.Store;
import Player.Player;
import Player.Inventory;

import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);

    public void run() {
        System.out.println("Macera oyununa Hoşgeldiniz!");
        System.out.print("Lütfen kullanıcı adınızı giriniz : ");
        String playerName = input.nextLine();

        //Gerekli olan nesneler üretildi.
        Inventory inventory = new Inventory();
        Player player = new Player(playerName, inventory);

        //Kullanıcıyı hangi karakterle oynamak istiyorsa seçime gönderiyoruz.
        player.chooseCharType(player);

        //Gerekli olan nesneler üretildi.
        BaseLocation location = null;
        boolean game = true;

        //Oyun Başlatıldı
        while (game) {
            //Ödüller alındı ise oyunu kazanıyor.
            if (isWin(player.getInventory())) {
                System.out.println("Tebrikler! Gerekli olan yemek,odun ve su malzemelerini bularak oyunumuzu başarılı bir şekilde tamamladınız.");
                break;
            }
            System.out.println();
            System.out.println("-------------BÖLGE SEÇ------------");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Mağara");
            System.out.println("4 - Orman");
            System.out.println("5 - Nehir");
            System.out.println("6 - Maden");
            System.out.println("7 - Çıkış");

            int loc = input.nextInt();
            switch (loc) {
                case 1:
                    location = new SafeHouse(player);
                    game = location.onLocation(player);
                    break;
                case 2:
                    location = new Store(player);
                    game = location.onLocation(player);
                    break;
                case 3:
                    location = new Cave(player);
                    game = location.onLocation(player);
                    break;
                case 4:
                    location = new Forest(player);
                    game = location.onLocation(player);
                    break;
                case 5:
                    location = new River(player);
                    game = location.onLocation(player);
                    break;
                case 6:
                    location = new Mine(player);
                    game = location.onLocation(player);
                    break;
                case 7:
                    game = false;
                default:
                    location = new SafeHouse(player);
            }

        }
        //Gittiği lokasyonda kullanıcı sağlığı sıfır olursa oyun devam etmez.
        if (!game) {
            System.out.println("Oyun Bitti");
        }


    }
    //Ödüllerin kontrolü
    public boolean isWin(Inventory inventory) {
        return inventory.isFood() && inventory.isFirewood() && inventory.isWater();
    }


}
