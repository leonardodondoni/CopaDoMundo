//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
//Leonardo Dondoni de Siqueira e Murilo Vargas
import java.text.SimpleDateFormat;
import java.util.Date;
public class Match {
    private int matchCode;
    private int firstTeamCode;
    private int secondTeamCode;
    private Date matchDate;
    private int firstTeamGoals;
    private int secondTeamGoals;
    private Boolean finishedGame;

    public Match(int newFirstTeamCode, int newSecondTeamCode, String newMatchDate, int newMatchCode) throws Exception {
        matchCode = newMatchCode;
        firstTeamCode = newFirstTeamCode;
        secondTeamCode = newSecondTeamCode;
        finishedGame = false;
        try {
            matchDate = new SimpleDateFormat("dd/MM/yyyy").parse(newMatchDate);
        } catch (Exception e) {
            throw new Exception("Invalid date format! Correct format dd/MM/yyyy!");
        }
    }

    public int getMatchCode() {
        return matchCode;
    }

    public int getFirstTeamCode() {
        return firstTeamCode;
    }

    public int getSecondTeamCode() {
        return secondTeamCode;
    }

    public Boolean getFinishedGame() {
        return finishedGame;
    }

    public void setFinishedGame() {
        finishedGame = true;
    }

    public void setSecondTeamGoals(int newSecondTeamGoals) {
        secondTeamGoals = newSecondTeamGoals;
    }
    public void setFirstTeamGoals(int newFirstTeamGoals) {
        firstTeamGoals = newFirstTeamGoals;
    }
    public String toString() {
        return "Match{" +
                "matchCode=" + matchCode +
                ", firstTeamCode=" + firstTeamCode +
                ", secondTeamCode=" + secondTeamCode +
                ", matchDate=" + matchDate +
                ", firstTeamGoals=" + firstTeamGoals +
                ", secondTeamGoals=" + secondTeamGoals +
                ", finishedGame=" + finishedGame +
                '}';
    }
}