package pl.marcinos.votecenter.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.marcinos.votecenter.R;

public class PodgladDorosleAdmin extends AppCompatActivity {
    Button podgladajPierwszaTure;
    Button podgladajtop15;
    Button podgladawynikifinalu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podglad_dorosle_admin);
        podgladajPierwszaTure=(Button)findViewById(R.id.buttonPierwszaTura);
        podgladajPierwszaTure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PodgladDorosleAdmin.this, DoroslePierwszaTuraAdmin.class);
                startActivity(intent);
            }
        });
        podgladajtop15=(Button)findViewById(R.id.buttonpodgladajtop15);
        podgladajtop15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PodgladDorosleAdmin.this, DorosleTop15Tura.class);
                startActivity(intent);
            }
        });
        podgladawynikifinalu=(Button)findViewById(R.id.buttonFinalPodglad);
        podgladawynikifinalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PodgladDorosleAdmin.this, DorosleFinalTuraAdmin.class);
                startActivity(intent);
            }
        });
    }
}
