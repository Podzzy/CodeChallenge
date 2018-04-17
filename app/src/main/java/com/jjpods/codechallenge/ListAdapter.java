package com.jjpods.codechallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jjpod on 4/17/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private List<ListItem> listItems;
    private Context context;

    public ListAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.nameTextView.setText(listItem.getName());
        holder.cityTextView.setText(listItem.getCity());
        holder.stateTextView.setText(listItem.getState());
        holder.endDateTextView.setText(listItem.getEndDate());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView, cityTextView, stateTextView, endDateTextView;

        public ViewHolder(View itemView){
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameText);
            cityTextView = itemView.findViewById(R.id.cityText);
            stateTextView = itemView.findViewById(R.id.stateText);
            endDateTextView = itemView.findViewById(R.id.dateText);
        }
    }
}
