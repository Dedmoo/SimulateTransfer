
package project1_g37;

public class Player {

    private int backNumber;
    private String name;
    private String position;
    private double marketValue;
    private Team currentTeam;
    private Team previousTeam;

    public Player(String name, int backNumber, String position) {
        this.name = name;
        this.backNumber = backNumber;
        this.position = position;
    }

    public int getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(int backNumber) {
        this.backNumber = backNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    public Team getPreviousTeam() {
        return previousTeam;
    }

    public void setPreviousTeam(Team previousTeam) {
        this.previousTeam = previousTeam;
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + ", backNumber=" + backNumber
                + ", position='" + position + '\''
                + ", marketValue=" + marketValue
                + ", currentTeam=" + (currentTeam != null ? currentTeam.getFullName() : "None")
                + ", previousTeam=" + (previousTeam != null ? previousTeam.getFullName() : "None")
                + '}';
    }
}
