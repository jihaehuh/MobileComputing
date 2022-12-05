package com.zeze7.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton=findViewById(R.id.PageButton);
        Button settingButton=findViewById(R.id.SetUpButton);
        TextView dateText =findViewById(R.id.DateText);

        long now = System.currentTimeMillis();    //날짜 바꾸기
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String getTime = sdf.format(date);

        dateText.setText(getTime);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addSchedule.class);
                intent.putExtra("date", dateText.getText().toString());
                startActivity(intent);
            }
        });
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,set.class);
                startActivity(intent);
            }
        });

        dateText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, dateset.class);
                intent.putExtra("date", dateText.getText().toString());
                startActivity(intent);
            }
        });
    /*
        try {

            FileInputStream fis = openFileInput("MemoData.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String nowMemo = reader.readLine();

            while (nowMemo != null) {
                String[] memoList = nowMemo.split(",");

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.memocard, findViewById(R.id.memoListWindow), true);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
