package _20_12_2023;

import java.util.*;

public class Play extends Participant {

    public Play(String name, int age) {
        super(name, age);
    }

    public static <T extends Participant> void play(Set<Team<T>> teams) {
        Map<Team<T>, Double> results = new HashMap<>();

        for (Team<T> team : teams) {
            results.put(team, 0.0);
        }

        List<Team<T>> teamsList = new ArrayList<>(teams);
        for (int i = 0; i < teamsList.size(); i++) {
            Team<T> team1 = teamsList.get(i);
            for (int j = i + 1; j < teamsList.size(); j++) {
                Team<T> team2 = teamsList.get(j);
                playMatch(team1, team2, results);
            }
        }

        List<Map.Entry<Team<T>, Double>> sortedResults = new ArrayList<>(results.entrySet());
        sortedResults.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Final Standings:");
        for (Map.Entry<Team<T>, Double> entry : sortedResults) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static <T extends Participant> void playMatch(Team<T> team1, Team<T> team2, Map<Team<T>, Double> results) {
        double result = getRandomValue();
        double pointsTeam1 = results.getOrDefault(team1, 0.0);
        double pointsTeam2 = results.getOrDefault(team2, 0.0);

        if (result == 1) {
            pointsTeam1 += 1.0;
            pointsTeam2 += 0.0;
        } else if (result == 0.5) {
            pointsTeam1 += 0.5;
            pointsTeam2 += 0.5;
        } else {
            pointsTeam1 += 0.0;
            pointsTeam2 += 1.0;
        }

        results.put(team1, pointsTeam1);
        results.put(team2, pointsTeam2);
    }

    private static double getRandomValue() {
        double[] values = {0.0, 0.5, 1.0};
        Random random = new Random();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }
}

