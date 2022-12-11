package util;

import objects.GamblingEvent;
import objects.Outcome;
import objects.User;
import java.util.List;
import java.util.Random;

public class HelperFunctions {

    public static Outcome flip() {
        Random rand = new Random();
        int asd = rand.nextInt(2);
        if (asd == 0) {
            return Outcome.YES;
        } else {
            return Outcome.NO;
        }
    }

    public static void doCalculations(GamblingEvent gamblingEvent, List<User> listOfNoUsers, List<User> listOfYesUsers) {

        double sumOfAllPoints = 0;
        for (var entry : gamblingEvent.getGambledPointsMatchedToUsers().entrySet()) {
            sumOfAllPoints = sumOfAllPoints + entry.getValue();
        }

        double sumOfAllNoPoints = 0;
        for (var entry : gamblingEvent.getGambledPointsMatchedToUsers().entrySet()) {
            if (entry.getKey().getOutcomeThatWasBetOn() == Outcome.NO) {
                sumOfAllNoPoints = sumOfAllNoPoints + entry.getValue();
            }
        }

        double sumOfAllYesPoints = 0;
        for (var entry : gamblingEvent.getGambledPointsMatchedToUsers().entrySet()) {
            if (entry.getKey().getOutcomeThatWasBetOn() == Outcome.YES) {
                sumOfAllYesPoints = sumOfAllYesPoints + entry.getValue();
            }
        }

        if (gamblingEvent.getOutcomeOfEvent() == Outcome.NO) {
            float winningPercentage = (float) (sumOfAllPoints / sumOfAllNoPoints);
            for (User user : listOfNoUsers) {
                user.setTotalPoints((winningPercentage * gamblingEvent.getGambledPointsMatchedToUsers().get(user)) + user.getTotalPoints());
            }
        } else if (gamblingEvent.getOutcomeOfEvent() == Outcome.YES) {
            double winningPercentage = sumOfAllPoints / sumOfAllYesPoints;
            for (User user : listOfYesUsers) {
                user.setTotalPoints((winningPercentage * gamblingEvent.getGambledPointsMatchedToUsers().get(user)) + user.getTotalPoints());
            }
        }
    }

    private HelperFunctions() {}

}
