package NEW_YEAR;

import com.github.javafaker.Faker;

import java.util.*;


public class Generator extends Participant {
    static final Faker FAKER = new Faker();

    public Generator(String name, int age) {
        super(name, age);
    }

    public static <T> List<T> genParti(Class<T> t) {
        List<T> list = new ArrayList<>();
        int number = 4;
        if (t.getName().contains("Adult")) {
            while (number != 0) {
                list.add((T) new Adult(FAKER.name().name(), (int) (Math.random() * 4) + 18));
                number--;
            }
        } else if (t.getName().contains("Teenager")) {
            while (number != 0) {
                list.add((T) new Teenager(FAKER.name().name(), (int) (Math.random() * 8) + 10));
                number--;
            }
        } else if (t.getName().contains("Pupil")) {
            while (number != 0) {
                list.add((T) new Pupil(FAKER.name().name(), (int) (Math.random() * 4) + 6));
                number--;
            }
        }
        return list;
    }

    public static <T extends Participant> Set<Team<T>> generator(Class<T> t) {
        Set<Team<T>> set = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            set.add(new Team<>(FAKER.team().name(), genParti(t)));
        }
        return set;
    }
}
