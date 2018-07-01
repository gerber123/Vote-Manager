package pl.marcinos.votecenter.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.marcinos.votecenter.R;

import static pl.marcinos.votecenter.MainActivity.admin123;
import static pl.marcinos.votecenter.MainActivity.user123;

public class NastUstawieniaAdmin extends AppCompatActivity {
    Button buttonOn;
    Button buttonOff;
    Button buttonNastolatki;
    Button buttonDorosle;
    TextView textOnOff;
    FirebaseDatabase database;
    DatabaseReference users;
    TextView TextViewResult;
    EditText editText;
    Button buttonZatwierdz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nast_ustawienia_admin);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        final EditText editText = (EditText)findViewById(R.id.EditText);
        Button buttonZatwierdz = (Button)findViewById(R.id.buttonZatwierdz);
        TextViewResult = (TextView)findViewById(R.id.texInfooo);
        TextViewResult.setText("Aktualnie w finale będzie: \n"+ admin123.getFinalnastolatkiList()+" modelek");

        buttonZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(editText.getText().toString().equals(""))
                {
                    TextViewResult.setText("Aktualnie w finale będzie: ");
                    Toast.makeText(getApplicationContext(),"Podaj liczbe modelek",Toast.LENGTH_SHORT).show();

                }
                else {
//                    double input = Double.parseDouble(editText.getText().toString());
                    int input = Integer.parseInt(editText.getText().toString());
                    TextViewResult.setText("Aktualnie w finale będzie: \n" + Integer.toString(input) + " modelek");
                    admin123.setAdminScoreNastolatki(1);
                    admin123.setVoteScore(admin123.getVoteScore());
                    admin123.setEmail(admin123.getEmail());
                    admin123.setUserName(admin123.getUserName());
                    admin123.setPassword(admin123.getPassword());
                    admin123.setFinalnastolatkiList((int)input);
                    users.child("admin").setValue(admin123);
                    Toast.makeText(getApplicationContext(),"Zaaktualizowałeś listę finalną",Toast.LENGTH_SHORT).show();

                }
            }
        });
        buttonOn=(Button)findViewById(R.id.buttonOn);
        buttonOff=(Button)findViewById(R.id.buttonOff);
        textOnOff=(TextView)findViewById(R.id.textOnOff);
        if(admin123.getAdminScoreNastolatki()==1)
        {
            textOnOff.setText("włączony");
        }
        else
        {
            textOnOff.setText("wyłączony");
        }
        buttonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textOnOff.setText("Włączony");

                admin123.setAdminScoreNastolatki(1);
                admin123.setVoteScore(admin123.getVoteScore());
                admin123.setEmail(admin123.getEmail());
                admin123.setUserName(admin123.getUserName());
                admin123.setPassword(admin123.getPassword());
                users.child("admin").setValue(admin123);
                Toast.makeText(getApplicationContext(),"Włączyłeś ranking finalny",Toast.LENGTH_LONG).show();


            }
        });
        buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textOnOff.setText("Wyłączony");
                admin123.setAdminScoreNastolatki(0);

                admin123.setVoteScore(admin123.getVoteScore());
                admin123.setEmail(admin123.getEmail());
                admin123.setUserName(admin123.getUserName());
                admin123.setPassword(admin123.getPassword());
                users.child("admin").setValue(admin123);
                Toast.makeText(getApplicationContext(),"Wyłączyłeś ranking finalny",Toast.LENGTH_LONG).show();




            }
        });






    }
}

