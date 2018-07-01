package pl.marcinos.votecenter.Dorosle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by marci on 23.04.2018.
 */

public class DoroslaFire {
    public String nazwisko;
    public String imie;
    public String miejscowosc;
    public String wzrost;
    public String wiek;
    public int punkty;

    FirebaseDatabase database;
    DatabaseReference users;

    public int getPunkty() {

        return punkty;
    }

    public int calePunkty;

    public int getCalePunkty() {
        return calePunkty;
    }

    public int getPunktyFinalnetop15() {
        return punktyFinalnetop15;
    }

    public int getPunktyFinalnetop15sprawdz() {
        return punktyFinalnetop15sprawdz;
    }

    public void setPunktyFinalnetop15(int punktyFinalnetop15) {
        this.punktyFinalnetop15 = punktyFinalnetop15;
    }

    public void setPunktyFinalnetop15sprawdz(int punktyFinalnetop15sprawdz) {
        this.punktyFinalnetop15sprawdz = punktyFinalnetop15sprawdz;
    }

    public int punktyFinalnetop15;
    public int punktyFinalnetop15sprawdz;
    public DoroslaFire()
    {

    }
    public int punktyFinalne;
    public int getPunktyFinalne() {
        return punktyFinalne;
    }
    public void setPunktyFinalne(int punktyFinalne) {
        this.punktyFinalne = punktyFinalne;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getWzrost() {
        return wzrost;
    }

    public String getWiek() {
        return wiek;
    }

    public void setCalePunkty(int calePunkty) {
        this.calePunkty = calePunkty;
    }
        public int punktyf;

    public void setPunktyf(int punktyf) {
        this.punktyf = punktyf;
    }

    public int getPunktyf() {

        return punktyf;
    }

    public DoroslaFire(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.punkty=0;
        this.calePunkty=0;
        this.punktyFinalne=0;
        this.punktyf=0;
        this.punktyFinalnetop15 =0;
        this.punktyFinalnetop15sprawdz =0;

    }
    public DoroslaFire(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek,int punkty, int calePunkty,int punktyFinalne) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.punkty=punkty;
        this.calePunkty=calePunkty;
        this.punktyFinalne=punktyFinalne;

    }}

