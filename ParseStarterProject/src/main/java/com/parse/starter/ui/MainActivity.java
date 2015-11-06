/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.adapter.MessageAdapter;
import com.parse.starter.models.Message;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ListActivity {

    @Bind(R.id.btnAddMessage) Button mAddMessage;

    Boolean isLogin;
    ArrayList<String> mMessages;

    private static List<ParseObject> mObjects;
    private static List<Message> messages;
    private ListView lv;

    // MessageAdapter mMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // lv = (ListView) findViewById(R.id.list);

        if(ParseUser.getCurrentUser() == null){
            Intent intent = new Intent(this, LogInActivity.class);
            startActivity(intent);
        }

        Runnable addMessages = new Runnable(){
            @Override
            public void run(){
                for (ParseObject parseObject : mObjects) {
                    Message message = new Message(parseObject);
                    messages.add(message);
                    mMessages.add(message.getTitle());
                }
            }
        };

        allMessage(addMessages);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mMessages);

        setListAdapter(arrayAdapter);
        // lv.setAdapter(arrayAdapter);


        ParseAnalytics.trackAppOpenedInBackground(getIntent());



        mAddMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
                startActivity(intent);
            }
        });

    }

    public void allMessage(final Runnable addMessages) {

        ArrayList<String> mMessages;
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Message");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                mObjects = objects;
                runOnUiThread(addMessages);
            }
        });

    }




    /*
      @Override
      protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Message thisMessage = (Message) mAdapter.getItem(position);

      }
  */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
