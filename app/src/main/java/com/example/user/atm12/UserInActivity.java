package com.example.user.atm12;

import android.app.PictureInPictureParams;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_in);
    }


    public void ok(View view) {
        EditText edNickname = (EditText) findViewById(R.id.user_nickname);
        EditText edPhone = (EditText) findViewById(R.id.user_phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EJTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();

    }