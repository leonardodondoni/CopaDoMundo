//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
public class MatchList {
    public Match[] matchList;
    public TeamScores teamScores;
    private int index = 0;
    private int nextMatchCode;

    public MatchList() {
        matchList = new Match[62];
        teamScores = new TeamScores();
        nextMatchCode = 1000;
    }

    public Match createMatch(int firstTeamCode, int secondTeamCode, String matchDate) throws Exception {
        if(index == matchList.length) {
            throw new Exception("Match limit reached!");
        }

        Match match =  new Match(firstTeamCode, secondTeamCode, matchDate, nextMatchCode);
        matchList[index] = match;
        index++;
        nextMatchCode++;
        return match;
    }

    public void excludeByMatchCode(int matchCode) {
        for (int i = 0; i <= index - 1; i++) {
            if(matchList[i].getMatchCode() == matchCode) {
                for(int j = i; j <= index - 1; j++) {
                    matchList[j] = matchList[j + 1];
                }
                index--;
                break;
            }
        }
    }

    public Match findByMatchCode(int teamCode) {
        for (int i = 0; i <= index - 1; i++) {
            if (matchList[i].getMatchCode() == teamCode) return matchList[i];
        }
        return null;
    }

    public Match[] findAll() {
        Match[] returnMatchList = new Match[index];

        for(int i = 0; i <= index - 1; i++) {
            returnMatchList[i] = matchList[i];
        }
        return returnMatchList;
    }

    public void excludeTeamFromScoreByTeamCode(int teamCode) {
        teamScores.excludeByTeamCode(teamCode);
    }

    public int[] findScoreByTeamCode(int teamCode) {
        int [] scoreReturn = teamScores.findScoreByTeamCode(teamCode);
        return scoreReturn;
    }

    public Match finalizeMatch(int matchCode, int firstTeamGoals, int secondTeamGoals) throws Exception {
        Match match = findByMatchCode(matchCode);

        if (match == null) {
            throw new Exception("Invalid match code!");
        }
        if (match.getFinishedGame() == true) {
            throw new Exception("Match already finished!");
        }

        match.setFirstTeamGoals(firstTeamGoals);
        match.setSecondTeamGoals(secondTeamGoals);
        match.setFinishedGame();

        if(firstTeamGoals > secondTeamGoals) {
            teamScores.handleTeamScore(match.getFirstTeamCode(), firstTeamGoals, secondTeamGoals, true, false);
            teamScores.handleTeamScore(match.getSecondTeamCode(), secondTeamGoals, firstTeamGoals, false, true);
        } else if (secondTeamGoals > firstTeamGoals) {
            teamScores.handleTeamScore(match.getSecondTeamCode(), secondTeamGoals, firstTeamGoals, true, false);
            teamScores.handleTeamScore(match.getFirstTeamCode(), firstTeamGoals, secondTeamGoals, false, true);
        } else {
            teamScores.handleTeamScore(match.getFirstTeamCode(), firstTeamGoals, secondTeamGoals, false, false);
            teamScores.handleTeamScore(match.getSecondTeamCode(), secondTeamGoals, firstTeamGoals, false, false);
        }

        return match;
        
    }
    
}
