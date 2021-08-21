package hw1_AdventureGame;

public class Weapon {

    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList = {new Weapon(1, "Tabanca", 2, 20),
                               new Weapon(2, "Kılıç", 3, 35),
                               new Weapon(3, "Tüfek", 7, 45)};
        return weaponList;
    }

    public static Weapon getWeaponById(int id){
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id){
                return weapon;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
