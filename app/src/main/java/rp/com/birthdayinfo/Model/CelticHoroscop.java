package rp.com.birthdayinfo.Model;

import android.content.Context;

import rp.com.birthdayinfo.R;

public class CelticHoroscop {

    private int in;
    private String desc,details;
    private int icon;
    private Context cont;

    public CelticHoroscop(int in, Context con) {
        this.in = in;
        this.cont = con;
        computeZodiac(in);
    }

    private void computeZodiac(int in) {
        switch (in){
            case 0:
                details=cont.getString(R.string.melo_s);
                icon = R.drawable.melo;
                desc = cont.getResources().getString(R.string.melo);
                break;
            case 1:
                details=cont.getString(R.string.abete_s);
                icon = R.drawable.abete;
                desc = cont.getResources().getString(R.string.abete);
                break;
            case 2:
                details=cont.getString(R.string.olmo_s);
                icon = R.drawable.olmo;
                desc = cont.getResources().getString(R.string.olmo);
                break;
            case 3:
                details=cont.getString(R.string.cipresso_s);
                icon = R.drawable.cipresso;
                desc = cont.getResources().getString(R.string.cipresso);
                break;
            case 4:
                details=cont.getString(R.string.pioppo_s);
                icon = R.drawable.pioppo;
                desc = cont.getResources().getString(R.string.pioppo);
                break;
            case 5:
                details = cont.getString(R.string.cedro_s);
                icon = R.drawable.cedro;
                desc = cont.getResources().getString(R.string.cedro);
                break;
            case 6:
                details = cont.getString(R.string.pino_s);
                icon = R.drawable.pino;
                desc = cont.getResources().getString(R.string.pino);
                break;
            case 7:
                details = cont.getString(R.string.salix_s);
                icon = R.drawable.salix;
                desc = cont.getResources().getString(R.string.salice);
                break;
            case 8:
                details = cont.getString(R.string.tiglio_s);
                icon = R.drawable.tiglio;
                desc = cont.getResources().getString(R.string.tiglio);
                break;
            case 9:
                details = cont.getString(R.string.quercia_s);
                icon = R.drawable.quercia;
                desc = cont.getResources().getString(R.string.quercia);
                break;
            case 10:
                details = cont.getString(R.string.nocciolo_s);
                icon = R.drawable.nocciolo;
                desc = cont.getResources().getString(R.string.nocciolo);
                break;
            case 11:
                details = cont.getString(R.string.corniolo_s);
                icon = R.drawable.corniolo;
                desc = cont.getResources().getString(R.string.corniolo);
                break;
            case 12:
                details = cont.getString(R.string.acero_s);
                icon = R.drawable.acero;
                desc = cont.getResources().getString(R.string.acero);
            case 13:
                details = cont.getString(R.string.noce_s);
                icon = R.drawable.noce;
                desc = cont.getResources().getString(R.string.noce);
                break;
            case 14:
                details = cont.getString(R.string.castagno_s);
                icon = R.drawable.castagno;
                desc = cont.getResources().getString(R.string.castagno);
                break;
            case 15:
                details = cont.getString(R.string.frassino_s);
                icon = R.drawable.frassino;
                desc = cont.getResources().getString(R.string.frassino);
                break;
            case 16:
                details = cont.getString(R.string.carpino_s);
                icon = R.drawable.carpino;
                desc = cont.getResources().getString(R.string.carpino);
                break;
            case 17:
                details = cont.getString(R.string.fico_s);
                icon = R.drawable.fico;
                desc = cont.getResources().getString(R.string.fico);
                break;
            case 18:
                details = cont.getString(R.string.betulla_s);
                icon = R.drawable.betulla;
                desc = cont.getResources().getString(R.string.betulla);
                break;
            case 19:
                details = cont.getString(R.string.ulivo_s);
                icon = R.drawable.ulivo;
                desc = cont.getResources().getString(R.string.ulivo);
                break;
            case 20:
                details = cont.getString(R.string.faggio_s);
                icon = R.drawable.faggio;
                desc = cont.getResources().getString(R.string.faggio);
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

