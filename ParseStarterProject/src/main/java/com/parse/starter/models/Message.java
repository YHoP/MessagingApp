package com.parse.starter.models;


import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.Date;
import java.util.List;

public class Message {
    private ParseObject mParseObject;
    private static List<ParseObject> mObjects;
    private static List<Message> messages;


    public Message(String title, String message){
        mParseObject = new ParseObject("Message");
        mParseObject.put("title", title);
        mParseObject.put("message", message);
    }

    public Message(ParseObject parseObject) {
        mParseObject = parseObject;
    }

    public String getTitle() {
        return mParseObject.getString("title");
    }

    public void setTitle(String title) {
        mParseObject.put("title", title);
    }

    public String getMessage() {
        return mParseObject.getString("message");
    }

    public void setMessage(String message) {
        mParseObject.put("message", message);
    }

    public String getPostDate() {
        Date date = mParseObject.getCreatedAt();
        return date.toString();
    }

    public void save() {
        mParseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.i("Save Message", "Successful");
                } else {
                    Log.i("Save Message", "Failed");
                    e.printStackTrace();
                }
            }
        });
    }

}

