package new_year;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Team<T extends Participant> {
    @Getter
    @Setter
    private String name;
    private final List<T> participant;

    public Team(String name, List<T> participant) {
        this.name = name;
        this.participant = participant;
    }

    public List<Participant> getParticipant() {
        return (List<Participant>) participant;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", participant=" + participant +
                '}';
    }

}
