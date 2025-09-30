package chars;
import java.util.Random;

import kickstrat.NobleStrategy;

public class Noble extends Character {
    private static final Random random = new Random();

    public Noble(int minPower, int maxPower, int minHp, int maxHp) {
        super(random.nextInt(maxPower - minPower + 1) + minPower, random.nextInt(maxHp - minHp + 1) + minHp, new NobleStrategy());
    }

    @Override
    public void kick(Character target) {
        target.setHp(Math.max(target.getHp() - random.nextInt(getPower() - 1) + 1, 0));
    }
}
