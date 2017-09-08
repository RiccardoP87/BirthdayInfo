package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import java.util.ArrayList;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.R;
import rp.com.birthdayinfo.View.Fragments.PreferencesFragment;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Intent backI;

    public static void start(Context context) {
        Intent i = new Intent(context, SettingsActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_settings);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.settings));
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.text));
        }else{}
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, PreferencesFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        switch (getIntent().getExtras().getString("Class")){
            case "HoroscopActivity":
                backI = new Intent(getApplicationContext(),HoroscopActivity.class);
                break;
            case "ChineseZodiacActivity":
                backI = new Intent(getApplicationContext(),ChineseZodiacActivity.class);
                break;
            case "MayanHoroscopActivity":
                backI = new Intent(getApplicationContext(),MayanHoroscopActivity.class);
                break;
            case "CelticHoroscopActivity":
                backI = new Intent(getApplicationContext(),CelticHoroscopActivity.class);
                break;
            case "ArabianHoroscopoActivity":
                backI = new Intent(getApplicationContext(),ArabianHoroscopoActivity.class);
                break;
            case "InduHoroscopActivity":
                backI = new Intent(getApplicationContext(),InduHoroscopActivity.class);
                break;
            case "BirthdayInfoActivity":
                backI = new Intent(getApplicationContext(),BirthdayInfoActivity.class);
                break;
            case "NextBirthdayActivity":
                backI = new Intent(getApplicationContext(),NextBirthdayActivity.class);
                break;
        }
        backI.putExtra("Age",getIntent().getExtras().getString("Age"));
        backI.putExtra("Today",getIntent().getExtras().getString("Today"));
        backI.putExtra("Name",getIntent().getExtras().getString("Name"));
        backI.putExtra("Numb",getIntent().getExtras().getString("Numb"));
        startActivity(backI);
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
            case android.R.id.home:
                switch (getIntent().getExtras().getString("Class")){
                    case "HoroscopActivity":
                        backI = new Intent(getApplicationContext(),HoroscopActivity.class);
                        break;
                    case "ChineseZodiacActivity":
                        backI = new Intent(getApplicationContext(),ChineseZodiacActivity.class);
                        break;
                    case "MayanHoroscopActivity":
                        backI = new Intent(getApplicationContext(),MayanHoroscopActivity.class);
                        break;
                    case "CelticHoroscopActivity":
                        backI = new Intent(getApplicationContext(),CelticHoroscopActivity.class);
                        break;
                    case "ArabianHoroscopoActivity":
                        backI = new Intent(getApplicationContext(),ArabianHoroscopoActivity.class);
                        break;
                    case "InduHoroscopActivity":
                        backI = new Intent(getApplicationContext(),InduHoroscopActivity.class);
                        break;
                    case "BirthdayInfoActivity":
                        backI = new Intent(getApplicationContext(),InduHoroscopActivity.class);
                        break;
                    case "NextBirthdayActivity":
                        backI = new Intent(getApplicationContext(),InduHoroscopActivity.class);
                        break;
                }
                backI.putExtra("Age",getIntent().getExtras().getString("Age"));
                backI.putExtra("Today",getIntent().getExtras().getString("Today"));
                backI.putExtra("Name",getIntent().getExtras().getString("Name"));
                backI.putExtra("Numb",getIntent().getExtras().getString("Numb"));
                startActivity(backI);
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
