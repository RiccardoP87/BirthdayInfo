package rp.com.birthdayinfo.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import rp.com.birthdayinfo.Model.Age;
import rp.com.birthdayinfo.R;

public class AgeAdapter extends BaseAdapter{

    private Context context;
    private List<Age> list;

    public AgeAdapter(Context context, List<Age> list) {
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
            v = LayoutInflater.from(context).inflate(R.layout.raw_age, null);
        }
        Age ai = (Age) getItem(position);
        TextView txt = (TextView) v.findViewById(R.id.calendar);
        txt.setText(ai.getTitle());
        txt = (TextView) v.findViewById(R.id.age);
        txt.setText(ai.getAge());
        return v;
    }
}
