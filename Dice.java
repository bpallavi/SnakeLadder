package MyStuff.SnakeLadderPackage;

import java.util.Random;

public class Dice {
    
    public int rolldice() {
        Random r = new Random();
        int value = r.nextInt(6) + 1;

        return value;
    }
}
