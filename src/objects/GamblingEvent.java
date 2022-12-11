package objects;

import java.util.Map;

public class GamblingEvent {
    private Outcome outcomeOfEvent;
    private Map<User, Double> gambledPointsMatchedToUsers;

    public GamblingEvent(Outcome outcomeOfEvent, Map<User, Double> gambledPointsMatchedToUsers) {
        this.outcomeOfEvent = outcomeOfEvent;
        this.gambledPointsMatchedToUsers = gambledPointsMatchedToUsers;
    }

    public Outcome getOutcomeOfEvent() {
        return outcomeOfEvent;
    }

    public void setOutcomeOfEvent(Outcome outcomeOfEvent) {
        this.outcomeOfEvent = outcomeOfEvent;
    }

    public Map<User, Double> getGambledPointsMatchedToUsers() {
        return gambledPointsMatchedToUsers;
    }

    public void setGambledPointsMatchedToUsers(Map<User, Double> gambledPointsMatchedToUsers) {
        this.gambledPointsMatchedToUsers = gambledPointsMatchedToUsers;
    }
}
