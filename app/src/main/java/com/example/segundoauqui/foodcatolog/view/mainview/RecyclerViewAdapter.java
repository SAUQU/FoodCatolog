package com.example.segundoauqui.foodcatolog.view.mainview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.segundoauqui.foodcatolog.R;
import com.example.segundoauqui.foodcatolog.model.Groceries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by segundoauqui on 11/9/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Groceries> list;

    public RecyclerViewAdapter(List<Groceries> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Groceries grocery = list.get(position);
        holder.name.setText(grocery.name);
        holder.type.setText(grocery.type);
        holder.price.setText(String.valueOf(grocery.price));


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


//    private ArrayList<String> values;
//
//    public RecyclerViewAdapter(ArrayList<String> values) {
//        this.values = values;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.name.setText(values.get(position));
//        holder.type.setText(values.get(position));
//        holder.price.setText(values.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return values.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView name;
//        private TextView type;
//        private TextView price;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//            name = (TextView) itemView.findViewById(R.id.list_item_name);
//            type = (TextView) itemView.findViewById(R.id.list_item_type);
//            price = (TextView) itemView.findViewById(R.id.list_item_price);
//        }
//    }
}
