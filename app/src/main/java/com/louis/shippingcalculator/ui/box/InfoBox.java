package com.louis.shippingcalculator.ui.box;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.louis.shippingcalculator.R;
import com.louis.shippingcalculator.controller.BoxController;
import com.louis.shippingcalculator.model.Box;

public class InfoBox extends AppCompatActivity {

    Box box;

    TextView nameTV;
    TextView widthTV;
    TextView heightTV;
    TextView depthTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_box);

        box = new Gson().fromJson(String.valueOf(getIntent().getStringExtra(BoxController.INTENT_BOX)), Box.class);

        nameTV = findViewById(R.id.name);
        widthTV = findViewById(R.id.width);
        heightTV = findViewById(R.id.height);
        depthTV = findViewById(R.id.depth);

        nameTV.setText(box.getName());
        widthTV.setText(String.valueOf(box.getWidth()));
        heightTV.setText(String.valueOf(box.getHeight()));
        depthTV.setText(String.valueOf(box.getDepth()));

        findViewById(R.id.deleteBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BoxController.delete(InfoBox.this, box);
            }
        });

        findViewById(R.id.editBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BoxController.launchEdit(InfoBox.this, box);
            }
        });
    }
}