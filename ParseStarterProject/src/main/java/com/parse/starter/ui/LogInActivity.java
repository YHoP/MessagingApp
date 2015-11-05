package com.parse.starter.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.starter.R;
import com.parse.starter.models.User;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.txtUsername) EditText mTxtUsername;
    @Bind(R.id.txtPassword) EditText mTxtPassword;
    @Bind(R.id.btnSubmit) Button mBtnSubmit;
    @Bind(R.id.txtSubmit) TextView mTxtSubmit;

    Boolean signUpModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        String username = mTxtUsername.getText().toString();
        String password = mTxtPassword.getText().toString();

        User.login(username, password);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.txtSubmit){

            Log.i("AppInfo", "Change Signup Mode");
            if(signUpModeActive){
                signUpModeActive = false;
                mTxtSubmit.setText("Sign up");
                mBtnSubmit.setText("Log in");
            } else {
                signUpModeActive = true;
                mBtnSubmit.setText("Log in");
                mTxtSubmit.setText("Sign up");
            }
        } else if (v.getId() == R.id.imgLogo || v.getId() == R.id.relativeLayout){
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);

        }

    }

    public void signUpOrLogin(View view) {
        String username = String.valueOf(mTxtUsername.getText());
        String password = String.valueOf(mTxtPassword.getText());
        if(signUpModeActive) {
            User user = new User();
            user.login(username, password);
        } else {
            User user = new User(username, password);
            user.signUp();
        }
        showMessageList();
    }

    public void showMessageList() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
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
