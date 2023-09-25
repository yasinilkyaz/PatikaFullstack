import CharTypes.Archer;
import CharTypes.BaseChar;
import CharTypes.Knight;
import CharTypes.Samurai;
import Locations.BaseLocation;
import Locations.SafeLocations.SafeHouse;
import Player.Player;
import Player.Inventory;

import java.util.Scanner;

public class Game {

    Scanner input=new Scanner(System.in);

    public void run(){
        System.out.println("Macera oyununa Hoşgeldiniz!");
        System.out.print("Lütfen kullanıcı adınızı giriniz : ");
        String playerName=input.nextLine();

        Samurai samurai=new Samurai();
        Archer archer=new Archer();
        Knight knight=new Knight();

        BaseChar[] charTypes={samurai,archer,knight};

        for (BaseChar charType:charTypes) {
            System.out.println(charType.getCharId()+"-"+charType.getCharName()+"\t"+charType.getDamage()+"\t"+charType.getHealth()+"\t"+charType.getMoney());

        }
        System.out.println("Karakterinizi seçiniz :");
        int selectedCharacter=input.nextInt();
        switch (selectedCharacter){
            case 1:
                System.out.println("samuray");
                break;
            case 2:
                    System.out.println("okçu");
                    break;
            case 3:
                System.out.println("Şövalye");
                break;

        }
        BaseLocation location=new SafeHouse();
        Inventory inventory=new Inventory();
        Player player=new Player(playerName, location,samurai,inventory, samurai.getDamage(), samurai.getHealth(),samurai.getMoney());

        System.out.println("Seçiminiz"+player.getCharType().getCharName());

        //player kurucudan karakterin sağlık hasar  parayı sil caselerin içinde belirt
    }

}
