package pl.marcinos.votecenter.Nastolatki;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by marci on 19.04.2018.
 */

public class NastolatkaFire {
    public String nazwisko;
    public String imie;
    public String miejscowosc;
    public String wzrost;
    public String wiek;
    public int punkty;

    FirebaseDatabase database;
    DatabaseReference users;

    public int punktyf;
    public int punktyFinalne;

    public void setPunktyf(int punktyf) {
        this.punktyf = punktyf;
    }

    public void setPunktyFinalne(int punktyFinalne) {
        this.punktyFinalne = punktyFinalne;
    }

    public int getPunktyf() {
        return punktyf;
    }

    public int getPunktyFinalne() {
        return punktyFinalne;
    }

    public int getPunkty() {

        return punkty;
    }

    public int calePunkty;

    public int getCalePunkty() {
        return calePunkty;
    }


    public NastolatkaFire()
    {

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

    public NastolatkaFire(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.punkty=0;
        this.calePunkty=0;
        this.punktyFinalne=0;

    }}
