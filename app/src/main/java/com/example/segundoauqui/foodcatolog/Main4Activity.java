package com.example.segundoauqui.foodcatolog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    TextView tvFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tvFinal = (TextView) findViewById(R.id.tvFinal);
        tvFinal.setText("$ " + String.valueOf(getIntent().getDoubleExtra("sum" ,0.00)));


    }
}
