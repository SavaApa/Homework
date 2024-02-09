package new_year;

import java.util.*;

public class Play extends Participant {

    public Play(String name, int age) {
        super(name, age);
    }

    public static <T extends Participant> Map<Team<T>, Double> play(Set<Team<T>> teams) {
        List<Map.Entry<Team<T>, Double>> results = new ArrayList<>();

        for (Team<T> team : teams) {
            results.add(new AbstractMap.SimpleEntry<>(team, 0.0));
        }

        List<Team<T>> teamsList = new ArrayList<>(teams);
        for (int i = 0; i < teamsList.size(); i++) {
            Team<T> team1 = teamsList.get(i);
            for (int j = i + 1; j < teamsList.size(); j++) {
                Team<T> team2 = teamsList.get(j);
                playMatch(team1, team2, results);
            }
        }
        for (Map.Entry<Team<T>, Double> entry : results) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }

        Map<Team<T>, Double> finalResults = new LinkedHashMap<>();
        for (Map.Entry<Team<T>, Double> entry : results) {
            finalResults.put(entry.getKey(), entry.getValue());
        }

        return finalResults;
    }

    private static <T extends Participant> void playMatch(Team<T> team1, Team<T> team2, List<Map.Entry<Team<T>, Double>> results) {
        double result = getRandomValue();

        int index1 = findTeamIndex(team1, results);
        int index2 = findTeamIndex(team2, results);

        double pointsTeam1 = results.get(index1).getValue();
        double pointsTeam2 = results.get(index2).getValue();

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

        results.get(index1).setValue(pointsTeam1);
        results.get(index2).setValue(pointsTeam2);
    }

    private static <T extends Participant> int findTeamIndex(Team<T> team, List<Map.Entry<Team<T>, Double>> results) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getKey().equals(team)) {
                return i;
            }
        }
        return -1;
    }

    private static double getRandomValue() {
        double[] values = {0.0, 0.5, 1.0};
        Random random = new Random();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }
}


