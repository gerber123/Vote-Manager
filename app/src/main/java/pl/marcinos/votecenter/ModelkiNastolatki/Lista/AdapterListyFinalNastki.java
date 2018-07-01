package pl.marcinos.votecenter.ModelkiNastolatki.Lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.marcinos.votecenter.Nastolatki.Nastolatki;
import pl.marcinos.votecenter.R;

/**
 * Created by marci on 07.05.2018.
 */


    public class AdapterListyFinalNastki extends BaseAdapter {
        private Context context;
        private List<Nastolatki> NastolatkiList;
        private LayoutInflater layoutInflater;
        int[] Images = {R.drawable.pierwsza,R.drawable.druga,R.drawable.trzecia,R.drawable.czwarta,R.drawable.piata,R.drawable.szosta};

        public AdapterListyFinalNastki(Context context, List<Nastolatki> NastolatkiList)
        {
            this.context=context;
            this.NastolatkiList=NastolatkiList;

            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return NastolatkiList.size();
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
                convertView=layoutInflater.inflate(R.layout.customlayoutfinal,parent,false);
                viewHolder.nazwisko=(TextView)convertView.findViewById((R.id.textView_nazwisko));
                viewHolder.imie=(TextView)convertView.findViewById((R.id.textView_imie));
                viewHolder.miejscowosc=(TextView)convertView.findViewById((R.id.textView_miejscowosc));
                viewHolder.wzrost=(TextView)convertView.findViewById((R.id.textView_wzrost));
                viewHolder.wiek=(TextView)convertView.findViewById((R.id.textView_wiek));
                viewHolder.img=(ImageView)convertView.findViewById((R.id.imageView2));


                convertView.setTag(viewHolder);
            }
            else
            {

                viewHolder =  (ViewHolder)convertView.getTag();
            }



            viewHolder.imie.setText("Imię: "+NastolatkiList.get(position).getImie());
            viewHolder.nazwisko.setText("Nazwisko: "+NastolatkiList.get(position).getNazwisko());
            viewHolder.miejscowosc.setText("Miejscowość: "+NastolatkiList.get(position).getMiejscowosc());
            viewHolder.wzrost.setText("Wiek: "+ NastolatkiList.get(position).getWiek()+" lat");
            viewHolder.wiek.setText("Wzrost: "+NastolatkiList.get(position).getWzrost()+" cm");

            viewHolder.img.setImageResource(NastolatkiList.get(position).getImageAvatar());

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


            ImageView img;

        }
    }
