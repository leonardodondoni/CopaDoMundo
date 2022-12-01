//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
import java.util.Scanner;

public class Main {
    public static <e> void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean execute = true;
        TeamList teamList = new TeamList();
        MatchList matchList = new MatchList();

        do {
            System.out.println(
                    "------MENU------\n0 - Sair\n1 - Inserir times\n2 - Listar todos os times\n3 - Excluir time\n4 - Incluir partida\n5 - Listar todas as partidas\n6 - Excluir partida\n7 - Finalizar uma partida\n8 - Buscar pontuação de um time");
            int option = input.nextInt();
            try {
                if (option == 0) {
                    execute = false;
                }
                if (option == 1) {
                    System.out.println("Informe o nome do país: ");
                    input.nextLine();
                    String countryName = input.nextLine();
                    teamList.createTeam(countryName);
                }
                if (option == 2) {
                    Team[] returnTeamList = teamList.findAll();
                    System.out.println("Lista de times: ");
                    for (int i = 0; i < returnTeamList.length; i++) {
                        System.out.println(returnTeamList[i].toString());
                    }
                }
                if (option == 3) {
                    System.out.println("Informe o código do time que deseja excluir: ");
                    int excludeTeamCode = input.nextInt();
                    teamList.excludeByTeamCode(excludeTeamCode);
                    matchList.excludeTeamFromScoreByTeamCode(excludeTeamCode);
                }
                if (option == 4) {
                    System.out.println("Informe o código do primeiro time da partida: ");
                    int firstTeamCode = input.nextInt();
                    System.out.println("Informe o código do segundo time da partida: ");
                    int secondTeamCode = input.nextInt();
                    System.out.println("Informe a data da partida: ");
                    input.nextLine();
                    String matchDate = input.nextLine();

                    matchList.createMatch(firstTeamCode, secondTeamCode, matchDate);
                }
                if (option == 5) {
                    Match[] returnMatchList = matchList.findAll();
                    System.out.println("Lista de partidas: ");
                    for (int i = 0; i < returnMatchList.length; i++) {
                        System.out.println(returnMatchList[i].toString());
                    }
                }
                if (option == 6) {
                    System.out.println("Informe o código da partida que deseja excluir: ");
                    int excludeMatchCode = input.nextInt();
                    matchList.excludeByMatchCode(excludeMatchCode);
                }
                if (option == 7) {
                    System.out.println("Informe o código da partida que deseja finalizar: ");
                    int finishMatchCode = input.nextInt();
                    System.out.println("Informe o número de gols do primeiro time: ");
                    int firstTeamGoals = input.nextInt();
                    System.out.println("Informe o número de gols do segundo time: ");
                    int secondTeamGoals = input.nextInt();
                    matchList.finalizeMatch(finishMatchCode, firstTeamGoals, secondTeamGoals);
                }
                if (option == 8) {
                    System.out.println("Informe o código do time que deseja buscar a pontuação: ");
                    int teamCode = input.nextInt();
                    int[] teamScore = matchList.findScoreByTeamCode(teamCode);
                    if (teamScore[0] != teamCode) {
                        System.out.println("Nenhum time encontrado!");
                        continue;
                    }
                    System.out.println("Total de pontos: " + teamScore[1]);
                    System.out.println("Total de jogos: " + teamScore[2]);
                    System.out.println("Total de vitórias: " + teamScore[3]);
                    System.out.println("Total de empates: " + teamScore[4]);
                    System.out.println("Total de derrotas: " + teamScore[5]);
                    System.out.println("Total de gols: " + teamScore[6]);
                    System.out.println("Total de gols sofridos: " + teamScore[7]);
                    System.out.println("Saldo de gols: " + teamScore[8]);
                    System.out.println("Aproveitamento: " + teamScore[9]);
                }
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }

        } while (execute);
    }
}