package rp.com.birthdayinfo.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rp.com.birthdayinfo.Model.People;
import rp.com.birthdayinfo.View.Activities.ListPeopleActivity;

public final class SharedUtilities {

    private static SharedUtilities helper;

    public static SharedUtilities getInstance() {
        synchronized (SharedUtilities.class) {
            if (helper == null) {
                helper = new SharedUtilities();
            }
            return helper;
        }
    }

    public void saveMap(Context context, Map<String, Map<String, Boolean>> back) {
        Gson gson = new Gson();
        String jsonCurProduct = gson.toJson(back);

        SharedPreferences sharedPref = context.getSharedPreferences("Shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("Save", jsonCurProduct);
        editor.commit();
    }

    public Map<String, Map<String, Boolean>> getMap(Context c){
        Gson gson = new Gson();
        Map<String, Map<String, Boolean>> saveFromShared = new HashMap<>();
        SharedPreferences sharedPref = c.getSharedPreferences("Shared", Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString("Save", "");

        Type type = new TypeToken<Map<String, Map<String, Boolean>> >() {}.getType();
        saveFromShared = gson.fromJson(jsonPreferences, type);

        return saveFromShared;
    }

    public void saveBirthday(Context context, String s) {
        SharedPreferences sharedPref = context.getSharedPreferences("Shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Age",s);
        editor.commit();
    }

    public String restoreBirthday(Context c){
        SharedPreferences sharedPref = c.getSharedPreferences("Shared", Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString("Age", "");
        return jsonPreferences;
    }

    public List<People> getPeople(Context c) {
        Gson gson = new Gson();
        ArrayList<People> saveFromShared;
        SharedPreferences sharedPref = c.getSharedPreferences("Shared", Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString("Save3", "");

        Type type = new TypeToken<ArrayList<People>>(){}.getType();
        saveFromShared = gson.fromJson(jsonPreferences, type);

        return saveFromShared;
    }

    public void savePeople(Context c, List<People> arrayList) {
        Gson gson = new Gson();
        String jsonCurProduct = gson.toJson(arrayList);

        SharedPreferences sharedPref = c.getSharedPreferences("Shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("Save3", jsonCurProduct);
        editor.commit();
    }
}
