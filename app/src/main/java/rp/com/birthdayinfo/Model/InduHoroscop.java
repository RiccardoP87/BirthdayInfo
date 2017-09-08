package rp.com.birthdayinfo.Model;

import android.content.Context;
import rp.com.birthdayinfo.R;

public class InduHoroscop {
    private String desc,details;
    private int in;
    private Context con;
    private int icon;

    public InduHoroscop(int is,Context c){
        this.in = is;
        this.con = c;
        computeZodiac(in);
    }


    private void computeZodiac(int in) {
        switch (in){
            case 0:
                icon = R.drawable.aries;
                details = con.getString(R.string.aries2_s);
                desc = con.getResources().getString(R.string.ariete2);
                break;
            case 1:
                icon = R.drawable.taurus;
                details = con.getString(R.string.taurus2_s);
                desc = con.getResources().getString(R.string.toro2);
                break;
            case 2:
                icon = R.drawable.gemini;
                details = con.getString(R.string.gemini2_s);
                desc = con.getResources().getString(R.string.gemelli2);
                break;
            case 3:
                icon = R.drawable.cancer;
                details = con.getString(R.string.cancer2_s);
                desc = con.getResources().getString(R.string.cancro2);
                break;
            case 4:
                icon = R.drawable.leo;
                details = con.getString(R.string.leo2_s);
                desc = con.getResources().getString(R.string.leone2);
                break;
            case 5:
                icon = R.drawable.virgo;
                details = con.getString(R.string.virgo2_s);
                desc = con.getResources().getString(R.string.vergine2);
                break;
            case 6:
                icon = R.drawable.libra;
                details = con.getString(R.string.libra2_s);
                desc = con.getResources().getString(R.string.bilancia2);
                break;
            case 7:
                icon = R.drawable.scorpio;
                details = con.getString(R.string.scorpio2_s);
                desc = con.getResources().getString(R.string.scorpione2);
                break;
            case 8:
                icon = R.drawable.sagittarius;
                details = con.getString(R.string.sagi2_s);
                desc = con.getResources().getString(R.string.saggittario2);
                break;
            case 9:
                icon = R.drawable.capricorn;
                details = con.getString(R.string.capri2_s);
                desc = con.getResources().getString(R.string.capricorno2);
                break;
            case 10:
                icon = R.drawable.aquarius;
                details = con.getString(R.string.acqua2_s);
                desc = con.getResources().getString(R.string.acquario2);
                break;
            case 11:
                icon = R.drawable.pisces;
                details = con.getString(R.string.pisces2_s);
                desc = con.getResources().getString(R.string.pesci2);
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