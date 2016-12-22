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
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public List<donationInfo> donationList;
    private List<donationInfo> filteredList;



    private static List<donationInfo> filter(List<donationInfo> baseDB, String query) {

        final String theQuery = query.toLowerCase();
         List<donationInfo> filteredModel = new ArrayList<>();

            for(donationInfo model: baseDB) {
                final String text = model.mTitle.toLowerCase();
                if(text.contains(theQuery)){
                    Log.e("We made it!: ","adding to the filteredModel");
                    filteredModel.add(model);

                }

            }
        return filteredModel;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getDataTask datTask = new getDataTask();
        datTask.mainActiv = this;
        datTask.execute();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.donationRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        SearchView searchBar = (SearchView) findViewById(R.id.searchBarEditText);
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.e("onQueryTextSubmit",s);
                s = s.toLowerCase();
                final List<donationInfo> filteredModelList = filter(donationList,s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.e("onQueryTextChange",s);
                s = s.toLowerCase();
                final List<donationInfo> filteredModelList = filter(donationList,s);
                Log.e("filteredModel: ", Integer.toString(filteredModelList.size()));
                mRecyclerView.swapAdapter(new donationAdapter(filteredModelList),true);
                return false;
            }
        });


        donationList = new ArrayList<>();
        /*
        donationList.add(new donationInfo("World Wildlife Foundation","An organization dedicated to helping wildlife"));
        donationList.add(new donationInfo("The Red Cross","A foundation dedicated to human health"));
        donationList.add(new donationInfo("Kamala Harris","A political candidate here in California!"));
        donationList.add(new donationInfo("Not Donald Trump","Not serious, just funny :)"));
        donationList.add(new donationInfo("Action Against Hunger","Organization committed to fighting hunger"));
        donationList.add(new donationInfo("Environmental Core","Committee that raises environmental awareness"));
        */
        //use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

       // mAdapter = new donationAdapter(donationList);

        //mRecyclerView.setAdapter(mAdapter);

        setSupportActionBar(toolbar);

    }
}
