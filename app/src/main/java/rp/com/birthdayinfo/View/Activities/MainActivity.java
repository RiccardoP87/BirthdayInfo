package rp.com.birthdayinfo.View.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.timepicker.TimePickerBuilder;
import com.codetroopers.betterpickers.timepicker.TimePickerDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;
import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.R;

public class MainActivity extends AppCompatActivity
        implements CalendarDatePickerDialogFragment.OnDateSetListener,
        TimePickerDialogFragment.TimePickerDialogHandler{

    private TextView data1,data2,h1,h2;
    private int calling;
    private SimpleDateFormat dayN;
    private SimpleDateFormat m;
    private SimpleDateFormat y;
    private SimpleDateFormat h;
    private AppController controller;
    private ImageView dob,hour1,cal,hour2,calcola,people;
    private TextView one,two,three,four,five,six;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_main);
        data1 = (TextView)findViewById(R.id.textView3);
        data2 = (TextView)findViewById(R.id.textView6);
        h1 = (TextView)findViewById(R.id.textView2);
        h2 = (TextView)findViewById(R.id.textView8);
        dob = (ImageView)findViewById(R.id.dob);
        hour1 = (ImageView)findViewById(R.id.ora);
        cal = (ImageView)findViewById(R.id.today);
        hour2 = (ImageView)findViewById(R.id.ora_t);
        calcola = (ImageView)findViewById(R.id.calc);
        people = (ImageView)findViewById(R.id.other);
        dayN = new SimpleDateFormat("dd");
        m = new SimpleDateFormat("MM");
        y = new SimpleDateFormat("yyyy");
        h = new SimpleDateFormat("HH:mm");
        one = (TextView)findViewById(R.id.textView);
        two = (TextView)findViewById(R.id.textView4);
        three = (TextView)findViewById(R.id.textView5);
        four = (TextView)findViewById(R.id.textView7);
        five = (TextView)findViewById(R.id.textView9);
        six = (TextView)findViewById(R.id.textView1312);
        controller = new AppController(getApplicationContext());
        if(controller.getGetRegistration()==null){
            final Intent reg = new Intent(MainActivity.this,RegistrationActivity.class);
            startActivity(reg);
            this.finish();
        }else{
            controller.smap();
            if(controller.getSex()){
                dob.setImageDrawable(getResources().getDrawable(R.drawable.birthday2));
                hour1.setImageDrawable(getResources().getDrawable(R.drawable.hour2));
                cal.setImageDrawable(getResources().getDrawable(R.drawable.calendar2));
                hour2.setImageDrawable(getResources().getDrawable(R.drawable.hour2));
                calcola.setImageDrawable(getResources().getDrawable(R.drawable.calculator2));
                people.setImageDrawable(getResources().getDrawable(R.drawable.people2));
                data1.setTextColor(getResources().getColor(R.color.woman));
                data2.setTextColor(getResources().getColor(R.color.woman));
                h1.setTextColor(getResources().getColor(R.color.woman));
                h2.setTextColor(getResources().getColor(R.color.woman));
                one.setTextColor(getResources().getColor(R.color.woman));
                two.setTextColor(getResources().getColor(R.color.woman));
                three.setTextColor(getResources().getColor(R.color.woman));
                four.setTextColor(getResources().getColor(R.color.woman));
                five.setTextColor(getResources().getColor(R.color.woman));
                six.setTextColor(getResources().getColor(R.color.woman));
                setTheme(R.style.MyMaterialTheme3);
            }else{
                dob.setImageDrawable(getResources().getDrawable(R.drawable.birthday));
                hour1.setImageDrawable(getResources().getDrawable(R.drawable.hour));
                cal.setImageDrawable(getResources().getDrawable(R.drawable.calendar));
                hour2.setImageDrawable(getResources().getDrawable(R.drawable.hour));
                calcola.setImageDrawable(getResources().getDrawable(R.drawable.calculator));
                people.setImageDrawable(getResources().getDrawable(R.drawable.people));
                data1.setTextColor(getResources().getColor(R.color.text));
                data2.setTextColor(getResources().getColor(R.color.text));
                h1.setTextColor(getResources().getColor(R.color.text));
                h2.setTextColor(getResources().getColor(R.color.text));
                one.setTextColor(getResources().getColor(R.color.text));
                two.setTextColor(getResources().getColor(R.color.text));
                three.setTextColor(getResources().getColor(R.color.text));
                four.setTextColor(getResources().getColor(R.color.text));
                five.setTextColor(getResources().getColor(R.color.text));
                six.setTextColor(getResources().getColor(R.color.text));
                setTheme(R.style.MyMaterialTheme);
            }

        }
        start();
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(MainActivity.this);
                cdp.show(getSupportFragmentManager(), "");
                calling = 0;
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(MainActivity.this);
                cdp.show(getSupportFragmentManager(), "");
                calling = 1;
            }
        });

        calcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(controller.differenceOk(data1.getText().toString(),
                            data2.getText().toString())){
                        SharedUtilities.getInstance().saveBirthday(getApplicationContext(),
                                data1.getText().toString());
                        final Intent i = new Intent(MainActivity.this,ViewBirthday.class);
                        i.putExtra("Age",data1.getText().toString());
                        i.putExtra("Today",data2.getText().toString());
                        i.putExtra("Name",controller.getName());
                        i.putExtra("LoveMOF",controller.getSex());
                        startActivity(i);
                    }else{
                        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText(getString(R.string.ops))
                                .setContentText(getString(R.string.error_data))
                                .show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        hour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerBuilder tpb = new TimePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                tpb.show();
                calling = 0;
            }
        });

        hour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerBuilder tpb = new TimePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                tpb.show();
                calling = 1;
            }
        });

       people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(getApplicationContext(),ListPeopleActivity.class);
                i.putExtra("Age",data1.getText().toString());
                i.putExtra("Today",data2.getText().toString());
                startActivity(i);
            }
        });
    }

    @Deprecated
    private void start() {
        Date date = new Date();
        s = SharedUtilities.getInstance().restoreBirthday(getApplicationContext());
        if(!s.equals("")){
            data1.setText(s);
        }else{
            data1.setText(""+dayN.format(date)+"-"+m.format(date)+"-"+y.format(date));
        }
        h1.setText(""+h.format(date));
        data2.setText(""+dayN.format(date)+"-"+m.format(date)+"-"+y.format(date));
        h2.setText(""+h.format(date));
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear,
                          int dayOfMonth) {
        if(calling==0){
            if(monthOfYear<=11){
                data1.setText(controller.eraseError(""+dayOfMonth+"-"+(monthOfYear+1)+"-"+year));
            }else{
                data1.setText(controller.eraseError(""+dayOfMonth+"-"+monthOfYear+"-"+year));
            }
        }else if(calling==1){
            if(monthOfYear<=11){
                data2.setText(controller.eraseError(""+dayOfMonth+"-"+(monthOfYear+1)+"-"+year));
            }else{
                data2.setText(controller.eraseError(""+dayOfMonth+"-"+monthOfYear+"-"+year));
            }

        }
    }

    @Override
    public void onDialogTimeSet(int reference, int hourOfDay, int minute) {
        if(calling==0){
            h1.setText(""+hourOfDay+":"+minute);
        }else if(calling==1){
            h2.setText(""+hourOfDay+":"+minute);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent sett = new Intent(getApplicationContext(), SettingsActivity.class);
                sett.putExtra("Age",getIntent().getExtras().getString("Age"));
                sett.putExtra("Today",getIntent().getExtras().getString("Today"));
                sett.putExtra("Name",controller.getName());
                startActivity(sett);
                break;
            default:
                break;
        }

        return true;
    }
}
