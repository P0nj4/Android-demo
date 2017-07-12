package com.example.germanpereyra.recipies;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by germanpereyra on 7/12/17.
 */

public class RecipiesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Fresca-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
