package Locations.BattleLocations;

import Locations.BaseLocation;
import MonsterTypes.BaseMonster;
import Player.Player;

import java.util.Random;

public abstract class BattleLocation extends BaseLocation {

    private BaseMonster monster;
    private int maxMonster;
    private String award;

    public BattleLocation(Player player, BaseMonster monster, int maxMonster, String award) {
        super(player);
        this.monster = monster;
        this.maxMonster = maxMonster;
        this.award = award;
    }


    @Override
    public boolean onLocation(Player player) {
        int monsterNumber = randomMonsterNumber();
        System.out.println("Burada " + monsterNumber + " tane " + monster.getMonsterName() + " var.");
        System.out.println("<G>ir veya <U>zaklaş");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("G")) {

            return combat(monsterNumber);

        } else return true;


    }

    public boolean combat(int monsterNumber) {

        if (firstHitChance(2) > 0) {
            System.out.println("ilk vuruşu " + getMonster().getMonsterName() + " yaptı.");
            this.getPlayer().setHealthy(getPlayer().getHealthy() - getMonster().getDamage() + getPlayer().getInventory().getArmorDefence());
        }

        for (int i = 1; i <= monsterNumber; i++) {
            int monsterFirstHealth = getMonster().getHealth();
            System.out.println("Sağlığınız :" + getPlayer().getHealthy() + "\t " + i + ". " + getMonster().getMonsterName() + "Sağlığı :" + getMonster().getHealth());


            while (this.getPlayer().getHealthy() > 0 && getMonster().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String battleSelect = input.nextLine();
                battleSelect = battleSelect.toUpperCase();

                if (battleSelect.equals("K")) {
                    return true;

                }
                if (battleSelect.equals("V")) {

                    int monsterHealth = this.getMonster().getHealth();
                    int playerHealth = this.getPlayer().getHealthy();
                    int monsterDamage = getMonster().getDamage();
                    int playerDamage = getPlayer().getTotalDamage();
                    this.getMonster().setHealth(monsterHealth - playerDamage);
                    this.getPlayer().setHealthy(playerHealth - monsterDamage + getPlayer().getInventory().getArmorDefence());
                    if (getMonster().getHealth() < 0) {
                        getMonster().setHealth(0);
                    }
                    System.out.println("Sağlığınız :" + getPlayer().getHealthy() + "\t " + i + ". " +
                            getMonster().getMonsterName() + "Sağlığı :" + getMonster().getHealth());

                    if (this.getMonster().getHealth() <= 0) {
                        System.out.println(getMonster().getMonsterName() + " öldü");

                        if (getMonster().getMoney() > 0) {
                            getPlayer().setMoney(getPlayer().getMoney() + getMonster().getMoney());
                            System.out.println(getMonster().getMonsterName() + " para alındı. Paranız :" + getPlayer().getMoney());
                        }


                    }
                    if (this.getPlayer().getHealthy() <= 0) {
                        System.out.println(getPlayer().getPlayerName() + " Öldü.");
                        return false;
                    }
                }
            }
            getMonster().setHealth(monsterFirstHealth);
            if (i == monsterNumber) {
                System.out.println("Burayı tamamladınız. Ödülünüz : " + this.award);
                sectorClear(i);
                return true;
            }
        }

        return true;
    }

    public abstract void sectorClear(int loop);

    public int randomMonsterNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxMonster()) + 1;
    }

    public int firstHitChance(int ratio) {
        Random random = new Random();
        return random.nextInt(ratio);
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public BaseMonster getMonster() {
        return monster;
    }



}
