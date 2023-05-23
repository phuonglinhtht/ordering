package com.example.ordering.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ordering.models.ItemModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class SharedPreference {
    private static SharedPreference _instance;
    private static Context _context;
    public  static  final  String SHARED_PREF_NAME = "Ordering";
    public  static final String DEVICE_TOKEN = "DeviceToken";
    public  static final String ITEM = "Item";

    public static SharedPreference getInstance(Context context){
        if(_instance == null){
            _context = context;
            _instance = new SharedPreference();
        }
        return _instance;
    }

    public void setDeviceToken(String deviceToken){
        SharedPreferences sharedPreferences = _context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(DEVICE_TOKEN, deviceToken);
        editor.apply();
    }
    public  String getDeviceToken(){
        SharedPreferences sharedPreferences = _context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String deviceToken = sharedPreferences.getString(DEVICE_TOKEN, "");
        return deviceToken;
    }

    public ItemModel getItem(){
        SharedPreferences sharedPreferences = _context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String userJsonString = sharedPreferences.getString(ITEM, "");
        if(userJsonString =="") return null;
        Type type = new TypeToken<ItemModel>(){}.getType(); //
        return new Gson().fromJson(userJsonString, type);
    }

    public void setItem(ItemModel item){
        SharedPreferences sharedPreferences = _context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String userString = new Gson().toJson(item);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(ITEM, userString);
        editor.apply();
    }
}
