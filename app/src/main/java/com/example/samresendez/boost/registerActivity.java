package com.example.samresendez.boost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button registerBtn = (Button) findViewById(R.id.submitRegistration);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAsyncTask task = new registerAsyncTask();
                task.mEmail = ((EditText)findViewById(R.id.emailOne)).getText().toString();
                task.mUserName = ((EditText)findViewById(R.id.usernameOne)).getText().toString();
                task.mPassword = ((EditText)findViewById(R.id.passwordOne)).getText().toString();

                // task.execute();
                Globals.getInstance().setUser(task.mUserName);

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence text = "You were successfully registered!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });


    }


}
