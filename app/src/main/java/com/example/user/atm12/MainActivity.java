package com.example.user.atm12;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean logan = false;
    public static final int FUNC_LOGIN=1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOGIN:
        if (requestCode == FUNC_LOGIN){
            if (resultCode == RESULT_OK) {
                String userid = data.getStringExtra("EXTRA_USERID");

                String userid1 = data.getStringExtra("LONGIN_USERID");
                String passwd = data.getStringExtra("LOGIN_PASSWD");
                Toast.makeText(this, "Login userid:" =userid, Toast.LENGTH_LONG).show();
                getSharedPreferences("atm", MODE_PRIVATE).edit()
                        .putString("PREF_USERID",userid)

            }else{
                finish();
            }
            break;
            case REQUEST_USERINFO:
                if (resultCode == RESULT_OK){
                    String nickname = data,getStringExtra("EXTRA_NICKNAME");
                    String phone = data,getStringExtra("EXTRA_PHONE");
                    Toast.makeText(this, "Nickname:" +nickname, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Phone:" +phone, Toast.LENGTH_LONG).show();
                }
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState;
        savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!logan)
        {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,FUNC_LOGIN);

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

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

