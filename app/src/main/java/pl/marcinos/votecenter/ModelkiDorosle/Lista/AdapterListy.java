package pl.marcinos.votecenter.ModelkiDorosle.Lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.marcinos.votecenter.Dorosle.Dorosle;
import pl.marcinos.votecenter.R;

/**
 * Created by marci on 02.04.2018.
 */

public class AdapterListy extends BaseAdapter{
    private Context context;
    private List<Dorosle> DorosleList;
    private LayoutInflater layoutInflater;
    int[] Images = {R.drawable.pierwsza,R.drawable.druga,R.drawable.trzecia,R.drawable.czwarta,R.drawable.piata,R.drawable.szosta};

    public AdapterListy(Context context, List<Dorosle> potworyList)
    {
        this.context=context;
        this.DorosleList=potworyList;

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


        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder= new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.customlayout,parent,false);
            viewHolder.nazwisko=(TextView)convertView.findViewById((R.id.textView_nazwisko));
            viewHolder.imie=(TextView)convertView.findViewById((R.id.textView_imie));
            viewHolder.miejscowosc=(TextView)convertView.findViewById((R.id.textView_miejscowosc));
            viewHolder.wzrost=(TextView)convertView.findViewById((R.id.textView_wzrost));
            viewHolder.wiek=(TextView)convertView.findViewById((R.id.textView_wiek));
            viewHolder.img=(ImageView)convertView.findViewById((R.id.imageView2));
            viewHolder.tura=(TextView)convertView.findViewById((R.id.textView_tura));

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder =  (ViewHolder)convertView.getTag();
        }



        viewHolder.imie.setText("Imię: "+DorosleList.get(position).getImie());
        viewHolder.nazwisko.setText("Nazwisko: "+DorosleList.get(position).getNazwisko());
        viewHolder.miejscowosc.setText("Miejscowość: "+DorosleList.get(position).getMiejscowosc());
        viewHolder.wzrost.setText("Wiek: "+ DorosleList.get(position).getWiek()+" lat");
        viewHolder.wiek.setText("Wzrost: "+DorosleList.get(position).getWzrost()+" cm");

        viewHolder.img.setImageResource(DorosleList.get(position).getImageAvatar());
//        viewHolder.img.setImageResource(Images[position]);
        if(DorosleList.get(position).getPunkty()==0)
        {
            viewHolder.tura.setText("Wyjście: I");

        }
        if(DorosleList.get(position).getPunkty()==1)
        {
            viewHolder.tura.setText("Wyjście: II");

        }
        if(DorosleList.get(position).getPunkty()==2)
        {
            viewHolder.tura.setText("Wyjście: III");

        }
        if(DorosleList.get(position).getPunkty()>2)
        {
            viewHolder.tura.setText("Wyjście: Brak");

        }
        return convertView;
    }
    class ViewHolder
    {

        TextView nazwisko;
        TextView imie;
        TextView miejscowosc;
        TextView wzrost;
        TextView wiek;
        TextView tura;

        ImageView img;

    }
}
