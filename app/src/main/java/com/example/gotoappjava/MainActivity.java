package com.example.gotoappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gotoappjava.market.Market;
import com.example.gotoappjava.police.Police;
import com.example.gotoappjava.school.School;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHospital(View view) {
        Intent i = new Intent(this, Hospital.class);
        startActivity(i);
    }

    public void clickPolice(View view) {
        Intent i = new Intent(this, Police.class);
        startActivity(i);
    }

    public void clickMarket(View view) {
        Intent i = new Intent(this, Market.class);
        startActivity(i);
    }

    public void clickSchool(View view) {
        Intent i = new Intent(this, School.class);
        startActivity(i);
    }
}