package new_year;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static new_year.Utility.*;


public class Handler {
    public static void main(String[] args) {
        Set<Team<Adult>> teamAdult = Generator.generator(Adult.class);
        Set<Team<Teenager>> teamTeenager = Generator.generator(Teenager.class);
        Set<Team<Pupil>> teamPupil = Generator.generator(Pupil.class);
        System.out.println("Play Adult");
        Map<Team<Adult>, Double> resultAdult = Play.play(teamAdult);
        System.out.println("Play Pupil");
        Map<Team<Pupil>, Double> resultPupil = Play.play(teamPupil);
        System.out.println("Play Teenager");
        Map<Team<Teenager>, Double> resultTeenager = Play.play(teamTeenager);


        Map<Team<?>, Double> teamDoubleMap = new HashMap<>();
        teamDoubleMap.putAll(resultAdult);
        teamDoubleMap.putAll(resultPupil);
        teamDoubleMap.putAll(resultTeenager);
        System.out.println("Kоманда с максимальными баллами");
        System.out.println(maxResult(teamDoubleMap));

        System.out.println("Подсчет общего количества баллов в команде Adult");
        System.out.println(point(resultAdult));
        System.out.println("Подсчет общего количества баллов в команде Teenager");
        System.out.println(point(resultTeenager));
        System.out.println("Подсчет общего количества баллов в команде Pupil");
        System.out.println(point(resultPupil));

        System.out.println("Средний возраст Adult");
        System.out.println(averageAge(resultAdult));
        System.out.println("Средний возраст Teenager");
        System.out.println(averageAge(resultTeenager));
        System.out.println("Средний возраст Pupil");
        System.out.println(averageAge(resultPupil));

        System.out.println("Сортировка Adult по баллам");
        Map<Team<Adult>, Double> sortedAdult = sortPoint(resultAdult);
        sortedAdult.forEach((team, points) -> System.out.println(team + ": " + points));
        System.out.println("Сортировка Teenager по баллам");
        Map<Team<Teenager>, Double> sortedTeenager = sortPoint(resultTeenager);
        sortedTeenager.forEach((team, points) -> System.out.println(team + ": " + points));
        System.out.println("Сортировка Pupil по баллам");
        Map<Team<Pupil>, Double> sortedPupil = sortPoint(resultPupil);
        sortedPupil.forEach((team, points) -> System.out.println(team + ": " + points));

        System.out.println("где все участники принадлежат к одной категории (например, только Adult)");
        System.out.println(team(teamAdult));

        Set<Team<?>> combined = new HashSet<>();
        combined.addAll(teamAdult);
        combined.addAll(teamTeenager);
        combined.addAll(teamPupil);

        System.out.println(" Самый молодой участник среди всех команд");
        System.out.println(young(combined));

        System.out.println("Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников");
        System.out.println(experienced(combined));

        System.out.println("Команды с участниками в определенном возрастном диапазоне");
        for (Team<?> team : ageRange(combined)) {
            team.getParticipant().forEach(member -> System.out.println(" - " + member.getName() + ", возраст: " + member.getAge()));
        }

        System.out.println("Имена участников по убыванию возраста");
        System.out.println(decreasingAge(combined));

        System.out.println("Команда с наибольшим разбросом возрастов:");
        System.out.println(maxAgeSpread(combined));

        System.out.println("Найти команды, в которых все участники имеют уникальные имена");
        System.out.println(findTeamsWithUniqueNames(combined));

    }
}

