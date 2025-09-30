package chars;

import kickstrat.HobbitStrategy;

public final class Hobbit extends Character {
    public Hobbit() {
        super(0, 3, new HobbitStrategy());
    }

    @Override
    public void kick(Character target) {
        System.out.println("cry :(");
    }
}
