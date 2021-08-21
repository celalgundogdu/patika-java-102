package hw1_AdventureGame;

import java.util.InputMismatchException;

public class ToolStore extends NormalLocation{

    public ToolStore(Player player) {
        super(player,"Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("***Mağazaya hoşgeldiniz***");
        int choice = 0;
        do {
            System.out.println("1 - Silahlar\n2 - Zırhlar\n3 - Çıkış");
            try {
                System.out.print("Envanter Seçim: ");
                choice = Location.input.nextInt();
                switch (choice){
                    case 1:
                        printWeapon();
                        System.out.println("Çıkış için 0 giriniz");
                        buyWeapon();
                        break;
                    case 2:
                        printArmor();
                        System.out.println("Çıkış için 0 giriniz");
                        buyArmor();
                        break;
                    case 3:
                        System.out.println("Çıkış yapıldı.");
                        break;
                    default:
                        System.out.println("Geçersiz envanter id!");
                }
            } catch(InputMismatchException e){
                System.out.println("1, 2 veya 3 seçiniz!");
            }
            System.out.println();
            Location.input.nextLine();
        } while(choice != 3);

        return true;
    }

    private void printArmor() {
        System.out.println("===Zırhlar===");
        for (Armor armor : Armor.armors()){
            System.out.printf("%-2d - %-10s Maliyet: %-3d Blok: %-3d\n",
                    armor.getId(), armor.getName(), armor.getPrice(), armor.getBlock());
        }
    }

    private void printWeapon() {
        System.out.println("===Silahlar===");
        for (Weapon weapon : Weapon.weapons()){
            System.out.printf("%-2d - %-10s Maliyet: %-3d Hasar: %-3d\n",
                    weapon.getId(), weapon.getName(), weapon.getPrice(), weapon.getDamage());
        }
    }

    public void buyArmor(){
        int armorChoice = 0;
        do {
            try {
                System.out.print("Zırh seçiniz: ");
                armorChoice = Location.input.nextInt();
                if (armorChoice >= 1 && armorChoice <= Armor.armors().length ){
                    break;
                }
                if (armorChoice == 0){
                    return;
                }
                System.out.println("Geçersiz zırh id!");
            } catch(InputMismatchException e){
                System.out.println("Bir rakam giriniz!");
            }
            Location.input.nextLine();
        } while(true);

        Armor selectedArmor = Armor.getArmorById(armorChoice);
        if (this.getPlayer().getMoney() >= selectedArmor.getPrice()){
            System.out.println(selectedArmor.getName() + " satın alındı");
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println("Kalan para: " + this.getPlayer().getMoney());
        } else {
            System.out.println("Yeterli paranız bulunmamaktadır.");
        }
    }

    public void buyWeapon(){
        int weaponChoice = 0;
        do {
            try {
                System.out.print("Silah seçiniz: ");
                weaponChoice = Location.input.nextInt();
                if (weaponChoice >= 1 && weaponChoice <= Weapon.weapons().length){
                    break;
                }
                if (weaponChoice == 0){
                    return;
                }
                System.out.println("Geçersiz silah id!");
            } catch(InputMismatchException e){
                System.out.println("Bir rakam giriniz!");
            }
            Location.input.nextLine();
        } while(true);

        Weapon selectedWeapon = Weapon.getWeaponById(weaponChoice);
        if (this.getPlayer().getMoney() >= selectedWeapon.getPrice() ){
            System.out.println(selectedWeapon.getName() + " satın alındı!");
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("Kalan para: " + this.getPlayer().getMoney());
        }else {
            System.out.println("Yeterli paranız bulunmamaktadır.");
        }
    }

}
