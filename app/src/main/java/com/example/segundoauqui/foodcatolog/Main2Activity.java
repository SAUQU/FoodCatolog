package com.example.segundoauqui.foodcatolog;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.segundoauqui.foodcatolog.model.Groceries;
import com.example.segundoauqui.foodcatolog.model.SelectedItems;
import com.example.segundoauqui.foodcatolog.view.mainview.MainView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Food";
    private List<Groceries> result;
    private ArrayList<SelectedItems> itemSelected = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                intent.putExtra("sum",grandTotal(itemSelected));
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
