
package project1_g37;

import java.util.Scanner;

public class SimulateTransfer {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TransferBoard transferBoard = new TransferBoard();

        
        while (true) {
            System.out.println("\nFootball Manager System Menu:");
            System.out.println("1- List all Players in the system.");
            System.out.println("2- List all Teams in the system.");
            System.out.println("3- List all teamless players.");
            System.out.println("4- Establish a contract between a player and a team.");
            System.out.println("5- Terminate the existing contract between a player and a team.");
            System.out.println("6- Exit.");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    listAllPlayers(transferBoard);
                    break;
                case 2:
                    listAllTeams(transferBoard);
                    break;
                case 3:
                    listTeamlessPlayers(transferBoard);
                    break;
                case 4:
                    establishContract(transferBoard);
                    break;
                case 5:
                    terminateContract(transferBoard);
                    break;
                case 6:
                    exitProgram(transferBoard);
                    return;
                default:
                    System.out.println("Invalid option! Please choose a valid option.");
            }
        }
    }

    
    private static void listAllPlayers(TransferBoard transferBoard) {
        System.out.println("\nAll Players:");
       
        for (int i = 0; i < transferBoard.getPlayers().size(); i++) {
            Player player = transferBoard.getPlayers().get(i);
                
            System.out.println(player);
        }
    }

    
    private static void listAllTeams(TransferBoard transferBoard) {
        System.out.println("\nAll Teams:");
        
        for (int i = 0; i < transferBoard.getTeams().size(); i++) {
            Team team = transferBoard.getTeams().get(i);
            
            System.out.println(team);
        }
    }

    
    private static void listTeamlessPlayers(TransferBoard transferBoard) {
        boolean hasTeamlessPlayers = false;
        System.out.println("\nTeamless Players:");
        
        for (int i = 0; i < transferBoard.getPlayers().size(); i++) {
            Player player = transferBoard.getPlayers().get(i);
            
            if (player.getCurrentTeam() == null) {
                System.out.println(player.getName());
                hasTeamlessPlayers = true;
            }
        }
        if (!hasTeamlessPlayers) {
            System.out.println("No teamless players.");
        }
    }

    
private static void establishContract(TransferBoard transferBoard) {
    System.out.println("\nEnter player name, team name, contract type, and contract value (e.g., Muslera GS Permanent 1000000):");
    String pname = scanner.nextLine();
    String tname = scanner.nextLine();
    String ctype = scanner.nextLine();
    Double cvalue = scanner.nextDouble();
    
    System.out.println(transferBoard.makeContract(pname, tname, ctype, cvalue));

    
}


    
    private static void terminateContract(TransferBoard transferBoard) {
        System.out.println("\nEnter player name and team name to terminate the contract (e.g., Muslera GS):");
        String pname = scanner.nextLine();
        String tname = scanner.nextLine();
        
        
        transferBoard.terminateContract(pname, tname);
        
    }

    
    private static void exitProgram(TransferBoard transferBoard) {
        System.out.println("\nExiting the program:");
        System.out.println("For each player with a contract:");
        
        for (int i = 0; i < transferBoard.getContracts().size(); i++) {
            Contract contract = transferBoard.getContracts().get(i);
            System.out.println(contract.getPlayer().getName() + " : " + contract.getValue() + " " + contract.getPlayer().getCurrentTeam().getFullName() + " " + contract.getType());
        }
        System.out.println("For each team:");
        
        for (int i = 0; i < transferBoard.getTeams().size(); i++) {
            Team team = transferBoard.getTeams().get(i);
            System.out.println(team.getShortName() + " : " + team.getTotalValue() + " " + team.getSize());
        }
        System.out.println("For each player without a contract:");
        
        for (int i = 0; i < transferBoard.getPlayers().size(); i++) {
            Player player = transferBoard.getPlayers().get(i);
            if (player.getCurrentTeam() == null) {
                System.out.println(player.getName());
            }
        }
    }
}