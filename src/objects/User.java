package objects;

public class User {
    private int ID;
    private String userName;
    private Double totalPoints;
    private Outcome outcomeThatWasBetOn;

    public User(int ID, String userName, Double totalPoints, Outcome outcomeThatWasBetOn) {
        this.ID = ID;
        this.userName = userName;
        this.totalPoints = totalPoints;
        this.outcomeThatWasBetOn = outcomeThatWasBetOn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Double totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "objects.User{" +
                "ID='" + ID + '\'' +
                ", userName='" + userName + '\'' +
                ", totalPoints=" + totalPoints +
                ", outcomeThatWasBetOn=" + outcomeThatWasBetOn +
                '}';
    }

    public Outcome getOutcomeThatWasBetOn() {
        return outcomeThatWasBetOn;
    }

    public void setOutcomeThatWasBetOn(Outcome outcomeThatWasBetOn) {
        this.outcomeThatWasBetOn = outcomeThatWasBetOn;
    }
}
