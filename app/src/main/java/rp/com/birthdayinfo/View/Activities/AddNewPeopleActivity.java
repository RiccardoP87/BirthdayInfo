package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.design.widget.TextInputLayout;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.R;

public class AddNewPeopleActivity extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener {

    private TextView o,c,t,d;
    private ImageView dob,cal;
    private RippleView wo,ma;
    private SimpleDateFormat dayN;
    private SimpleDateFormat m;
    private SimpleDateFormat y;
    private AppController controller;
    private boolean manOrWoman = false;
    private Button save;
    private TextInputLayout name,surname;
    private List<People> arrayList;
    private int imageSource;
    private int calling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_add_new_people);
        o = (TextView) findViewById(R.id.textView);
        c = (TextView) findViewById(R.id.textView5);
        t = (TextView) findViewById(R.id.textView3);
        d = (TextView) findViewById(R.id.textView2);
        save = (Button) findViewById(R.id.reg);
        wo = (RippleView) findViewById(R.id.w);
        ma = (RippleView) findViewById(R.id.m);
        name = (TextInputLayout) findViewById(R.id.aWrapper);
        surname = (TextInputLayout) findViewById(R.id.bWrapper);
        controller = new AppController(getApplicationContext());
        arrayList = SharedUtilities.getInstance().getPeople(this);
        dob = (ImageView)findViewById(R.id.dob);
        cal = (ImageView)findViewById(R.id.today);
        Date date = new Date();
        dayN = new SimpleDateFormat("dd");
        m = new SimpleDateFormat("MM");
        y = new SimpleDateFormat("yyyy");
        d.setText(""+dayN.format(date)+"-"+m.format(date)+"-"+y.format(date));
        wo.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                manOrWoman = true;
                imageSource = R.drawable.woman;
                dob.setImageDrawable(getResources().getDrawable(R.drawable.birthday2));
                cal.setImageDrawable(getResources().getDrawable(R.drawable.calendar2));
                o.setTextColor(getResources().getColor(R.color.woman));
                c.setTextColor(getResources().getColor(R.color.woman));
                t.setTextColor(getResources().getColor(R.color.woman));
                d.setTextColor(getResources().getColor(R.color.woman));
                setTheme(R.style.MyMaterialTheme3);
            }
        });

        ma.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                manOrWoman = false;
                imageSource = R.drawable.man;
                dob.setImageDrawable(getResources().getDrawable(R.drawable.birthday));
                cal.setImageDrawable(getResources().getDrawable(R.drawable.calendar));
                o.setTextColor(getResources().getColor(R.color.text));
                c.setTextColor(getResources().getColor(R.color.text));
                t.setTextColor(getResources().getColor(R.color.text));
                d.setTextColor(getResources().getColor(R.color.text));
                setTheme(R.style.MyMaterialTheme);
            }
        });

        if(!manOrWoman){
            imageSource = R.drawable.man;
            dob.setImageDrawable(getResources().getDrawable(R.drawable.birthday));
            cal.setImageDrawable(getResources().getDrawable(R.drawable.calendar));
            o.setTextColor(getResources().getColor(R.color.text));
            c.setTextColor(getResources().getColor(R.color.text));
            t.setTextColor(getResources().getColor(R.color.text));
            d.setTextColor(getResources().getColor(R.color.text));
        }else{
            imageSource = R.drawable.woman;
            dob.setImageDrawable(getResources().getDrawable(R.drawable.birthday2));
            cal.setImageDrawable(getResources().getDrawable(R.drawable.calendar2));
            o.setTextColor(getResources().getColor(R.color.woman));
            c.setTextColor(getResources().getColor(R.color.woman));
            t.setTextColor(getResources().getColor(R.color.woman));
            d.setTextColor(getResources().getColor(R.color.woman));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(controller.differenceOk(t.getText().toString(),
                            d.getText().toString())){
                        if(arrayList!=null){
                            arrayList.add(new People(name.getEditText().getText().toString(),
                                    surname.getEditText().getText().toString(),
                                    t.getText().toString(),imageSource));
                        }else{
                            arrayList = new ArrayList<People>();
                            arrayList.add(new People(name.getEditText().getText().toString(),
                                    surname.getEditText().getText().toString(),
                                    t.getText().toString(),imageSource));
                        }
                        SharedUtilities.getInstance().savePeople(getApplicationContext(),arrayList);
                        new SweetAlertDialog(AddNewPeopleActivity.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText(getString(R.string.regN))
                                .setContentText(getString(R.string.backT))
                                .setCancelText(getString(R.string.nope))
                                .setConfirmText(getString(R.string.addP))
                                .showCancelButton(true)
                                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.cancel();
                                        final Intent back = new Intent(getApplicationContext(),ListPeopleActivity.class);
                                        back.putExtra("Today",d.getText().toString());
                                        startActivity(back);
                                    }
                                })
                                .show();
                    }else{
                        new SweetAlertDialog(AddNewPeopleActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText(getString(R.string.ops))
                                .setContentText(getString(R.string.error_data))
                                .show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(AddNewPeopleActivity.this);
                cdp.show(getSupportFragmentManager(), "");
                calling = 0;
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(AddNewPeopleActivity.this);
                cdp.show(getSupportFragmentManager(), "");
                calling = 1;
            }
        });




    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        if(calling==0){
            if(monthOfYear<=11){
                t.setText(controller.eraseError(""+dayOfMonth+"-"+(monthOfYear+1)+"-"+year));
            }else{
                t.setText(controller.eraseError(""+dayOfMonth+"-"+monthOfYear+"-"+year));
            }
        }else if(calling==1){
            if(monthOfYear<=11){
                d.setText(controller.eraseError(""+dayOfMonth+"-"+(monthOfYear+1)+"-"+year));
            }else{
                d.setText(controller.eraseError(""+dayOfMonth+"-"+monthOfYear+"-"+year));
            }

        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
