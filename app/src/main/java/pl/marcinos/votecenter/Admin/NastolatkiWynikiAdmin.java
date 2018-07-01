package pl.marcinos.votecenter.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.votecenter.Nastolatki.NastolatkaFire;
import pl.marcinos.votecenter.Nastolatki.Nastolatki;
import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.Home.Ejzemberg;
import static pl.marcinos.votecenter.Home.Grzesiak;
import static pl.marcinos.votecenter.Home.Grządziela;
import static pl.marcinos.votecenter.Home.Jung;
import static pl.marcinos.votecenter.Home.Majewska;
import static pl.marcinos.votecenter.Home.Niedziałek;
import static pl.marcinos.votecenter.Home.Pokojowa;
import static pl.marcinos.votecenter.Home.Pływaczyk;
import static pl.marcinos.votecenter.Home.Ławrynowicz;
import static pl.marcinos.votecenter.Home.Żok;
import static pl.marcinos.votecenter.MainActivity.admin123;

public class NastolatkiWynikiAdmin extends AppCompatActivity {
    ListView listt;
    FirebaseDatabase database;
    DatabaseReference nastolatkii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nastolatki_wyniki_admin);
        listt = (ListView)findViewById(R.id.myList);


        final List<Nastolatki> NastolatkiList=new ArrayList<>();
        final Nastolatki[] nastolatkiTablica = new Nastolatki[]{Ejzemberg,Grządziela,Grzesiak,Jung,Ławrynowicz,Majewska,Pływaczyk,Niedziałek,Pokojowa,Żok};
        database= FirebaseDatabase.getInstance();
        nastolatkii =database.getReference("Nastolatki");



        nastolatkii.orderByChild("punktyFinalne").addValueEventListener(new ValueEventListener() {
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
                    listt.setStackFromBottom(true);

                    AdapterListyAdmina myAdapterr = new AdapterListyAdmina(NastolatkiWynikiAdmin.this,NastolatkiList);


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
