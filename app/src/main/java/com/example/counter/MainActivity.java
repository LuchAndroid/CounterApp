package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPlusOne, btnMinusOne, btnAbout;
    TextView tvCount;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String COUNT = "count";
    private static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        addActionListeners();
        loadData();
        updateViews();
    }

    private void initializeComponents(){
        tvCount = findViewById(R.id.tvCount);
        btnPlusOne = findViewById(R.id.btnPlusOne);
        btnMinusOne = findViewById(R.id.btnMinusOne);
        btnAbout = findViewById(R.id.btnAbout);
    }

    private void addActionListeners() {
        btnPlusOne.setOnClickListener(v->plusOne());
        btnMinusOne.setOnClickListener(v->minusOne());
        btnAbout.setOnClickListener(v->showAbout());
    }

    private void plusOne() {
        count = Integer.parseInt(tvCount.getText().toString());
        tvCount.setText(++count+"");
        saveData();
    }

    private void minusOne() {
        count = Integer.parseInt(tvCount.getText().toString());
        tvCount.setText(--count+"");
        saveData();
    }

    private void showAbout() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNT, count);
        editor.apply();
        Toast.makeText(this, "Data saved...", Toast.LENGTH_SHORT);
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        count = sharedPreferences.getInt(COUNT, 0);
    }

    private void updateViews() {
        tvCount.setText(count+"");
    }
}