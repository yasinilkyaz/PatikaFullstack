package Locations.SafeLocations.Items;

public class Armor {
    private int id;
    private String name;
    private int blockedDamage;
    private int cost;

    public Armor(int id, String name, int blockedDamage, int cost) {
        this.id = id;
        this.name = name;
        this.blockedDamage = blockedDamage;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
