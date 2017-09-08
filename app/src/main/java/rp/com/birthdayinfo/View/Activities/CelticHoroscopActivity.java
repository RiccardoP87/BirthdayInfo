package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.support.v4.view.MenuItemCompat;
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.andexert.library.RippleView;
import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.Preferences;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.CelticHoroscop;
import rp.com.birthdayinfo.R;

public class CelticHoroscopActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView zodiac,t12;
    private RippleView next,back,details;
    private int zodiacPosition;
    private LinearLayout container;
    private AppController controller;
    private CircleImageView zodiacIcon;
    private CelticHoroscop celtic;
    private ColorDrawable colors,colors2;
    private FrameLayout frame,frame2;
    private Intent i;
    private boolean isNormal;
    private TextView t,nextt;
    private ImageButton change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        if(!Preferences.getInstance(this).isCeltic()&&!getIntent().hasExtra("Class")){
            Intent i = new Intent(this,ArabianHoroscopoActivity.class);
            i.putExtra("Today",getIntent().getExtras().getString("Today"));
            i.putExtra("Name",getIntent().getExtras().getString("Name"));
            i.putExtra("Age",getIntent().getExtras().getString("Age"));
            startActivity(i);
        }else if(!Preferences.getInstance(this).isCeltic()&&getIntent().hasExtra("Class")){
            Intent i = new Intent(CelticHoroscopActivity.this,MayanHoroscopActivity.class);
            i.putExtra("Today",getIntent().getExtras().getString("Today"));
            i.putExtra("Name",getIntent().getExtras().getString("Name"));
            i.putExtra("Age",getIntent().getExtras().getString("Age"));
            i.putExtra("Class",CelticHoroscopActivity.this.getClass().getSimpleName());
            startActivity(i);
        }
        colors = new ColorDrawable(getResources().getColor(R.color.trifoglio));
        colors2 = new ColorDrawable(getResources().getColor(R.color.erba));
        controller = new AppController(getApplicationContext());
        setContentView(R.layout.activity_celtic_horoscop);
        change = (ImageButton) findViewById(R.id.imageButton);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        t = (TextView) findViewById(R.id.oroscopo);
        t.setText(getResources().getString(R.string.di)+" "
                +getIntent().getExtras().getString("Name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(colors);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(colors2.getColor());
        }else{}
        nextt = (TextView) findViewById(R.id.next);
        setTheNext();
        frame = (FrameLayout) findViewById(R.id.frame);
        frame.setBackgroundDrawable(colors);
        frame2 = (FrameLayout) findViewById(R.id.frame2);
        frame2.setBackgroundDrawable(colors);
        next = (RippleView) findViewById(R.id.nextR);
        back = (RippleView) findViewById(R.id.backR);
        details  = (RippleView) findViewById(R.id.zodiac);
        zodiac = (TextView)findViewById(R.id.textView88);
        container = (LinearLayout)findViewById(R.id.container);
        zodiacIcon = (CircleImageView)findViewById(R.id.zodiacIcon);
        celtic = new CelticHoroscop(computeMySign(getIntent().getExtras().getString("Age")),getApplicationContext());
        t12 = (TextView) findViewById(R.id.textView12);
        t12.setText(controller.computeMonthC(getIntent().getExtras().getString("Age")));
        zodiacIcon.setImageDrawable(getResources().getDrawable(celtic.getIcon()));


        zodiac.setText(celtic.getDesc());


        next.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(CelticHoroscopActivity.this,ArabianHoroscopoActivity.class);
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
            }
        });

        back.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(CelticHoroscopActivity.this,MayanHoroscopActivity.class);
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                i.putExtra("Class",CelticHoroscopActivity.this.getClass().getSimpleName());
                startActivity(i);
            }
        });

        details.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(CelticHoroscopActivity.this,HoroscopActivityDetails.class);
                i.putExtra("Class",CelticHoroscopActivity.this.getClass().getSimpleName());
                i.putExtra("Color",new
                        ColorDrawable(getResources().getColor(R.color.trifoglio)).getColor());
                i.putExtra("Color2",new
                        ColorDrawable(getResources().getColor(R.color.erba)).getColor());
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(CelticHoroscopActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText(getString(R.string.change))
                        .setContentText(getString(R.string.changeT))
                        .setCancelText(getString(R.string.nopeC))
                        .setConfirmText(getString(R.string.addC))
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                                Intent i = new Intent(CelticHoroscopActivity.this,ListPeopleActivity.class);
                                i.putExtra("Class",CelticHoroscopActivity.this.getClass().getSimpleName());
                                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                                startActivity(i);
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Intent i = new Intent(CelticHoroscopActivity.this,MainActivity.class);
                                startActivity(i);
                            }
                        })
                        .show();
            }
        });


    }

    private void setTheNext() {
        if(!Preferences.getInstance(this).isCeltic()){
            if(!Preferences.getInstance(this).isArabo()){
                if(!Preferences.getInstance(this).isIndu()){
                    nextt.setText(getResources().getString(R.string.netx_b));
                }else{
                    nextt.setText(getResources().getString(R.string.i_zod));
                }
            }else{
                nextt.setText(getResources().getString(R.string.h_arab));
            }
        }else{
            nextt.setText(getResources().getString(R.string.celtic));
        }
    }

    private int computeMySign(String age) {
        zodiacPosition = controller.computeSignZodiacCeltic(age);
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
                final Intent i = new Intent(CelticHoroscopActivity.this,AboutActivity.class);
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
                break;
            case R.id.menu_other:
                final Intent apps = new Intent(CelticHoroscopActivity.this,OtherApps.class);
                apps.putExtra("Today",getIntent().getExtras().getString("Today"));
                apps.putExtra("Name",getIntent().getExtras().getString("Name"));
                apps.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(apps);
                break;
            case android.R.id.home:
                Intent back = new Intent(getApplicationContext(), MayanHoroscopActivity.class);
                back.putExtra("Today",getIntent().getExtras().getString("Today"));
                back.putExtra("Name",getIntent().getExtras().getString("Name"));
                back.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(back);
                break;
            case R.id.menu_settings:
                Intent sett = new Intent(getApplicationContext(), SettingsActivity.class);
                sett.putExtra("Class",this.getClass().getSimpleName());
                sett.putExtra("Today",getIntent().getExtras().getString("Today"));
                sett.putExtra("Name",getIntent().getExtras().getString("Name"));
                sett.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(sett);
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
