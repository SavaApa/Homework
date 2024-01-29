package NEW_YEAR;

import java.util.*;

public class Team<T extends Participant> {
    private String name;
    private final List<T> participant;

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
