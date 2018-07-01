package pl.marcinos.votecenter.Admin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.marcinos.votecenter.Dorosle.DoroslaFire;
import pl.marcinos.votecenter.Dorosle.Dorosle;
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosle;
import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.Home.Barkova;
import static pl.marcinos.votecenter.Home.Budkowska;
import static pl.marcinos.votecenter.Home.Chrośniak;
import static pl.marcinos.votecenter.Home.CiesielskaAnna;
import static pl.marcinos.votecenter.Home.CiesielskaEwa;
import static pl.marcinos.votecenter.Home.Czajkowska;
import static pl.marcinos.votecenter.Home.Czechowska;
import static pl.marcinos.votecenter.Home.Gonta;
import static pl.marcinos.votecenter.Home.Grzegorczyk;
import static pl.marcinos.votecenter.Home.Hrebennyk;
import static pl.marcinos.votecenter.Home.Imiołek;

import static pl.marcinos.votecenter.Home.Kalińska;
import static pl.marcinos.votecenter.Home.Kamińska;
import static pl.marcinos.votecenter.Home.Kokocińska;
import static pl.marcinos.votecenter.Home.Kostrzewa;
import static pl.marcinos.votecenter.Home.Kowalczyk;
import static pl.marcinos.votecenter.Home.Maciejewska;
import static pl.marcinos.votecenter.Home.Marczyńska;
import static pl.marcinos.votecenter.Home.Masłowska;

import static pl.marcinos.votecenter.Home.Osłońska;
import static pl.marcinos.votecenter.Home.Pacak;
import static pl.marcinos.votecenter.Home.Rakoczy;
import static pl.marcinos.votecenter.Home.Sieczkarek;
import static pl.marcinos.votecenter.Home.Sokowicz;
import static pl.marcinos.votecenter.Home.Stodzierz;
import static pl.marcinos.votecenter.Home.Stolarska;
import static pl.marcinos.votecenter.Home.Tarent;
import static pl.marcinos.votecenter.Home.Tomaszewska;

import static pl.marcinos.votecenter.Home.Zawrocka;
import static pl.marcinos.votecenter.Home.Żak;

public class DoroslePierwszaTuraAdmin extends AppCompatActivity {
    ListView listt;
    FirebaseDatabase database;
    TextView textOcena;
    RatingBar ratingBar;
    ImageView image;
    TextView textImie;
    TextView textNazwisko;
    TextView textWiek;
    TextView textMiejscowosc;
    DatabaseReference doroslee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorosle_pierwsza_tura_admin);
        listt = (ListView)findViewById(R.id.myList);


        final List<Dorosle> DorosleList=new ArrayList<>();
        final Dorosle[] DorosleTablica = new Dorosle[]{CiesielskaEwa,Barkova,Budkowska,Chrośniak,CiesielskaAnna,Czajkowska,Czechowska,Gonta,Grzegorczyk,Hrebennyk,Imiołek,Kalińska,Kamińska,Kokocińska,Kostrzewa,Kowalczyk,Maciejewska,Marczyńska,Masłowska,Osłońska,Pacak,Rakoczy,Sieczkarek,Sokowicz,Stodzierz,Stolarska,Tarent,Tomaszewska,Zawrocka,Żak };

        database=FirebaseDatabase.getInstance();
        doroslee =database.getReference("Dorosle");



        doroslee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                DorosleList.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    DoroslaFire modeleczka = postSnapshot.getValue(DoroslaFire.class);
                    for(int i=0;i<DorosleTablica.length;i++){
                        if(modeleczka.getNazwisko().equalsIgnoreCase(DorosleTablica[i].getNazwisko())&&modeleczka.getImie().equalsIgnoreCase(DorosleTablica[i].getImie()))
                        {
                            DorosleTablica[i].setCalePunkty(modeleczka.getCalePunkty());
                            DorosleTablica[i].setPunktyFinalne(modeleczka.getPunktyFinalne());
                            DorosleList.add(DorosleTablica[i]);


                        }
                        else
                        {
                        }

                    }
                    Collections.reverse(DorosleList);

                    AdapterListyAdminDorosle myAdapterr = new AdapterListyAdminDorosle(DoroslePierwszaTuraAdmin.this,DorosleList);


                    listt.setAdapter(myAdapterr);
                }





                Log.d("TAG", "" + dataSnapshot.getChildren());

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
