package _20_12_2023;

import com.github.javafaker.Faker;

import java.util.*;

public class Team<T extends Participant> {
    private static final Faker FAKER = new Faker();

    private String name;
    private List<T> participant;

    public Team(String name, List<T> participant) {
        this.name = name;
        this.participant = participant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getParticipant() {
        return participant;
    }

    public void setParticipant(List<T> participant) {
        this.participant = participant;

    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", participant=" + participant +
                '}';
    }
}
