package rp.com.birthdayinfo.Model;

import android.content.Context;
import rp.com.birthdayinfo.R;

public class HoroscopoZodiac {

    private String desc,details;
    private int in;
    private Context con;
    private int icon;

    public HoroscopoZodiac(int is,Context c){
        this.in = is;
        this.con = c;
        computeZodiac(in);
    }


    private void computeZodiac(int in) {
        switch (in){
            case 0:
                icon = R.drawable.aries;
                details = con.getString(R.string.aries_s);
                desc = con.getResources().getString(R.string.ariete);
                break;
            case 1:
                icon = R.drawable.taurus;
                details = con.getString(R.string.taurus_s);
                desc = con.getResources().getString(R.string.toro);
                break;
            case 2:
                icon = R.drawable.gemini;
                details = con.getString(R.string.gemini_s);
                desc = con.getResources().getString(R.string.gemelli);
                break;
            case 3:
                icon = R.drawable.cancer;
                details = con.getString(R.string.cancer_s);
                desc = con.getResources().getString(R.string.cancro);
                break;
            case 4:
                icon = R.drawable.leo;
                details = con.getString(R.string.leo_s);
                desc = con.getResources().getString(R.string.leone);
                break;
            case 5:
                icon = R.drawable.virgo;
                details = con.getString(R.string.virgo_s);
                desc = con.getResources().getString(R.string.vergine);
                break;
            case 6:
                icon = R.drawable.libra;
                details = con.getString(R.string.libra_s);
                desc = con.getResources().getString(R.string.bilancia);
                break;
            case 7:
                icon = R.drawable.scorpio;
                details = con.getString(R.string.scorpio_s);
                desc = con.getResources().getString(R.string.scorpione);
                break;
            case 8:
                icon = R.drawable.sagittarius;
                details = con.getString(R.string.sagi_s);
                desc = con.getResources().getString(R.string.saggittario);
                break;
            case 9:
                icon = R.drawable.capricorn;
                details = con.getString(R.string.capri_s);
                desc = con.getResources().getString(R.string.capricorno);
                break;
            case 10:
                icon = R.drawable.aquarius;
                details = con.getString(R.string.acqua_s);
                desc = con.getResources().getString(R.string.acquario);
                break;
            case 11:
                icon = R.drawable.pisces;
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