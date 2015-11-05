package com.parse.starter.models;


import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;
import java.util.List;

public class Message {
    ParseObject mParseObject;


    public void message(){
        ParseObject mParseObject = new ParseObject("Message");
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

}
