package com.viasofts.mygcs;

import android.content.SharedPreferences;

import java.util.HashMap;

public class SharedPrefManager {

    public static final String KEY_MY_DRONE_ID = "ap_my_drone_id";
    public static final String KEY_TARGET_DRONE_ID = "ap_target_drone_id";
    public static final String KEY_DISTANCE = "ap_target_distance";
    public static final String KEY_ALTITUDE = "ap_my_altitude";
    public static final String KEY_CONNECTION = "ap_connection";
    public static final String KEY_FOLLOW_HEIGHT = "ap_follow_height";

    private HashMap<String, String> map = new HashMap<>();

    private static SharedPrefManager INSTANCE = null;

    public static synchronized SharedPrefManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SharedPrefManager();
        }
        return (INSTANCE);
    }

    SharedPreferences sharedPref;

    public void init(SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
    }

    public void savePref(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();

        this.map.put(key, value);
    }

    public String readPref(String key) {
        return sharedPref.getString(key, "");
    }

    public static void save(String key, String value) {
        SharedPrefManager.getInstance().savePref(key, value);
    }

    public static String read(String key) {
        return SharedPrefManager.getInstance().readPref(key);
    }

    public static boolean isFollowingHeight() {
        if (read(KEY_FOLLOW_HEIGHT).equals("1")) return true;

        return false;
    }
}