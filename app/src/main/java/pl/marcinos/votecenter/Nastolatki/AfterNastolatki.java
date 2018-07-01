package pl.marcinos.votecenter.Nastolatki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.marcinos.votecenter.Dorosle.AfterDorosle;
import pl.marcinos.votecenter.Home;
import pl.marcinos.votecenter.Model.User;
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosle;
import pl.marcinos.votecenter.ModelkiNastolatki.Lista.ListaNastolatkiFinal;
import pl.marcinos.votecenter.ModelkiNastolatki.Lista.listaNastolatki;
import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.MainActivity.user123;

public class AfterNastolatki extends AppCompatActivity {

    Button buttonPierwszaTura;
    Button buttonFinal;
    Button buttonWroc;
    FirebaseDatabase database;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_nastolatki);
        buttonPierwszaTura=(Button)findViewById(R.id.buttonPierwszaTura);
        buttonFinal=(Button)findViewById(R.id.buttonFinal);
        buttonWroc=(Button)findViewById(R.id.buttonWroc);

        buttonPierwszaTura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterNastolatki.this, listaNastolatki.class);
                startActivity(intent);
            }
        });
        buttonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user123.adminScoreNastolatki==1)
                {

                        Intent intent = new Intent(AfterNastolatki.this, ListaNastolatkiFinal.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Witaj w głosowaniu Finalnym",Toast.LENGTH_SHORT).show();

                }
                else if(user123.adminScoreNastolatki!=1)
                {
                    Toast.makeText(getApplicationContext(),"Admin nie pozwala tu wchodzić", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonWroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterNastolatki.this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });










        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        users.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                User admin = dataSnapshot.child("admin").getValue(User.class);

                user123.setAdminScoreNastolatki(admin.getAdminScoreNastolatki());
                user123.setFinalnastolatkiList(admin.getFinalnastolatkiList());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
