import CharTypes.Archer;
import CharTypes.BaseChar;
import CharTypes.Knight;
import CharTypes.Samurai;
import Locations.BaseLocation;
import Locations.SafeLocations.SafeHouse;
import Locations.SafeLocations.Store;
import Player.Player;
import Player.Inventory;

import java.util.Scanner;

public class Game {

    Scanner input=new Scanner(System.in);

    public void run(){
        System.out.println("Macera oyununa Hoşgeldiniz!");
        System.out.print("Lütfen kullanıcı adınızı giriniz : ");
        String playerName=input.nextLine();


        Inventory inventory=new Inventory();
        Player player=new Player(playerName, inventory);

        player.chooseCharType(player);

        BaseLocation location=null;

        while (true){
            System.out.println();
            System.out.println("-------------BÖLGE SEÇ------------");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");

            int loc=input.nextInt();
            switch (loc){
                case 1:
                    location=new SafeHouse(player);
                    location.onLocation(player);
                    break;
                case 2:
                    location=new Store(player);
                    location.onLocation(player);
                    break;

                default:
                    location=new SafeHouse(player);
            }

        }

        //player kurucudan karakterin sağlık hasar  parayı sil caselerin içinde belirt
    }

}
