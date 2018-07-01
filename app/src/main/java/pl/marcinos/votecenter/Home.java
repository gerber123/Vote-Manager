package pl.marcinos.votecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Iterator;

import javax.sql.CommonDataSource;

import pl.marcinos.votecenter.Dorosle.AfterDorosle;
import pl.marcinos.votecenter.Dorosle.Dorosle;
import pl.marcinos.votecenter.Model.CurrentUser;
import pl.marcinos.votecenter.Model.User;
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosle;
import pl.marcinos.votecenter.Nastolatki.AfterNastolatki;
import pl.marcinos.votecenter.Nastolatki.Nastolatki;
import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.MainActivity.admin123;
import static pl.marcinos.votecenter.MainActivity.user123;

public class Home extends AppCompatActivity {
ImageView dorosle;
ImageView nastolatki;
TextView przywitanie;
Boolean wejscie=false;
int temp=0;
    public static Nastolatki Ejzemberg =new Nastolatki(R.drawable.ejzembergstroj,"Ejzemberg","Victoria","Łodziska","172","21",R.drawable.ejzemberg,R.drawable.ejzembergavatar);
    public static Nastolatki Grządziela =new Nastolatki(R.drawable.grzadzielastroj,"Grządziela","Julia","Gąsawa","175","17",R.drawable.grzadziela,R.drawable.grzadzielaavatar);
    public static   Nastolatki Grzesiak =new Nastolatki(R.drawable.grzesiakstroj,"Grzesiak","Wiktoria","Osieczna","172","15",R.drawable.grzesiak,R.drawable.grzesiakavatar);
    public static   Nastolatki Jung =new Nastolatki(R.drawable.jungstroj,"Jung","Aleksandra","Żary","173","16",R.drawable.jung,R.drawable.jungavatar);
    public static   Nastolatki Ławrynowicz =new Nastolatki(R.drawable.lawrynowiczstroj,"Ławrynowicz","Zuzanna","Wieleń","172","21",R.drawable.lawrynowicz,R.drawable.lawrynowiczavatar);

    public static   Nastolatki Majewska =new Nastolatki(R.drawable.majewskastroj,"Majewska","Martyna","Piła","173","17",R.drawable.majewska,R.drawable.majewskavatar);
    public static   Nastolatki Niedziałek =new Nastolatki(R.drawable.niedzialekstroj,"Niedziałek","Emilia","Piła","180","16",R.drawable.niedzialek,R.drawable.niedzialekavatar);
    public static   Nastolatki Pływaczyk =new Nastolatki(R.drawable.plywaczykstroj,"Pływaczyk","Wiktoria","Popówek","174","17",R.drawable.plywaczyk,R.drawable.plywaczykavatar);
    public static  Nastolatki Pokojowa =new Nastolatki(R.drawable.pokojowastroj,"Pokojowa","Oliwia","Konin","166","17",R.drawable.pokojowa,R.drawable.pokojowaavatar);
    public static  Nastolatki Żok =new Nastolatki(R.drawable.zokstroj,"Żok","Aleksandra","Głodno","175","16",R.drawable.zok,R.drawable.zokavatar);

//
//    public static Dorosle Baranowska =new Dorosle(R.drawable.baranowskaavatar,"Baranowska","Sandra","Warszawa","170","20 ",R.drawable.baranowska,R.drawable.baranowskaavatar);
  //
    public static Dorosle Barkova =new Dorosle(R.drawable.barkovastroj,"Barkova","Anastasiya","Poznan","180","27",R.drawable.barkova,R.drawable.barkovaavatar);
    public static Dorosle  Budkowska =new Dorosle(R.drawable.budkowskastroj,"Budkowska","Anna","Miłosław","171","21",R.drawable.budkowska,R.drawable.budkowskaavatar);
    public static Dorosle Chrośniak =new Dorosle(R.drawable.chrosniakstroj,"Chrośniak","Agata","Białe Błota","176","24",R.drawable.chrosniak,R.drawable.chrosniakavatar);
    public static Dorosle CiesielskaAnna =new Dorosle(R.drawable.ciesielskastroj,"Ciesielskaa","Anna","Poznań","168","22",R.drawable.ciesielskaewa,R.drawable.ciesielskaewaavatar);

