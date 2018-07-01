package pl.marcinos.votecenter.Model;

/**
 * Created by marci on 01.04.2018.
 */

public class User
{
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;
    private String email;
    private int voteScore;
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


    public void setAdminScore(int adminScore) {
        this.adminScore = adminScore;
    }

    private int adminScore;
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

    public int getAdminScore() {
        return adminScore;
    }

    public User() {
    }

    public void setVoteScore(int voteScore) {
        this.voteScore = voteScore;
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.voteScore=1;
        this.adminScore=0;
        this.adminScoretop10=0;
        this.adminScoreNastolatki=0;
        this.finalnastolatkiList=5;
        this.finaldorosleList =10;

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getVoteScore() {
        return voteScore;
    }
}
