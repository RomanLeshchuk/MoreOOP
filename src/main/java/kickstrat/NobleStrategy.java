package kickstrat;

import java.util.Random;

import chars.Character;

public class NobleStrategy implements KickStrategy {
    private static final Random random = new Random();

    @Override
    public void kick(Character c, Character target) {
        target.setHp(target.getHp() - (random.nextInt(c.getPower()) + 1));
    }
}
