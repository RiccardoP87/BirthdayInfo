package rp.com.birthdayinfo.Model;


import android.content.Context;

import rp.com.birthdayinfo.R;

public class ChineseZodiac {

    private int in;
    private String desc,details;
    private int icon;
    private Context con;

    public ChineseZodiac(int is,Context c){
        this.in = is;
        this.con = c;
        computeZodiac(in);
    }

    private void computeZodiac(int in) {
        switch (in){
            case 0:
                details=con.getString(R.string.mouse_s);
                icon = R.drawable.mouse;
                desc = con.getResources().getString(R.string.mouse);
                break;
            case 1:
                details=con.getString(R.string.cow_s);
                icon = R.drawable.cow;
                desc = con.getResources().getString(R.string.bufalo);
                break;
            case 2:
                details=con.getString(R.string.tigre_s);
                icon = R.drawable.tiger;
                desc = con.getResources().getString(R.string.tigre);
                break;
            case 3:
                details=con.getString(R.string.cavallo_s);
                icon = R.drawable.horse;
                desc = con.getResources().getString(R.string.cavallo);
                break;
            case 4:
                details=con.getString(R.string.gnu_s);
                icon = R.drawable.gnu;
                desc = con.getResources().getString(R.string.gnu);
                break;
            case 5:
                details = con.getString(R.string.gallo_s);
                icon = R.drawable.cock;
                desc = con.getResources().getString(R.string.gallo);
                break;
            case 6:
                details = con.getString(R.string.lepre_s);
                icon = R.drawable.rabbit;
                desc = con.getResources().getString(R.string.lepre);
                break;
            case 7:
                details = con.getString(R.string.drago_s);
                icon = R.drawable.dragon;
                desc = con.getResources().getString(R.string.drago);
                break;
            case 8:
                details = con.getString(R.string.snake_s);
                icon = R.drawable.snake;
                desc = con.getResources().getString(R.string.serpente);
                break;
            case 9:
                details = con.getString(R.string.scimmia_s);
                icon = R.drawable.monkey;
                desc = con.getResources().getString(R.string.scimmia);
                break;
            case 10:
                details = con.getString(R.string.cane_s);
                icon = R.drawable.dog;
                desc = con.getResources().getString(R.string.cane);
                break;
            case 11:
                details = con.getString(R.string.pig_s);
                icon = R.drawable.pig;
                desc = con.getResources().getString(R.string.cinghiale);
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
