package MonsterTypes;

public abstract class BaseMonster {

    String monsterName;
    int monsterId;
    int damage;
    int health;
    int money;

    //Ata sınıf
    public BaseMonster(String monsterName, int monsterId, int damage, int health, int money) {
        this.monsterName = monsterName;
        this.monsterId = monsterId;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
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
