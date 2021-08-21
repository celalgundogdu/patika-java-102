package hw1_AdventureGame;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private boolean food;
    private boolean firewood;
    private boolean water;

    public Inventory() {
        this.weapon = new Weapon(-1,"Yumruk", 0, 0);
        this.armor = new Armor(-1,"Paçavra",0,0);
        food = false;
        firewood = false;
        water = false;
    }

    public boolean isFullAwards(){
        return (isFood() && isFirewood() && isWater());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
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

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
