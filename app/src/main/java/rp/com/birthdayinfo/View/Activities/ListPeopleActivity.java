package rp.com.birthdayinfo.View.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import com.andexert.library.RippleView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import java.util.List;
import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;
import rp.com.birthdayinfo.View.Adapters.PeopleAdapter;

public class ListPeopleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Toolbar toolbar;
    private RippleView back;
    private AppController controller;
    private Intent i;
    private ListView listView;
    private PeopleAdapter adapter;
    private List<People> list;
    private FloatingActionButton add;
    private String age;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_list_people);
        controller = new AppController(getApplicationContext());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.addPeopele));


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getResources().getColor(R.color.text)));
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(new
                    ColorDrawable(getResources().getColor(R.color.text2)).getColor());
        }else{}
        add = (FloatingActionButton) findViewById(R.id.add_people);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListPeopleActivity.this,AddNewPeopleActivity.class);
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                startActivity(i);
            }
        });
        back = (RippleView) findViewById(R.id.backR);
        back.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(ListPeopleActivity.this,MainActivity.class);
                i.putExtra("Age",getIntent().getExtras().getString("Age"));
                i.putExtra("Today",getIntent().getExtras().getString("Today"));
                startActivity(i);
            }
        });
        listView = (ListView)findViewById(R.id.people);
        list = SharedUtilities.getInstance().getPeople(this);
        if(list!=null){
            adapter = new PeopleAdapter(this,list);
            listView.setAdapter(adapter);
        }
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(getIntent().hasExtra("Class")) {
            switch (getIntent().getExtras().getString("Class")) {
                case "HoroscopActivity":
                    i = new Intent(ListPeopleActivity.this, HoroscopActivity.class);
                    break;
                case "ChineseZodiacActivity":
                    i = new Intent(ListPeopleActivity.this, ChineseZodiacActivity.class);
                    break;
                case "MayanHoroscopActivity":
                    i = new Intent(ListPeopleActivity.this, MayanHoroscopActivity.class);
                    break;
                case "CelticHoroscopActivity":
                    i = new Intent(ListPeopleActivity.this, CelticHoroscopActivity.class);
                    break;
                case "ArabianHoroscopoActivity":
                    i = new Intent(ListPeopleActivity.this, ArabianHoroscopoActivity.class);
                    break;
                case "InduHoroscopActivity":
                    i = new Intent(ListPeopleActivity.this, InduHoroscopActivity.class);
                    break;
                case "NextBirthdayActivity":
                    i = new Intent(ListPeopleActivity.this, NextBirthdayActivity.class);
                    break;
                case "BirthdayInfoActivity":
                    i = new Intent(ListPeopleActivity.this, BirthdayInfoActivity.class);
                    break;
                case "ViewBirthday":
                    i = new Intent(ListPeopleActivity.this, ViewBirthday.class);
                    break;
            }
        }else{
            i = new Intent(ListPeopleActivity.this,ViewBirthday.class);
        }
        i.putExtra("Age",list.get(position).getEta());
        i.putExtra("Name",list.get(position).getName());
        i.putExtra("Today",getIntent().getExtras().getString("Today"));
        startActivity(i);

    }
}
