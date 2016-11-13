package com.example.samresendez.boost;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import static com.example.samresendez.boost.R.layout.item;

/**
 * Created by SamResendez on 11/12/16.
 */

public class donationAdapter extends RecyclerView.Adapter<donationAdapter.donationViewHolder> implements Filterable {




    public static class donationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView tv;
        TextView dv;
        ImageView iV;
        boolean isFiyah;

        donationViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tv = (TextView) itemView.findViewById(R.id.donationName);
            dv = (TextView) itemView.findViewById(R.id.donationDescription);
            iV = (ImageView) itemView.findViewById(R.id.theFireThing);
            isFiyah = false;
            if(tv != null) {
                Log.e("ASDF","sound view");
            }
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(itemView.getContext(),donateActivity.class);
            intent.putExtra("Title_of_thing",tv.getText().toString());
            itemView.getContext().startActivity(intent);
        }

        @Override
        public boolean onLongClick(View view) {
            Log.e("Huehuehue:","Inside the LongClick");
            final Handler handler = new Handler();

            final Runnable r = new Runnable() {
                int z = 0;
                public void run() {

                    if(z==0) {

                        iV.setImageResource(R.mipmap.fireone);
                       // iV.setBackground(itemView.getResources().getDrawable(R.mipmap.fireone));

                    }
                    else if(z==1) {

                       // iV.setBackground(itemView.getResources().getDrawable(R.mipmap.firetwo));
                        iV.setImageResource(R.mipmap.firetwo);
                    }
                    else if(z==2) {
                        iV.setImageResource(R.mipmap.boostfire);
                        z=-1;
                    }
                    z++;
                    handler.postDelayed(this, 250);
                }

            };

            handler.postDelayed(r, 250);









            return true;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(item,parent,false);
        donationViewHolder dA = new donationViewHolder(v);

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
