package hw1_AdventureGame;

public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Food", 3);
    }
}
