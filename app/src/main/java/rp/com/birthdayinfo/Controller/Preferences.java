package rp.com.birthdayinfo.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Preferences {

    public static final String HORROR = "horror_horoscope";
    public static final String LOVE = "love";
    public static final String OROSCOPO = "zodiaco";
    public static final String CINESE = "cinese";
    public static final String MAYA = "maya";
    public static final String CELTICO = "celtico";
    public static final String ARABO = "arabo";
    public static final String INDU = "indu";

    private static Preferences mInstance;
    private SharedPreferences mPrefs;
    private Context mContext;

    public static Preferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Preferences(context.getApplicationContext());
        }

        return mInstance;
    }

    private Preferences(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mContext = context;
    }

    /**
     * Get instance of app's Shared Preferences
     *
     * @return SharedPreference instance
     */
    public SharedPreferences getPreferences() {
        return mPrefs;
    }


    public boolean isHorror(){return mPrefs.getBoolean(HORROR, false);}

    public boolean isLove(){
        return mPrefs.getBoolean(LOVE,false);
    }

    public boolean isHoroscopo(){
        return mPrefs.getBoolean(OROSCOPO,true);
    }
    public boolean isChinese(){
        return mPrefs.getBoolean(CINESE,true);
    }
    public boolean isMaya(){
        return mPrefs.getBoolean(MAYA,true);
    }
    public boolean isCeltic(){
        return mPrefs.getBoolean(CELTICO,true);
    }
    public boolean isArabo(){
        return mPrefs.getBoolean(ARABO,true);
    }
    public boolean isIndu(){
        return mPrefs.getBoolean(INDU,true);
    }

}
