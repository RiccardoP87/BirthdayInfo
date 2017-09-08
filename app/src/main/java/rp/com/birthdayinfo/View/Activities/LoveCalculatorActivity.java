package rp.com.birthdayinfo.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import rp.com.birthdayinfo.R;

public class LoveCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(!getIntent().getExtras().getBoolean("LoveMOF")){
            setTheme(R.style.MyMaterialTheme);
        }else{
            setTheme(R.style.MyMaterialTheme3);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button cal = (Button) findViewById(R.id.resbtn);
        final TextView res = (TextView) findViewById(R.id.resview);
        final EditText name = (EditText) findViewById(R.id.nameField);
        final EditText cname = (EditText) findViewById(R.id.crushnameField);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText("");
                Editable n = name.getText();
                Editable cn = cname.getText();
                String concat = String.valueOf(n).concat(String.valueOf(cn)).toUpperCase();
                if ((n.toString().trim().length() == 0) || (cn.toString().trim().length() == 0)) {
                    Toast.makeText(LoveCalculatorActivity.this, R.string.no_field, Toast.LENGTH_LONG).show();
                } else {
                    int sum = 0;
                    for (int i = 0; i < concat.length(); i++) {
                        char character = concat.charAt(i);
                        int ascii = (int) character;
                        sum += ascii;
                    }
                    res.setText(getString(R.string.love1) +" "+ n +" "+ getString(R.string.love2) +" "+ cn + " "+ getString(R.string.love3) + " "+sum % 100 + getString(R.string.love4));
                }
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent back = new Intent(getApplicationContext(), HoroscopActivity.class);
                back.putExtra("Today",getIntent().getExtras().getString("Today"));
                back.putExtra("Name",getIntent().getExtras().getString("Name"));
                back.putExtra("Age",getIntent().getExtras().getString("Age"));
                back.putExtra("LoveMOF",getIntent().getExtras().getBoolean("LoveMOF"));
                startActivity(back);
                break;
            default:
                break;
        }

        return true;
    }

}

