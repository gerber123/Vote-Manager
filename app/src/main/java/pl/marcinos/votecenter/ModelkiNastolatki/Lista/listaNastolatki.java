package pl.marcinos.votecenter.ModelkiNastolatki.Lista;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.votecenter.Dorosle.Dorosle;
import pl.marcinos.votecenter.MainActivity;
import pl.marcinos.votecenter.Model.User;
import pl.marcinos.votecenter.MyViewHolder;
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

public class listaNastolatki extends AppCompatActivity {

    ListView list;
    FirebaseDatabase database;
    DatabaseReference nastolatkii;
    TextView textImie;
    ImageView image;
    ImageView imageStroj;
    TextView textNazwisko;
    TextView textWiek;
    TextView textMiejscowosc;
    TextView textOcena;
    RatingBar ratingBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_nastolatki);


        list = (ListView)findViewById(R.id.myList);

        final List<Nastolatki> NastolatkiList=new ArrayList<>();
        NastolatkiList.add(Ejzemberg);
        NastolatkiList.add(Grządziela);
        NastolatkiList.add(Grzesiak);
        NastolatkiList.add(Jung);
        NastolatkiList.add(Ławrynowicz);
        NastolatkiList.add(Majewska);
        NastolatkiList.add(Niedziałek);
        NastolatkiList.add(Pływaczyk);
        NastolatkiList.add(Pokojowa);
        NastolatkiList.add(Żok);

        database=FirebaseDatabase.getInstance();
        nastolatkii=database.getReference("Nastolatki");

        AdapterListy myAdapter = new AdapterListy(this,NastolatkiList);

        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
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
                    if(Ejzemberg.getPunkty()<=2) {
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
                    if(Ejzemberg.getPunkty()<=2) {
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
                    if(Ejzemberg.getPunkty()<=2) {
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
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==5)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==6)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==7)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==8)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==9)
                {
                    final Nastolatki Ejzemberg = NastolatkiList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(listaNastolatki.this);
        alertDialog.setTitle("Głosowanie");
        alertDialog.setMessage("Zaznacz swoja ocene");


        LayoutInflater inflater =this.getLayoutInflater();
        View pokaz_modelke_view=inflater.inflate(R.layout.pokazmodelke,null);
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
//        textWiek=(TextView) pokaz_modelke_view.findViewById(R.id.textWiek);
//        textMiejscowosc=(TextView) pokaz_modelke_view.findViewById(R.id.textMiejscowosc);
        image=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView3);
        imageStroj=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView4);
        image.setImageResource(nastolatka.getImage());
        imageStroj.setImageResource(nastolatka.getImageStroj());
        textImie.setText("Imie: "+nastolatka.getImie());
        textNazwisko.setText("Nazwisko: "+nastolatka.getNazwisko());
//        textWiek.setText("Wiek: "+nastolatka.getWiek());
//        textMiejscowosc.setText("Miejscowość: "+nastolatka.getMiejscowosc());
        alertDialog.setView(pokaz_modelke_view);
//        alertDialog.setIcon(R.drawable.ic_account_circle_black_24dp);

        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.setPositiveButton("Oddaj Głos", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

   final NastolatkaFire nastolatka1=new NastolatkaFire(nastolatka.getNazwisko().toString(),nastolatka.getImie().toString(),nastolatka.getMiejscowosc().toString(),nastolatka.getWzrost(),nastolatka.getWiek());
                final int ocena=(int)ratingBar.getRating();
                nastolatka.punkty+=1;
                list.invalidateViews();

               nastolatkii.addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(DataSnapshot dataSnapshot) {
                      if(dataSnapshot.child(nastolatka1.getNazwisko()).exists())
                      {
                          NastolatkaFire login =dataSnapshot.child(nastolatka1.getNazwisko()).getValue(NastolatkaFire.class);
                          int a= login.getCalePunkty();
                          int x = a+ocena;
                          login.setCalePunkty(x);
                          nastolatkii.child(nastolatka1.getNazwisko()).setValue(login);
                      }
                      else {
                          nastolatkii.child(nastolatka1.getNazwisko()).setValue(nastolatka1);
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
