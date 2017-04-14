package com.myartsonline.bharath.lowloss.RewardsRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myartsonline.bharath.lowloss.R;

import java.util.List;

/**
 * Created by bk on 14-04-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    public List<ListItem> listdata;
    LayoutInflater inflater;
    Context c;
    public MyAdapter(List<ListItem> list, Context c) {
        this.inflater = LayoutInflater.from(c);
        listdata = list;
        this.c = c;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rewards_li, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ListItem item=listdata.get(position);
        holder.name.setText(item.getName());
        holder.rank.setText(item.getRank());
        holder.score.setText(item.getScore());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        TextView name,score,rank;
        public Holder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            score=(TextView)itemView.findViewById(R.id.score);
            rank=(TextView)itemView.findViewById(R.id.rank);
        }

    }
}
