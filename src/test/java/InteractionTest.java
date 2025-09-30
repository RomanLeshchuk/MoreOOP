import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import chars.Character;
import chars.Hobbit;
import chars.Elf;
import chars.King;
import chars.Knight;

class InteractionTest {
    @Test
    void testHobbitCannotHurt() {
        Character hobbit = new Hobbit();
        Character elf = new Elf();

        int initialHp = elf.getHp();
        hobbit.kick(elf);

        assertEquals(initialHp, elf.getHp());
    }

    @Test
    void testElfKillsWeaker() {
        Character elf = new Elf();
        Character hobbit = new Hobbit();

        elf.kick(hobbit);

        assertFalse(hobbit.isAlive());
    }

    @Test
    void testKingKickDecreasesHp() {
        Character king = new King();
        Character target = new Hobbit();

        int hpBefore = target.getHp();
        king.kick(target);

        assertTrue(target.getHp() <= hpBefore && target.getHp() >= 0);
    }

    @Test
    void testKnightKickDecreasesHp() {
        Character knight = new Knight();
        Character target = new Elf();

        int hpBefore = target.getHp();
        knight.kick(target);

        assertTrue(target.getHp() <= hpBefore && target.getHp() >= 0);
    }

    @Test
    void testCharacterFactoryCreatesAllTypes() {
        CharacterFactory factory = new CharacterFactory();
        boolean hobbitFound = false, elfFound = false, kingFound = false, knightFound = false;

        for (int i = 0; i < 10000; ++i) {
            Character c = factory.createCharacter();
            if (c instanceof Hobbit) {
                hobbitFound = true;
            }
            if (c instanceof Elf) {
                elfFound = true;
            }
            if (c instanceof King) {
                kingFound = true;
            }
            if (c instanceof Knight) {
                knightFound = true;
            }
        }

        assertTrue(hobbitFound);
        assertTrue(elfFound);
        assertTrue(kingFound);
        assertTrue(knightFound);
    }

    @Test
    void testSetHpCannotGoBelowZero() {
        Character king = new King();
        king.setHp(-10);

        assertEquals(0, king.getHp());
        assertFalse(king.isAlive());
    }

    @Test
    void testFightUntilDead() {
        Character c1 = new Elf();
        Character c2 = new Hobbit();
        GameManager game = new GameManager();

        game.fight(c1, c2);

        assertTrue(!c1.isAlive() || !c2.isAlive());
    }
}
