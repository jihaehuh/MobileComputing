package com.zeze7.todo;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dateset);

        Button backButton=findViewById(R.id.DateBackButton);
        CalendarView date =findViewById(R.id.dateBox);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDay = null;
        try {
            currentDay = dateFormat.parse(getIntent().getStringExtra("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long currentLong = currentDay.getTime();
        date.setDate(currentLong);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date selectDate = new Date(date.getDate());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");

                String getTime = sdf.format(selectDate);

                getIntent().putExtra("newDate", getTime);
                onBackPressed();
            }
        });


    }
}