package com.example.samresendez.boost;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SamResendez on 11/12/16.
 */

public class donationAdapter extends RecyclerView.Adapter<donationAdapter.donationViewHolder> implements Filterable {




    public static class donationViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        donationViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.donationName);
            if(tv != null) {
                Log.e("ASDF","sound view");
            }
        }

    }

    List<String> namesList;

    donationAdapter(List<String> names) {
        namesList = names;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public donationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        donationViewHolder dA = new donationViewHolder(v);

        return dA;
    }

    @Override
    public void onBindViewHolder(donationViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.tv.setText(namesList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.e("Size:",Integer.toString(namesList.size()));
        return namesList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
