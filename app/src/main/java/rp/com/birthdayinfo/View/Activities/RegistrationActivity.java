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
import android.widget.ImageButton;
import android.widget.ImageView;

import com.andexert.library.RippleView;

import java.util.HashMap;
import java.util.Map;

import rp.com.birthdayinfo.Controller.AppController;
import rp.com.birthdayinfo.Controller.SharedUtilities;
import rp.com.birthdayinfo.R;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputLayout name,surname;
    private Button reg;
    private RippleView w,m;
    private boolean manOrWoman;
    private AppController appController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_registration);
        name = (TextInputLayout) findViewById(R.id.aWrapper);
        surname = (TextInputLayout) findViewById(R.id.bWrapper);
        reg = (Button) findViewById(R.id.reg);
        w = (RippleView) findViewById(R.id.w);
        m = (RippleView) findViewById(R.id.m);
        appController = new AppController(getApplicationContext());

        w.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                manOrWoman = true;
            }
        });

        m.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                manOrWoman = false;
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appController.registration(name.getEditText().getText().toString(),
                        surname.getEditText().getText().toString(),manOrWoman);
                final Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
