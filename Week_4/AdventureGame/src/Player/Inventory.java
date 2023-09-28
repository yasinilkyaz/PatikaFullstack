package Player;

public class Inventory {

    private boolean water = false;
    private boolean food = false;
    private boolean firewood = false;
    private String weaponName = "";
    private int weaponDamage = 0;
    private String armorName = "";
    private int armorDefence = 0;

    public Inventory() {
    }

    public Inventory(boolean water, boolean food, boolean firewood, String weaponName, int weaponDamage, String armorName, int armorDefence) {
        this.water = water;
        this.food = food;
        this.firewood = firewood;
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.armorName = armorName;
        this.armorDefence = armorDefence;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }
}
