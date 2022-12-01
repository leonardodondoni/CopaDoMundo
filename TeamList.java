//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
import java.util.Objects;

public class TeamList {
    public Team[] teamList;
    private int index = 0;
    private int nextTeamCode;

    public TeamList() {
        teamList = new Team[32];
        nextTeamCode = 1000;
    }
    public Team createTeam(String newCountryName) throws Exception {
        if(index == teamList.length) {
            throw new Exception("Team limit reached!");
        }
        Team teamAlreadyExists = findByCountryName(newCountryName);
        if(teamAlreadyExists != null) {
            throw new Exception("A team with this name already exists!");
        }
        Team newTeam = new Team(newCountryName, nextTeamCode);
        teamList[index] = newTeam;
        index++;
        nextTeamCode++;
        return newTeam;
    }

    public void excludeByTeamCode(int teamCode) {
        for (int i = 0; i <= index - 1; i++) {
            if(teamList[i].getTeamCode() == teamCode) {
                for(int j = i; j <= index - 1; j++) {
                    teamList[j] = teamList[j + 1];
                }
                index--;
                break;
            }
        }
    }

    public Team findByCountryName(String countryName) {
        for (int i = 0; i <= index - 1; i++) {
            if (Objects.equals(teamList[i].getCountryName(), countryName)) return teamList[i];
        }
        return null;
    }

    public Team findByTeamCode(int teamCode) {
        for (int i = 0; i <= index - 1; i++) {
            if (teamList[i].getTeamCode() == teamCode) return teamList[i];
        }
        return null;
    }

    public Team[] findAll() {
        Team[] returnTeamList = new Team[index];

        for(int i = 0; i <= index - 1; i++) {
            returnTeamList[i] = teamList[i];
        }
        return returnTeamList;
    }
    
}
