package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import rp.com.birthdayinfo.R;

public class AboutActivity extends AppCompatActivity {

    private LinearLayout mail;
    private ImageView facebook,store;
    private String url = "https://play.google.com/store/apps/details?id=rp.com.birthdayinfo&hl=it";
    private String faceUrl = "https://www.facebook.com/riccardo.m.pezzolati";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &      Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_about);
        mail = (LinearLayout)findViewById(R.id.ll_feedback);
        facebook = (ImageView)findViewById(R.id.face);
        store = (ImageView)findViewById(R.id.store);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailFeed();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFacebook();
            }
        });

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoStore();
            }
        });
    }

    private void gotoStore() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void gotoFacebook() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(faceUrl));
        startActivity(i);
    }

    private void mailFeed() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","riccardo.pezzolati@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),getClass());
        back.putExtra("Age",getIntent().getExtras().getString("Age"));
        back.putExtra("Today",getIntent().getExtras().getString("Today"));
        back.putExtra("Name",getIntent().getExtras().getString("Name"));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
