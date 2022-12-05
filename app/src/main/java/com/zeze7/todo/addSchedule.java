package com.zeze7.todo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class addSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_schedule);

        TextView date = findViewById(R.id.editTextDate);
        Button backButton=findViewById(R.id.AddBackButton);
        EditText[] memo={
                findViewById(R.id.checkBox),
                findViewById(R.id.checkBox2),
                findViewById(R.id.checkBox3),
                findViewById(R.id.checkBox4),
                findViewById(R.id.checkBox5),
                findViewById(R.id.checkBox6)
        };

        date.setText(getIntent().getStringExtra("date"));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fosMemo = null;



                try{
                    fosMemo = openFileOutput("MemoData.txt", Context.MODE_PRIVATE);
                    PrintWriter writer= new PrintWriter(fosMemo);
                    writer.write("\n" + getIntent().getStringExtra("date"));

                    for(EditText e : memo) {
                        writer.write("," + e.getText().toString());
                    }

                    writer.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

                onBackPressed();
            }
        });
    }
}
