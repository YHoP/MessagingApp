package com.parse.starter.models;


import android.util.Log;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class User {
    ParseUser mParseUser = new ParseUser();

    public User(String username, String password) {
        mParseUser.setUsername(username);
        mParseUser.setPassword(password);
    }

    public User() {
        ParseUser mParseUser = new ParseUser();
    }

    public String getName() {
        return mParseUser.getString("username");
    }

    public void setName(String username) {
        mParseUser.setUsername(username);
    }

    public void setPassword(String password) {
        mParseUser.setPassword(password);
    }

    public void signUp() {
        mParseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Save user: ", "Successful");
                } else {
                    Log.i("Save user: ", "Failed");
                    e.printStackTrace();
                }
            }
        });
    }

    public static void login(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    Log.i("Log in: ", "Successful");

                } else {
                    Log.i("Log in: ", "Failed");
                }
            }
        });
    }
}
