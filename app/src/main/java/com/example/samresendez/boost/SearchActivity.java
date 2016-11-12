package com.example.samresendez.boost;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    //RecyclerView Stuff
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<donationInfo> donationList;
    private List<donationInfo> filteredList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        /*
        EditText searchBar = (EditText) findViewById(R.id.searchBarEditText);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    for(int l = 0; i<donationList.size();l++) {
                        if( donationList.get(l).mTitle.contains(charSequence)) {
                            filteredList.add(donationList.get(l));
                        }
                    }
                mAdapter = new donationAdapter(filteredList);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        */





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.donationRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        donationList = new ArrayList<>();
        donationList.add(new donationInfo("World Wildlife Foundation","An organization dedicated to helping wildlife"));
        donationList.add(new donationInfo("The Red Cross","A foundation dedicated to human health"));
        donationList.add(new donationInfo("Kamala Harris","A political candidate here in California!"));
        donationList.add(new donationInfo("Not Donald Trump","Not serious, just funny :)"));
        donationList.add(new donationInfo("Action Against Hunger","Organization committed to fighting hunger"));
        donationList.add(new donationInfo("Environmental Core","Committee that raises environmental awareness"));


        //use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new donationAdapter(donationList);

        mRecyclerView.setAdapter(mAdapter);

        setSupportActionBar(toolbar);

    }
}
