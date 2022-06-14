package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ay1P7K0LOnQ6BIJ1R9StZJOpWCXMU8sWoCHNGEAQ") // should correspond to Application Id env variable
                .clientKey("GXUhsNLWgYRnXf0mkjrG0sY7DhXVY9PwQUbZBtmq")  // should correspond to Client key env variable
                .server("https://parseapi.back4app.com").build());
    }
}
