package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.multidex.MultiDex;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.andexert.library.RippleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;


public class ViewBirthday extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView year,month,week,day,hour,min,sec;
    private RippleView next;
    private String age;
    private AppController app;
    private String text;
    private TextView t;
    private String ages;
    private String text2;
    private ImageButton change;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_view_birthday);
        app = new AppController(getApplicationContext());
        age = getIntent().getExtras().getString("Age");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        t = (TextView) findViewById(R.id.oroscopo);
        text = getIntent().getExtras().getString("Name");
        t.setText(getResources().getString(R.string.di)+" "
                +text);
        text2 = getIntent().getExtras().getString("Today");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getResources().getColor(R.color.bpRed)));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(new
                    ColorDrawable(getResources().getColor(R.color.bpDarker_red)).getColor());
        }else{}
        year = (TextView)findViewById(R.id.textView12);
        month = (TextView)findViewById(R.id.textViewM);
        week = (TextView)findViewById(R.id.textViewS);
        day = (TextView)findViewById(R.id.textViewG);
        hour = (TextView)findViewById(R.id.textViewH);
        min = (TextView)findViewById(R.id.textViewMM);
        sec = (TextView)findViewById(R.id.textViewSEC);
        next = (RippleView) findViewById(R.id.nextR);

        year.setText(app.computeAge(age,text));
        month.setText(app.computeM(age,text));
        week.setText(app.computeW(age,text));
        day.setText(app.computeD(age,text));
        hour.setText(app.computeH(age,text));
        min.setText(app.computeMin(age,text));
        sec.setText(app.computeSec(age,text));

        change = (ImageButton) findViewById(R.id.imageButton);

        next.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(ViewBirthday.this,BirthdayInfoActivity.class);
                i.putExtra("Today",text2);
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                i.putExtra("LoveMOF",getIntent().getExtras().getBoolean("LoveMOF"));
                startActivity(i);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewBirthday.this,ListPeopleActivity.class);
                i.putExtra("Class",ViewBirthday.this.getClass().getSimpleName());
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    @Deprecated
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                final Intent i = new Intent(ViewBirthday.this,AboutActivity.class);
                i.putExtra("Today",text);
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
                break;
            case R.id.menu_other:
                final Intent apps = new Intent(ViewBirthday.this,OtherApps.class);
                apps.putExtra("Today",text);
                apps.putExtra("Name",getIntent().getExtras().getString("Name"));
                apps.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(apps);
                break;
            case android.R.id.home:
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                back.putExtra("Today",text);
                back.putExtra("Name",getIntent().getExtras().getString("Name"));
                back.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(back);
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
