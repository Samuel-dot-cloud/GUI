package com.manasseh.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    @BindView(R.id.nameSpace)
    TextView nameView;
    @BindView(R.id.genderSpace)
    TextView genderView;
    @BindView(R.id.foodSpace)
    TextView foodView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        String name = getIntent().getStringExtra("name");
        String food = getIntent().getStringExtra("food");
        String gender = getIntent().getStringExtra("gender");


        nameView.setText(name);
        genderView.setText(gender);
        foodView.setText(food);
    }
}