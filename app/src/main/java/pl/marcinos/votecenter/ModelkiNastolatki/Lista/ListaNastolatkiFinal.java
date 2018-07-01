package pl.marcinos.votecenter.ModelkiNastolatki.Lista;

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

import pl.marcinos.votecenter.ModelkiDorosle.Lista.*;
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
import static pl.marcinos.votecenter.MainActivity.user123;

public class ListaNastolatkiFinal extends AppCompatActivity {
    ListView listt;
    FirebaseDatabase database;
    DatabaseReference nastolatkii;
    ImageView image;
    ImageView imageStroj;
    TextView textImie;
    TextView textNazwisko;
    TextView textWiek;
    TextView textMiejscowosc;
    TextView textOcena;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_nastolatki_final);

        listt = (ListView)findViewById(R.id.myListt);


        final List<Nastolatki> NastolatkiList=new ArrayList<>();
        final Nastolatki[] nastolatkiTablica = new Nastolatki[]{Ejzemberg,Grządziela,Grzesiak,Jung,Ławrynowicz,Majewska,Pływaczyk,Niedziałek,Pokojowa,Żok};
        database=FirebaseDatabase.getInstance();
        nastolatkii =database.getReference("Nastolatki");



        nastolatkii.orderByChild("calePunkty").limitToLast(5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                NastolatkiList.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    NastolatkaFire modeleczka = postSnapshot.getValue(NastolatkaFire.class);
                    for(int i=0;i<nastolatkiTablica.length;i++){
                        if(modeleczka.getNazwisko().equalsIgnoreCase(nastolatkiTablica[i].getNazwisko())&&modeleczka.getImie().equalsIgnoreCase(nastolatkiTablica[i].getImie()))
                        {
                            NastolatkiList.add(nastolatkiTablica[i]);

                        }
                        else
                        {
                        }

                    }
                    Collections.reverse( NastolatkiList);
//                    listt.setStackFromBottom(true);
                    AdapterListyFinalNastki myAdapterr = new AdapterListyFinalNastki(ListaNastolatkiFinal.this,NastolatkiList);


                    listt.setAdapter(myAdapterr);
                }





                Log.d("TAG", "" + dataSnapshot.getChildren());

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunktyf()==0) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==1)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunktyf()==0) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==2)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunktyf()==0) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==3)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunktyf()==0) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==4)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunktyf()==0) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

    }
    private void showSignUpDialog(final Nastolatki nastolatka)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListaNastolatkiFinal.this);
        alertDialog.setTitle("Głosowanie");
        alertDialog.setMessage("Zaznacz swoja ocene");


        LayoutInflater inflater =this.getLayoutInflater();
        View pokaz_modelke_view=inflater.inflate(R.layout.pokazmodelkefinal,null);
        textOcena=(TextView)pokaz_modelke_view.findViewById(R.id.textOcena);
        ratingBar=(RatingBar)pokaz_modelke_view.findViewById(R.id.ratingBar);
        ratingBar.setStepSize(1);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int a =(int)ratingBar.getRating();
                textOcena.setText("Twoja Ocena: "+a);
            }
        });

        textImie=(TextView)pokaz_modelke_view.findViewById(R.id.textImie);
        textNazwisko=(TextView) pokaz_modelke_view.findViewById(R.id.textNazwisko);

        image=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView3);
        imageStroj=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView4);
        image.setImageResource(nastolatka.getImage());
        imageStroj.setImageResource(nastolatka.getImageStroj());
        textImie.setText("Imie: "+nastolatka.getImie());
        textNazwisko.setText("Nazwisko: "+nastolatka.getNazwisko());
        alertDialog.setView(pokaz_modelke_view);

        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.setPositiveButton("Oddaj Głos", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final NastolatkaFire dorosla1=new NastolatkaFire(nastolatka.getNazwisko().toString(),nastolatka.getImie().toString(),nastolatka.getMiejscowosc().toString(),nastolatka.getWzrost(),nastolatka.getWiek());
                final int ocena=(int)ratingBar.getRating();
                nastolatka.punktyf+=ocena;
                nastolatkii.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(dorosla1.getNazwisko()).exists())
                        {
                            NastolatkaFire login =dataSnapshot.child(dorosla1.getNazwisko()).getValue(NastolatkaFire.class);

                            int a= login.getPunktyFinalne();
                            int x = a+ocena;
                            login.setPunktyFinalne(x);
                            nastolatkii.child(dorosla1.getNazwisko()).setValue(login);







                        }
                        else
                        {


                            nastolatkii.child(dorosla1.getNazwisko()).setValue(dorosla1);
                        }
                    }









                    @Override
                    public void onCancelled(DatabaseError databaseError)
                    {

                    } });




                Toast.makeText(getApplicationContext(),"Dziękuje za głos",Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();

    }
}
