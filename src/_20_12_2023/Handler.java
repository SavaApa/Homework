package _20_12_2023;

import java.util.Map;
import java.util.Set;

import static _20_12_2023.Generator.generator;


public class Handler {
    public static void main(String[] args) {
        Generator.generator(Adult.class);
        System.out.println("----------------------------------------------------------------");
        Generator.generator(Teenager.class);
        System.out.println("----------------------------------------------------------------");
        Generator.generator(Pupil.class);
        System.out.println("----------------------------------------------------------------");
        Set<Team<Adult>> teamAdult = generator(Adult.class);
        Play.play(teamAdult);
        System.out.println("----------------------------------------------------------------");
        Set<Team<Teenager>> teamTeenager = generator(Teenager.class);
        Play.play(teamTeenager);
        System.out.println("----------------------------------------------------------------");
        Set<Team<Pupil>> teamPupil = generator(Pupil.class);
        Play.play(teamPupil);
        System.out.println("_------------------------------");
    }
}

