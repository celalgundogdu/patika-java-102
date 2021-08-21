package hw1_AdventureGame;

import java.util.Random;

public abstract class BattleLocation extends Location{

    private Monster monster;
    private String award;
    private int maxNumberOfMonster;
    private Random rnd = new Random();

    public BattleLocation(Player player, String name, Monster monster, String award, int maxNumberOfMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxNumberOfMonster = maxNumberOfMonster;
    }

    @Override
    public boolean onLocation() {
        int numberOfMonster = specifyMonsterNumber();
        System.out.println(this.getName() + " bölgesindesiniz.");
        System.out.println("Burada " + numberOfMonster +" tane " + this.getMonster().getName() + " bulunuyor");
        String caseChoice;
        do {
            System.out.print("Savaş (S) veya Kaç (K): ");
            caseChoice = Location.input.nextLine();
        }while(!caseChoice.toUpperCase().equals("S") && !caseChoice.toUpperCase().equals("K"));

        if (caseChoice.toUpperCase().equals("S")){
            System.out.println("\nSavaş başlıyor..");
            if (combat(numberOfMonster)){
                System.out.println("\nTebrikler! Bölgeyi temizlediniz!");
                return true;
            }
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("\nCanınız kalmadı!");
            return false;
        }
        return true;
    }

    public boolean combat(int numberOfMonster){
        for (int i = 1; i <= numberOfMonster; i++){
            System.out.println("\n\t&&& " + i + ". " + this.getMonster().getName() + " ile Mücadele &&&");
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            printPlayerStats();
            printMonsterStats();
            String combatChoice;
            System.out.println();

            if (isPlayerFirstAttack()){
                while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                    if (isPlayerAttack()){
                        hitByPlayer();
                        System.out.println();
                        hitByMonster();
                    }
                }
            } else {
                while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                    hitByMonster();
                    if (this.getPlayer().getHealth() > 0) {
                        boolean isAttack;
                        do {
                            isAttack = isPlayerAttack();
                            if (isAttack) {
                                hitByPlayer();
                                break;
                            }
                        } while (!isAttack);
                    }
                    System.out.println();
                }
            }

            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println(i + ". " + this.getMonster().getName() + " yok edildi!");
                if (this.getMonster().getId() != 4) {
                    System.out.println(this.getMonster().getAward() + " para kazanıldı!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                } else {
                    specifyRandomAward();
                }
            }else {
                return false;
            }
        }

        switch (this.getAward().toLowerCase()) {
            case "water" -> this.getPlayer().getInventory().setWater(true);
            case "food" -> this.getPlayer().getInventory().setFood(true);
            case "firewood" -> this.getPlayer().getInventory().setFirewood(true);
        }
        if (!this.getName().equals("Maden")) {
            System.out.println(this.getAward().toUpperCase() + " ödülü alındı.");
        }
        return true;
    }

    public boolean isPlayerFirstAttack(){
        int randomNumber = this.rnd.nextInt(100);
        if (randomNumber < 50){
            return false;
        }
        return true;
    }

    public void hitByMonster(){
        if (this.getMonster().getHealth() > 0){
            System.out.println(this.getMonster().getName() + " vurdu!");
            int blockedDamage = this.getMonster().getDamage() -
                    this.getPlayer().getInventory().getArmor().getBlock();
            if (blockedDamage < 0) {
                blockedDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - blockedDamage);
            printAfterHit();
        }
    }

    public void hitByPlayer(){
        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
        printAfterHit();
    }

    public boolean isPlayerAttack(){
        do {
            System.out.print("\nVur (V) veya Kaç (K): ");
            String combatChoice = input.nextLine().toUpperCase();
            if (combatChoice.equals("V")) {
                return true;
            } else if(combatChoice.equals("K")){
                return false;
            } else {
                System.out.println("V veya K giriniz.");
            }
        }while(true);
    }

    public void specifyRandomAward(){
        this.rnd = new Random();
        int randomNumber = rnd.nextInt(100);
        if (randomNumber > 45 ) {
            System.out.println("Ödül düştü!");
            String awardType = findAwardType();
            int awardId;
            if (awardType.toLowerCase().equals("silah")){
                awardId = findAward(50,30,20);
                Weapon weapon = Weapon.weapons()[awardId-1];
                System.out.println(weapon.getName() + " düştü!");
                System.out.print("Almak için A'ya basınız: ");
                String awardChoice = input.nextLine();
                if (awardChoice.toUpperCase().equals("A")){
                    this.getPlayer().getInventory().setWeapon(weapon);
                    System.out.println(weapon.getName() + " alındı.");
                }
            }else if(awardType.toLowerCase().equals("zırh")){
                awardId = findAward(50,30,20);
                Armor armor = Armor.armors()[awardId-1];
                System.out.println(armor.getName() + " düştü!");
                System.out.print("Almak için A'ya basınız: ");
                String awardChoice = input.nextLine();
                if (awardChoice.toUpperCase().equals("A")){
                    this.getPlayer().getInventory().setArmor(armor);
                    System.out.println(armor.getName() + " alındı.");
                }
            }else {
                awardId = findAward(50,30,20);
                int money = 0;
                switch (awardId){
                    case 1:
                        money = 1;
                    case 2:
                        money = 5;
                    case 3:
                        money = 10;
                }
                this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                System.out.println(money + " para kazanıldı!");
            }
        } else {
            System.out.println("Ödül düşmedi.");
        }
    }

    public int findAward(int rate1, int rate2, int rate3){
        int randomNumber = rnd.nextInt(100);
        if (randomNumber > rate1){
            return 1;
        } else if (randomNumber > rate2){
            return 2;
        } else {
            return 3;
        }
    }

    public String findAwardType(){
        int randomNumber = rnd.nextInt(110);
        if (randomNumber < 30){
            return "Silah";
        }else if (randomNumber < 60){
            return "Zırh";
        }else{
            return "Para";
        }
    }

    public void printAfterHit(){
        System.out.printf("%-15s can : %-3d\n", this.getPlayer().getName(), this.getPlayer().getHealth());
        System.out.printf("%-15s can : %-3d\n", this.getMonster().getName(), this.getMonster().getHealth());
    }

    public void printPlayerStats(){
        System.out.printf("%-10s => Can: %-5d Hasar: %-5d Blok:%-5d\n", this.getPlayer().getName(),
                this.getPlayer().getHealth(), this.getPlayer().getTotalDamage(),
                this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void printMonsterStats(){
        System.out.printf("%-10s => Can: %-5d Hasar: %-5d Ödül: %-5d\n", this.getMonster().getName(),
                this.getMonster().getHealth(), this.getMonster().getDamage(), this.getMonster().getAward());
    }

    public int specifyMonsterNumber(){
        return this.rnd.nextInt(this.maxNumberOfMonster) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxNumberOfMonster() {
        return maxNumberOfMonster;
    }

    public void setMaxNumberOfMonster(int maxNumberOfMonster) {
        this.maxNumberOfMonster = maxNumberOfMonster;
    }
}
