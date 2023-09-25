package Player;

import CharTypes.BaseChar;
import Locations.BaseLocation;

public class Player {

    private String playerName;
    private BaseLocation location;
    private BaseChar charType;
    private Inventory inventory;
    private int damage;
    private int healthy;
    private int money;

    public Player(String playerName, BaseLocation location, BaseChar charType, Inventory inventory, int damage, int healthy, int money) {
        this.playerName = playerName;
        this.location = location;
        this.charType = charType;
        this.inventory = inventory;
        this.damage = damage;
        this.healthy = healthy;
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public BaseLocation getLocation() {
        return location;
    }

    public void setLocation(BaseLocation location) {
        this.location = location;
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
