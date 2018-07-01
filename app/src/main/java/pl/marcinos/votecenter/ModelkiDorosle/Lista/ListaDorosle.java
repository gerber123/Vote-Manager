package pl.marcinos.votecenter.ModelkiDorosle.Lista;

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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pl.marcinos.votecenter.Dorosle.DoroslaFire;
import pl.marcinos.votecenter.Dorosle.Dorosle;
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


public class ListaDorosle extends AppCompatActivity {

    ListView list;
    FirebaseDatabase database;
    DatabaseReference doroslee;
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
        setContentView(R.layout.activity_lista_dorosle);



        list = (ListView)findViewById(R.id.myList);

        final List<Dorosle> DorosleList=new ArrayList<>();
//        DorosleList.add(Baranowska);
        DorosleList.add(Barkova);
        DorosleList.add(Budkowska);
        DorosleList.add(Chrośniak);
        DorosleList.add(CiesielskaAnna);
        DorosleList.add(CiesielskaEwa);
        DorosleList.add(Czajkowska);
        DorosleList.add(Czechowska);
        DorosleList.add(Gonta);
        DorosleList.add(Grzegorczyk);
        DorosleList.add(Hrebennyk);
        DorosleList.add(Imiołek);
//        DorosleList.add(Kacperczyk);
        DorosleList.add(Kalińska);
        DorosleList.add(Kamińska);
        DorosleList.add(Kokocińska);
        DorosleList.add(Kostrzewa);
        DorosleList.add(Kowalczyk);
        DorosleList.add(Maciejewska);
        DorosleList.add(Marczyńska);
        DorosleList.add(Masłowska);
//        DorosleList.add(Nieznańska);
        DorosleList.add(Osłońska);
        DorosleList.add(Pacak);
        DorosleList.add(Rakoczy);
        DorosleList.add(Sieczkarek);
        DorosleList.add(Sokowicz);
        DorosleList.add(Stodzierz);
        DorosleList.add(Stolarska);
        DorosleList.add(Tarent);
        DorosleList.add(Tomaszewska);
        DorosleList.add(Zawrocka);
        DorosleList.add(Żak);


        database=FirebaseDatabase.getInstance();
        doroslee=database.getReference("Dorosle");


        final AdapterListy myAdapter = new AdapterListy(this,DorosleList);
        list.invalidateViews();

//        myAdapter.notifyDataSetChanged();

        list.setAdapter(myAdapter);
//        list.invalidateViews();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                        list.invalidateViews();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==1)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==2)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==3)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==4)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==5)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==6)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2)
                    {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==7)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
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
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==9)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }

                if(position==10)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }

                if(position==11)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==12)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==13)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==14)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==15)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==16)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==17)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==18)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==19)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==20)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==21)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==22)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==23)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==24)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==25)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==26)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==27)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==28)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==29)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2){
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==30)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==31)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==31)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
                    if(Ejzemberg.getPunkty()<=2) {
                        showSignUpDialog(Ejzemberg);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Głosowałeś już na tą dame", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==32)
                {
                    final Dorosle Ejzemberg = DorosleList.get(position);
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

    private void showSignUpDialog(final Dorosle dorosla)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListaDorosle.this);
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

        image=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView3);
        image.setImageResource(dorosla.getImage());
        imageStroj=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView4);
        imageStroj.setImageResource(dorosla.getImageStroj());
        textImie.setText("Imie: "+dorosla.getImie());
        textNazwisko.setText("Nazwisko: "+dorosla.getNazwisko());
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

                final DoroslaFire dorosla1=new DoroslaFire(dorosla.getNazwisko().toString(),dorosla.getImie().toString(),dorosla.getMiejscowosc().toString(),dorosla.getWzrost(),dorosla.getWiek());
                final int ocena=(int)ratingBar.getRating();

                dorosla.punkty+=1;
                list.invalidateViews();
                doroslee.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(dorosla1.getNazwisko()).exists())
                        {
                            DoroslaFire login =dataSnapshot.child(dorosla1.getNazwisko()).getValue(DoroslaFire.class);
                            int a= login.getCalePunkty();
                            int x = a+ocena;
                            login.setCalePunkty(x);
                            doroslee.child(dorosla1.getNazwisko()).setValue(login);
//                }






                        }
                        else
                        {
                            doroslee.child(dorosla1.getNazwisko()).setValue(dorosla1);
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
