package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.andexert.library.RippleView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.Preferences;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.Age;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;
import rp.com.birthdayinfo.View.Adapters.AgeAdapter;
import rp.com.birthdayinfo.View.Adapters.ViewPagerAdapter;
import rp.com.birthdayinfo.View.Fragments.CalendarBirthday;
import rp.com.birthdayinfo.View.Fragments.WikiBirthday;

public class BirthdayInfoActivity extends AppCompatActivity {

    private LinearLayout main,calendarLayout;
    private FrameLayout bottomBar;
    private WebView event;
    private Toolbar toolbar;
    private RippleView next,back;
    private Button close;
    private String url = "";
    private StringBuilder builder;
    private AppController app;
    private ListView list;
    private List<Age> lista;
    private AgeAdapter adapter;
    private TextView age;
    private int index;
    private String[] years = new String[]{"Ab Urbe Condita","Calendario Armeno","Calendario " +
            "Bengalese","Calendario Berbero","Calendario Bizantino","Calendario Buddhista",
            "Calendario Cinese", "Calendario Copto","Calendario Ebraico","Calendario Etiopico",
            "Calendario Vikram Samvat","Calendario Shaka Samvat","Kali Yuga",
            "Calendario Islamico","Calendario Persiano"};
    private FrameLayout frame;
    private ColorDrawable colors,colors2;
    private Intent i;
    private TextView t,nextt;
    private ImageButton change;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapters;
    private int[] tabIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = new AppController(getApplicationContext());
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        colors = new ColorDrawable(getResources().getColor(R.color.cioccolato));
        colors2 = new ColorDrawable(getResources().getColor(R.color.corallo));
        setContentView(R.layout.activity_birthday_info);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        setupTabIcons();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        t = (TextView)findViewById(R.id.oroscopo);
        t.setText(getResources()
                .getString(R.string.di)+" "+getIntent().getExtras().getString("Name"));
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
        main = (LinearLayout) findViewById(R.id.main);
        bottomBar = (FrameLayout)findViewById(R.id.bottomBar);
        event = (WebView)findViewById(R.id.storyc);
        event.getSettings().setJavaScriptEnabled(true);
        event.getSettings().setLoadsImagesAutomatically(true);
        event.setWebViewClient(new WebViewClient());
        url = checkLocal()+computeMyAge(getIntent().getExtras().getString("Age"));
        event.loadUrl(url);
        next = (RippleView) findViewById(R.id.nextR);
        back = (RippleView) findViewById(R.id.backR);
        close = (Button)findViewById(R.id.close);
        change = (ImageButton)findViewById(R.id.imageButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomBar.setVisibility(View.VISIBLE);
                main.setVisibility(View.VISIBLE);
                calendarLayout.setVisibility(View.GONE);
                toolbar.setVisibility(View.VISIBLE);
            }
        });


        next.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(BirthdayInfoActivity.this,HoroscopActivity.class);
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                i.putExtra("LoveMOF",getIntent().getExtras().getBoolean("LoveMOF"));
                startActivity(i);
            }
        });

        back.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(BirthdayInfoActivity.this,ViewBirthday.class);
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BirthdayInfoActivity.this,ListPeopleActivity.class);
                i.putExtra("Class",BirthdayInfoActivity.this.getClass().getSimpleName());
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                startActivity(i);
            }
        });

        calendarLayout = (LinearLayout) findViewById(R.id.cal);
        list = (ListView) findViewById(R.id.ageL);
        lista = new ArrayList<>();
        age = (TextView) findViewById(R.id.age);
        age.setText(app.computeYear(getIntent().getExtras().getString("Age")));
        addElementToList();
    }

    private void setupTabIcons() {
        tabIcons = new int[]{
                R.drawable.history,
                R.drawable.data,
                };


        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);

    }

    private void setupViewPager(ViewPager viewPager) {
        adapters = new ViewPagerAdapter(getSupportFragmentManager());
        adapters.addFrag(new WikiBirthday().newInstance(), "ONE");
        adapters.addFrag(new CalendarBirthday().newInstance(), "TWO");
        viewPager.setAdapter(adapters);
    }

    private void setTheNext() {
        if(!Preferences.getInstance(this).isHoroscopo()){
            if(!Preferences.getInstance(this).isChinese()){
                if(!Preferences.getInstance(this).isMaya()){
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
                }else{
                    nextt.setText(getResources().getString(R.string.mayan));
                }
            }else{
                nextt.setText(getResources().getString(R.string.chinese));
            }
        }else{
            nextt.setText(getResources().getString(R.string.zodi));
        }
    }

    private String checkLocal() {
        switch (Locale.getDefault().getLanguage() ){
            case "it":
                url = "https://it.wikipedia.org/wiki/";
                break;
            case "us":
                url = "https://en.wikipedia.org/wiki/";
                break;
            case "es":
                url = "https://es.wikipedia.org/wiki/";
                break;
            case "fr":
                url = "https://fr.wikipedia.org/wiki/";
                break;
            case "de":
                url = "https://de.wikipedia.org/wiki/";
                break;
            case "hi":
                url = "https://hi.wikipedia.org/wiki/";
                break;
            case "pt":
                url = "https://pt.wikipedia.org/wiki/";
                break;
        }
        return url;
    }

    private void addElementToList() {
        index = 0;
        for(String a:app.getComputedYear(getIntent().getExtras().getString("Age"))){
            lista.add(new Age(years[index],a));
            index++;
        }
        adapter = new AgeAdapter(getApplicationContext(),lista);
        list.setAdapter(adapter);
    }

    @NonNull
    private String computeMyAge(String age) {
        builder = new StringBuilder();
        char[] day = new char[1];
        char[] day2 = new char[2];
        char[] month = new char[2];
        if(age.toCharArray()[0]==48){
            day[0] = age.toCharArray()[1];
            builder.append(day[0]);
        }else{
            day2[0] = age.toCharArray()[0];
            day2[1] = age.toCharArray()[1];
            String s = ""+day2[0]+""+day2[1];
            builder.append(s);
        }
        month[0] = age.toCharArray()[3];
        month[1] = age.toCharArray()[4];
        String s = ""+month[0]+""+month[1];
        builder.append('_');
        switch (s){
            case "01":
                builder.append(getString(R.string.gen));
                break;
            case "02":
                builder.append(getString(R.string.feb));
                break;
            case "03":
                builder.append(getString(R.string.mar));
                break;
            case "04":
                builder.append(getString(R.string.apr));
                break;
            case "05":
                builder.append(getString(R.string.mag));
                break;
            case "06":
                builder.append(getString(R.string.giu));
                break;
            case "07":
                builder.append(getString(R.string.lug));
                break;
            case "08":
                builder.append(getString(R.string.ago));
                break;
            case "09":
                builder.append(getString(R.string.set));
                break;
            case "10":
                builder.append(getString(R.string.ott));
                break;
            case "11":
                builder.append(getString(R.string.nov));
                break;
            case "12":
                builder.append(getString(R.string.dic));
                break;
        }
        return builder.toString();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.birthdayinfo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_calendar:
                showCalendar();
                break;
            case android.R.id.home:
                Intent back = new Intent(getApplicationContext(), ViewBirthday.class);
                back.putExtra("Today",getIntent().getExtras().getString("Today"));
                back.putExtra("Name",getIntent().getExtras().getString("Name"));
                back.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(back);
                break;
            case R.id.menu_about:
                final Intent i = new Intent(BirthdayInfoActivity.this,AboutActivity.class);
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                i.putExtra("Name",getIntent().getExtras().getString("Name"));
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(i);
                break;
            case R.id.menu_other:
                final Intent apps = new Intent(BirthdayInfoActivity.this,OtherApps.class);
                apps.putExtra("Today",getIntent().getExtras().getString("Today"));
                apps.putExtra("Name",getIntent().getExtras().getString("Name"));
                apps.putExtra("Age",getIntent().getExtras().getString("Age"));
                startActivity(apps);
                break;
            case R.id.menu_settings:
                Intent sett = new Intent(BirthdayInfoActivity.this, SettingsActivity.class);
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

    private void showCalendar() {
        this.calendarLayout.setVisibility(View.VISIBLE);
        this.main.setVisibility(View.GONE);
        bottomBar.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
