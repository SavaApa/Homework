package NEW_YEAR;

import java.util.*;
import java.util.stream.Collectors;

public class Utility<T extends Participant> {

    //Найти команду с максимальными баллами:
    public static Team<?> maxResult(Map<Team<?>, Double> teamDoubleMap) {
        return teamDoubleMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    //    Подсчет общего количества баллов:
    public static <T extends Participant> double point(Map<Team<T>, Double> teamPoint) {
        return teamPoint.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    //    Средний возраст участников в каждой команде:
    public static <T extends Participant> double averageAge(Map<Team<T>, Double> ageParticipant) {
        return ageParticipant.keySet().stream()
                .flatMap(el -> el.getParticipant().stream())
                .mapToDouble(Participant::getAge)
                .average()
                .orElse(0.0);
    }

    //Сортировка команд по баллам:
    public static <T extends Participant> Map<Team<T>, Double> sortPoint(Map<Team<T>, Double> map) {
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    //Команды с определенной категорией участников: Вывести команды,
// где все участники принадлежат к одной категории (например, только Adult).
    public static <T extends Participant> Set<Team<T>> team(Set<Team<T>> teams) {
        return teams.stream()
                .filter(team -> team.getParticipant().stream().allMatch(participant -> participant instanceof Adult))
                .collect(Collectors.toSet());
    }

    //    Самый молодой участник среди всех команд:
    public static Optional<?> young(Set<Team<?>> teams) {
        return Optional.of(teams.stream()
                .flatMap(el -> el.getParticipant().stream())
                .min(Comparator.comparingInt(Participant::getAge))
                .orElseThrow());
    }

    //    Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.
    public static Team<?> experienced(Set<Team<?>> teams) {
        return teams.stream()
                .max(Comparator.comparingInt(el -> el.getParticipant().stream()
                        .mapToInt(Participant::getAge).sum()))
                .orElseThrow();
    }

    //    Команды с участниками в определенном возрастном диапазоне:
    public static Set<Team<?>> ageRange(Set<Team<?>> teams) {
        return teams.stream()
                .filter(el -> el.getParticipant().stream()
                        .anyMatch(ele -> ele.getAge() > 14))
                .collect(Collectors.toSet());
    }

    //    Имена участников по убыванию возраста:
    public static Set<String> decreasingAge(Set<Team<?>> teams) {
        return teams.stream()
                .flatMap(el -> el.getParticipant().stream())
                .sorted(Comparator.comparingInt(Participant::getAge).reversed())
                .map(Participant::getName)
                .collect(Collectors.toSet());
    }

    public static Team<?> maxAgeSpread(Set<Team<?>> teams) {
        return teams.stream()
                .max(Comparator.comparingDouble(team -> calculateAge(team.getParticipant())))
                .orElse(null);
    }

    public static double calculateAge(List<Participant> participants) {
        List<Integer> ages = participants.stream()
                .map(Participant::getAge)
                .toList();

        int minAge = Collections.min(ages);
        int maxAge = Collections.max(ages);

        return maxAge - minAge;
    }

    public static Set<Team<?>> findTeamsWithUniqueNames(Set<Team<?>> teams) {
        return teams.stream()
                .filter(team -> team.getParticipant().stream()
                        .map(Participant::getName)
                        .distinct()
                        .count() == team.getParticipant().size())
                .collect(Collectors.toSet());
    }
}
