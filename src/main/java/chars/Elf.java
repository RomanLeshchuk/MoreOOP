package chars;

import kickstrat.ElfStrategy;

public final class Elf extends Character {
    public Elf() {
        super(10, 10, new ElfStrategy());
    }

    @Override
    public void kick(Character target) {
        if (getPower() > target.getPower()) {
            target.setHp(0);
        } else {
            target.setPower(target.getPower() - 1);
        }
    }
}
