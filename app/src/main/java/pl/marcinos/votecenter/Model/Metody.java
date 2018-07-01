package pl.marcinos.votecenter.Model;

/**
 * Created by marci on 26.06.2018.
 */

public class Metody {



//    private void showSignUpDialog(final Nastolatki nastolatka)
//    {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NastolatkiFinalTuraAdmin.this);
//        alertDialog.setTitle("Głosowanie");
//        alertDialog.setMessage("Zaznacz swoja ocene");
//
//
//        LayoutInflater inflater =this.getLayoutInflater();
//        View pokaz_modelke_view=inflater.inflate(R.layout.pokazmodelkefinal,null);
//        textOcena=(TextView)pokaz_modelke_view.findViewById(R.id.textOcena);
//        ratingBar=(RatingBar)pokaz_modelke_view.findViewById(R.id.ratingBar);
//        ratingBar.setStepSize(1);
//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                int a =(int)ratingBar.getRating();
//                textOcena.setText("Twoja Ocena: "+a*100);
//            }
//        });
//
//        textImie=(TextView)pokaz_modelke_view.findViewById(R.id.textImie);
//        textNazwisko=(TextView) pokaz_modelke_view.findViewById(R.id.textNazwisko);
//
//        image=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView3);
//        image.setImageResource(nastolatka.getImage());
//        textImie.setText("Imie: "+nastolatka.getImie());
//        textNazwisko.setText("Nazwisko: "+nastolatka.getNazwisko());
//        alertDialog.setView(pokaz_modelke_view);
//
//        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        alertDialog.setPositiveButton("Oddaj Głos", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                final NastolatkaFire dorosla1=new NastolatkaFire(nastolatka.getNazwisko().toString(),nastolatka.getImie().toString(),nastolatka.getMiejscowosc().toString(),nastolatka.getWzrost(),nastolatka.getWiek());
//                final int ocena=(int)ratingBar.getRating()*100;
//                nastolatka.punktyf+=ocena;
//                nastolatkii.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.child(dorosla1.getNazwisko()).exists())
//                        {
//                            NastolatkaFire login =dataSnapshot.child(dorosla1.getNazwisko()).getValue(NastolatkaFire.class);
//
//                            int a= login.getPunktyFinalne();
//                            int x = a+ocena;
//                            login.setPunktyFinalne(x);
//                            nastolatkii.child(dorosla1.getNazwisko()).setValue(login);
//
//
//
//
//
//
//
//                        }
//                        else
//                        {
//
//
//                            nastolatkii.child(dorosla1.getNazwisko()).setValue(dorosla1);
//                        }
//                    }
//
//
//
//
//
//
//
//
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError)
//                    {
//
//                    } });
//
//
//
//
//                Toast.makeText(getApplicationContext(),"Dziękuje za głos",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alertDialog.show();
//
//    }




//    private void showSignUpDialog(final Dorosle dorosla)
//    {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DorosleTop15Tura.this);
//        alertDialog.setTitle("Głosowanie");
//        alertDialog.setMessage("Zaznacz swoja ocene");
//
//
//        LayoutInflater inflater =this.getLayoutInflater();
//        View pokaz_modelke_view=inflater.inflate(R.layout.pokazmodelke,null);
//        textOcena=(TextView)pokaz_modelke_view.findViewById(R.id.textOcena);
//        ratingBar=(RatingBar)pokaz_modelke_view.findViewById(R.id.ratingBar);
//        ratingBar.setStepSize(1);
//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                int a =(int)ratingBar.getRating();
//                textOcena.setText("Twoja Ocena: "+a*100);
//            }
//        });
//
//        textImie=(TextView)pokaz_modelke_view.findViewById(R.id.textImie);
//        textNazwisko=(TextView) pokaz_modelke_view.findViewById(R.id.textNazwisko);
//
//        image=(ImageView)pokaz_modelke_view.findViewById(R.id.imageView3);
//        image.setImageResource(dorosla.getImage());
//        textImie.setText("Imie: "+dorosla.getImie());
//        textNazwisko.setText("Nazwisko: "+dorosla.getNazwisko());
//        alertDialog.setView(pokaz_modelke_view);
//
//        alertDialog.setNegativeButton("Wróć", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        alertDialog.setPositiveButton("Oddaj Głos", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                final DoroslaFire dorosla1=new DoroslaFire(dorosla.getNazwisko().toString(),dorosla.getImie().toString(),dorosla.getMiejscowosc().toString(),dorosla.getWzrost(),dorosla.getWiek());
//                final int ocena=(int)ratingBar.getRating()*100;
//                dorosla.punktyFinalnetop15sprawdz +=ocena;
//                dorosleee.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.child(dorosla1.getNazwisko()).exists())
//                        {
//                            DoroslaFire login =dataSnapshot.child(dorosla1.getNazwisko()).getValue(DoroslaFire.class);
//
//                            int a= login.getPunktyFinalnetop15();
//                            int x = a+ocena;
//                            login.setPunktyFinalnetop15(x);
//                            dorosleee.child(dorosla1.getNazwisko()).setValue(login);
//
//
//
//
//
//
//
//                        }
//                        else
//                        {
//
//
//                            dorosleee.child(dorosla1.getNazwisko()).setValue(dorosla1);
//                        }
//                    }
//
//
//
//
//
//
//
//
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError)
//                    {
//
//                    } });
//
//
//
//
//                Toast.makeText(getApplicationContext(),"Dziękuje za głos",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alertDialog.show();
//
//    }

}
