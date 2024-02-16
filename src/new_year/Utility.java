package new_year;

import new_year.exception.*;

import java.util.*;
import java.util.stream.Collectors;

public class Utility<T extends Participant> {

    //Найти команду с максимальными баллами:
    public static Team<?> maxResult(Map<Team<?>, Double> teamDoubleMap) throws NoTeamWithMaxResultException {
        if (teamDoubleMap == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return teamDoubleMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoTeamWithMaxResultException(ErrorMessage.NO_TEAM_MAX_RESULT));

    }

    //    Подсчет общего количества баллов:
    public static <T extends Participant> double point(Map<Team<T>, Double> teamPoint) {
        if (teamPoint == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        for (Team<T> team : teamPoint.keySet()) {
            if (!(team.getParticipant() instanceof Participant)) {
                throw new ClassCastException(ErrorMessage.TEAM_MUST_BE_COMPATIBLE_WITH_PARTICIPANT);
            }
        }
        return teamPoint.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    //    Средний возраст участников в каждой команде:
    public static <T extends Participant> double averageAge(Map<Team<T>, Double> ageParticipant) throws ImpossibleToCalculateTheAverageAge {
        if (ageParticipant == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return ageParticipant.keySet().stream()
                .flatMap(el -> el.getParticipant().stream())
                .mapToDouble(Participant::getAge)
                .average()
                .orElseThrow(() -> new ImpossibleToCalculateTheAverageAge(ErrorMessage.IMPOSSIBLE_TO_CALCULATE_THE_AVERAGE_AGE));
    }

    //Сортировка команд по баллам:
    public static <T extends Participant> Map<Team<T>, Double> sortPoint(Map<Team<T>, Double> map) {
        if (map == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    //Команды с определенной категорией участников: Вывести команды,
// где все участники принадлежат к одной категории (например, только Adult).
    public static <T extends Participant> Set<Team<T>> team(Set<Team<T>> teams) {
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return teams.stream()
                .filter(team -> {
                    for (Participant participant : team.getParticipant()) {
                        if (!(participant instanceof Adult)) {
                            throw new ClassCastException(ErrorMessage.THERE_IS_NO_SUCH_CATEGORY);
                        }
                    }
                    return true;
                })
                .collect(Collectors.toSet());
    }

    //    Самый молодой участник среди всех команд:
    public static Optional<?> young(Set<Team<?>> teams) throws NoElement {
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return Optional.of(teams.stream()
                .flatMap(el -> el.getParticipant().stream())
                .min(Comparator.comparingInt(Participant::getAge))
                .orElseThrow(() -> new NoElement(ErrorMessage.NO_ELEMENT)));
    }

    //    Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.
    public static Team<?> experienced(Set<Team<?>> teams) {
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return teams.stream()
                .max(Comparator.comparingInt(el -> el.getParticipant().stream()
                        .mapToInt(Participant::getAge).sum()))
                .orElseThrow(() -> new NoSuchElementException(ErrorMessage.NO_ELEMENT));
    }

    //    Команды с участниками в определенном возрастном диапазоне:
    public static Set<Team<?>> ageRange(Set<Team<?>> teams) {
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return teams.stream()
                .filter(team -> {
                    List<Participant> list = team.getParticipant();
                    if (list == null) {
                        throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
                    }
                    return list.stream().allMatch(participant -> participant.getAge() > 14);

                })
                .collect(Collectors.toSet());
    }

    //    Имена участников по убыванию возраста:
    public static Set<String> decreasingAge(Set<Team<?>> teams) throws UnableToPrintNameInClass {
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }

        return teams.stream()
                .flatMap(el -> el.getParticipant().stream())
                .sorted(Comparator.comparingInt(Participant::getAge).reversed())
                .map(participant -> {
                    String name = participant.getName();
                    if (name == null) {
                        throw new UnableToPrintNameInClass(ErrorMessage.UNABLE_TO_PRINT_NAME_IN_CLASS);
                    }
                    return name;
                })
                .collect(Collectors.toSet());
    }
//    Найти команду с наибольшим разбросом возрастов участников.

    public static Team<?> maxAgeSpread(Set<Team<?>> teams) throws CantFindSuchCommand {
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return teams.stream()
                .max(Comparator.comparingDouble(team -> calculateAge(team.getParticipant())))
                .orElseThrow(() -> new CantFindSuchCommand(ErrorMessage.CANNOT_FIND_SUCH_COMMAND));
    }

    public static double calculateAge(List<Participant> participants) throws CannotCalculate {
        if (participants == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        List<Integer> ages = participants.stream()
                .map(Participant::getAge)
                .toList();

        if(ages.isEmpty()){
            throw new CannotCalculate(ErrorMessage.CANNOT_CALCULATE);
        }

        int minAge = Collections.min(ages);
        int maxAge = Collections.max(ages);

        return maxAge - minAge;
    }


    //Найти команды, в которых все участники имеют уникальные имена.
    public static Set<Team<?>> findTeamsWithUniqueNames(Set<Team<?>> teams){
        if (teams == null) {
            throw new NullPointerException(ErrorMessage.PARAM_MUST_NOT_BE_NULL);
        }
        return teams.stream()
                .filter(team -> {
                    Set<String> uniqueNames = team.getParticipant().stream()
                            .map(participant -> {
                                String name = participant.getName();
                                if (name == null) {
                                    throw new IllegalArgumentException(ErrorMessage.PARTICIPANT_IN_TEAM_HAS_NULL_NAME);
                                }
                                return name;
                            })
                            .collect(Collectors.toSet());

                    return uniqueNames.size() == team.getParticipant().size();
                })
                .collect(Collectors.toSet());
    }
}
