package Player;

import CharTypes.Archer;
import CharTypes.BaseChar;
import CharTypes.Knight;
import CharTypes.Samurai;
import Locations.BaseLocation;
import Locations.SafeLocations.SafeHouse;

import java.util.Scanner;

public class Player {

    private String playerName;
    private BaseChar charType;
    private Inventory inventory;
    private int damage;
    private int healthy;
    private int money;

    Scanner input=new Scanner(System.in);

    public Player(String playerName, Inventory inventory) {
        this.playerName = playerName;

        this.inventory = inventory;

    }
    public void setCharStatus(BaseChar charType){
        this.charType=charType;
        this.damage=charType.getDamage();
        this.healthy=charType.getHealth();
        this.money=charType.getMoney();
    }
    public void chooseCharType(Player player){

        Samurai samurai=new Samurai();
        Archer archer=new Archer();
        Knight knight=new Knight();


        BaseChar[] charTypes={samurai,archer,knight};

        for (BaseChar charType:charTypes) {
            System.out.println(charType.getCharId()+"-"+charType.getCharName()+"\t"+
                    "Hasar :"+charType.getDamage()+"\t"+
                    "Sağlık :"+charType.getHealth()+"\t"+
                    "Para :"+charType.getMoney());

        }
        System.out.println("Karakterinizi seçiniz :");
        int selectedCharacter=input.nextInt();
        if(selectedCharacter==1){
            player.setCharStatus(samurai);

        } else if (selectedCharacter==2) {
            player.setCharStatus(archer);

        } else if (selectedCharacter==3) {
            player.setCharStatus(knight);

        }else {
            System.out.println("Hatalı giriş yaptınız. Samuray olarak devam ediyorsunuz.");
            player.setCharStatus(samurai);
        }


        System.out.println("Oyuna başlayabilirsin "+player.getCharType().getCharName()+" "+playerName);

    }
    public int getTotalDamage(){
        return this.damage+ inventory.getWeaponDamage();
    }
    public int blockDamage(){
        return inventory.getArmorDefence();
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public BaseChar getCharType() {
        return charType;
    }

    public void setCharType(BaseChar charType) {
        this.charType = charType;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
