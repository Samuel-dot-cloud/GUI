package com.manasseh.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.name)
    EditText nameSpace;
    String[] foods = { "Egg curry", "Meat stew", "Ugali", "Rice", "Bean stew" };
    private String food, name, gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, foods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }


    public void onRadioButtonClicked(View view) {
        // Is the view now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which RadioButton was clicked
        switch(view.getId()) {
            case R.id.chk1:
                if (checked){
                    name = nameSpace.getText().toString();
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("name", String.valueOf(name));
                    intent.putExtra("food", String.valueOf(food));
                    intent.putExtra("gender", String.valueOf(gender));
                    startActivity(intent);
                }
                // Do your coding
        else
                // Do your coding

                break;
            // Perform your logic
        }

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which Checkbox was clicked
        gender = "";
        switch(view.getId()) {
            case R.id.chkMale:
                if (checked) {
                    gender = checked?"Male Selected":"Male Deselected";
                }

                break;

            case R.id.chkFemale:
                if (checked) {
                    gender = checked?"Female Selected":"Female Deselected";
                }

                break;

            default:
        }
        Toast.makeText(getApplicationContext(), gender, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        food = foods[position];
        Toast.makeText(getApplicationContext(), "Selected food: "+food , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}