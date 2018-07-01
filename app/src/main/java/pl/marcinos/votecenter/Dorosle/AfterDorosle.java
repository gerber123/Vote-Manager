package pl.marcinos.votecenter.Dorosle;

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

import pl.marcinos.votecenter.Home;
import pl.marcinos.votecenter.Model.User;
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosle;
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosleFinal;
import pl.marcinos.votecenter.ModelkiDorosle.Lista.ListaDorosleTop15;
import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.MainActivity.user123;

public class AfterDorosle extends AppCompatActivity {

    Button buttonPierwszaTura;
    Button buttonFinal;
    Button button15;
    Button buttonWroc;
    FirebaseDatabase database;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_dorosle);
        buttonPierwszaTura=(Button)findViewById(R.id.buttonPierwszaTura);
        buttonFinal=(Button)findViewById(R.id.buttonFinal);
        button15=(Button)findViewById(R.id.buttonTop15);
        buttonWroc=(Button)findViewById(R.id.buttonWroc);

        buttonPierwszaTura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterDorosle.this, ListaDorosle.class);
                startActivity(intent);
            }
        });
        buttonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user123.adminScore==1)
                {

                    Intent intent = new Intent(AfterDorosle.this,  ListaDorosleFinal.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Witaj w głosowaniu TOP 10",Toast.LENGTH_SHORT).show();

                }
                else if(user123.adminScore!=1)
                {
                    Toast.makeText(getApplicationContext(),"Admin nie pozwala tu wchodzić", Toast.LENGTH_LONG).show();
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user123.getAdminScoretop10()==1)
                {

                    Intent intent = new Intent(AfterDorosle.this,ListaDorosleTop15.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Witaj w głosowaniu TOP 15",Toast.LENGTH_SHORT).show();

                }
                else if(user123.getAdminScoretop10()!=1)
                {
                    Toast.makeText(getApplicationContext(),"Admin nie pozwala tu wchodzić", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonWroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterDorosle.this, Home.class);
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

                user123.setAdminScore(admin.getAdminScore());
                user123.setAdminScoretop10(admin.getAdminScoretop10());
                user123.setFinaldorosleList(admin.getFinaldorosleList());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
