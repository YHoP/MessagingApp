package com.parse.starter.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parse.starter.R;
import com.parse.starter.models.Message;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.editTitle) EditText mEditTitle;
    @Bind(R.id.editMessage) EditText mEditMessage;
    @Bind(R.id.btnSubmitMessage) Button mSubmitButton;
    @Bind(R.id.relativeLayout) RelativeLayout mRelativeLayout;
    Message mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(this);
        mRelativeLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSubmitMessage){
            String message = mEditMessage.getText().toString();
            String title = mEditTitle.getText().toString();

            mMessage = new Message(title, message);
            mMessage.save();
            showMessageList();
        } else {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);
        }

    }

    public void showMessageList() {
        Intent intent = new Intent(NewMessageActivity.this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_message, menu);
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
