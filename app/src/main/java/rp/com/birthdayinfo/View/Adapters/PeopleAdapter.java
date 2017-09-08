package rp.com.birthdayinfo.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rp.com.birthdayinfo.Model.Age;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;



public class PeopleAdapter extends BaseAdapter {

    private Context context;
    private List<People> list;

    public PeopleAdapter(Context context, List<People> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if(v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.people, null);
        }
        People ai = (People) getItem(position);
        TextView txt = (TextView) v.findViewById(R.id.nome);
        TextView txt2 = (TextView) v.findViewById(R.id.cognome);
        TextView txt3 = (TextView) v.findViewById(R.id.eta);
        ImageView img = (ImageView) v.findViewById(R.id.manorwoman);
        txt.setText(ai.getName());
        txt2.setText(ai.getSurname());
        txt3.setText(ai.getEta());
        img.setImageResource(ai.getImage());
        return v;
    }
}
