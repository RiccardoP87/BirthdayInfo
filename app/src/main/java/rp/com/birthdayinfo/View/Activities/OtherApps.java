package rp.com.birthdayinfo.View.Activities;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.view.View;
import com.andexert.library.RippleView;

import rp.com.birthdayinfo.R;


public class OtherApps extends Activity {

    RippleView r,c;
    public static final String UNITCURL = "https://play.google.com/store/apps/details?id=rp.com.unitconverter&hl=it";
    public static final String DONTCURL = "https://play.google.com/store/apps/details?id=rp.com.dontcallme&hl=it";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_other_apss);
        r = (RippleView)findViewById(R.id.rv_unitconverter);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherApps.this.startActivity(new Intent("android.intent.action.VIEW",
                        Uri.parse(UNITCURL)));
            }
        });
        c = (RippleView)findViewById(R.id.rv_dont);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherApps.this.startActivity(new Intent("android.intent.action.VIEW",
                        Uri.parse(DONTCURL)));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),getClass());
        back.putExtra("Age",getIntent().getExtras().getString("Age"));
        back.putExtra("Today",getIntent().getExtras().getString("Today"));
        back.putExtra("Name",getIntent().getExtras().getString("Name"));
        back.putExtra("Numb",getIntent().getExtras().getString("Numb"));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
