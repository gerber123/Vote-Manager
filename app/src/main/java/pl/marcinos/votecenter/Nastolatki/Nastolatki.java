package pl.marcinos.votecenter.Nastolatki;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by marci on 17.04.2018.
 */

public class Nastolatki {

        public String nazwisko;
        public String imie;
        public String miejscowosc;
        public String wzrost;
        public String wiek;
        public int punkty;
        public int calePunkty;
    public int ImageAvatar;
    public int Image;
    public int ImageStroj;
    public int getImageStroj() {
        return ImageStroj;
    }

    public void setImageStroj(int imageStroj) {
        ImageStroj = imageStroj;
    }
    public int getCalePunkty() {
        return calePunkty;
    }

    FirebaseDatabase database;
    DatabaseReference users;

    public int getPunkty() {

        return punkty;
    }


    public int getImageAvatar() {
        return ImageAvatar;
    }


    public void setCalePunkty(int calePunkty) {
        this.calePunkty = calePunkty;
    }
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
    public Nastolatki()
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


    public int getImage() {
        return Image;
    }


    public Nastolatki(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek)
    {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.punkty=0;
        this.calePunkty=0;
        this.punktyf=0;
        this.punktyFinalne=0;

    }
    public Nastolatki(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek, int Image ,int ImageAvatar ) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.ImageAvatar=ImageAvatar;
        this.Image= Image;
    }
    public Nastolatki(int ImageStroj,String nazwisko, String imie, String miejscowosc, String wzrost, String wiek, int Image ,int ImageAvatar ) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.ImageAvatar=ImageAvatar;
        this.Image= Image;
        this.ImageStroj=ImageStroj;
    }
}