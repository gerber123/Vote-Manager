package pl.marcinos.votecenter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by marci on 17.04.2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView imie, nazwisko;
    public ImageView obrazek, overflow;
    public CardView cardView;

    public MyViewHolder(View view)
    {
        super(view);
        imie = (TextView) view.findViewById(R.id.textImie);
        nazwisko = (TextView) view.findViewById(R.id.textNazwisko);
        obrazek = (ImageView) view.findViewById(R.id.imageView3);

    }
}