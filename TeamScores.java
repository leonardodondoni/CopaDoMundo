//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
public class TeamScores {
    public int[][] teamScores;
    public int teamIndex;

    public TeamScores() {
        teamScores = new int[32][10];
        teamIndex = 0;
    }

    public int[] findScoreByTeamCode(int teamCode) {
        int[] scoreReturn = new int[10];
        for(int i = 0; i < teamIndex; i++) {
            if(teamScores[i][0] == teamCode) {
                for(int j = 0; j <= 9; j++) {
                    scoreReturn[j] = teamScores[i][j];
                }
            }
        }
        return scoreReturn;
    }

    public void handleTeamScore(int teamCode, int goals, int goalsConceded, boolean isWinner, boolean isLoser) {
        for(int i = 0; i < teamIndex; i++) {
            if(teamScores[i][0] == teamCode) {
                updateNewTeamScore(i, goals, goalsConceded, isWinner, isLoser);
                return;
            }
        }
        createNewTeamScore(teamCode, goals, goalsConceded, isWinner, isLoser);
    }

    public void excludeByTeamCode(int teamCode) {
        for(int i = 0; i < teamIndex; i++) {
            if(teamScores[i][0] == teamCode) {
                for(int j = i; j < teamIndex; j++) {
                    for(int y = 0; y <= 9; y++) {
                        teamScores[j][y] = teamScores[j + 1][y];
                    }
                }
                teamIndex--;
                break;
            }
        }
    }

    private void createNewTeamScore(int teamCode, int goals, int goalsConceded, boolean isWinner, boolean isLoser) {
        int points = isWinner ? 3 : isLoser ? 0 : 1;
        teamScores[teamIndex][0] = teamCode;
        teamScores[teamIndex][1] = teamScores[teamIndex][1] + points;
        teamScores[teamIndex][2] = teamScores[teamIndex][2] + 1;
        teamScores[teamIndex][3] = isWinner ? teamScores[teamIndex][3] + 1 : teamScores[teamIndex][3];
        teamScores[teamIndex][4] = !isWinner && !isLoser ? teamScores[teamIndex][4] + 1 : teamScores[teamIndex][4];
        teamScores[teamIndex][5] = isLoser ? teamScores[teamIndex][5] + 1 : teamScores[teamIndex][5];
        teamScores[teamIndex][6] = teamScores[teamIndex][6] + goals;
        teamScores[teamIndex][7] = teamScores[teamIndex][7] + goalsConceded;
        teamScores[teamIndex][8] = teamScores[teamIndex][6] - teamScores[teamIndex][7];
        teamScores[teamIndex][9] = teamScores[teamIndex][3] / teamScores[teamIndex][2] * 100;

        teamIndex++;
    }

    private void updateNewTeamScore(int existingTeamIndex, int goals, int goalsConceded,  boolean isWinner, boolean isLoser) {
        int points = isWinner ? 3 : isLoser ? 0 : 1;
        teamScores[existingTeamIndex][1] = teamScores[existingTeamIndex][1] + points;
        teamScores[existingTeamIndex][2] = teamScores[existingTeamIndex][2] + 1;
        teamScores[existingTeamIndex][3] = isWinner ? teamScores[existingTeamIndex][3] + 1 : teamScores[existingTeamIndex][3];
        teamScores[existingTeamIndex][4] = !isWinner && !isLoser ? teamScores[existingTeamIndex][4] + 1 : teamScores[existingTeamIndex][4];
        teamScores[existingTeamIndex][5] = isLoser ? teamScores[existingTeamIndex][5] + 1 : teamScores[existingTeamIndex][5];
        teamScores[existingTeamIndex][6] = teamScores[existingTeamIndex][6] + goals;
        teamScores[existingTeamIndex][7] = teamScores[existingTeamIndex][7] + goalsConceded;
        teamScores[existingTeamIndex][8] = teamScores[existingTeamIndex][6] - teamScores[existingTeamIndex][7];
        teamScores[existingTeamIndex][9] = teamScores[existingTeamIndex][3] / teamScores[existingTeamIndex][2] * 100;
    }
}
