package _20_12_2023;

import java.util.Map;
import java.util.Set;

import static _20_12_2023.Generator.generator;


public class Handler {
    public static void main(String[] args) {
        Set<Team<Adult>> teamAdult = Generator.generator(Adult.class);
        System.out.println("----------------------------------------------------------------");
        Play.play(teamAdult);
        System.out.println("----------------------------------------------------------------");
        Set<Team<Teenager>> teamTeenager = Generator.generator(Teenager.class);
        System.out.println("----------------------------------------------------------------");
        Play.play(teamTeenager);
        System.out.println("----------------------------------------------------------------");
        Set<Team<Pupil>> teamPupil = Generator.generator(Pupil.class);
        System.out.println("----------------------------------------------------------------");
        Play.play(teamPupil);
    }
}

