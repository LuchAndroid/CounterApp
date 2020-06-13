package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initializeComponents();
        addActionListeners();
    }

    private void initializeComponents() {
        btnBack = findViewById(R.id.btnBack);
    }

    private void addActionListeners() {
        btnBack.setOnClickListener(v->showHome());
    }

    private void showHome() {
        startActivity(new Intent(this, MainActivity.class));
    }
}