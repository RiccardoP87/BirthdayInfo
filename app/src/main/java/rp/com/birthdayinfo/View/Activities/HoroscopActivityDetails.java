package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.multidex.MultiDex;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.util.ArrayList;

import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.Preferences;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.ArabianHoroscop;
import rp.com.birthdayinfo.Model.CelticHoroscop;
import rp.com.birthdayinfo.Model.ChineseZodiac;
import rp.com.birthdayinfo.Model.HoroscopoZodiac;
import rp.com.birthdayinfo.Model.HorrorHoscopoZodiac;
import rp.com.birthdayinfo.Model.InduHoroscop;
import rp.com.birthdayinfo.Model.MayanHoroscop;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;

public class HoroscopActivityDetails extends AppCompatActivity {

    private Toolbar toolbar;
    private RippleView back;
    private CollapsingToolbarLayout ctl_zodiac;
    private ImageView iv_zodiac_detail,zodiaco;
    private TextView tv_zodiac_value,zodiac,tv_zodiac_desc_1;
    private HoroscopoZodiac hz;
    private HorrorHoscopoZodiac hz2;
    private ChineseZodiac cz;
    private MayanHoroscop mh;
    private CelticHoroscop ch;
    private ArabianHoroscop ah;
    private InduHoroscop ih;
    private int zodiacPosition;
    private AppController controller;
    private String classes;
    private RelativeLayout backG;
    private Intent i;
    private Intent backI;
    private TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_horoscop_details);
        controller = new AppController(getApplicationContext());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.di)+" "+getIntent().getExtras().getString("Name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getIntent().getExtras().getInt("Color2")));
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(new
                    ColorDrawable(getIntent().getExtras().getInt("Color")).getColor());
        }else{}
        ctl_zodiac = (CollapsingToolbarLayout) findViewById(R.id.ctl_zodiac);
        iv_zodiac_detail = (ImageView) findViewById(R.id.iv_zodiac_detail);
        tv_zodiac_value = (TextView)findViewById(R.id.tv_zodiac_value);
        zodiac = (TextView)findViewById(R.id.zodiac);
        tv_zodiac_desc_1 = (TextView)findViewById(R.id.tv_zodiac_desc_1);
        ctl_zodiac.setBackgroundDrawable(new ColorDrawable(getIntent().getExtras().getInt("Color2")));
        ctl_zodiac.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        zodiaco = (ImageView) findViewById(R.id.zodiaco);
        backG = (RelativeLayout) findViewById(R.id.background);
        backG.setBackgroundDrawable(new ColorDrawable(getIntent().getExtras().getInt("Color")));
        back = (RippleView) findViewById(R.id.backR);
        back.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                switch (getIntent().getExtras().getString("Class")){
                    case "HoroscopActivity":
                        i = new Intent(HoroscopActivityDetails.this,HoroscopActivity.class);
                        break;
                    case "ChineseZodiacActivity":
                        i = new Intent(HoroscopActivityDetails.this,ChineseZodiacActivity.class);
                        break;
                    case "MayanHoroscopActivity":
                        i = new Intent(HoroscopActivityDetails.this,MayanHoroscopActivity.class);
                        break;
                    case "CelticHoroscopActivity":
                        i = new Intent(HoroscopActivityDetails.this,CelticHoroscopActivity.class);
                        break;
                    case "ArabianHoroscopoActivity":
                        i = new Intent(HoroscopActivityDetails.this,ArabianHoroscopoActivity.class);
                        break;
                    case "InduHoroscopActivity":
                        i = new Intent(HoroscopActivityDetails.this,InduHoroscopActivity.class);
                        break;
                }
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
            }
        });
        if(getIntent().hasExtra("Age")){
            if(getIntent().hasExtra("Class")) {
                classes = getIntent().getExtras().getString("Class");
                if (classes.equals("HoroscopActivity")) {
                    if (Preferences.getInstance(getApplicationContext()).isHorror()) {
                        hz2 = new HorrorHoscopoZodiac(computeMySign(getIntent().getExtras().getString("Age"), 0),
                                getApplicationContext());
                        iv_zodiac_detail.setImageResource(hz2.getIcon());
                        tv_zodiac_value.setText(hz2.getDesc());
                        tv_zodiac_desc_1.setText(hz2.getDetails());
                        toolbar.setTitle(hz2.getDesc());
                        tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                        zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.ic_zodiac));
                    } else {
                        hz = new HoroscopoZodiac(computeMySign(getIntent().getExtras().getString("Age"), 0),
                                getApplicationContext());
                        iv_zodiac_detail.setImageResource(hz.getIcon());
                        iv_zodiac_detail.setColorFilter(Color.argb(255, 255, 255, 255));
                        tv_zodiac_value.setText(hz.getDesc());
                        tv_zodiac_desc_1.setText(hz.getDetails());
                        toolbar.setTitle(hz.getDesc());
                        tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                        zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.ic_zodiac));
                    }
                } else if (classes.equals("ChineseZodiacActivity")) {
                    cz = new ChineseZodiac(computeMySign(getIntent().getExtras().getString("Age"), 1),
                            getApplicationContext());
                    iv_zodiac_detail.setImageResource(cz.getIcon());
                    iv_zodiac_detail.setColorFilter(Color.argb(255, 255, 255, 255));
                    tv_zodiac_value.setText(cz.getDesc());
                    tv_zodiac_desc_1.setText(cz.getDetails());
                    toolbar.setTitle(cz.getDesc());
                    tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                    zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.ic_chinese_zodiac));
                } else if (classes.equals("MayanHoroscopActivity")) {
                    mh = new MayanHoroscop(computeMySign(getIntent().getExtras().getString("Age"), 2),
                            getApplicationContext());
                    iv_zodiac_detail.setImageResource(mh.getIcon());
                    iv_zodiac_detail.setColorFilter(Color.argb(255, 255, 255, 255));
                    tv_zodiac_value.setText(mh.getDesc());
                    tv_zodiac_desc_1.setText(mh.getDetails());
                    toolbar.setTitle(mh.getDesc());
                    tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                    zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.mayan));
                } else if (classes.equals("CelticHoroscopActivity")) {
                    ch = new CelticHoroscop(computeMySign(getIntent().getExtras().getString("Age"), 3),
                            getApplicationContext());
                    iv_zodiac_detail.setImageResource(ch.getIcon());
                    tv_zodiac_value.setText(ch.getDesc());
                    tv_zodiac_desc_1.setText(ch.getDetails());
                    toolbar.setTitle(ch.getDesc());
                    tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                    zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.triquetra));
                } else if (classes.equals("ArabianHoroscopoActivity")) {
                    ah = new ArabianHoroscop(computeMySign(getIntent().getExtras().getString("Age"), 4),
                            getApplicationContext());
                    iv_zodiac_detail.setImageResource(ah.getIcon());
                    iv_zodiac_detail.setColorFilter(Color.argb(255, 255, 255, 255));
                    tv_zodiac_value.setText(ah.getDesc());
                    tv_zodiac_desc_1.setText(ah.getDetails());
                    toolbar.setTitle(ah.getDesc());
                    tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                    zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.islamic));
                } else {
                    ih = new InduHoroscop(computeMySign(getIntent().getExtras().getString("Age"), 5),
                            getApplicationContext());
                    iv_zodiac_detail.setImageResource(ih.getIcon());
                    iv_zodiac_detail.setColorFilter(Color.argb(255, 255, 255, 255));
                    tv_zodiac_value.setText(ih.getDesc());
                    tv_zodiac_desc_1.setText(ih.getDetails());
                    toolbar.setTitle(ih.getDesc());
                    tv_zodiac_desc_1.setTextColor(getIntent().getExtras().getInt("Color"));
                    zodiaco.setImageDrawable(getResources().getDrawable(R.drawable.indu));
                }
            }
            }
    }

    private int computeMySign(String age,int index) {
        switch (index){
            case 0:
                zodiacPosition = controller.computeSignZodiac(age);
                break;
            case 1:
                zodiacPosition = controller.computeMySign(age);
                break;
            case 2:
                zodiacPosition = controller.computeSignZodiacMayan(age);
                break;
            case 3:
                zodiacPosition = controller.computeSignZodiacCeltic(age);
                break;
            case 4:
                zodiacPosition = controller.computeSignArab(age);
                break;
            case 5:
                zodiacPosition = controller.computeSignZodiacIndu(age);
                break;
        }
        return zodiacPosition;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    @Deprecated
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                final Intent i = new Intent(HoroscopActivityDetails.this,AboutActivity.class);
                startActivity(i);
                break;
            case R.id.menu_other:
                final Intent apps = new Intent(HoroscopActivityDetails.this,OtherApps.class);
                startActivity(apps);
            case android.R.id.home:
                switch (getIntent().getExtras().getString("Class")){
                    case "HoroscopActivity":
                        backI = new Intent(HoroscopActivityDetails.this,HoroscopActivity.class);
                        break;
                    case "ChineseZodiacActivity":
                        backI = new Intent(HoroscopActivityDetails.this,ChineseZodiacActivity.class);
                        break;
                    case "MayanHoroscopActivity":
                        backI = new Intent(HoroscopActivityDetails.this,MayanHoroscopActivity.class);
                        break;
                    case "CelticHoroscopActivity":
                        backI = new Intent(HoroscopActivityDetails.this,CelticHoroscopActivity.class);
                        break;
                    case "ArabianHoroscopoActivity":
                        backI = new Intent(HoroscopActivityDetails.this,ArabianHoroscopoActivity.class);
                        break;
                    case "InduHoroscopActivity":
                        backI = new Intent(HoroscopActivityDetails.this,InduHoroscopActivity.class);
                        break;
                }
                backI.putExtra("Today",getIntent().getExtras().getString("Today"));
                backI.putExtra("Name",getIntent().getExtras().getString("Name"));
                backI.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(backI);
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        switch (getIntent().getExtras().getString("Class")){
            case "HoroscopActivity":
                i = new Intent(HoroscopActivityDetails.this,HoroscopActivity.class);
                break;
            case "ChineseZodiacActivity":
                i = new Intent(HoroscopActivityDetails.this,ChineseZodiacActivity.class);
                break;
            case "MayanHoroscopActivity":
                i = new Intent(HoroscopActivityDetails.this,MayanHoroscopActivity.class);
                break;
            case "CelticHoroscopActivity":
                i = new Intent(HoroscopActivityDetails.this,CelticHoroscopActivity.class);
                break;
            case "ArabianHoroscopoActivity":
                i = new Intent(HoroscopActivityDetails.this,ArabianHoroscopoActivity.class);
                break;
            case "InduHoroscopActivity":
                i = new Intent(HoroscopActivityDetails.this,InduHoroscopActivity.class);
                break;
        }
        i.putExtra("Today",getIntent().getExtras().getString("Today"));
        i.putExtra("Name",getIntent().getExtras().getString("Name"));
        i.putExtra("Age",getIntent().getExtras().getString("Age"));
        startActivity(i);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
