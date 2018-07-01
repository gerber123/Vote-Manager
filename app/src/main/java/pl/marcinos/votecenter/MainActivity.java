package pl.marcinos.votecenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import pl.marcinos.votecenter.Admin.HomeAdmin;
import pl.marcinos.votecenter.Model.CurrentUser;
import pl.marcinos.votecenter.Model.User;

public class MainActivity extends AppCompatActivity {

    static MaterialEditText edtNewUser;
    MaterialEditText edtNewPassword;
    MaterialEditText edtNewEmail;

    MaterialEditText edtUser, edtPassword;

    Button btnSignUp, btnSignIn;
    FirebaseDatabase database;
    DatabaseReference  users;
    public static CurrentUser user123 = new CurrentUser();
    public static CurrentUser admin123 = new CurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //FireBase
//        btnSignUp.setEnabled(false);
        database=FirebaseDatabase.getInstance();
        users=database.getReference("Users");

        edtUser=(MaterialEditText)findViewById(R.id.edtUserName);
        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);


        btnSignIn=(Button)findViewById(R.id.btn_sign_in);
        btnSignUp=(Button)findViewById(R.id.btn_sign_up);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUpDialog();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(edtUser.getText().toString(),edtPassword.getText().toString());
            }
        });

    }

    private void signIn(final String user, final String pwd)
    {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(user).exists())
                {
                     if(!user.isEmpty())
                     {
                         User login =dataSnapshot.child(user).getValue(User.class);
                         User admin = dataSnapshot.child("admin").getValue(User.class);
                         if(login.getPassword().equals(pwd)&&(login.getVoteScore()==1)) {
                             if(user.equalsIgnoreCase(admin.getUserName()))
                             {
                                 Toast.makeText(MainActivity.this, "Witam Panie Admin!", Toast.LENGTH_SHORT).show();

                                 Intent intent = new Intent(MainActivity.this, HomeAdmin.class);
                                 startActivity(intent);
                                 MainActivity.this.finish();
                                 admin123.setUserName(admin.getUserName());
                                 admin123.setPassword(admin.getPassword());
                                 admin123.setEmail(admin.getEmail());
                                 admin123.setVoteScore(admin.getVoteScore());
                                 admin123.setAdminScore(5);
                                 admin123.setAdminScoreNastolatki(5);
                                 admin123.setAdminScoretop10(5);
                                 admin123.setFinaldorosleList(10);
                                 admin123.setFinalnastolatkiList(5);

                             }
                             else {
                                 Toast.makeText(MainActivity.this, "Zalogowales sie !", Toast.LENGTH_SHORT).show();

                                 Intent intent = new Intent(MainActivity.this, Home.class);
                                 startActivity(intent);
                                 MainActivity.this.finish();
                                 user123.setUserName(login.getUserName());
                                 user123.setPassword(login.getPassword());   
                                 user123.setEmail(login.getEmail());
                                 user123.setVoteScore(login.getVoteScore());
                                 user123.setAdminScore(0);
                                 user123.setAdminScoreNastolatki(0);
                                 user123.setAdminScoretop10(0);
                                 user123.setFinalnastolatkiList(5);
                                 user123.setFinaldorosleList(10);
                             }

                         }
                         else if(admin.getPassword().equals(pwd)) {



                         }

                         else
                             Toast.makeText(MainActivity.this,"Złe hasło",Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                         Toast.makeText(MainActivity.this,"Proszę wypełnic wszystkie pola",Toast.LENGTH_SHORT).show();
                     }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Niema takiego użytkownika",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showSignUpDialog()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Rejestracja");
        alertDialog.setMessage("Prosze wypełnić wszystkie pola");


        LayoutInflater inflater =this.getLayoutInflater();
        View sign_up_layout=inflater.inflate(R.layout.sign_up_layout,null);


        edtNewUser=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewUserName);
        edtNewPassword=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewPassword);
        edtNewEmail=(MaterialEditText)sign_up_layout.findViewById(R.id.edtNewEmail);

        alertDialog.setView(sign_up_layout);
        alertDialog.setIcon(R.drawable.ic_account_circle_black_24dp);

        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.setPositiveButton("Stwórz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final User user=new User(edtNewUser.getText().toString(),edtNewPassword.getText().toString()
                ,edtNewEmail.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUserName()).exists())
                        {
                            Toast.makeText(MainActivity.this,"Taki użytkownik już istnieje", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            users.child(user.getUserName())
                                    .setValue(user);


//                            users.child(user.getUserName()).setValue(edtNewUser.getText().toString());
                            Toast.makeText(MainActivity.this,"Utworzono Konto",Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                dialog.dismiss();
            }
        });

        alertDialog.show();

    }
}
