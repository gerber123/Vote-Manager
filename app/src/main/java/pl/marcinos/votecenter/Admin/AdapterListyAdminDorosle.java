package pl.marcinos.votecenter.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.marcinos.votecenter.Dorosle.Dorosle;
import pl.marcinos.votecenter.Nastolatki.Nastolatki;
import pl.marcinos.votecenter.R;

/**
 * Created by marci on 28.04.2018.
 */

public class AdapterListyAdminDorosle extends BaseAdapter{

    private Context context;
    private List<Dorosle> DorosleList;
    private LayoutInflater layoutInflater;

    public AdapterListyAdminDorosle(Context context, List<Dorosle> DorosleList)
    {
        this.context=context;
        this.DorosleList=DorosleList;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return DorosleList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {


        AdapterListyAdminDorosle.ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder= new AdapterListyAdminDorosle.ViewHolder();
            convertView=layoutInflater.inflate(R.layout.customlayoutadmin,parent,false);
            viewHolder.nazwisko=(TextView)convertView.findViewById((R.id.textView_nazwisko));
            viewHolder.imie=(TextView)convertView.findViewById((R.id.textView_imie));
            viewHolder.miejscowosc=(TextView)convertView.findViewById((R.id.textView_miejscowosc));
            viewHolder.wzrost=(TextView)convertView.findViewById((R.id.textView_wzrost));
            viewHolder.wiek=(TextView)convertView.findViewById((R.id.textView_wiek));
            viewHolder.punkty=(TextView)convertView.findViewById((R.id.textView_punkty));
            viewHolder.punktyFinalne=(TextView)convertView.findViewById((R.id.textView_punktyFinalne));
            viewHolder.punktytop15=(TextView)convertView.findViewById((R.id.textView_punktyTop15));
            viewHolder.img=(ImageView)convertView.findViewById((R.id.imageView2));


            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder =  (AdapterListyAdminDorosle.ViewHolder)convertView.getTag();
        }



        viewHolder.imie.setText("Imię: "+DorosleList.get(position).getImie());
        viewHolder.nazwisko.setText("Nazwisko: "+DorosleList.get(position).getNazwisko());
        viewHolder.miejscowosc.setText("Miejscowość: "+DorosleList.get(position).getMiejscowosc());
        viewHolder.wzrost.setText("Wiek: "+ DorosleList.get(position).getWiek()+" lat");
        viewHolder.wiek.setText("Wzrost: "+DorosleList.get(position).getWzrost()+" cm");
        viewHolder.punkty.setText("Punkty Top34: "+DorosleList.get(position).getCalePunkty()+"");
       viewHolder.punktyFinalne.setText("Punkty Top10: "+DorosleList.get(position).getPunktyFinalne()+"");
       viewHolder.punktytop15.setText("Punkty Top15: "+DorosleList.get(position).getPunktyFinalnetop15()+"");

        viewHolder.img.setImageResource(DorosleList.get(position).getImageAvatar());
//        viewHolder.img.setImageResource(Images[position]);

        return convertView;
    }
    class ViewHolder
    {

        TextView nazwisko;
        TextView imie;
        TextView miejscowosc;
        TextView wzrost;
        TextView wiek;
        TextView punkty;
      TextView punktyFinalne;
      TextView punktytop15;

        ImageView img;

    }
}


