package com.example.samresendez.boost;

import android.content.Intent;
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
        TextView dv;

        donationViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.donationName);
            dv = (TextView) itemView.findViewById(R.id.donationDescription);
            if(tv != null) {
                Log.e("ASDF","sound view");
            }
        }

    }

    List<donationInfo> donationInfos;

    donationAdapter(List<donationInfo> names) {
        donationInfos = names;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public donationViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        donationViewHolder dA = new donationViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(),donateActivity.class);
                parent.getContext().startActivity(intent);
            }
        });

        return dA;
    }

    @Override
    public void onBindViewHolder(donationViewHolder holder, int position) {

        donationInfo info = donationInfos.get(position);

        holder.tv.setText(info.mTitle);
        holder.dv.setText(info.mDescrip);
    }

    @Override
    public int getItemCount() {
        return donationInfos.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
