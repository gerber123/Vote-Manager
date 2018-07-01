package pl.marcinos.votecenter.Admin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosleFinal;
import pl.marcinos.votecenter.ModelkiNastolatki.Lista.AdapterListy;
import pl.marcinos.votecenter.ModelkiNastolatki.Lista.ListaNastolatkiFinal;
import pl.marcinos.votecenter.ModelkiNastolatki.Lista.listaNastolatki;
import pl.marcinos.votecenter.Nastolatki.NastolatkaFire;
import pl.marcinos.votecenter.Nastolatki.Nastolatki;
import pl.marcinos.votecenter.R;


import static pl.marcinos.votecenter.Home.Barkova;
import static pl.marcinos.votecenter.Home.Budkowska;
import static pl.marcinos.votecenter.Home.Chrośniak;
import static pl.marcinos.votecenter.Home.CiesielskaAnna;
import static pl.marcinos.votecenter.Home.CiesielskaEwa;
import static pl.marcinos.votecenter.Home.Czajkowska;
import static pl.marcinos.votecenter.Home.Czechowska;
import static pl.marcinos.votecenter.Home.Ejzemberg;
import static pl.marcinos.votecenter.Home.Gonta;
import static pl.marcinos.votecenter.Home.Grzegorczyk;
import static pl.marcinos.votecenter.Home.Grzesiak;
import static pl.marcinos.votecenter.Home.Grządziela;
import static pl.marcinos.votecenter.Home.Hrebennyk;
import static pl.marcinos.votecenter.Home.Imiołek;
import static pl.marcinos.votecenter.Home.Jung;

import static pl.marcinos.votecenter.Home.Kalińska;
import static pl.marcinos.votecenter.Home.Kamińska;
import static pl.marcinos.votecenter.Home.Kokocińska;
import static pl.marcinos.votecenter.Home.Kostrzewa;
import static pl.marcinos.votecenter.Home.Kowalczyk;
import static pl.marcinos.votecenter.Home.Maciejewska;
import static pl.marcinos.votecenter.Home.Majewska;
import static pl.marcinos.votecenter.Home.Marczyńska;
import static pl.marcinos.votecenter.Home.Masłowska;
import static pl.marcinos.votecenter.Home.Niedziałek;

import static pl.marcinos.votecenter.Home.Osłońska;
import static pl.marcinos.votecenter.Home.Pacak;
import static pl.marcinos.votecenter.Home.Pokojowa;
import static pl.marcinos.votecenter.Home.Pływaczyk;
import static pl.marcinos.votecenter.Home.Rakoczy;
import static pl.marcinos.votecenter.Home.Sieczkarek;
import static pl.marcinos.votecenter.Home.Sokowicz;
import static pl.marcinos.votecenter.Home.Stodzierz;
import static pl.marcinos.votecenter.Home.Stolarska;
import static pl.marcinos.votecenter.Home.Tarent;
import static pl.marcinos.votecenter.Home.Tomaszewska;

import static pl.marcinos.votecenter.Home.Zawrocka;
import static pl.marcinos.votecenter.Home.Ławrynowicz;
import static pl.marcinos.votecenter.Home.Żak;
import static pl.marcinos.votecenter.Home.Żok;

public class NastolatkiPierwszaTuraAdmin extends AppCompatActivity {
    ListView listt;
    FirebaseDatabase database;
    DatabaseReference nastolatkii;
    ImageView image;
    TextView textImie;
    TextView textNazwisko;
    TextView textWiek;
    TextView textMiejscowosc;
    TextView textOcena;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nastolatki_pierwsza_tura_admin);
        listt = (ListView)findViewById(R.id.myList);


        final List<Nastolatki> NastolatkiList=new ArrayList<>();
        final Nastolatki[] nastolatkiTablica = new Nastolatki[]{Ejzemberg,Grządziela,Grzesiak,Jung,Ławrynowicz,Majewska,Pływaczyk,Niedziałek,Pokojowa,Żok};
        database=FirebaseDatabase.getInstance();
        nastolatkii =database.getReference("Nastolatki");



        nastolatkii.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                NastolatkiList.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    NastolatkaFire modeleczka = postSnapshot.getValue(NastolatkaFire.class);
                    for(int i=0;i<nastolatkiTablica.length;i++){
                        if(modeleczka.getNazwisko().equalsIgnoreCase(nastolatkiTablica[i].getNazwisko())&&modeleczka.getImie().equalsIgnoreCase(nastolatkiTablica[i].getImie()))
                        {
                            nastolatkiTablica[i].setCalePunkty(modeleczka.getCalePunkty());
                            nastolatkiTablica[i].setPunktyFinalne(modeleczka.getPunktyFinalne());
                            NastolatkiList.add(nastolatkiTablica[i]);


                        }
                        else
                        {
                        }

                    }
//                   listt.setStackFromBottom(true);
                    Collections.reverse(NastolatkiList);
                    AdapterListyAdmina myAdapterr = new AdapterListyAdmina(NastolatkiPierwszaTuraAdmin.this,NastolatkiList);


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