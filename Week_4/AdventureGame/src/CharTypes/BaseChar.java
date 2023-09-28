package CharTypes;

public abstract class BaseChar {

    String charName;
    int charId;
    int damage;
    int health;
    int money;
    //Ata sınıf
    public BaseChar(String charName, int charId, int damage, int health, int money) {
        this.charName = charName;
        this.charId = charId;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
