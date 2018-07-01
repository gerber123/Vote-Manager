package pl.marcinos.votecenter.Dorosle;

/**
 * Created by marci on 02.04.2018.
 */

public class Dorosle
{
    public String nazwisko;
    public String imie;
    public String miejscowosc;
    public String wzrost;
    public String wiek;

    public int getPunktyFinalnetop15() {
        return punktyFinalnetop15;
    }

    public int getPunktyFinalnetop15sprawdz() {
        return punktyFinalnetop15sprawdz;
    }

    public void setPunktyFinalnetop15(int punktyFinalnetop15) {
        this.punktyFinalnetop15 = punktyFinalnetop15;
    }

    public int getPunktyf() {
        return punktyf;
    }

    public void setPunktyFinalnetop15sprawdz(int punktyFinalnetop15sprawdz) {
        this.punktyFinalnetop15sprawdz = punktyFinalnetop15sprawdz;
    }

    public int punktyFinalnetop15;
    public int punktyFinalnetop15sprawdz;
    public int punkty;
    public int calePunkty;
    public void setCalePunkty(int calePunkty) {
        this.calePunkty = calePunkty;
    }

    public int ImageAvatar;
    public int punktyFinalne;
    public int Image;
    public int ImageStroj;
    public int getPunktyFinalne() {
        return punktyFinalne;
    }
    public void setPunktyFinalne(int punktyFinalne) {
        this.punktyFinalne = punktyFinalne;
    }

    public Dorosle(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek, int image, int imageAvatar ) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;

        this.ImageAvatar = imageAvatar;
        this.Image = image;

    }
    public Dorosle(int ImageStroj, String nazwisko, String imie, String miejscowosc, String wzrost, String wiek, int image, int imageAvatar ) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;
        this.ImageStroj=ImageStroj;

        this.ImageAvatar = imageAvatar;
        this.Image = image;

    }

    public int getImageStroj() {
        return ImageStroj;
    }

    public void setImageStroj(int imageStroj) {
        ImageStroj = imageStroj;
    }

    public int getPunkty() {
        return punkty;
    }

    public int getCalePunkty() {
        return calePunkty;
    }

    public int getImageAvatar() {
        return ImageAvatar;
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

    public int punktyf;

    public void setPunktyf(int punktyf) {
        this.punktyf = punktyf;
    }


    public Dorosle(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;

    }
    public Dorosle(String nazwisko, String imie, String miejscowosc, String wzrost, String wiek, int Image) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.miejscowosc = miejscowosc;
        this.wzrost = wzrost;
        this.wiek = wiek;

        this.Image= Image;
    }
}
