
package project1_g37;

public class Team {

    private String shortName;
    private String fullName;
    private double totalValue;
    private int size;
    static final int maxTeamSize = 22;

    public Team(String fullName, String shortName) {
        this.shortName = shortName;
        this.fullName = fullName;

    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getmaxTeamSize() {
        return maxTeamSize;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Team{"
                + "shortName='" + shortName + '\''
                + ", fullName='" + fullName + '\''
                + ", totalValue=" + totalValue
                + ", size=" + size
                + '}';
    }
}
