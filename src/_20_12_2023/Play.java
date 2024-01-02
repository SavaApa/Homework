package _20_12_2023;

import java.util.*;

public class Play extends Participant{

    public Play(String name, int age) {
        super(name, age);
    }

    public static <T extends Participant>  Map<Team<T>, Double> play(Set<Team<T>> teams) {
        Map<Team<T>, Double> map = new HashMap<>();
        for (Team<T> team : teams){
            map.put(team, 0.0);
        }
        for (Team<T> team1 : map.keySet()) {
            for (Team<T> team2 : map.keySet()) {
                double result = getRandomValue();
                if (team1 != team2) {
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
        }
        for (Map.Entry<Team<T>, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return map;
    }
    private static double getRandomValue() {
        double[] values = {0.0, 0.5, 1.0};
        Random random = new Random();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }
}
