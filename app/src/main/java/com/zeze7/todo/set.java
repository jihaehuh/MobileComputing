package com.zeze7.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class set extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);   //화면불러오기

        Button alarmButton=findViewById(R.id.chip4);    //버튼선언
        Button letterButton=findViewById(R.id.chip5);
        Button languageButton=findViewById(R.id.chip6);
        Button backButton=findViewById(R.id.SetBackButton);

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this, alarmset.class); //버튼 클릭후 창뜨기
                startActivity(intent);
            }
        });

        letterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this, letterset.class);
                startActivity(intent);
            }
        });

        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this, languageset.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}