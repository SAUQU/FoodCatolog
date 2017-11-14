package com.example.segundoauqui.foodcatolog;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.segundoauqui.foodcatolog.model.Groceries;
import com.example.segundoauqui.foodcatolog.model.SelectedItems;
import com.example.segundoauqui.foodcatolog.view.mainview.MainView;
import com.example.segundoauqui.foodcatolog.view.mainview.RVISAdapter;
import com.example.segundoauqui.foodcatolog.view.mainview.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVISAdapter adapter;
    LinearLayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    List<SelectedItems> result;
    private ArrayList<SelectedItems> itemSelected = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        recyclerView = (RecyclerView) findViewById(R.id.selectedRecycler);
        result = new ArrayList<>();
        result = getIntent().getParcelableArrayListExtra("check");
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RVISAdapter(result);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.payment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                Bundle b = new Bundle();
                b.putDouble("sum",grandTotal(result));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
    private double grandTotal(List<SelectedItems> items){

        double totalPrice = 0.0;
        for(int i = 0 ; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice();
        }

        return totalPrice;
    }


}








