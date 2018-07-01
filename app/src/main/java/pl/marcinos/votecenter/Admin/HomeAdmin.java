package pl.marcinos.votecenter.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.votecenter.Dorosle.AfterDorosle;
import pl.marcinos.votecenter.Home;
import pl.marcinos.votecenter.Model.User;
import pl.marcinos.votecenter.Nastolatki.NastolatkaFire;
import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.MainActivity.admin123;

public class HomeAdmin extends AppCompatActivity {

    Button buttonOn;
    Button buttonOff;
    Button buttonNastolatki;
    Button buttonDorosle;
    TextView textOnOff;
    FirebaseDatabase database;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);


        buttonNastolatki=(Button)findViewById(R.id.buttonNastolatki);
        buttonDorosle=(Button)findViewById(R.id.buttonDorosle);
        buttonNastolatki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdmin.this, NastolatkiAdmin.class);
                startActivity(intent);
            }
        });
        buttonDorosle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdmin.this, DorosleAdmin.class);
                startActivity(intent);
            }
        });
        database= FirebaseDatabase.getInstance();
        users =database.getReference("Users");



        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



            User admin = dataSnapshot.child("admin").getValue(User.class);
            admin123.setFinaldorosleList(admin.getFinaldorosleList());
            admin123.setFinalnastolatkiList(admin.getFinalnastolatkiList());
            admin123.setAdminScore(admin.getAdminScore());
            admin123.setAdminScoreNastolatki(admin.getAdminScoreNastolatki());

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        database = FirebaseDatabase.getInstance();
//        users = database.getReference("Users");
//
//        buttonOn=(Button)findViewById(R.id.buttonOn);
//        buttonOff=(Button)findViewById(R.id.buttonOff);
//        textOnOff=(TextView)findViewById(R.id.textOnOff);
//        textOnOff.setText("Wyłączony");
//        buttonOn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                        textOnOff.setText("Włączony");
//                        admin123.setAdminScore(1);
//                        admin123.setVoteScore(admin123.getVoteScore());
//                        admin123.setEmail(admin123.getEmail());
//                        admin123.setUserName(admin123.getUserName());
//                        admin123.setPassword(admin123.getPassword());
//                        users.child("admin").setValue(admin123);
//
//
//
//            }
//        });
//        buttonOff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                        textOnOff.setText("Wyłączony");
//                        admin123.setAdminScore(0);
//
//                        admin123.setVoteScore(admin123.getVoteScore());
//                        admin123.setEmail(admin123.getEmail());
//                        admin123.setUserName(admin123.getUserName());
//                        admin123.setPassword(admin123.getPassword());
//                        users.child("admin").setValue(admin123);
//
//
//
//            }
//        });






    }
}
