
package project1_g37;
import java.util.ArrayList;

public class TransferBoard {
    private ArrayList<Contract> contracts;
    private ArrayList<Player> players;
    private ArrayList<Team> teams;

    public TransferBoard() {
        contracts = new ArrayList<>();
        players = new ArrayList<>();
        teams = new ArrayList<>();
        populatePlayers();
        populateTeams();
    }

    public void populatePlayers() {
        players.add(new Player("Muslera", 1, "Goalkeeper"));
        players.add(new Player("Kaan", 22, "Defence"));
        players.add(new Player("Toreira", 34, "Midfield"));
        players.add(new Player("Icardi", 99, "Forward"));
        players.add(new Player("Kerem", 7, "Midfield"));
        players.add(new Player("Abdulkerim", 17, "Defence"));
        players.add(new Player("Oliveira", 20, "Midfield"));
        players.add(new Player("Mertens", 10, "Midfield"));
        players.add(new Player("Bakambu", 9, "Forward"));
        players.add(new Player("Nellson", 4, "Defence"));
        players.add(new Player("Boey", 2, "Defence"));
    }

    public void populateTeams() {
        teams.add(new Team("Galatasaray", "GS"));
        teams.add(new Team("Fenerbahce", "FB"));
        teams.add(new Team("Besiktas", "BJK"));
        teams.add(new Team("Trabzonspor", "TS"));
        teams.add(new Team("Ankaragucu", "ANK"));
        teams.add(new Team("Basaksehir", "BSK"));
        teams.add(new Team("Karagumruk", "KGM"));
    }

    public String makeContract(String playerName, String teamName, String contractType, double contractValue) {
       
        Player player = findPlayer(playerName);
       
       
        if (player == null) {
            return "UnknownPlayer";
        }

        Team team = findTeam(teamName);
        
        if (team == null) {
            return "UnknownTeam";
        }

        if (team.getSize() >= team.getmaxTeamSize()) {
            return "ExceedingMaxNumPlayers";
        }

        Contract existingContract = findContract(playerName, teamName);
        if (existingContract != null) {
            return "ExistingContract";
        }

        if (player.getCurrentTeam() != null && player.getCurrentTeam().getShortName() == teamName && contractType.equals("Rented")) {
            return "ContractNotPossible";
        }

        if (player.getCurrentTeam() == null && !contractType.equals("Permanent")) {
            return "InvalidContractType";
        }

        if (player.getCurrentTeam() != null) {
            player.getCurrentTeam().setSize(player.getCurrentTeam().getSize() - 1);
            player.getCurrentTeam().setTotalValue(player.getCurrentTeam().getTotalValue() - contractValue);
        }
        
        player.setPreviousTeam(player.getCurrentTeam());  
        player.setCurrentTeam(team);
        player.setMarketValue(contractValue);

        team.setSize(team.getSize() + 1);
        
        team.setTotalValue(team.getTotalValue() + contractValue);

        contracts.add(new Contract(player, team, contractType, contractValue));
  
              
        return "SuccessfullyContracted";
    }

    public void terminateContract(String playerName, String teamName) {
        Contract contract = findContract(playerName, teamName);
        
        if (contract != null) {
            Player player = contract.getPlayer();
            Team team = contract.getTeam();

            if (contract.getType().equals("Rented")) {
                player.setCurrentTeam(player.getPreviousTeam());
                player.setMarketValue(player.getPreviousTeam().getTotalValue());
            } else {
                player.setCurrentTeam(null);
                player.setMarketValue(0.0);
            }

            team.setSize(team.getSize() - 1);
            team.setTotalValue(team.getTotalValue() - contract.getValue());

            contracts.remove(contract);
            System.out.println("The player is Terminated");
        }
        System.out.println("The player is already teamless");
    }

    private Player findPlayer(String playerName) {
         for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        
        return null;
    }

    private Team findTeam(String teamName) {
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (team.getShortName().equals(teamName)) {
                return team;
            }
        }
        
        return null;
    }

    private Contract findContract(String playerName, String teamName) {
        
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            if (contract.getPlayer().getName().equals(playerName) && contract.getTeam().getFullName().equals(teamName)) {
                return contract;
             
                       
            }
        }
        return null;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}