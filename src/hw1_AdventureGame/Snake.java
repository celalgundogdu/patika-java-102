package hw1_AdventureGame;

import java.util.Random;

public class Snake extends Monster{

    public Snake() {
        super(4, "Yılan",12 );
        Random rnd = new Random();
        this.setDamage(rnd.nextInt(4) + 3);
    }

}
