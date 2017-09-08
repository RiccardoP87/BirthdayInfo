package rp.com.birthdayinfo.Model;

import android.content.Context;

import rp.com.birthdayinfo.R;


public class MayanHoroscop {

    private String desc,details;
    private int icon,in;
    private Context con;

    public MayanHoroscop(int in,Context c) {
        this.in = in;
        this.con = c;
        computeZodiac(in);
    }

    private void computeZodiac(int in) {
        switch (in){
            case 0:
                details=con.getString(R.string.luce_s);
                icon = R.drawable.lucertola;
                desc = con.getResources().getString(R.string.lucertola);
                break;
            case 1:
                details=con.getString(R.string.scimmi_m_s);
                icon = R.drawable.scimmia;
                desc = con.getResources().getString(R.string.scimmia_m);
                break;
            case 2:
                details=con.getString(R.string.falco_s);
                icon = R.drawable.falco;
                desc = con.getResources().getString(R.string.falcone);
                break;
            case 3:
                details=con.getString(R.string.giaguari_s);
                icon = R.drawable.giaguaro;
                desc = con.getResources().getString(R.string.giaguaro);
                break;
            case 4:
                details=con.getString(R.string.mcane_s);
                icon = R.drawable.mcane;
                desc = con.getResources().getString(R.string.cane_m);
                break;
            case 5:
                details = con.getString(R.string.snakem_s);
                icon = R.drawable.serpente;
                desc = con.getResources().getString(R.string.serpente);
                break;
            case 6:
                details = con.getString(R.string.leprem_s);
                icon = R.drawable.lepre;
                desc = con.getResources().getString(R.string.lepre_m);
                break;
            case 7:
                details = con.getString(R.string.tarta_s);
                icon = R.drawable.tartaruga;
                desc = con.getResources().getString(R.string.tartaruga);
                break;
            case 8:
                details = con.getString(R.string.pipi_s);
                icon = R.drawable.pipistrello;
                desc = con.getResources().getString(R.string.pipi);
                break;
            case 9:
                details = con.getString(R.string.scorpiom_s);
                icon = R.drawable.scorpione;
                desc = con.getResources().getString(R.string.scorpione_m);
                break;
            case 10:
                details = con.getString(R.string.cervo_s);
                icon = R.drawable.cervo;
                desc = con.getResources().getString(R.string.cervo);
                break;
            case 11:
                details = con.getString(R.string.civetta_s);
                icon = R.drawable.civetta;
                desc = con.getResources().getString(R.string.civetta);
                break;
            case 12:
                details = con.getString(R.string.pavone_s);
                icon = R.drawable.pavone;
                desc = con.getResources().getString(R.string.pavone);
                break;
        }
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

