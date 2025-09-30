package kickstrat;

import chars.Character;

public class ElfStrategy implements KickStrategy {
    @Override
    public void kick(Character c, Character target) {
        if (c.getPower() > target.getPower()) {
            target.setHp(0);
        } else {
            target.setPower(target.getPower() - 1);
        }
    }
}
