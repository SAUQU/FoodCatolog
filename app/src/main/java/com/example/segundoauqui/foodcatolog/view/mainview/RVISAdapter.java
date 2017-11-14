package com.example.segundoauqui.foodcatolog.view.mainview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.segundoauqui.foodcatolog.R;
import com.example.segundoauqui.foodcatolog.model.SelectedItems;

import java.util.List;

/**
 * Created by segundoauqui on 11/13/17.
 */

public class RVISAdapter extends RecyclerView.Adapter<RVISAdapter.ViewHolder> {

    private List<SelectedItems> list;
    private SelectedItems selectedItems;

    public RVISAdapter(List<SelectedItems> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_selected_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        selectedItems = list.get(position);
        holder.name.setText(selectedItems.name);
        holder.type.setText(selectedItems.type);
        holder.price.setText(String.valueOf(selectedItems.price));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, type, price;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.list_item_name);
            type = (TextView) itemView.findViewById(R.id.list_item_type);
            price = (TextView) itemView.findViewById(R.id.list_item_price);
        }
    }


}
