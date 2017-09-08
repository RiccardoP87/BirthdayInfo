package rp.com.birthdayinfo.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import rp.com.birthdayinfo.R;


public class CalendarBirthday extends Fragment {

    private static CalendarBirthday myFragment;

    public CalendarBirthday() {}

    public static CalendarBirthday newInstance() {
        myFragment = new CalendarBirthday();
        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calendar_fragment, container, false);
    }
}
