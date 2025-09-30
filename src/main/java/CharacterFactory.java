import java.util.ArrayList;
import java.util.Random;

import org.reflections.Reflections;

import chars.Character;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class CharacterFactory {
    private static final Random random = new Random();

    @SneakyThrows
    public Character createCharacter() {
        Reflections reflections = new Reflections("chars");
        ArrayList<Class<? extends Character>> charClasses = new ArrayList<>(reflections.getSubTypesOf(Character.class));
        charClasses.removeIf(c -> !Modifier.isFinal(c.getModifiers()));
        Class<? extends Character> randomChar = charClasses.get(random.nextInt(charClasses.size()));
        Constructor<? extends Character> constructor = randomChar.getConstructor();
        return constructor.newInstance();
    }
}
