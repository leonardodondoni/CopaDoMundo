//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
public class Team {
    private int teamCode;
    private String countryName;

    public Team(String newCountryName, int newTeamCode) {
        teamCode = newTeamCode;
        countryName = newCountryName;
    };
    public String getCountryName() {
        return countryName;
    }

    public int getTeamCode() {
        return teamCode;
    }
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
