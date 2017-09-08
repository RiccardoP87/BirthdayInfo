package rp.com.birthdayinfo.Model;


import android.content.Context;

import rp.com.birthdayinfo.R;

public class ArabianHoroscop {

    private String desc,details;
    private int in;
    private Context con;
    private int icon;

    public ArabianHoroscop(int is,Context c){
        this.in = is;
        this.con = c;
        computeZodiac(in);
    }


    private void computeZodiac(int in) {
        switch (in){
            case 0:
                icon = R.drawable.pugnale;
                details = con.getString(R.string.pugnale);
                desc = con.getResources().getString(R.string.pugnale_s);
                break;
            case 1:
                icon = R.drawable.coltellaccio;
                details = con.getString(R.string.coltellaccio);
                desc = con.getResources().getString(R.string.coltellaccio_s);
                break;
            case 2:
                icon = R.drawable.coltello;
                details = con.getString(R.string.coltello);
                desc = con.getResources().getString(R.string.coltello_s);
                break;
            case 3:
                icon = R.drawable.kriss;
                details = con.getString(R.string.kriss);
                desc = con.getResources().getString(R.string.kriss_s);
                break;
            case 4:
                icon = R.drawable.ascia;
                details = con.getString(R.string.ascia);
                desc = con.getResources().getString(R.string.ascia_s);
                break;
            case 5:
                icon = R.drawable.clava;
                details = con.getString(R.string.clava);
                desc = con.getResources().getString(R.string.clava_s);
                break;
            case 6:
                icon = R.drawable.mazza;
                details = con.getString(R.string.mazza);
                desc = con.getResources().getString(R.string.mazza_s);
                break;
            case 7:
                icon = R.drawable.catena;
                details = con.getString(R.string.catena);
                desc = con.getResources().getString(R.string.catena_s);
                break;
            case 8:
                icon = R.drawable.lancia;
                details = con.getString(R.string.lancia);
                desc = con.getResources().getString(R.string.lancia_s);
                break;
            case 9:
                icon = R.drawable.fionda;
                details = con.getString(R.string.fionda);
                desc = con.getResources().getString(R.string.fionda_s);
                break;
            case 10:
                icon = R.drawable.spada;
                details = con.getString(R.string.spada);
                desc = con.getResources().getString(R.string.spada_s);
                break;
            case 11:
                icon = R.drawable.arco;
                details = con.getString(R.string.arco);
                desc = con.getResources().getString(R.string.arco_s);
                break;
        }
    }

    public String getDesc() {
        return desc;
    }

    public String getDetails() {
        return details;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}
