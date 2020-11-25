package com.aamjantamedia.ajm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.View_Holder> {
    private Context mContext;
    private List<Article> ItemList;

    public RecyclerViewAdapter(List<Article> itemList,Context mContext) {
        this.mContext = mContext;
        ItemList = itemList;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()) .inflate(R.layout.rowitem, parent, false);
        return new View_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.View_Holder holder, int position) {
        Article Item = ItemList.get(position);
        holder.heading.setText(Item.getTitle());
        holder.body.setText(Item.getContent());
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView heading;
        TextView body;
        public View_Holder(View itemView) {
            super(itemView);

            heading = (TextView) itemView.findViewById(R.id.item_heading);
            body = (TextView) itemView.findViewById(R.id.item_body);
        }
    }
}
