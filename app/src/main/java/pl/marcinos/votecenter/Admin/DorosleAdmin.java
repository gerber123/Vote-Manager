package pl.marcinos.votecenter.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.marcinos.votecenter.R;

public class DorosleAdmin extends AppCompatActivity {

    Button buttonPodgladu;
    Button buttonUstawienia;
    Button buttonWinners;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorosle_admin);
        buttonPodgladu=(Button)findViewById(R.id.buttonpodglad);
        buttonPodgladu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DorosleAdmin.this, PodgladDorosleAdmin.class);
                startActivity(intent);
            }
        });
        buttonUstawienia=(Button)findViewById(R.id.buttonzmienUstawienia);
        buttonUstawienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DorosleAdmin.this, DoroUstawieniaAdmin.class);
                startActivity(intent);
            }
        });
        buttonWinners=(Button)findViewById(R.id.buttonWinners);
        buttonWinners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DorosleAdmin.this, HomeAdmin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}