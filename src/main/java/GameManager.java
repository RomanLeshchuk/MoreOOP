import chars.Character;
import chars.Hobbit;
import chars.Elf;

public class GameManager {
    void fight(Character c1, Character c2) { 
        System.out.println("Characters stats:");
        System.out.println("1. " + c1 + ", hp: " + c1.getHp() + ", power: " + c1.getPower());
        System.out.println("2. " + c2 + ", hp: " + c2.getHp() + ", power: " + c2.getPower());

        if (c1 instanceof Hobbit && c2 instanceof Hobbit) {
            System.out.println("Two hobbits will fight forever!");
            return;
        }

        if (c1 instanceof Elf && c2 instanceof Elf && c1.getPower() == c2.getPower()) {
            System.out.println("Two elfs with same power will fight forever!");
            return;
        }
        
        while (true) {
            c1.kick(c2);
            System.out.println("First character kicks second. Second char stats now:");
            System.out.println("hp: " + c2.getHp() + ", power: " + c2.getPower());
            if (!c2.isAlive()) {
                System.out.println("And second character dies");
                break;
            }

            c2.kick(c1);
            System.out.println("Second character kicks first. First char stats now:");
            System.out.println("hp: " + c1.getHp() + ", power: " + c1.getPower());
            if (!c1.isAlive()) {
                System.out.println("And first character dies");
                break;
            }
        }
    }
}
