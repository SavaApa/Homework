package _20_12_2023;

import java.util.Map;
import java.util.Set;

import static _20_12_2023.Generator.generator;


public class Handler {
    public static void main(String[] args) {
          Set<Team<Adult>> teamAdult = Generator.generator(Adult.class);
          System.out.println("----------------------------------------------------------------");
//          Set<Team<Teenager>> teamTeenager = Generator.generator(Teenager.class);
//          System.out.println("----------------------------------------------------------------");
//          Set<Team<Pupil>> teamPupil = Generator.generator(Pupil.class);
//          System.out.println("----------------------------------------------------------------");
          Map<Team<Adult>, Double> team1 = Play.play(teamAdult);
          System.out.println("----------------------------------------------------------------");
//          Map<Team<Teenager>, Double> team2 = Play.play(teamTeenager);
//          System.out.println("----------------------------------------------------------------");
//          Map<Team<Pupil>, Double> team3 = Play.play(teamPupil);
//          System.out.println("-----------------------------------------------------------------");
          Map<Team<Adult>, Double> semiFinalAdult = Play.semiFinal(team1);
//          System.out.println("-----------------------------------------------------------------");
//          Play.semiFinal(team2);
//          System.out.println("-----------------------------------------------------------------");
//          Play.semiFinal(team3);
        System.out.println("------------------------------------------------------------------------");
        Play.finalPlay(semiFinalAdult);



    }
}

