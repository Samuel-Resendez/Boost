package com.example.samresendez.boost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.AuthenticationException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText creditCardEditText = (EditText) findViewById(R.id.CardNumberEditText);
        creditCardEditText.addTextChangedListener(new creditCardTextWatcher());

        Button registerBtn = (Button) findViewById(R.id.submitRegistration);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String creditCardNum = ((EditText) findViewById(R.id.CardNumberEditText)).getText().toString();
                String rawExpData = ((EditText) findViewById(R.id.expirationDateEditText)).getText().toString();
                String cvcString = ((EditText) findViewById(R.id.cvcEditText)).getText().toString();

                String monthString = "";
                String yearString = "";

                //Parse Raw Expiration Data:
                for(int i = 0; i < rawExpData.length(); i++) {
                    if(rawExpData.charAt(i) ==  '/') {
                        monthString = rawExpData.substring(0,i);
                        yearString = rawExpData.substring(i+1);
                    }
                }
                //Month and year confirmed working


                if(monthString == "" || yearString == "") {

                    Context context = getApplicationContext();
                    CharSequence text = "Please enter the expiration date";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    int month = Integer.parseInt(monthString);
                    int year = Integer.parseInt(yearString);


                    Card creditCard = new Card(creditCardNum, month, year, cvcString);


                    if (!creditCard.validateCard()) {

                        Context context = getApplicationContext();
                        CharSequence text = "Credit card information not valid";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        //TODO: 1. Clear Fields. 2. Give them another try


                    } else {
                        //Card is successfully validated
                        try {
                            Stripe stripe = new Stripe("pk_test_6pRNASCoBOKtIshFeQd4XMUh");
                            stripe.createToken(
                                    creditCard,
                                    new TokenCallback() {
                                        @Override
                                        public void onError(Exception error) {
                                            Context context = getApplicationContext();
                                            CharSequence text = "Failed to receive valid stripe token";
                                            int duration = Toast.LENGTH_LONG;

                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();
                                        }

                                        @Override
                                        public void onSuccess(Token token) {
                                            //TODO: Send token to server, with credentials


                                            //Login to donationActivity.

                                            Intent intent = new Intent(getApplicationContext(), donateActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                            );

                        } catch (AuthenticationException exception) {
                            //TODO: In case stripe generation fails
                            Log.e("Stripe things", exception.getMessage());
                        }
                    }
                }
                String Email = ((EditText)findViewById(R.id.emailOne)).getText().toString();
                String UserName = ((EditText)findViewById(R.id.usernameOne)).getText().toString();
                String Password = ((EditText)findViewById(R.id.passwordOne)).getText().toString();


                // task.execute();
                Globals.getInstance().setUser(UserName);

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
