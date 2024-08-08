
package project1_g37;

public class Contract {

    private Player player;
    private Team team;
    private String type;
    private double value;

    public Contract(Player player, Team team, String type, double value) {
        this.player = player;
        this.team = team;
        this.type = type;
        this.value = value;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}