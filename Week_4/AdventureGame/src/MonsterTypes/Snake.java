package MonsterTypes;

import java.util.Random;

public class Snake extends BaseMonster {


    public Snake() {
        super("Yılan", 4, 0, 12, 0);
        setDamage(randomDamage());
        //damage 0 olarak tanımlanıp set metodu içerinden random int değeri alınır
    }

    private int randomDamage() {
        Random random = new Random();
        return random.nextInt(4) + 3;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
