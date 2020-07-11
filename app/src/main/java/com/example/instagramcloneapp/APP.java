package com.example.instagramcloneapp;

import android.app.Application;

import com.parse.Parse;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("JEPMDMn9a2wbcvanYpNYMcWN1K22qf5qmzPcASWl")
                // if defined
                .clientKey("BkGIM9Xivk127lp6msE7oYOjrGxdbwY4mJbmhUOt")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
