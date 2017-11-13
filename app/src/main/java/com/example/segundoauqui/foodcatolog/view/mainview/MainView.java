package com.example.segundoauqui.foodcatolog.view.mainview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.segundoauqui.foodcatolog.Main2Activity;
import com.example.segundoauqui.foodcatolog.Main3Activity;
import com.example.segundoauqui.foodcatolog.R;
import com.example.segundoauqui.foodcatolog.model.Groceries;
import com.example.segundoauqui.foodcatolog.model.SelectedItems;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class MainView extends AppCompatActivity {

    private static final String TAG = "Add";
    private RecyclerView recyclerView;
    private List<Groceries> result;
    private RecyclerViewAdapter adapter;
    LinearLayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    Groceries groceries;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainView.this, Main3Activity.class);
                startActivity(intent);
                Toast.makeText(MainView.this, "Checking Out", Toast.LENGTH_SHORT).show();
            }
        });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("groceries");
        result = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(result);
        recyclerView.setAdapter(adapter);
        GetDataFromFirebase();
    }

    private void GetDataFromFirebase() {
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(Groceries.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                groceries = dataSnapshot.getValue(Groceries.class);
                int index = getItem(groceries);
                result.set(index, groceries);
                adapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private int getItem(Groceries grocery) {
        int index = -1;
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).name.equals(grocery.name)){
                index = i;
                break;
            }
        }
        return index;
    }

}