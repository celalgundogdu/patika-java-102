package hw1_AdventureGame;

public class SafeHouse extends NormalLocation{


    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        if (this.getPlayer().getInventory().isFullAwards()){
            System.out.println("Tebrikler! Tüm ödülleri topladınız ve oyunu tamamladınız.");
            return false;
        }
        return true;
    }
}
