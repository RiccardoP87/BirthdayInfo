package rp.com.birthdayinfo.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import rp.com.birthdayinfo.R;


public class WikiBirthday extends Fragment{

    private static WikiBirthday myFragment;



    public static WikiBirthday newInstance() {
        myFragment = new WikiBirthday();
        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wiki_fragment, container, false);

        return view;
    }

}
