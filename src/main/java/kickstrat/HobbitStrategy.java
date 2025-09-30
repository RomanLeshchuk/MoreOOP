package kickstrat;

import chars.Character;

public class HobbitStrategy implements KickStrategy {
    @Override
    public void kick(Character c, Character target) {
        System.out.println("cry :(");
    }
}
