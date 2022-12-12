import objects.GamblingEvent;
import objects.Outcome;
import objects.User;
import util.HelperFunctions;
import java.util.*;
import static strings.MyStrings.*;

public class Main {
    public static void main(String[] args) {

        //////////CREATE LISTS AND MAPS//////////////
        List<User> gamblersList = new ArrayList<>();
        List<Double> gamblerPointsList = new ArrayList<>();
        List<User> usersThatSaidNo;
        List<User> usersThatSaidYes;
        HashMap<User, Double> map = new HashMap<>();

        ///GET USER INPUT///
        Scanner sc = new Scanner(System.in);

        boolean keepCreatingUsers = true;
        ////////CREATE USER ATTRIBUTES//////////
        while (keepCreatingUsers) {
            int userID = new Random().nextInt(MAXPOINTSFORID);
            String userName;
            double gambledPoints;
            Outcome outcome;

            //////////////START CREATING USER///////////////////
            System.out.println(welcomeString);

            ///////////////GET USER NAME/////////////////
            System.out.println(askForName);
            userName = sc.nextLine();

            //////////////////GET GAMBLING AMOUNT////////////////
            System.out.println(askForGamblingAmount);
            gambledPoints = sc.nextDouble();
            while (gambledPoints > totalPoints) {
                System.out.println(gamblingAmountError);
                gambledPoints = sc.nextDouble();
            }
            sc.nextLine();

            ///////////////////GET OUTCOME//////////////////////
            System.out.println(askForOutcome);
            outcome = Outcome.getByName(sc.nextLine().toUpperCase());
            while (!(outcome == Outcome.YES || outcome == Outcome.NO)) {
                System.out.println(outcomeError);
                outcome = Outcome.getByName(sc.nextLine());
            }

            //////////////ADD USER TO LIST//////////////////
            gamblersList.add(new User(userID, userName, totalPoints, outcome));
            gamblerPointsList.add(gambledPoints);
            System.out.println("Current List of Users: " + gamblersList);
            System.out.println("Press 1 to Continue adding users, Press 2 to stop.");
            /////////////FINISH OR CONTINUE//////////////
            if (sc.nextInt() == 1) {
                sc.nextLine();
                continue;
            } else {
                keepCreatingUsers = false;
                break;
            }
        }

        /////////////GET USERS THAT SAID NO///////////////
        usersThatSaidNo = gamblersList.stream()
                .filter(user -> user.getOutcomeThatWasBetOn() == Outcome.NO).toList();

        ////////////GET USERS THAT SAID YES///////////////
        usersThatSaidYes = gamblersList.stream()
                .filter(p -> p.getOutcomeThatWasBetOn() == Outcome.YES).toList();

        ////////////CREATE ITERATORS TO GO OVER 2 LISTS AT THE SAME TIME/////////////
        Iterator<User> gamblersListIterator = gamblersList.iterator();
        Iterator<Double> gamblersPointsIterator = gamblerPointsList.iterator();

        /////////////GO THROUGH LISTS AND ADD USERS AND THEIR POINTS TO THE MAP/////////////
        while (gamblersListIterator.hasNext() && gamblersPointsIterator.hasNext()) {
            map.put(gamblersListIterator.next(), gamblersPointsIterator.next());
        }

        //////////////////REDUCE BET POINTS FROM USERS//////////////////////
        for (Map.Entry<User, Double> entry : map.entrySet()) {
            double userGambledAmount = entry.getValue();
            entry.getKey().setTotalPoints(entry.getKey().getTotalPoints() - userGambledAmount);
        }

        /////////////CREATE GAMBLING EVENT//////////////
        GamblingEvent gamblingEvent = new GamblingEvent(HelperFunctions.flip(), map);

        //////////////////////DO CALCULATIONS/////////////////////
        HelperFunctions.doCalculations(gamblingEvent, usersThatSaidNo, usersThatSaidYes);
        System.out.println(usersThatSaidNo);
        System.out.println(usersThatSaidYes);
    }
}


