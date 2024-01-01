package _20_12_2023;

import com.github.javafaker.Faker;

import java.util.*;

public class Team<T extends Participant> {
    private static final Faker FAKER = new Faker();

    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }

    public static <T extends Participant> void play(Map<Team<T>, List<T>> d) {
        Map<Team<T>, Double> map = new HashMap<>();
        for (Team<T> team1 : d.keySet()) {
            for (Team<T> team2 : d.keySet()) {
                double result = getRandomValue();
                if (result == 1) {
                    map.put(team1, 1.0);
                    map.put(team2, 0.0);
                } else if (result == 0.5) {
                    map.put(team1, 0.5);
                    map.put(team2, 0.5);
                } else {
                    map.put(team1, 0.0);
                    map.put(team2, 1.0);
                }
            }
        }
        for (Map.Entry<Team<T>, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static double getRandomValue() {
        double[] values = {0.0, 0.5, 1.0};
        Random random = new Random();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

}
