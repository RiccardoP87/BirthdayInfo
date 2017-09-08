package rp.com.birthdayinfo.Model;

import android.content.Context;
import rp.com.birthdayinfo.R;

public class HorrorHoscopoZodiac {

    private String desc,details;
    private int in;
    private Context con;
    private int icon;

    public HorrorHoscopoZodiac(int is,Context c){
        this.in = is;
        this.con = c;
        computeZodiac(in);
    }


    private void computeZodiac(int in) {
        switch (in){
            case 0:
                icon = R.drawable.ariete;
                details = con.getString(R.string.aries_s);
                desc = con.getResources().getString(R.string.ariete);
                break;
            case 1:
                icon = R.drawable.toro;
                details = con.getString(R.string.taurus_s);
                desc = con.getResources().getString(R.string.toro);
                break;
            case 2:
                icon = R.drawable.gemelli;
                details = con.getString(R.string.gemini_s);
                desc = con.getResources().getString(R.string.gemelli);
                break;
            case 3:
                icon = R.drawable.cancro;
                details = con.getString(R.string.cancer_s);
                desc = con.getResources().getString(R.string.cancro);
                break;
            case 4:
                icon = R.drawable.leone;
                details = con.getString(R.string.leo_s);
                desc = con.getResources().getString(R.string.leone);
                break;
            case 5:
                icon = R.drawable.vergini;
                details = con.getString(R.string.virgo_s);
                desc = con.getResources().getString(R.string.vergine);
                break;
            case 6:
                icon = R.drawable.bilancia;
                details = con.getString(R.string.libra_s);
                desc = con.getResources().getString(R.string.bilancia);
                break;
            case 7:
                icon = R.drawable.scorpione2;
                details = con.getString(R.string.scorpio_s);
                desc = con.getResources().getString(R.string.scorpione);
                break;
            case 8:
                icon = R.drawable.saggittario;
                details = con.getString(R.string.sagi_s);
                desc = con.getResources().getString(R.string.saggittario);
                break;
            case 9:
                icon = R.drawable.capricorno;
                details = con.getString(R.string.capri_s);
                desc = con.getResources().getString(R.string.capricorno);
                break;
            case 10:
                icon = R.drawable.acquario;
                details = con.getString(R.string.acqua_s);
                desc = con.getResources().getString(R.string.acquario);
                break;
            case 11:
                icon = R.drawable.pesci;
                details = con.getString(R.string.pisces_s);
                desc = con.getResources().getString(R.string.pesci);
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