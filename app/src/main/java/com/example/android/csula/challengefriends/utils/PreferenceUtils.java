package com.example.android.csula.challengefriends.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.amazonaws.com.google.gson.Gson;
import com.example.android.csula.challengefriends.R;
import com.example.android.csula.challengefriends.models.User;

/**
 * Created by Mahdiye on 5/18/2016.
 */
public class PreferenceUtils {
    public static void setCurrentUser(User currentUser, Context context){
        Gson gson = new Gson();
        String json = gson.toJson(currentUser);
        setSharedValues(context.getString(R.string.user_prefs_key), json, context);
    }

    public static User getCurrentUser(Context context){
        Gson gson = new Gson();
        String json = getSharedValues(context.getString(R.string.user_prefs_key), context);
        User user = gson.fromJson(json, User.class);
        return user;
    }

    public static void clearCurrentUser( Context context){
        removeFromSharedValues(context.getString(R.string.user_prefs_key), context);
    }

    public static String getSharedValues(String key, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(key, null);
    }

    public static void setSharedValues(String key, String value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void removeFromSharedValues(String key, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }
}