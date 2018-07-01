package pl.marcinos.votecenter.Model;

/**
 * Created by marci on 03.04.2018.
 */

public class CurrentUser
{
    public String userName;
    public int voteScore;
    private String password;
    private String email;
    public int adminScore;
    private int adminScoretop10;

    public void setAdminScoretop10(int adminScoretop10) {
        this.adminScoretop10 = adminScoretop10;
    }

    public int getAdminScoretop10() {
        return adminScoretop10;

    }
    public void setAdminScoreNastolatki(int adminScoreNastolatki) {
        this.adminScoreNastolatki = adminScoreNastolatki;
    }

    public int getAdminScoreNastolatki() {

        return adminScoreNastolatki;
    }

    public int adminScoreNastolatki;





    public CurrentUser() {

    }
    public int getVoteScore() {
        return voteScore;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;

    }
    private int finalnastolatkiList;

    public void setFinalnastolatkiList(int finalnastolatkiList) {
        this.finalnastolatkiList = finalnastolatkiList;
    }

    public void setFinaldorosleList(int finaldorosleList) {
        this.finaldorosleList = finaldorosleList;
    }

    public int getFinalnastolatkiList() {

        return finalnastolatkiList;
    }

    public int getFinaldorosleList() {
        return finaldorosleList;
    }

    private int finaldorosleList;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVoteScore(int voteScore) {
        this.voteScore = voteScore;
    }

    public int getAdminScore() {
        return adminScore;
    }

    public void setAdminScore(int adminScore) {

        this.adminScore = adminScore;
    }

    public CurrentUser(String userName, String password, String email) {

        this.userName = userName;
        this.voteScore = 2;
        this.password=password;
        this.email=email;
        this.adminScore=0;
        this.adminScoretop10=0;
        this.finalnastolatkiList=5;
        this.finaldorosleList =10;

    }
}
