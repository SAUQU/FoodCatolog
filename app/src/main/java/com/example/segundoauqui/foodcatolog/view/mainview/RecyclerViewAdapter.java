package com.example.segundoauqui.foodcatolog.view.mainview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.segundoauqui.foodcatolog.R;
import com.example.segundoauqui.foodcatolog.model.Groceries;
import com.example.segundoauqui.foodcatolog.model.SelectedItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by segundoauqui on 11/9/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private OnItemSelectedListener listener;
    private List<Groceries> list;
    private Groceries grocery;
    ArrayList<SelectedItems> listItems = new ArrayList<>();
    public RecyclerViewAdapter(List<Groceries> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        grocery = list.get(position);
        holder.name.setText(grocery.name);
        holder.type.setText(grocery.type);
        holder.price.setText(String.valueOf(grocery.price));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemSelectedListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public void unsetItemSelectedListener() {
        this.listener = null;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, type, price;
        ImageButton ibSelect;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.list_item_name);
            type = (TextView) itemView.findViewById(R.id.list_item_type);
            price = (TextView) itemView.findViewById(R.id.list_item_price);
            ibSelect = (ImageButton) itemView.findViewById(R.id.ibSelect);

            ibSelect.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listItems.add(new SelectedItems(list.get(getAdapterPosition()).name,
                    list.get(getAdapterPosition()).type,
                    list.get(getAdapterPosition()).price));
            Toast.makeText(view.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition())
                    + "   " + list.get(getAdapterPosition()).name
                    + "   " + listItems.size(), Toast.LENGTH_SHORT).show();

            listener.onItemSelected(list.get(getAdapterPosition()).getName(),
                    list.get(getAdapterPosition()).getType(),
                    list.get(getAdapterPosition()).getPrice());
        }
    }
    public interface OnItemSelectedListener {
        void onItemSelected(String name, String type, double price);
    }

}