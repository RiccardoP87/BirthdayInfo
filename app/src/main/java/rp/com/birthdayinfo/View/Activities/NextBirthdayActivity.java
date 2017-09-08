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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.andexert.library.RippleView;
import java.util.ArrayList;
import java.util.List;
import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.Preferences;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.Age;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;
import rp.com.birthdayinfo.View.Adapters.AgeAdapter;

public class NextBirthdayActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RippleView back;
    private AppController app;
    private ListView list;
    private List<Age> lista;
    private AgeAdapter adapter;
    private ColorDrawable colors, colors2;
    private FrameLayout frame;
    private TextView t;
    private ImageButton change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        colors = new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark));
        colors2 = new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark));
        setContentView(R.layout.activity_next_birthday);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        app = new AppController(getApplicationContext());
        t = (TextView) findViewById(R.id.oroscopo);
        t.setText(getResources().getString(R.string.di) + " "
                + getIntent().getExtras().getString("Name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(colors);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(colors2.getColor());
        } else {
        }
        frame = (FrameLayout) findViewById(R.id.frame);
        frame.setBackgroundDrawable(colors);
        back = (RippleView) findViewById(R.id.backR);
        back.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(NextBirthdayActivity.this, InduHoroscopActivity.class);
                i.putExtra("Today", getIntent().getExtras().getString("Today"));
                i.putExtra("Name", getIntent().getExtras().getString("Name"));
                i.putExtra("Age", getIntent().getExtras().getString("Age"));
                i.putExtra("Class",NextBirthdayActivity.this.getClass().getSimpleName());
                startActivity(i);
            }
        });
        list = (ListView) findViewById(R.id.lista);
        lista = new ArrayList<>();
        addElementToList();
        change = (ImageButton) findViewById(R.id.imageButton);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NextBirthdayActivity.this,ListPeopleActivity.class);
                i.putExtra("Class",NextBirthdayActivity.this.getClass().getSimpleName());
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                startActivity(i);
            }
        });
    }

    private void addElementToList() {
        for (int i = 0; i < 10; i++) {
            lista.add(new Age(app.setNext(i + 1, getIntent().getExtras().getString("Age"),
                    getIntent().getExtras().getString("Today")),
                    app.computeDayName(app.setNext(i + 1, getIntent().getExtras().getString("Age"),
                            getIntent().getExtras().getString("Today")))));
        }
        adapter = new AgeAdapter(getApplicationContext(), lista);
        list.setAdapter(adapter);
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
                final Intent i = new Intent(NextBirthdayActivity.this, AboutActivity.class);
                i.putExtra("Today", getIntent().getExtras().getString("Today"));
                i.putExtra("Name", getIntent().getExtras().getString("Name"));
                i.putExtra("Age", getIntent().getExtras().getString("Age"));
                startActivity(i);
                break;
            case R.id.menu_other:
                final Intent apps = new Intent(NextBirthdayActivity.this, OtherApps.class);
                apps.putExtra("Today", getIntent().getExtras().getString("Today"));
                apps.putExtra("Name", getIntent().getExtras().getString("Name"));
                apps.putExtra("Age", getIntent().getExtras().getString("Age"));
                startActivity(apps);
                break;
            case android.R.id.home:
                Intent back = new Intent(getApplicationContext(), InduHoroscopActivity.class);
                back.putExtra("Today", getIntent().getExtras().getString("Today"));
                back.putExtra("Name", getIntent().getExtras().getString("Name"));
                back.putExtra("Age", getIntent().getExtras().getString("Age"));
                startActivity(back);
                break;
            case R.id.menu_settings:
                Intent sett = new Intent(getApplicationContext(), SettingsActivity.class);
                sett.putExtra("Class", this.getClass().getSimpleName());
                sett.putExtra("Today", getIntent().getExtras().getString("Today"));
                sett.putExtra("Name", getIntent().getExtras().getString("Name"));
                sett.putExtra("Age", getIntent().getExtras().getString("Age"));
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