    public static Dorosle CiesielskaEwa =new Dorosle(R.drawable.eciesielskastroj,"Ciesielska","Ewa","Poznań","170","23",R.drawable.ciesielska,R.drawable.ciesielskaavatar);
    public static Dorosle Czajkowska =new Dorosle(R.drawable.czajkowskastroj,"Czajkowska","Klaudia","Janiszewo","164","19",R.drawable.czajkowska,R.drawable.czajkowskaavatar);
    public static Dorosle Czechowska =new Dorosle(R.drawable.czechowskastroj,"Czechowska","Klaudia","Poznań","171","23",R.drawable.czechowska,R.drawable.czechowskaavatar);
    public static Dorosle Gonta =new Dorosle(R.drawable.gontastroj,"Gonta","Laura","Poznań","170","20",R.drawable.gonta,R.drawable.gontaavatar);
    public static Dorosle Grzegorczyk =new Dorosle(R.drawable.grzegorczykstroj,"Grzegorczyk","Daria","Kalisz","176","23",R.drawable.grzegorczyk,R.drawable.grzegorczykavatar);
    public static Dorosle Hrebennyk =new Dorosle(R.drawable.hrebennykstroj,"Hrebennyk","Valeriya","Ostrów Wielkopolski","171","18",R.drawable.hrebennyk,R.drawable.hrebennykavatar);
    public static Dorosle Imiołek =new Dorosle(R.drawable.imiolekstroj,"Imiołek","Klaudia","Poznań","174","16",R.drawable.imiolek,R.drawable.imiolekavatar);
   //
//    public static Dorosle Kacperczyk =new Dorosle(R.drawable.kacperczykavatar,"Kacperczyk","Sandra","Jerzykowo","169","17",R.drawable.kacperczyk,R.drawable.kacperczykavatar);
    //
    public static Dorosle Kalińska =new Dorosle(R.drawable.kalinskastroj,"Kalińska","Weronika","Luboń","169","20",R.drawable.kalinska,R.drawable.kalinskaavatar);
    public static Dorosle Kamińska =new Dorosle(R.drawable.kaminskastroj,"Kamińska","Daria","Poznań","181","20",R.drawable.kaminska,R.drawable.kaminskaavatar);
    public static Dorosle Kokocińska =new Dorosle(R.drawable.kokocinskastroj,"Kokocińska","Iga","Koło","171","24",R.drawable.kokocinska,R.drawable.kokocinskaavatar);
    public static Dorosle Kostrzewa =new Dorosle(R.drawable.kostrzewastroj,"Kostrzewa","Joanna","Poznań","170","22",R.drawable.kostrzewa,R.drawable.kostrzewaavatar);
    public static Dorosle Kowalczyk =new Dorosle(R.drawable.kowalczykstroj,"Kowalczyk","Magdalena","Gorzyń","171","27",R.drawable.kowalczyk,R.drawable.kowalczykavatar);
    public static Dorosle Maciejewska =new Dorosle(R.drawable.maciejewskastroj,"Maciejewska","Martyna","Tarnowo Podgórne","180","21",R.drawable.maciejewska,R.drawable.maciejewskaavatar);
    public static Dorosle Marczyńska =new Dorosle(R.drawable.marczynskastroj,"Marczyńska","Karolina","Szamocin","178","20",R.drawable.marczynska,R.drawable.marczynskaavatar);
    public static Dorosle Masłowska =new Dorosle(R.drawable.maslowskastroj,"Masłowska","Angela","Zabrze","174","25",R.drawable.maslowska,R.drawable.maslowskaavatar);
   //
//    public static Dorosle Nieznańska =new Dorosle(R.drawable.nieznanskaavatar,"Nieznańska","Karolina Ida","Warszawa","170","21",R.drawable.nieznanska,R.drawable.nieznanskaavatar);
   //
    public static Dorosle Osłońska =new Dorosle(R.drawable.oslonskastroj,"Osłońska","Wiktoria","Mochy","175","20",R.drawable.oslonska,R.drawable.oslonskaavatar);
    public static Dorosle Pacak =new Dorosle(R.drawable.pacakstroj,"Pacak","Klaudia","Katowice","179","22",R.drawable.pacak,R.drawable.pacakavatar);
    public static Dorosle Rakoczy =new Dorosle(R.drawable.rakoczystroj,"Rakoczy","Klaudia","Ostrzeszów","170","21",R.drawable.rakoczy,R.drawable.rakoczyavatar);
    public static Dorosle Sieczkarek =new Dorosle(R.drawable.sieczkarekstroj,"Sieczkarek","Klaudia","Poznań","173","26",R.drawable.sieczarek,R.drawable.sieczarekavatar);
    public static Dorosle Sokowicz =new Dorosle(R.drawable.sokowiczstroj,"Sokowicz","Paulina","Łęczyca","177","19",R.drawable.sokowicz,R.drawable.sokowiczavatar);
    public static Dorosle Stodzierz =new Dorosle(R.drawable.stodzierzstroj,"Stodzierz","Agata","Turek","170","22",R.drawable.stodierz,R.drawable.stodierzavatar);
    public static Dorosle Stolarska =new Dorosle(R.drawable.stolarskastroj,"Stolarska","Karolina","Osięciny","181","22",R.drawable.stolarska,R.drawable.stolarskaavatar);
    public static Dorosle Tarent =new Dorosle(R.drawable.tarentstroj,"Tarent","Sandra","Dąbrowa","174","18",R.drawable.tarent,R.drawable.tarentavatar);
    public static Dorosle Tomaszewska =new Dorosle(R.drawable.tomaszewskastroj,"Tomaszewska","Joanna","Poznań","177","22",R.drawable.tomaszewska,R.drawable.tomaszewskaavatar);

   //
//    public static Dorosle Wojtkowiak =new Dorosle(R.drawable.wojtkowiakavatar,"Wojtkowiak","Marika","Warszawa","168","25",R.drawable.wojtkowiak,R.drawable.wojtkowiak);
    //

    public static Dorosle Zawrocka =new Dorosle(R.drawable.zawrockastroj,"Zawrocka","Klaudia","Budzisław Kościelny","174","24",R.drawable.zawrocka,R.drawable.zawrockaavatar);
    public static Dorosle Żak =new Dorosle(R.drawable.zakstroj,"Żak","Adrianna","Chrzanów","172","23",R.drawable.zak,R.drawable.zakavatar);


    FirebaseDatabase database;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        przywitanie = (TextView) findViewById(R.id.textView);
        dorosle = (ImageView) findViewById(R.id.imageDorosle);
        nastolatki = (ImageView) findViewById(R.id.imageNastolatki);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");




        dorosle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent intent = new Intent(Home.this, AfterDorosle.class);
                startActivity(intent);



                return false;
            }
        });
        nastolatki.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent intent = new Intent(Home.this, AfterNastolatki.class);
                startActivity(intent);



                return false;
            }
        });




    }



}
