package hw1_AdventureGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private Inventory inventory;
    private String name;
    private String characterName;
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
       GameCharacter[] gameCharacterList = {new Samurai(), new Archer(), new Knight()};
       for (GameCharacter gameCharacter : gameCharacterList){
           System.out.printf("ID: %-3d Karakter: %-10s Hasar: %-5d Can: %-5d Bütçe: %-5d \n", gameCharacter.getId(),
                   gameCharacter.getName(), gameCharacter.getDamage(), gameCharacter.getHealth(), gameCharacter.getMoney());
       }

       boolean isChoiceValid  = false;
       do {
           int characterChoice = 0;
           try {
               System.out.print("Bir karakter id giriniz: ");
               characterChoice = input.nextInt();
               switch (characterChoice){
                   case 1:
                       initPlayer(new Samurai());
                       isChoiceValid = true;
                       break;
                   case 2:
                       initPlayer(new Archer());
                       isChoiceValid = true;
                       break;
                   case 3:
                       initPlayer(new Knight());
                       isChoiceValid = true;
                       break;
                   default:
                       System.out.println("Geçerli bir karakter seçiniz!");
                       break;
               }
           } catch(InputMismatchException | NullPointerException e){
               System.out.println("Bir rakam giriniz");
           }
           input.nextLine();
       } while(!isChoiceValid);

    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setCharacterName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }

    public void printPlayer(){
        System.out.printf("\nKarakter: %-10s Silah: %-10s Zırh: %-10s Hasar: %-5d Blok: %-5d Can: %-5d Bütçe: %-5d \n\n",
                this.getCharacterName(), this.getInventory().getWeapon().getName(),
                this.getInventory().getArmor().getName(), this.getTotalDamage(), this.getInventory().getArmor().getBlock(),
                this.getHealth(), this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
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
        if (health < 0){
            this.health = 0;
            return;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
