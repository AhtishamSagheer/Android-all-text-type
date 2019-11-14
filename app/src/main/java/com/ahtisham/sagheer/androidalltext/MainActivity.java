package com.ahtisham.sagheer.androidalltext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    EditText Time,Date;

    CheckedTextView CheckedTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Time=(EditText) findViewById(R.id.time);
        Date=(EditText) findViewById(R.id.date);
        CheckedTextView=(CheckedTextView)findViewById(R.id.checkedTextView);
        CheckedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckedTextView.isChecked())
                {
                    CheckedTextView.setChecked(false);
                    CheckedTextView.setText("Not Checked");
                }
                else
                {
                    CheckedTextView.setChecked(true);
                    CheckedTextView.setText("is Checked");
                }
            }
        });
        Thread t=new Thread()
        {
            @Override
            public void run() {
               while(!isInterrupted())
               {
                   try {
                       Thread.sleep(1000);
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                            long time=System.currentTimeMillis();
                               //For Time
                               SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh-mm-ss a");
                               String timeString=simpleDateFormat.format(time);
                               Time.setText(timeString);

                               //For Date

                               SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("MMM dd yyyy");
                               String date=simpleDateFormat2.format(time);
                               Date.setText(date);


                           }
                       });
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }

            }
        };
        t.start();
    }
}
